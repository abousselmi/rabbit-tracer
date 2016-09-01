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

package tracer.ui;

import com.rabbitmq.client.AMQP;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import tracer.utils.CustomJsonViewer;

/**
 *
 * @author ayoub bousselmi
 * @since September 2015
 */
public class MessageViewerUI extends javax.swing.JFrame {

    private final Document myFormattedDocument;
    private final Document myRawDocument;
    private final int myFDocumentLength;
    private final int myRDocumentLength;
    private final AMQP.BasicProperties myMessageProperties;
    
    public MessageViewerUI(Object[] message) {
        initComponents();
        myMessageProperties = (AMQP.BasicProperties) message[5];
        displayMessage(message);
        myFormattedDocument = formattedCoreMessage.getDocument();
        myFDocumentLength = myFormattedDocument.getLength();
        myRawDocument = rawCoreMessage.getDocument();
        myRDocumentLength = myRawDocument.getLength();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        messageID = new javax.swing.JTextField();
        topic = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        routinkKey = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        time = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        findTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        formattedCoreMessage = new javax.swing.JEditorPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rawCoreMessage = new javax.swing.JEditorPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        propertiesPane = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/tracer/res/rabbit.png")));

        jLabel1.setText("Message ID:");

        messageID.setEditable(false);
        messageID.setText(" ");
        messageID.setToolTipText("");

        topic.setEditable(false);
        topic.setText(" ");
        topic.setToolTipText("");

        jLabel2.setText("Topic:");

        jLabel3.setText("Routing Key:");

        routinkKey.setEditable(false);
        routinkKey.setText(" ");
        routinkKey.setToolTipText("");

        jLabel4.setText("Message Core:");

        jButton1.setText("Quit");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        time.setEditable(false);
        time.setText(" ");
        time.setToolTipText("");

        jLabel5.setText("Time:");
        jLabel5.setToolTipText("When this message was fetched by RabbitTracer");

        jLabel6.setText("Find:");

        findTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findTextFieldActionPerformed(evt);
            }
        });

        jButton2.setText("Find");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        formattedCoreMessage.setEditable(false);
        formattedCoreMessage.setContentType("text/html"); // NOI18N
        formattedCoreMessage.setText("<html>\r\n  <head>\r\n\r  <style>\n  <!--\n  body {\n    font-family: consolas;\n    font-size: 11px;\n  }\n  -->\n  </style>\n  </head>\r\n  <body>\r\n    \n  </body>\r\n</html>\r\n");
        formattedCoreMessage.setSelectedTextColor(new java.awt.Color(255, 153, 0));
        formattedCoreMessage.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(formattedCoreMessage);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Formatted JSON", jPanel1);

        rawCoreMessage.setEditable(false);
        rawCoreMessage.setContentType("text/html"); // NOI18N
        rawCoreMessage.setText("<html>\n  <head>\n  <style>\n  <!--\n  body {\n    font-family: consolas;\n    font-size: 11px;\n  }\n  -->\n  </style>\n  </head>\n  <body>\n    \n  </body>\n</html>\n");
        rawCoreMessage.setToolTipText("");
        rawCoreMessage.setSelectedTextColor(new java.awt.Color(255, 153, 0));
        rawCoreMessage.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(rawCoreMessage);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Raw JSON", jPanel2);

        propertiesPane.setEditable(false);
        propertiesPane.setContentType("text/html"); // NOI18N
        propertiesPane.setText("<html>\n  <head>\n  <style>\n  <!--\n  body {\n    font-family: consolas;\n    font-size: 11px;\n  }\n  -->\n  </style>\n  </head>\n  <body>\n    \n  </body>\n</html>\n");
        propertiesPane.setSelectedTextColor(new java.awt.Color(255, 153, 0));
        propertiesPane.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(propertiesPane);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Message Properties", jPanel3);

        jMenu1.setText("Message Viewer");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Find               ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Maximize Window               ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Quit               ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(messageID, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(time, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(topic, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(routinkKey)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(findTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(topic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(routinkKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel6)
                    .addComponent(findTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String stringToFind = findTextField.getText();
        if(!stringToFind.isEmpty()){
            if(jTabbedPane1.getSelectedIndex() == 1){
                rawCoreMessage.getHighlighter().removeAllHighlights();
                
                try {
                    for (int index = 0; index + stringToFind.length() < myRDocumentLength; index++) {
                        String match = myRawDocument.getText(index, stringToFind.length());
                        if (stringToFind.equals(match)) {
                            javax.swing.text.DefaultHighlighter.DefaultHighlightPainter highlightPainter =
                                    new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(Color.ORANGE);
                            rawCoreMessage.getHighlighter().addHighlight(index, index + stringToFind.length(),
                                    highlightPainter);
                        }
                    }
                } catch (BadLocationException ex) {
                    ex.printStackTrace(System.out);
                }
            }else{
                formattedCoreMessage.getHighlighter().removeAllHighlights();
                try {
                    for (int index = 0; index + stringToFind.length() < myFDocumentLength; index++) {
                        String match = myFormattedDocument.getText(index, stringToFind.length());
                        if (stringToFind.equals(match)) {
                            javax.swing.text.DefaultHighlighter.DefaultHighlightPainter highlightPainter =
                                    new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(Color.ORANGE);
                            formattedCoreMessage.getHighlighter().addHighlight(index, index + stringToFind.length(),
                                    highlightPainter);
                        }
                    }
                } catch (BadLocationException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void findTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findTextFieldActionPerformed
        jButton2ActionPerformed(evt);
    }//GEN-LAST:event_findTextFieldActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        findTextField.requestFocus();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jButton1ActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.setExtendedState(this.getExtendedState()|javax.swing.JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField findTextField;
    private javax.swing.JEditorPane formattedCoreMessage;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField messageID;
    private javax.swing.JEditorPane propertiesPane;
    private javax.swing.JEditorPane rawCoreMessage;
    private javax.swing.JTextField routinkKey;
    private javax.swing.JTextField time;
    private javax.swing.JTextField topic;
    // End of variables declaration//GEN-END:variables

    private void displayMessage(Object[] message) {
        try{
            setTitle("Message "+message[0]+"@"+(String)message[2]);
            messageID.setText(""+message[0]);
            time.setText((String)message[1]);
            topic.setText((String)message[2]);
            routinkKey.setText((String)message[3]);
            formattedCoreMessage.setText(new CustomJsonViewer().getJSON((String)message[4]));
            rawCoreMessage.setText((String)message[4]);
            String propoertiesCore = "<b>AMQP.BasicProperties</b><br>&nbsp;&nbsp;|"+
                    "<br>&nbsp;&nbsp;|__<b>Server (RabbitMQ): application_id:</b> "+myMessageProperties.getAppId()+
                    "<br>&nbsp;&nbsp;|__<b>Server (RabbitMQ): cluster_id:</b> "+myMessageProperties.getClusterId()+
                    "<br>&nbsp;&nbsp;|__<b>Server (RabbitMQ): user_id:</b> "+myMessageProperties.getUserId()+
                    "<br>&nbsp;&nbsp;|__<b>Server (RabbitMQ): message_id:</b> "+myMessageProperties.getMessageId()+
                    "<br>&nbsp;&nbsp;|__<b>Server (RabbitMQ): time_stamp:</b> "+myMessageProperties.getTimestamp()+
                    "<br>&nbsp;&nbsp;|__<b>Server (RabbitMQ): reply_to:</b> "+myMessageProperties.getReplyTo()+
                    "<br>&nbsp;&nbsp;|__<b>Server (RabbitMQ): priority:</b> "+myMessageProperties.getPriority()+
                    "<br>&nbsp;&nbsp;|__<b>Server (RabbitMQ): expiration:</b> "+myMessageProperties.getExpiration()+
                    "<br>&nbsp;&nbsp;|__<b>Server (RabbitMQ): content_type:</b> "+myMessageProperties.getContentType()+
                    "<br>&nbsp;&nbsp;|__<b>Server (RabbitMQ): content_encoding:</b> "+myMessageProperties.getContentEncoding()+
                    "<br>&nbsp;&nbsp;|__<b>Server (RabbitMQ): type:</b> "+myMessageProperties.getType()+
                    "<br>&nbsp;&nbsp;|__<b>Server (RabbitMQ): delivery_mode:</b> "+myMessageProperties.getDeliveryMode()+
                    "<br>&nbsp;&nbsp;|__<b>Server (RabbitMQ): headers:</b> "+Arrays.toString(myMessageProperties.getHeaders().keySet().toArray());
            if(myMessageProperties != null){
                String values = "";
                for(String key: myMessageProperties.getHeaders().keySet()){
                    if(key.equals("properties")){
                        values = values + "<br>"+HEADERS_SPACE+"|__<b>Client (Application): " + key + ":</b>";
                        try {
                            java.util.HashMap<String, Object> propertiesMap = (java.util.HashMap<String, Object>) myMessageProperties.
                                    getHeaders().get("properties");
                            for(String k: propertiesMap.keySet()){
                                values = values + "<br>"+HEADERS_SPACE+"&nbsp;&nbsp;&nbsp;&nbsp;"
                                        + "&nbsp;&nbsp;|__<b>Client (Application): " + k + ":</b> "
                                        + propertiesMap.get(k);
                            }
                        }catch(java.lang.ClassCastException ex) {
                            ex.printStackTrace(System.out);
                            values = values + "<br>"+HEADERS_SPACE+"&nbsp;&nbsp;&nbsp;&nbsp;"
                                    + "&nbsp;&nbsp;|__<b>" + key + ":</b> "
                                    + myMessageProperties.getHeaders().get(key).toString();
                        }
                    }else{
                        values = values + "<br>"+HEADERS_SPACE+"|__<b>Client (Application): " + key + ":</b> "
                                + myMessageProperties.getHeaders().get(key).toString();
                    }
                }
                propoertiesCore = propoertiesCore + values;
            }
            propertiesPane.setText(propoertiesCore);
        }catch(NullPointerException ex){
            System.out.println("oops, cannot display message..");
        }
    }
    
    private static final String HEADERS_SPACE = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
            
}
