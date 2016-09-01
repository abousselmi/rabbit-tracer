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

import java.awt.Color;
import java.awt.Font;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;
import tracer.manager.Manager;
import tracer.main.RabbitTracer;
import tracer.utils.io.ConfigFileLoader;
import tracer.utils.io.ConfigFileWriter;
import tracer.utils.CustomLog;
import tracer.utils.tabs.TracingTableRenderer;
import tracer.utils.io.DataFileWriter;

/**
 *
 * @author ayoub bousselmi
 * @since September 2015
 */
public class MainUI extends javax.swing.JFrame {
    
    //propoerties  
    private final MainUI mainUI = this;
    private final HashMap<String, Object[]> exchangesMap;
    private final HashMap<String, Boolean> exchangesStatesMap;
    private final HashMap<String, Manager> computeTraceMap;
    private final ArrayList<String> tracePanePool;
    
    private final boolean useRabbitTracerLog = true;
    
    private String globalSelectedExchange = "";
    private InnerUpdater iu;
    
    public MainUI() {
        initComponents();
        initView();
        
        exchangesMap = new HashMap<String, Object[]>();
        exchangesStatesMap = new HashMap<String, Boolean>();
        computeTraceMap = new HashMap<String, Manager>();
        tracePanePool = new ArrayList<String>();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logPanelPopup = new javax.swing.JPopupMenu();
        clearMenu = new javax.swing.JMenuItem();
        jSplitPane1 = new javax.swing.JSplitPane();
        configPane = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rabbitIP = new javax.swing.JTextField();
        isCustomPort = new javax.swing.JCheckBox();
        rabbitPort = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rabbitID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rabbitPass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        rabbitVHost = new javax.swing.JTextField();
        isCustomTimout = new javax.swing.JCheckBox();
        rabbitTimout = new javax.swing.JTextField();
        addExchangeBtn = new javax.swing.JButton();
        hideSettingsCheckBox = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exchangeName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        exchangeType = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        exchangeParams = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rabbitBingingKeys = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        isUsingTimer = new javax.swing.JCheckBox();
        tracingDuration = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        viewPane = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        traceViewTabPane = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        logTextArea = new javax.swing.JTextArea();
        jToolBar3 = new javax.swing.JToolBar();
        jLabel10 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jToggleButton1 = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel9 = new javax.swing.JLabel();
        exchangeNamesList = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLabel8 = new javax.swing.JLabel();
        startBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jPanel3 = new javax.swing.JPanel();
        nbrOfMsg = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        startRunningMenu = new javax.swing.JMenuItem();
        stopRunningMenu = new javax.swing.JMenuItem();
        deleteExchangeMenu = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();

        clearMenu.setText("Clear log     ");
        clearMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearMenuActionPerformed(evt);
            }
        });
        logPanelPopup.add(clearMenu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/tracer/res/rabbit.png")));
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(0);

        configPane.setFocusable(false);
        configPane.setMinimumSize(new java.awt.Dimension(0, 0));
        configPane.setName(""); // NOI18N

        jScrollPane3.setBorder(null);
        jScrollPane3.getVerticalScrollBar().setUnitIncrement(12);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(177, 200, 207)));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(" RabbitMQ node configuration "));

        jLabel3.setText("Host (IP): ");

        rabbitIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rabbitIP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rabbitIPFocusGained(evt);
            }
        });

        isCustomPort.setText("Custom node port:");
        isCustomPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isCustomPortActionPerformed(evt);
            }
        });

        rabbitPort.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rabbitPort.setText("5672");
        rabbitPort.setToolTipText("");
        rabbitPort.setEnabled(false);
        rabbitPort.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rabbitPortFocusGained(evt);
            }
        });

        jLabel4.setText("Username: ");

        rabbitID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rabbitID.setText("guest");
        rabbitID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rabbitIDFocusGained(evt);
            }
        });

        jLabel5.setText("Password: ");

        rabbitPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rabbitPass.setText("guest");
        rabbitPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rabbitPassFocusGained(evt);
            }
        });

        jLabel6.setText("Virtual Host: ");

        rabbitVHost.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rabbitVHost.setText("/");
        rabbitVHost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rabbitVHostFocusGained(evt);
            }
        });

        isCustomTimout.setText("Custom timeout:");
        isCustomTimout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isCustomTimoutActionPerformed(evt);
            }
        });

        rabbitTimout.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rabbitTimout.setText("500");
        rabbitTimout.setToolTipText("Timeout in milliseconds");
        rabbitTimout.setEnabled(false);
        rabbitTimout.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rabbitTimoutFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rabbitIP))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(isCustomPort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rabbitPort))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rabbitID))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rabbitPass))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rabbitVHost))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(isCustomTimout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rabbitTimout)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rabbitIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isCustomPort)
                    .addComponent(rabbitPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rabbitID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rabbitPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rabbitVHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isCustomTimout)
                    .addComponent(rabbitTimout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addExchangeBtn.setText("Add Exchange");
        addExchangeBtn.setFocusable(false);
        addExchangeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExchangeBtnActionPerformed(evt);
            }
        });

        hideSettingsCheckBox.setText("Autohide settings");
        hideSettingsCheckBox.setFocusable(false);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(" Exchange configuration "));

        jLabel1.setText("Name: ");

        exchangeName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                exchangeNameFocusGained(evt);
            }
        });

        jLabel2.setText("Type: ");

        exchangeType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "topic", "direct", "fanout", "headers" }));

        jLabel13.setText("Parameters: ");

        exchangeParams.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Default", "D", "AD", "I", "D + AD", "D + I", "AD + I", "D + AD + I" }));
        exchangeParams.setToolTipText("<html>\nA RabbitMQ exchange can be:\n<ul>\n<li><b> D</b>: Durable</li>\n<li><b> AD</b>: Auto-delete</li>\n<li><b> I</b>: Internal</li>\n</ul>\nor a combination of these 3 types.<br>\nIf the exchange is not D or AD or I,<br>\nthen it must be set to <b>Default</b>\n</html>");

        jLabel7.setText("Binding keys (eg. rabbit, fox, crow):");

        rabbitBingingKeys.setColumns(20);
        rabbitBingingKeys.setRows(1);
        rabbitBingingKeys.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rabbitBingingKeysFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(rabbitBingingKeys);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exchangeName))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exchangeType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exchangeParams, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(exchangeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(exchangeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(exchangeParams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Timer configuration "));

        isUsingTimer.setText("Enable a tracing timer");
        isUsingTimer.setFocusable(false);
        isUsingTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isUsingTimerActionPerformed(evt);
            }
        });

        tracingDuration.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.MEDIUM))));
        tracingDuration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tracingDuration.setText("00:01:00");
        tracingDuration.setEnabled(false);

        jLabel14.setText("[hh:mm:ss]");
        jLabel14.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(tracingDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addComponent(isUsingTimer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(isUsingTimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tracingDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(hideSettingsCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addExchangeBtn)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hideSettingsCheckBox)
                    .addComponent(addExchangeBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel2);

        configPane.addTab("Control Panel     ", jScrollPane3);

        jSplitPane1.setLeftComponent(configPane);

        viewPane.setFocusable(false);

        traceViewTabPane.setFocusable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(traceViewTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(traceViewTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        viewPane.addTab("Statistics: Routing Keys & RPCs    ", jPanel6);

        jScrollPane2.setBorder(null);

        logTextArea.setEditable(false);
        logTextArea.setColumns(20);
        logTextArea.setRows(5);
        logTextArea.setTabSize(100);
        logTextArea.setAutoscrolls(false);
        logTextArea.setSelectedTextColor(java.awt.Color.ORANGE);
        logTextArea.setSelectionColor(new java.awt.Color(0, 0, 0));
        logTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logTextAreaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(logTextArea);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        viewPane.addTab("Logger    ", jPanel9);

        jSplitPane1.setRightComponent(viewPane);

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);
        jToolBar3.setMinimumSize(new java.awt.Dimension(273, 30));
        jToolBar3.setPreferredSize(new java.awt.Dimension(291, 30));

        jLabel10.setText("  ");
        jToolBar3.add(jLabel10);
        jToolBar3.add(jSeparator6);

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tracer/res/gear.png"))); // NOI18N
        jToggleButton1.setToolTipText("Settings");
        jToggleButton1.setFocusable(false);
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.setMaximumSize(new java.awt.Dimension(30, 30));
        jToggleButton1.setMinimumSize(new java.awt.Dimension(30, 30));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(30, 30));
        jToggleButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jToolBar3.add(jToggleButton1);
        jToolBar3.add(jSeparator1);

        jLabel9.setText(" Exchange name: ");
        jToolBar3.add(jLabel9);

        exchangeNamesList.setMaximumRowCount(10);
        exchangeNamesList.setToolTipText("Select Exchange (global variable)");
        exchangeNamesList.setFocusable(false);
        exchangeNamesList.setMinimumSize(new java.awt.Dimension(25, 200));
        exchangeNamesList.setOpaque(false);
        exchangeNamesList.setPreferredSize(new java.awt.Dimension(25, 200));
        exchangeNamesList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exchangeNamesListActionPerformed(evt);
            }
        });
        jToolBar3.add(exchangeNamesList);
        jToolBar3.add(jSeparator2);

        jLabel8.setText(" Contols: ");
        jToolBar3.add(jLabel8);

        startBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tracer/res/start.png"))); // NOI18N
        startBtn.setToolTipText("Connect/Start tracing");
        startBtn.setFocusable(false);
        startBtn.setMaximumSize(new java.awt.Dimension(30, 30));
        startBtn.setMinimumSize(new java.awt.Dimension(30, 30));
        startBtn.setPreferredSize(new java.awt.Dimension(30, 30));
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });
        jToolBar3.add(startBtn);

        stopBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tracer/res/stop.png"))); // NOI18N
        stopBtn.setToolTipText("Disconnect/Stop tracing");
        stopBtn.setEnabled(false);
        stopBtn.setFocusable(false);
        stopBtn.setMaximumSize(new java.awt.Dimension(30, 30));
        stopBtn.setMinimumSize(new java.awt.Dimension(30, 30));
        stopBtn.setPreferredSize(new java.awt.Dimension(30, 30));
        stopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBtnActionPerformed(evt);
            }
        });
        jToolBar3.add(stopBtn);

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tracer/res/delete.png"))); // NOI18N
        deleteBtn.setToolTipText("Delete Exchange");
        deleteBtn.setFocusable(false);
        deleteBtn.setMaximumSize(new java.awt.Dimension(30, 30));
        deleteBtn.setMinimumSize(new java.awt.Dimension(30, 30));
        deleteBtn.setPreferredSize(new java.awt.Dimension(30, 30));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        jToolBar3.add(deleteBtn);

        jLabel11.setText("  ");
        jToolBar3.add(jLabel11);
        jToolBar3.add(jSeparator3);

        jPanel3.setFocusable(false);

        nbrOfMsg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nbrOfMsg.setText(" ");

        jLabel12.setText("TNRM");
        jLabel12.setToolTipText("Total number of recieved messages");

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nbrOfMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nbrOfMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Save Exchange Data..          ");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);
        jMenu1.add(jSeparator7);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setText("Save Exchange Config          ");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setText("Load Exchange Config          ");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);
        jMenu1.add(jSeparator5);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Quit..               ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Run");

        startRunningMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        startRunningMenu.setText("Connect/Start tracing          ");
        startRunningMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startRunningMenuActionPerformed(evt);
            }
        });
        jMenu5.add(startRunningMenu);

        stopRunningMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        stopRunningMenu.setText("Disconnect/Stop tracing          ");
        stopRunningMenu.setEnabled(false);
        stopRunningMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopRunningMenuActionPerformed(evt);
            }
        });
        jMenu5.add(stopRunningMenu);

        deleteExchangeMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        deleteExchangeMenu.setText("Delete exchange          ");
        deleteExchangeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteExchangeMenuActionPerformed(evt);
            }
        });
        jMenu5.add(deleteExchangeMenu);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Tools");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Clear Logging Panel          ");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Clear Exchange Configuration          ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);
        jMenu4.add(jSeparator10);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Load Tracing Exchange  (Used with Firehose)          ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);
        jMenu4.add(jSeparator11);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Search for Keyword..");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);
        jMenu4.add(jSeparator9);

        jMenuItem13.setText("RabbitMQ Node Logger");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem13);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("View");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Maximize Window               ");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Minimize Window               ");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("?");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Java Memory Details");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);
        jMenu3.add(jSeparator4);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("About               ");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(916, 723));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        iu.stop();
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AboutUI(mainUI, true).setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        logTextArea.setText("  "); 
        System.out.println("ready:");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(exchangeNamesList.getItemCount() != 0){
            deleteExchange((String) exchangeNamesList.getSelectedItem());
        }else{
            System.out.println("you need to create at "
                + "least one exchage to delete one..");
        }

    }//GEN-LAST:event_deleteBtnActionPerformed
   
    private void exchangeNamesListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exchangeNamesListActionPerformed
        String selectedExchange = (String) exchangeNamesList.getSelectedItem();
        if(selectedExchange != null){
            System.out.println("'"+selectedExchange+"' is selected..");
        }
        if(exchangesStatesMap.containsKey(selectedExchange)){
            if(exchangesStatesMap.get(selectedExchange)){
                runningStateUI(true);
                globalSelectedExchange = selectedExchange;
                System.out.println("connection to this exchange is active..");
            }else{
                runningStateUI(false);
                System.out.println("connection to this exchange is not "
                    + "active..");
            }
        }
    }//GEN-LAST:event_exchangeNamesListActionPerformed

    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBtnActionPerformed
        if(exchangeNamesList.getItemCount() != 0){
            runningStateUI(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    String exchangeToTrace = (String) exchangeNamesList.
                    getSelectedItem();
                    ((Manager) computeTraceMap.get(exchangeToTrace)).
                    disconnectFromRabbitNode();
                    exchangesStatesMap.put(exchangeToTrace, false);
                }
            });
        }else{
            System.out.println("you need to create at "
                + "least one exchage to stop one..");
        }
    }//GEN-LAST:event_stopBtnActionPerformed

    public void stopTracingByEndConnectionTime(){
        stopBtnActionPerformed(null);
    }
    
    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        if(exchangeNamesList.getItemCount() != 0){
            if(!exchangesStatesMap.get((String) exchangeNamesList.
                getSelectedItem())){
            runningStateUI(true);
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    //wich exchange
                    String exchangeToTrace = (String) exchangeNamesList.
                    getSelectedItem();
                    exchangesStatesMap.put(exchangeToTrace, true);
                    if(!tracePanePool.contains(exchangeToTrace)){
                        createNewTracePaneView(exchangeToTrace);
                    }
                    startConnection(exchangeToTrace);
                    //start couting messagesb by assigning the current
                    //exchange name to the global exchange name variable
                    globalSelectedExchange = exchangeToTrace;
                }

                private void createNewTracePaneView(String exchangeToTrace) {
                    TracingTableRenderer myRenderer = 
                            new TracingTableRenderer();
                    
                    //General table view
                    JTable myTraceTable = new javax.swing.JTable(
                            new tracer.utils.tabs.TracingTableModel());
                    myTraceTable.setBorder(null);
                    myTraceTable.setDefaultRenderer(Object.class, myRenderer);
                    myTraceTable.getColumnModel().getColumn(0).setMaxWidth(70);
                    myTraceTable.getColumnModel().getColumn(0).
                    setPreferredWidth(35);
                    JTableHeader header = myTraceTable.getTableHeader();
                    header.setBackground(Color.BLACK);
                    header.setForeground(Color.ORANGE);
                    JScrollPane myTracePane = new javax.swing.JScrollPane();
                    myTracePane.setBorder(null);
                    myTracePane.setViewportView(myTraceTable);
                    tracePanePool.add(traceViewTabPane.getComponentCount(),
                            exchangeToTrace);
                    
                    //Tabbed pane to gather stats view
                    JTabbedPane statsPane = new JTabbedPane();
                    statsPane.setBorder(null);
                    //RK stats table view
                    JTable myRKStatsTable = new javax.
                    swing.JTable(new tracer.utils.tabs.
                            DynamicRKStatsTableModel());
                    myRKStatsTable.setBorder(null);
                    myRKStatsTable.getColumnModel().getColumn(0).
                            setMaxWidth(70);
                    myRKStatsTable.getColumnModel().getColumn(0).
                    setPreferredWidth(35);
                    header = myRKStatsTable.getTableHeader();
                    header.setBackground(Color.black);
                    header.setForeground(Color.ORANGE);
                    myRKStatsTable.setToolTipText(TOOLTIPTEXT);
                    JScrollPane myRKStatsPane = new javax.swing.
                            JScrollPane();
                    myRKStatsPane.setBorder(null);
                    myRKStatsPane.setViewportView(myRKStatsTable);
                    
                    //RPC stats table view
                    JTable myRPCStatsTable = new javax.
                    swing.JTable(new tracer.utils.tabs.
                            DynamicRPCStatsTableModel());
                    myRPCStatsTable.setBorder(null);
                    myRPCStatsTable.getColumnModel().getColumn(0).
                            setMaxWidth(70);
                    header = myRPCStatsTable.getTableHeader();
                    header.setBackground(Color.black);
                    header.setForeground(Color.ORANGE);
                    JScrollPane myRPCStatsPane = new javax.swing.
                            JScrollPane();
                    myRPCStatsPane.setBorder(null);
                    myRPCStatsPane.setViewportView(myRPCStatsTable);
                    
                    //final rendering
                    statsPane.add("Routing Key Statistics  ", myRKStatsPane);
                    statsPane.add("RPC Methods Statistics  ", myRPCStatsPane);
                    
                    javax.swing.JSplitPane mySplitViewer = new javax.swing.
                            JSplitPane(javax.swing.JSplitPane.VERTICAL_SPLIT,
                            myTracePane, statsPane);
                    mySplitViewer.setDividerLocation(Math.round((float)
                            (traceViewTabPane.getHeight()*0.66F)));
                    traceViewTabPane.addTab(exchangeToTrace, mySplitViewer);

                    //create new tracer and give it messages and stats tabs
                    //FIXME: with concurrency this may cause big issues. 
                    //We need to redesign the GUI to be used in concurrency.
                    Manager ct = new Manager(exchangeToTrace, mainUI,  
                            myTraceTable, myRKStatsTable, myRPCStatsTable,
                            exchangesMap.get(exchangeToTrace));
                    addNewComputeTrace(exchangeToTrace, ct);
                }

                private void addNewComputeTrace(String exch, Manager 
                        tracer) {
                    if(computeTraceMap.containsKey(exch)){
                        System.out.println("exchange already exists in compute"
                            + "trace map..");
                    } else{
                        computeTraceMap.put(exch, tracer);
                        System.out.println("exchange is added successfully to"
                            + " compute trace map..");
                    }
                }

                private void startConnection(String exchangeToTrace) {
                    System.out.println("starting connection to "+
                        exchangeToTrace+"..");
                    ((Manager) computeTraceMap.get(exchangeToTrace)).
                    connectToRabbitNode();
                    if(isUsingTimer.isSelected()){
                        String formattedTime = tracingDuration.getText();
                        int connectionDuration = 
                            Integer.parseInt(formattedTime. //hours
                                    substring(0, 2)) * 3600 +
                            Integer.parseInt(formattedTime. //minutes
                                    substring(3, 5)) * 60 +
                            Integer.parseInt(formattedTime. //seconds
                                    substring(6));
                        ((Manager) computeTraceMap.get(exchangeToTrace)).
                            setconnectionDuration(connectionDuration);
                    }
                }
            });
        }else{
            runningStateUI(false);
        }
        }else{
            System.out.println("you need to create "
                    + "at least one exchage to launch one..");
        }

    }//GEN-LAST:event_startBtnActionPerformed

    private void addExchangeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExchangeBtnActionPerformed
        boolean isValidConfig = true;
        boolean isValidPort = false;
        boolean isValidTimeout = false;
        
        if(exchangeName.getText().isEmpty()){
            System.out.println("the exchange name cannot be empty!");
            isValidConfig = false;
        }
        if(rabbitIP.getText().isEmpty()){
            System.out.println("the RabbitMQ host IP cannot be empty!");
            isValidConfig = false;
        }
        if(rabbitID.getText().isEmpty()){
            System.out.println("the RabbitMQ username cannot be empty!");
            isValidConfig = false;
        }
        if(rabbitPass.getPassword().length == 0){
            System.out.println("the RabbitMQ password cannot be empty!");
            isValidConfig = false;
        }
        if(rabbitVHost.getText().isEmpty()){
            System.out.println("the RabbitMQ virtual host cannot be empty!");
            isValidConfig = false;
        }
        if(isCustomPort.isSelected()){
            try{
                int port = Integer.parseInt(rabbitPort.getText());
                if(port > 0 && port < 65535){
                    isValidPort = true;
                }else{
                    System.out.println("the port you typed is not valid!\nUsing default port(5672)..");
                    isValidConfig = false;
                }
            }catch(NumberFormatException ex){
                System.out.println("the port you typed is not valid!\nUsing default port (5672)..");
                isValidConfig = false;
            }
        }
        if(isCustomTimout.isSelected()){
            try{
                int timeout = Integer.parseInt(rabbitTimout.getText());
                if(timeout > 0){
                    isValidTimeout = true;
                }else{
                    System.out.println("the timeout you typed is not valid!\nUsing default timeout (500 ms)..");
                    isValidConfig = false;
                }
            }catch(NumberFormatException ex){
                System.out.println("the timeout you typed is not valid!\nUsing default timeout (500 ms)..");
                isValidConfig = false;
            }
        }
        if(isValidConfig){
            addNewExchange(isValidPort, isValidTimeout);
            if(hideSettingsCheckBox.isSelected()){
                jSplitPane1.setDividerLocation(0);
                DIVIDER_STATE = false;
                jToggleButton1.setSelected(false);
            }
        }else{
            System.out.println("please check the confguration and try again!");
        }
    }//GEN-LAST:event_addExchangeBtnActionPerformed

    private void rabbitTimoutFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rabbitTimoutFocusGained
        rabbitTimout.selectAll();
    }//GEN-LAST:event_rabbitTimoutFocusGained

    private void rabbitBingingKeysFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rabbitBingingKeysFocusGained
        rabbitBingingKeys.selectAll();
    }//GEN-LAST:event_rabbitBingingKeysFocusGained

    private void rabbitVHostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rabbitVHostFocusGained
        rabbitVHost.selectAll();
    }//GEN-LAST:event_rabbitVHostFocusGained

    private void rabbitPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rabbitPassFocusGained
        rabbitPass.selectAll();
    }//GEN-LAST:event_rabbitPassFocusGained

    private void rabbitIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rabbitIDFocusGained
        rabbitID.selectAll();
    }//GEN-LAST:event_rabbitIDFocusGained

    private void rabbitPortFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rabbitPortFocusGained
        rabbitPort.selectAll();
    }//GEN-LAST:event_rabbitPortFocusGained

    private void isCustomPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isCustomPortActionPerformed
        if(isCustomPort.isSelected()){
            rabbitPort.setEnabled(true);
            System.out.println("user is using custom rabbit port..");
        }else{
            rabbitPort.setEnabled(false);
            System.out.println("user is using default rabbit port..");
        }
    }//GEN-LAST:event_isCustomPortActionPerformed

    private void rabbitIPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rabbitIPFocusGained
        rabbitIP.selectAll();
    }//GEN-LAST:event_rabbitIPFocusGained

    private void exchangeNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exchangeNameFocusGained
        exchangeName.selectAll();
    }//GEN-LAST:event_exchangeNameFocusGained

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.out.println("loading Tracing Exchange infos.. (Used with Firehose)");
        exchangeName.setText("amq.rabbitmq.trace");
        exchangeType.setSelectedIndex(TOPIC_EXCHANGE);
        exchangeParams.setSelectedIndex(DURABLE_INTERNAL_EXCHANGE);
        rabbitBingingKeys.setText("publish.#, deliver.#");
        System.out.println("INFO: when using the Firehose tracing plugin, make sure to \n"
                + "  run:\n"
                + "      $ sudo rabbitmqctl trace_on \n"
                + "  Using this exchange, you can trace all incoming messages \n"
                + "  using the routing key \'publish.#\', and all outgoing \n"
                + "  messages using the routing key \'deliver.#\'. If you are \n"
                + "  interested in one type of flow, just keep its \n"
                + "  corresponding routing key and delete the other one.");
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        exchangeName.setText("");
        exchangeType.setSelectedIndex(0);
        exchangeParams.setSelectedIndex(0);
        rabbitIP.setText("");
        rabbitPort.setText("5672");
        rabbitPort.setEnabled(false);
        isCustomPort.setSelected(false);
        rabbitID.setText("");
        rabbitPass.setText("");
        rabbitBingingKeys.setText("");
        rabbitTimout.setText("500");
        rabbitTimout.setEnabled(false);
        isCustomTimout.setSelected(false);
        System.out.println("exchange configuration is clear..");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SearchUI(mainUI, (String) exchangeNamesList.getSelectedItem()).setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        if(!DIVIDER_STATE){
            jSplitPane1.setResizeWeight(0.0);
        }
    }//GEN-LAST:event_formWindowStateChanged

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        this.setExtendedState(this.getExtendedState()|javax.swing.JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        this.setState(javax.swing.JFrame.ICONIFIED);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if(jToggleButton1.isSelected()){
            jSplitPane1.setDividerLocation(320);
            DIVIDER_STATE = true;
        }else{
            jSplitPane1.setDividerLocation(0);
            DIVIDER_STATE = false;
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MemoryUI(mainUI, true).setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if(exchangeNamesList.getItemCount() > 0){
            saveExchangeInboxToFile();
        }else{
            System.out.println("exchanges list is empty..");
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // save exchange config
        String[][] configData = new String[][]{
            {"rabbitIP",rabbitIP.getText()},
            {"isCustomPort",isCustomPort.isSelected()+""},
            {"rabbitPort",rabbitPort.getText()},
            {"rabbitID",rabbitID.getText()},
            {"rabbitVHost",rabbitVHost.getText()},
            {"isCustomTimout",isCustomTimout.isSelected()+""},
            {"rabbitTimout",rabbitTimout.getText()},
            {"exchangeName",exchangeName.getText()},
            {"exchangeType",exchangeType.getSelectedIndex()+""},
            {"exchangeParams",exchangeParams.getSelectedIndex()+""},
            {"rabbitBingingKeys",rabbitBingingKeys.getText()}};
        
        String myFileName = exchangeName.getText()+"_"+rabbitIP.getText()+".ini";
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File(configsDirectory));
        chooser.setDialogTitle("save as "+myFileName+"..");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);
        chooser.setSelectedFile(new java.io.File(myFileName));
        
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            configsDirectory = chooser.getCurrentDirectory().getAbsolutePath();
            System.out.println("current configs dir: "+configsDirectory);
            ConfigFileWriter cfw = new ConfigFileWriter(
                    chooser.getSelectedFile(), configData);
        }else {
            System.out.println("cancel saving data..");
        }
        
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // load config file
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File(configsDirectory));
        chooser.setDialogTitle("load config file..");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);
        
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            configsDirectory = chooser.getCurrentDirectory().getAbsolutePath();
            System.out.println("current configs dir: "+configsDirectory);
            HashMap<String,String> configMap = new ConfigFileLoader().
                    loadConfig(chooser.getSelectedFile());
            if(!configMap.isEmpty()){
                try {
                    rabbitIP.setText(configMap.get("rabbitIP"));
                    isCustomPort.setSelected(Boolean.valueOf(configMap.get("isCustomPort")));
                    rabbitPort.setText(configMap.get("rabbitPort"));
                    rabbitID.setText(configMap.get("rabbitID"));
                    rabbitVHost.setText(configMap.get("rabbitVHost"));
                    isCustomTimout.setSelected(Boolean.valueOf(configMap.get("isCustomTimout")));
                    rabbitTimout.setText(configMap.get("rabbitTimout"));
                    exchangeName.setText(configMap.get("exchangeName"));
                    exchangeType.setSelectedIndex(Integer.valueOf(configMap.get("exchangeType")));
                    exchangeParams.setSelectedIndex(Integer.valueOf(configMap.get("exchangeParams")));
                    rabbitBingingKeys.setText(configMap.get("rabbitBingingKeys"));
                    if(isCustomPort.isSelected()){
                        rabbitPort.setEnabled(true);
                    }else{
                        rabbitPort.setEnabled(false);
                    }
                    if(isCustomTimout.isSelected()){
                        rabbitTimout.setEnabled(true);
                    }else{
                        rabbitTimout.setEnabled(false);
                    }
                } catch(Exception ex){
                    System.out.println("config file is damaged..");
                }
            }
            rabbitPass.setText("");
        }else {
            System.out.println("cancel loading data..");
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void isCustomTimoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isCustomTimoutActionPerformed
        // added later because forgotten..
        if(isCustomTimout.isSelected()){
            rabbitTimout.setEnabled(true);
        }else{
            rabbitTimout.setEnabled(false);
        }
    }//GEN-LAST:event_isCustomTimoutActionPerformed

    private void startRunningMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startRunningMenuActionPerformed
        startBtnActionPerformed(evt);
    }//GEN-LAST:event_startRunningMenuActionPerformed

    private void stopRunningMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopRunningMenuActionPerformed
        stopBtnActionPerformed(evt);
    }//GEN-LAST:event_stopRunningMenuActionPerformed

    private void deleteExchangeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteExchangeMenuActionPerformed
        deleteBtnActionPerformed(evt);
    }//GEN-LAST:event_deleteExchangeMenuActionPerformed

    private void logTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logTextAreaMouseClicked
        if(SwingUtilities.isRightMouseButton(evt)){
            logPanelPopup.show(logTextArea, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_logTextAreaMouseClicked

    private void clearMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearMenuActionPerformed
        jMenuItem5ActionPerformed(evt);
    }//GEN-LAST:event_clearMenuActionPerformed

    private void isUsingTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isUsingTimerActionPerformed
        if(isUsingTimer.isSelected()){
            tracingDuration.setEnabled(true);
            jLabel14.setEnabled(true);
        }else{
            tracingDuration.setEnabled(false);
            jLabel14.setEnabled(false);
        }  
    }//GEN-LAST:event_isUsingTimerActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoggerUI().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private boolean DIVIDER_STATE = false;
    private final int TOPIC_EXCHANGE = 0;
    private final int DURABLE_INTERNAL_EXCHANGE = 1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addExchangeBtn;
    private javax.swing.JMenuItem clearMenu;
    private javax.swing.JTabbedPane configPane;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JMenuItem deleteExchangeMenu;
    private javax.swing.JTextField exchangeName;
    private javax.swing.JComboBox exchangeNamesList;
    private javax.swing.JComboBox exchangeParams;
    private javax.swing.JComboBox exchangeType;
    private javax.swing.JCheckBox hideSettingsCheckBox;
    private javax.swing.JCheckBox isCustomPort;
    private javax.swing.JCheckBox isCustomTimout;
    private javax.swing.JCheckBox isUsingTimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JPopupMenu logPanelPopup;
    private javax.swing.JTextArea logTextArea;
    private javax.swing.JLabel nbrOfMsg;
    private javax.swing.JTextArea rabbitBingingKeys;
    private javax.swing.JTextField rabbitID;
    private javax.swing.JTextField rabbitIP;
    private javax.swing.JPasswordField rabbitPass;
    private javax.swing.JTextField rabbitPort;
    private javax.swing.JTextField rabbitTimout;
    private javax.swing.JTextField rabbitVHost;
    private javax.swing.JButton startBtn;
    private javax.swing.JMenuItem startRunningMenu;
    private javax.swing.JButton stopBtn;
    private javax.swing.JMenuItem stopRunningMenu;
    private javax.swing.JTabbedPane traceViewTabPane;
    private javax.swing.JFormattedTextField tracingDuration;
    private javax.swing.JTabbedPane viewPane;
    // End of variables declaration//GEN-END:variables
        
    private void initView() {
        setTitle("RabbitTracer v"+tracer.main.RabbitTracer.APP_VERSION);
        if(useRabbitTracerLog){
            PrintStream printStream = new PrintStream(new CustomLog(
                    logTextArea));
            System.setOut(printStream);
            //System.setErr(printStream);
        }
        logTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        System.out.println("\n+----------------------------------------"
                + "-------------+");
        System.out.println(" Welcome to RabbitTracer v"+
                tracer.main.RabbitTracer.APP_VERSION);
        System.out.println("     Copyright - 2015 Orange (OLN Lannion)");
        System.out.println("     Author: Ayoub BOUSSELMI - NAVI Team");
        System.out.println("+------------------------------------------"
                + "-----------+");
        iu = new InnerUpdater();
        iu.start();
    }
    
    private void addNewExchange(boolean isValidPort, boolean isValidTimeout) {
        //add new exange to the exchanges map
        String exchName = exchangeName.getText()+"@"+rabbitIP.getText();
        if(!exchangesMap.containsKey(exchName)){
            int rmqPort = 5672;
            if(isCustomPort.isSelected()){
                if(isValidPort){
                    rmqPort = Integer.getInteger(rabbitPort.getText());
                }
            }
            int rmqTimeout = 500;
            if(isCustomTimout.isSelected()){
                if(isValidTimeout){
                    rmqTimeout = Integer.getInteger(rabbitTimout.getText());
                }
            }
            //formatting binding keys
            StringTokenizer st = new StringTokenizer(rabbitBingingKeys.
                    getText().replaceAll(" ", ""),
                    ",");
            String[] bks = new String[st.countTokens()];
            int i = 0;
            while (st.hasMoreTokens()) {
                bks[i] = st.nextToken();
                i++;
            }
            
            Object[] exchangeMetaDataObject = new Object[]{exchangeName.
                    getText(), String.valueOf(exchangeType.getSelectedItem()),
                    exchangeParams.getSelectedIndex(), rabbitIP.getText(),
                    rmqPort, rabbitID.getText(), String.copyValueOf(rabbitPass.
                            getPassword()),
                    rabbitVHost.getText(), bks, rmqTimeout};
            exchangesMap.put(exchName, exchangeMetaDataObject);
            exchangeNamesList.addItem(exchName);
            exchangesStatesMap.put(exchName, false);
            System.out.println("exchange '"+exchName+"' is added "
                    + "successfully..");
        }else {
            System.out.println("the exchange you are trying to add exists "
                        + "already!");
        }
    }
    
    private void deleteExchange(String exchngName){
        //delete exange from the exchanges map
        if(exchangesMap.containsKey(exchngName)){
            exchangesMap.remove(exchngName);
            exchangeNamesList.removeItem(exchngName);
            exchangesStatesMap.remove(exchngName);
            computeTraceMap.remove(exchngName);
            int tracePaneID = tracePanePool.indexOf(exchngName);
            if(tracePaneID > -1){
                traceViewTabPane.remove(tracePaneID);
                tracePanePool.remove(exchngName);
                System.out.println("exchange '"+exchngName+"' is removed "
                        + "successfully..");
            }
        } else {
            System.out.println("the exchange you are trying to remove does not"
                    + " exist, so it is not removed..");
        }
    }
    
    public ArrayList<Object[]> getExchangeData(String exchangeToSearchIn){
        return computeTraceMap.get(exchangeToSearchIn).getInbox();
    }
    
    private void saveExchangeInboxToFile(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                String myFileName = exchangeNamesList.getSelectedItem().
                        toString();
                myFileName = myFileName.replaceAll("@", "_");
                
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf1 = new SimpleDateFormat("HHmmssSSS");
                SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd");
                String timeStamp = sdf1.format(cal.getTime());
                String data = sdf2.format(cal.getTime());
                myFileName = myFileName + "_data_"+timeStamp+".jrt";
                
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File(workingDirectory));
                chooser.setDialogTitle("save as "+myFileName+"..");
                chooser.setFileSelectionMode(JFileChooser.
                        FILES_AND_DIRECTORIES);
                chooser.setAcceptAllFileFilterUsed(true);
                chooser.setSelectedFile(new java.io.File(myFileName));
                
                if (chooser.showSaveDialog(MainUI.this) == JFileChooser.
                        APPROVE_OPTION) {
                    workingDirectory = chooser.getCurrentDirectory().
                            getAbsolutePath();
                    System.out.println("current working dir: "+
                            workingDirectory);
                    new DataFileWriter(chooser.getSelectedFile(),
                            getContentToSave(timeStamp, data));
                }else {
                    System.out.println("cancel saving data..");
                }
            }
        });
    }

    private String workingDirectory = ".";
    private String configsDirectory = ".";
    
    private final String TOOLTIPTEXT = ""
            + "<html><b>id:</b> message id (a RabbitTracer id)<br>"
            + "<b>rk:</b> routing key<br>"
            + "<b>nbr(msg):</b> number of received messages<br>"
            + "<b>%msg/rk:</b> % of messages per routing key<br>"
            + "<b>nbr(msg)/5s:</b> nbr(msg) in the last 5s<br>"
            + "<b>rate.msg/s:</b> mean rate per second<br>";

    private String getContentToSave(String timeStamp, String date) {
        String exchName = exchangeNamesList.getSelectedItem().toString();
        String content = "RabbitTracer v"+RabbitTracer.APP_VERSION+"\n";
        content += "exchange.name: "+exchName+"\n";
        content += "date: "+date+"\n";
        content += "time: "+timeStamp+"\n";
        
        //process stats
        if(computeTraceMap.isEmpty()){
            System.out.println("saving an empty data file...");
        }else{
            content += "total number of messages: "+computeTraceMap.
                    get(exchName).getInbox().size()+"\n\n\n";
            content += "ROUTING KEY STATS DATA\n\n";
            content += computeTraceMap.get(exchName).getRKStatsScreenshot()+
                    "\n\n\n";
            content += "RPC STATS DATA\n\n";
            content += computeTraceMap.get(exchName).getRPCStatsScreenshot()+
                    "\n\n\n";
            
            System.out.println("loading exchange log data...");
            content += "EXCHANGE INBOX DATA\n\n";
            content += computeTraceMap.get(exchName).getLogfromInbox();
        }
        
        return content;
    }
    
    private void runningStateUI(boolean isRunning){
        if(isRunning){
            startBtn.setEnabled(false);
            startRunningMenu.setEnabled(false);
            stopBtn.setEnabled(true);
            stopRunningMenu.setEnabled(true);
            deleteBtn.setEnabled(false);
            deleteExchangeMenu.setEnabled(false);
        }else{
            startBtn.setEnabled(true);
            startRunningMenu.setEnabled(true);
            stopBtn.setEnabled(false);
            stopRunningMenu.setEnabled(false);
            deleteBtn.setEnabled(true);
            deleteExchangeMenu.setEnabled(true);
        }
    }
    
    private class InnerUpdater implements Runnable {

        private boolean isRunning = true;
        
        @Override
        public void run() {
            
            while (isRunning) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if(!globalSelectedExchange.isEmpty()){
                            jLabel12.setText("TNRM from "+
                                    globalSelectedExchange+":");
                            //FIXME: too complecated and not very usefull
                            //may be deleted in the future..
                            if(computeTraceMap.
                                    containsKey(globalSelectedExchange)){
                                if(computeTraceMap.
                                            get(globalSelectedExchange).
                                            getInbox() != null){
                                    nbrOfMsg.setText(""+
                                    computeTraceMap.
                                            get(globalSelectedExchange).
                                            getInbox().size());
                                }
                            }
                        }else{
                            jLabel12.setText("TNRM");
                            nbrOfMsg.setText(" ");
                        }
                    }
                });
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException ex) {
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
}
