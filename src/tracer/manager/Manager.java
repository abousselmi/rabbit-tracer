/* 
 * Copyright 2016 Orange.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tracer.manager;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import tracer.ui.MessageViewerUI;

/**
 *
 * @author ayoub bousselmi
 * @since September 2015
 */

public class Manager {
    
    //this variable is not used :D
    private final String exchangeID;
    
    //MainGui object pointer
    private final tracer.ui.MainUI mainUI;
    
    //init my UI
    private final JTable myTraceTable;
    private final JTable myRKStatsTable;
    private final JTable myRPCStatsTable;
    
    private final SimpleDateFormat myDateFormatter;
    
    //rabbit node params
    private String EXCHANGE_NAME;
    private String EXCHANGE_TYPE;
    private int EXCHANGE_PARAMS;
    private String HOST;
    private int PORT;
    private String USER_NAME;
    private String PASSWORD;
    private String VIRTUAL_HOST_NAME;
    private int TIMEOUT;
    private String[] BINDING_KEYS;
    
    //messages inbox
    private final ArrayList<Object[]> inbox;
    private String logFromInbox = "";
    
    //routing keys stats variables
    private final HashMap<String, Integer> myRKStatsCounterMap;
    private final HashMap<String, Integer> myRKStatsFiveSecondsCounterMap;
    private final HashMap<String, Float> myRKStatsTotalDataSizeMap;
    private final HashMap<String, Float> myRKStatsMeanDataSizeMap;
    private final ArrayList<Integer> dynamicRKRates;
    private final HashMap<String, Float> myRKStatsPercentageMap;
    
    //rpc stats variables
    private final HashMap<String, Integer> myRPCStatsCounterMap;
    private final HashMap<String, Float> myRPCStatsPercentageMap;
    private final HashMap<String, String[]> myRPCRKExchangeMap;
    
    //global variable
    private final DynamicStatsViewThreadUpdater myStatsUpdater;
    private int elapsedTimeInSeconds = 0;
    private int elapsedTimeInMinutes = 0;
    private int elapsedTimeInHours = 0;
    
    //connection objects
    private Connection myConnection;
    private Channel myChannel;
    
    //needed to keep RK sorted in the table view
    private final ArrayList<String> routingKeysList = new ArrayList<String>();
    private int numberOfDetectedRKs = 0;
    private final float dynamicRKRate = 0f;
    
    //needed to keep RPC sorted in the table view
    private final ArrayList<String> rpcMethodsList = new ArrayList<String>();
    private int numberOfDetectedRPCs = 0;
    private final float dynamicRPCRate = 0f;
    
    public Manager(String extID, tracer.ui.MainUI mainui, JTable tracetab, 
            JTable rkstatstab, JTable rpcstatstab, Object[] objExchMetaData) {
        exchangeID = extID;
        mainUI = mainui;
        myTraceTable = tracetab;
        myRKStatsTable = rkstatstab;
        myRPCStatsTable = rpcstatstab;
        
        inbox = new ArrayList<Object[]>();
        
        //rk vars init
        myRKStatsCounterMap = new HashMap<String, Integer>();
        myRKStatsFiveSecondsCounterMap = new HashMap<String, Integer>();
        myRKStatsTotalDataSizeMap = new HashMap<String, Float>();
        myRKStatsMeanDataSizeMap = new HashMap<String, Float>();
        dynamicRKRates = new ArrayList<Integer>();
        myRKStatsPercentageMap = new HashMap<String, Float>();
        
        //rpc vars init
        myRPCStatsCounterMap = new HashMap<String, Integer>();
        myRPCStatsPercentageMap = new HashMap<String, Float>();
        myRPCRKExchangeMap = new HashMap<String, String[]>();
        
        myStatsUpdater = new DynamicStatsViewThreadUpdater(this);
        initConnectionToRabbitNode(objExchMetaData);
        initTraceTable();
        myDateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }
    
    private void initConnectionToRabbitNode(Object[] objExchMetaData) {
        System.out.println("connecting rabbit node using the following "
                + "config:");
        this.setExchangeName((String) objExchMetaData[0]);
        System.out.println("  + exchange name: "+objExchMetaData[0]);
        
        this.setExchangeType((String) objExchMetaData[1]);
        System.out.println("  + exchange type: "+objExchMetaData[1]);
        
        this.setExchangeParams((Integer) objExchMetaData[2]);
        System.out.println("  + exchange parameters: "+objExchMetaData[2]);
        
        this.setHost((String) objExchMetaData[3]);
        System.out.println("  + rabbit node IP address: "+objExchMetaData[3]);
        
        this.setPort((Integer) objExchMetaData[4]);
        System.out.println("  + custom rabbit node port = "+objExchMetaData[4]);
        
        this.setUserName((String) objExchMetaData[5]);
        System.out.println("  + rabbit user ID: "+objExchMetaData[5]);
        
        this.setPassword((String) objExchMetaData[6]);
        System.out.println("  + rabbit user password: *********** ");
        
        this.setVirtualHostName((String) objExchMetaData[7]);
        System.out.println("  + rabbit node virtual host: "+objExchMetaData[7]);
        
        
        this.setBindingKeys((String[]) objExchMetaData[8]);
        System.out.println("  + list of binding keys: "+Arrays.asList((String[]) 
                objExchMetaData[8]));
        
        this.setTimeout((Integer) objExchMetaData[9]);
        System.out.println("  + timout to rabbit node = "+objExchMetaData[9]);
    }
    
    public void connectToRabbitNode(){
        try {
            com.rabbitmq.client.ConnectionFactory myFactory = 
                    new ConnectionFactory();
            myFactory.setHost(HOST);
            myFactory.setPort(PORT);
            myFactory.setUsername(USER_NAME);
            myFactory.setPassword(PASSWORD);
            myFactory.setVirtualHost(VIRTUAL_HOST_NAME);
            myFactory.setConnectionTimeout(TIMEOUT);
            
            //Automatic recovery from network failures
            myFactory.setAutomaticRecoveryEnabled(true);
            System.out.println("automatic recovery from network failures is "
                    + "enabled");
            
            System.out.println("creating new connection..");
            myConnection = myFactory.newConnection();
            
            System.out.println("host: "+HOST+" is connected..");
            
            System.out.println("creating new channel..");
            myChannel = myConnection.createChannel();
            System.out.println("declaring new Exchange..");
            
            switch(getExchageParams()){
                case 0:
                    myChannel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE, 
                            false, false, false, null);
                    break;
                case 1: 
                    myChannel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE, 
                            true, false, false, null);
                    break;
                case 2:
                    myChannel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE, 
                            false, true, false, null);
                    break;
                case 3:
                    myChannel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE, 
                            false, false, true, null);
                    break;
                case 4:
                    myChannel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE, 
                            true, true, false, null);
                    break;
                case 5:
                    myChannel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE, 
                            true, false, true, null);
                    break;
                case 6:
                    myChannel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE, 
                            false, true, true, null);
                    break;
                case 7:
                    myChannel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE, 
                            true, true, true, null);
                    break;
                default:
                    break;
            }
            System.out.println("creating random queue..");
            String QUEUE_NAME = myChannel.queueDeclare().getQueue();
            for (String bindingKey : BINDING_KEYS) {
                System.out.println("binding to exchange="+EXCHANGE_NAME+
                        " using Binding Key="+bindingKey);
                myChannel.queueBind(QUEUE_NAME, EXCHANGE_NAME, bindingKey);
            }
            System.out.println("waiting for messages, this may take few seconds"
                    + "..");
            System.out.println(" - rk: routing key");
            System.out.println(" - en: exchange name");
            System.out.println(" - ts: time stamp");
            System.out.println(" - ct: content type");
            System.out.println(" - ce: content encoding");
            System.out.println(" - mp: message preview");
            myStatsUpdater.start();
            com.rabbitmq.client.Consumer myConsumer = 
                    new DefaultConsumer(myChannel){
                int messageCounter = 1;
                @Override
                public void handleDelivery(String consumerTag, 
                        Envelope envelope, AMQP.BasicProperties properties, 
                        byte[] body) throws IOException {
                    
                    String messageCore = new String (body, "UTF-8");
                    String currentRoutingKey = envelope.getRoutingKey();
                    //currentRPC is used for display in the global tracing table
                    String currentRPC = getRPCMethod(messageCore);
                    //there are redendant RPCs. to make the difference, we add
                    //the routing key to the RPC
                    String currentRPCandRK = currentRoutingKey+" * "+currentRPC;
                    
                    addNewMessageToInbox(new Object[]{messageCounter, 
                        getFormattedTime(), EXCHANGE_NAME, 
                        envelope.getRoutingKey(), messageCore, properties});
                    
                    //verify if it's a new or a deja-vu RPC in the main 
                    //rpc method tracking list
                    if(!rpcMethodsList.contains(currentRPCandRK)){
                        rpcMethodsList.add(currentRPCandRK);
                    }
                    
                    //verify if it's a new or a deja-vu routing key in the main 
                    //routing keys tracking list
                    if(!routingKeysList.contains(currentRoutingKey)){
                        routingKeysList.add(currentRoutingKey);
                    }
                    
                    //verify if it's a new or a deja-vu routing key in the stats 
                    //recording list and init stats
                    //logically it can be added to the condition above but
                    //I prefer it this way
                    if(!myRKStatsCounterMap.containsKey(currentRoutingKey)){
                        myRKStatsCounterMap.put(currentRoutingKey, 1);
                        myRKStatsPercentageMap.put(currentRoutingKey, 
                                (1.0f/messageCounter)*100);
                        myRKStatsFiveSecondsCounterMap.put(currentRoutingKey, 
                                1);
                        myRKStatsTotalDataSizeMap.put(currentRoutingKey, 
                                (body.length/1024F));
                        myRKStatsMeanDataSizeMap.put(currentRoutingKey, 
                                (body.length/1024F));
                        dynamicRKRates.add(1);
                    }else{
                        //FIXED: chaos.. update: everything is fine
                        myRKStatsCounterMap.put(currentRoutingKey, 
                                myRKStatsCounterMap.get(currentRoutingKey)+1);
                        for (String rk : routingKeysList) {
                            //loop all routing keys because it depends on the 
                            //total number of recieved messages.
                            myRKStatsPercentageMap.put(rk, (((float) 
                                    myRKStatsCounterMap.get(rk))
                                    /messageCounter)*100);
                        }
                        myRKStatsTotalDataSizeMap.put(currentRoutingKey, 
                                myRKStatsTotalDataSizeMap.get(currentRoutingKey) 
                                        + (body.length/1024.0F));
                        myRKStatsMeanDataSizeMap.put(currentRoutingKey, 
                                ((float) myRKStatsTotalDataSizeMap.
                                get(currentRoutingKey))/myRKStatsCounterMap.
                                        get(currentRoutingKey));
                    }
                    
                    //verify if it's a new or a deja-vu rpc in the stats 
                    //recording list and init stats
                    if(!myRPCStatsCounterMap.containsKey(currentRPCandRK)){
                        myRPCStatsCounterMap.put(currentRPCandRK, 1);
                        myRPCStatsPercentageMap.put(currentRPCandRK, 
                                (1.0f/messageCounter)*100);
                        myRPCRKExchangeMap.put(currentRPCandRK, new String[]{
                            EXCHANGE_NAME, currentRoutingKey, currentRPC});
                    }else{
                        myRPCStatsCounterMap.put(currentRPCandRK, 
                                myRPCStatsCounterMap.get(currentRPCandRK)+1);
                        for (String rpc : rpcMethodsList) {
                            //loop all rpc because it depends on the 
                            //total number of received messages.
                            //using the messageCounter is OK because even 
                            //messages that are not RPCs are considered as
                            //RPCs with a 'N/A' RPC type.
                            myRPCStatsPercentageMap.put(rpc, (((float) 
                                    myRPCStatsCounterMap.get(rpc))
                                    /messageCounter)*100);
                        }
                    }
                    
                    // Properties object added to message object
                    displayNewMessage(new Object[]{messageCounter, 
                        getFormattedTime(), EXCHANGE_NAME, 
                        envelope.getRoutingKey(), currentRPC, 
                        properties});
                    
                    //FIXED: custom messages (ex. used for test) may be less  
                    //longer than 30 character which raises an exception.
                    String messagePreview = messageCore;
                    if(messageCore.length() > 100){
                        messagePreview = messageCore.substring(0, 85)+"...";
                    }
                    
                    System.out.println(
                            "MSG ["+messageCounter+"]:"+
                            " | rk: "+envelope.getRoutingKey()+
                            " | en: "+envelope.getExchange()+
                            " | ts: "+properties.getTimestamp()+
                            " | ct: "+properties.getContentType()+
                            " | ce: "+properties.
                                    getContentEncoding()+
                            " | mp: "+messagePreview + " |");
                    messageCounter++;
                }

                private String getFormattedTime() {
                    return myDateFormatter.format(new Date());
                }

                private String getRPCMethod(String messageCore) {
                    String rpcMethodName = "N/A";
                    //clean up the message core
                    messageCore = messageCore.replaceAll("[\\p{Punct}&&[^,:_]]",
                            "");
                    //transform the message core to a list of tokens
                    StringTokenizer st1 = new StringTokenizer(messageCore, 
                            ",");
                    //locate the string token 'method' and save the next
                    //one which is the rpc method name
                    while (st1.hasMoreElements()) {
                        String token = (String) st1.nextElement();
                        if(token.trim().startsWith("method")){
                            rpcMethodName = token.substring(9);
                        }
                    }
                    return rpcMethodName;
                }
            };
            myChannel.basicConsume(QUEUE_NAME, true, myConsumer);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } catch (TimeoutException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public void disconnectFromRabbitNode(){
        if(myChannel != null && myChannel.isOpen()){
            System.out.println("closing channel..");
            try {
                myChannel.close();
                System.out.println("channel closed successfully..");
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            } catch (TimeoutException ex) {
                ex.printStackTrace(System.out);
            }
            if(myConnection != null && myConnection.isOpen()){
                System.out.println("disconnecting from rabbit node..");
                try {
                    myConnection.close();
                    System.out.println("disconnected successfully..");
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            addEndRow();
            myStatsUpdater.stop();
        }
    }
    
    private void initTraceTable() {
        myTraceTable.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            Object[] message = inbox.get(myTraceTable.
                                    getSelectedRow());
                            new MessageViewerUI(message).setVisible(true);
                        }
                    });
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    
    public void addNewMessageToInbox(Object[] message){
        inbox.add(message);
        updateLogFromInbox(message);
    }
        
    public void displayNewMessage(Object[] message){
        Object[] messageToDisplay = new Object[]{message[0], message[1], 
                        message[2], message[3], message[4]};
        tracer.utils.tabs.TracingTableModel myModel = (tracer.utils.tabs.
                TracingTableModel) myTraceTable.getModel();
        myModel.addRow(messageToDisplay);
    }
    
    /**
     *
     * @return ArrayList: the set of all received messages at time t
     */
    public ArrayList<Object[]> getInbox(){
        return inbox;
    }
    
    private void updateLogFromInbox(Object[] message) {
        logFromInbox += "#----\n";
        logFromInbox += "message.id: "+message[0]+"\n";
        logFromInbox += "message.time.stamp: "+message[1]+"\n";
        logFromInbox += "exchange.name: "+message[2]+"\n";
        logFromInbox += "routing.key: "+message[3]+"\n";
        logFromInbox += "message.core: "+message[4]+"\n";
        logFromInbox += "message.properties: "+message[5]+"\n\n";
    }
    
    public String getLogfromInbox() {
        return logFromInbox;
    }
    
    //update RK and RPC stats tables
    private void updateStatsTables() {
        int i = 0;
        int k = 0;
        
        //get RK table model from tracer.utils.rkstatstab
        tracer.utils.tabs.DynamicRKStatsTableModel myRKTabModel = (
                tracer.utils.tabs.DynamicRKStatsTableModel) 
                myRKStatsTable.getModel();
        
        //get RPC table model from tracer.utils.rpcstatstab
        tracer.utils.tabs.DynamicRPCStatsTableModel myRPCTabModel = (
                tracer.utils.tabs.DynamicRPCStatsTableModel) 
                myRPCStatsTable.getModel();
        
        //detecing new RKs
        if(routingKeysList.size() > numberOfDetectedRKs){
            for (int j = 0; j < routingKeysList.size() - 
                    numberOfDetectedRKs; j++) {
                String rk = routingKeysList.
                        get(numberOfDetectedRKs + j);
                Object[] data = new Object[]{numberOfDetectedRKs + 
                        j + 1, rk, myRKStatsCounterMap.get(rk), 
                        formatFloat((myRKStatsPercentageMap.get(rk))), 
                        dynamicRKRate, 0.0F, 0.0F, 0.0F, 
                        myRKStatsTotalDataSizeMap.get(rk), 
                        myRKStatsMeanDataSizeMap.get(rk)};
                myRKTabModel.addRow(data);
                System.out.println("new routing key is detected in ["
                        +EXCHANGE_NAME+"]: "+rk);
            }
            numberOfDetectedRKs = routingKeysList.size();
        }
        
        //detecting new RPCs
        //only update stats if a new RPC is detected
        if(rpcMethodsList.size() > numberOfDetectedRPCs){
            for (int j = 0; j < rpcMethodsList.size() - 
                    numberOfDetectedRPCs; j++) {
                String rpc = rpcMethodsList.
                        get(numberOfDetectedRPCs + j);
                Object[] data = new Object[]{numberOfDetectedRPCs + 
                        j + 1, myRPCRKExchangeMap.get(rpc)[0], 
                        myRPCRKExchangeMap.get(rpc)[1], 
                        myRPCRKExchangeMap.get(rpc)[2], 
                        myRPCStatsCounterMap.get(rpc), 
                        formatFloat((myRPCStatsPercentageMap.get(rpc))), 
                        dynamicRPCRate};
                myRPCTabModel.addRow(data);
                System.out.println("new rpc is detected in ["
                        +EXCHANGE_NAME+"]: "+rpc);
            }
            numberOfDetectedRPCs = rpcMethodsList.size();
        }
        
        //updating RPC table model
        //logically, this takes less time than the RK tab update so placed 
        //before
        for(String rpc : rpcMethodsList){
            float rpcRateInSeconds;
            if(elapsedTimeInSeconds != 0){
                rpcRateInSeconds = ((float) myRPCStatsCounterMap.get(rpc))
                        /elapsedTimeInSeconds;
            }else{
                rpcRateInSeconds = (float) myRPCStatsCounterMap.get(rpc);
            }
            Object[] data = new Object[]{k+1, myRPCRKExchangeMap.get(rpc)[0], 
                    myRPCRKExchangeMap.get(rpc)[1], 
                    myRPCRKExchangeMap.get(rpc)[2], 
                    myRPCStatsCounterMap.get(rpc), 
                    formatFloat((myRPCStatsPercentageMap.get(rpc))), 
                    rpcRateInSeconds};
            for (int j = 0; j < data.length; j++) {
                myRPCTabModel.setValueAt(data[j], k, j);
            }
            k++;
        }
        
        //updating RK table model
        for(String rk : routingKeysList) {
            //updating existant rows in table view (step 1)
            float rkRateInSeconds;
            float rkRateInMinutes;
            float rkRateInHours;
            if(elapsedTimeInSeconds != 0){
                rkRateInSeconds = ((float) myRKStatsCounterMap.get(rk))
                        /elapsedTimeInSeconds;
            }else{
                rkRateInSeconds = (float) myRKStatsCounterMap.get(rk);
            }
            if(elapsedTimeInMinutes != 0){
                rkRateInMinutes = ((float) myRKStatsCounterMap.get(rk))
                        /elapsedTimeInMinutes;
            }else{
                rkRateInMinutes = (float) myRKStatsCounterMap.get(rk);
            }
            if(elapsedTimeInHours != 0){
                rkRateInHours = ((float) myRKStatsCounterMap.get(rk))
                        /elapsedTimeInHours;
            }else{
                rkRateInHours = (float) myRKStatsCounterMap.get(rk);
            }
            
            if(elapsedTimeInSeconds%5 == 0){ //executed every five seconds
                dynamicRKRates.set(i, myRKStatsCounterMap.get(rk) - 
                        myRKStatsFiveSecondsCounterMap.get(rk));
                myRKStatsFiveSecondsCounterMap.put(rk, 
                        myRKStatsCounterMap.get(rk));
            }
            Object[] data = new Object[]{i+1, rk, myRKStatsCounterMap.get(rk), 
                formatFloat((myRKStatsPercentageMap.get(rk))), 
                dynamicRKRates.get(i), 
                formatFloat((rkRateInSeconds)), 
                formatFloat((rkRateInMinutes)), 
                formatFloat((rkRateInHours)), 
                formatFloat((myRKStatsTotalDataSizeMap.get(rk))),
                formatFloat(myRKStatsMeanDataSizeMap.get(rk))};
            for (int j = 0; j < data.length; j++) {
                myRKTabModel.setValueAt(data[j], i, j);
            }
            i++;
        }
    }

    private float formatFloat(float x){
        //DecimalFormatter is not useful because we need to parse the string
        //back to float, which may cause problems with a DecimalFormatter
        String formatted = String.valueOf(x);
        StringTokenizer st = new StringTokenizer(formatted, ".");
        
        if(st.countTokens() == 1){
            formatted = st.nextToken();
        }else{
            formatted = st.nextToken();
            String tok = st.nextToken();
            if(tok.length() < 3){
                formatted += "."+tok;
            }else{
                formatted += "."+tok.substring(0, 2);
            }
        }
        //correction
        for (int i = 0; i < formatted.length(); i++) {
            if(!Character.isDigit(formatted.charAt(i))){
                if(formatted.charAt(i) != '.'){
                    formatted = formatted.replace(formatted.charAt(i), 'x');
                }
            }
        }
        formatted = formatted.replaceAll("x", "");
        return Float.parseFloat(formatted);
    }
    
    /**
     *
     * @return String: stats of this exchange a time t. Used to be saved
     */
    public String getRKStatsScreenshot(){
        int rows = myRKStatsTable.getRowCount();
        int cols = myRKStatsTable.getColumnCount();
        String stats = "";
        
        for (int i = 0; i < cols; i++) {
            stats += myRKStatsTable.getColumnName(i)+"\t";
        }
        stats += "\n";
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                stats = stats + myRKStatsTable.getValueAt(i, j) + "\t";
            }
            stats += "\n";
        }
        return stats;
    }
    
    public String getRPCStatsScreenshot(){
        int rows = myRPCStatsTable.getRowCount();
        int cols = myRPCStatsTable.getColumnCount();
        String stats = "";
        
        for (int i = 0; i < cols; i++) {
            stats += myRPCStatsTable.getColumnName(i)+"\t";
        }
        stats += "\n";
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                stats = stats + myRPCStatsTable.getValueAt(i, j) + "\t";
            }
            stats += "\n";
        }
        return stats;
    }

    public void setconnectionDuration(int connectionDuration) {
        if(myStatsUpdater != null){
            isTimedConnection = true;
            connectionTimer = connectionDuration;
        }
    }
    
    private boolean isTimedConnection = false;
    private int connectionTimer = 0;
    
    private class DynamicStatsViewThreadUpdater implements Runnable {

        private boolean isRunning = true;
        private final Manager myCompute;
        
        public DynamicStatsViewThreadUpdater(Manager ct) {
            myCompute = ct;
        }
        
        @Override
        public void run() {
            
            while (isRunning) {                
                //update stats table
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        myCompute.updateStatsTables();
                    }
                });
                try {
                    Thread.sleep(1000);
                    elapsedTimeInSeconds++;
                    if((elapsedTimeInSeconds % 60) == 0){
                        elapsedTimeInMinutes++;
                    }
                    if((elapsedTimeInSeconds % 3600) == 0){
                        elapsedTimeInHours++;
                    }
                    if(isTimedConnection){
                        if(elapsedTimeInSeconds >= connectionTimer){
                            isTimedConnection = false;
                            notifyMainGui();
                        }
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.
                            SEVERE, null, ex);
                }
            }
        }
        
        public void start(){
            new Thread(this).start();
        }
        
        public void stop(){
            isRunning = false;
        }        
    }
    
    private void notifyMainGui() {
        mainUI.stopTracingByEndConnectionTime();
    }
    private void addEndRow() {
        tracer.utils.tabs.TracingTableModel myModel = (tracer.utils.tabs.TracingTableModel) myTraceTable.getModel();
        myModel.addRow(new Object[]{0, "#", "#", "#", "#"});
    }
    
    public String getExchageName(){
        return EXCHANGE_NAME;
    }
    
    public void setExchangeName(String exchangeName){
        EXCHANGE_NAME = exchangeName;
    }

    public String getExchageType(){
        return EXCHANGE_TYPE;
    }
    
    public void setExchangeType(String exchangeType){
        EXCHANGE_TYPE = exchangeType;
    }
    
    public int getExchageParams(){
        return EXCHANGE_PARAMS;
    }
    
    public void setExchangeParams(int exchangeParams){
        EXCHANGE_PARAMS = exchangeParams;
    }
    
    public String getHost(){
        return HOST;
    }
    
    public void setHost(String host){
        HOST = host;
    }
    
    public String[] getBindingKeys(){
        return BINDING_KEYS;
    }
    
    public void setBindingKeys(String[] bindingKeys){
        BINDING_KEYS = bindingKeys;
    }
    
    public int getPort(){
        return PORT;
    }
    
    public void setPort(int port){
        PORT = port;
    }
    
    public String getUserName(){
        return USER_NAME;
    }
    
    public void setUserName(String username){
        USER_NAME = username;
    }
    
    public String getPassword(){
        return PASSWORD;
    }
    
    public void setPassword(String pass){
        PASSWORD = pass;
    }
    
    public String getVirtualHostName(){
        return VIRTUAL_HOST_NAME;
    }
    
    public void setVirtualHostName(String vhostName){
        VIRTUAL_HOST_NAME = vhostName;
    }
    
    public int getTimeout(){
        return TIMEOUT;
    }
    
    public void setTimeout(int timeout){
        TIMEOUT = timeout;
    }
    
}
