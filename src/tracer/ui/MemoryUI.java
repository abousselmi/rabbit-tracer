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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ayoub bousselmi
 */
public class MemoryUI extends javax.swing.JDialog{

    private final DecimalFormat myDecimalFormatter;
    private final Locale myLocale;
    private final UpdateMemory memoryThread;
    
    
    public MemoryUI(tracer.ui.MainUI parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        myLocale  = new Locale(System.getProperty("user.language"), System.getProperty("user.country"));
        myDecimalFormatter = (DecimalFormat) NumberFormat.getNumberInstance(myLocale);
        myDecimalFormatter.applyPattern("###,##0.000");

        DefaultTableCellRenderer myRightRenderer = new DefaultTableCellRenderer();
        myRightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(myRightRenderer);

        memoryThread = new UpdateMemory();
        memoryThread.start();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Java Memory Details");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/tracer/res/rabbit.png")));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Maximum available memory (KB)", null},
                {"Total memory (KB)", null},
                {"Free memory (KB)", null},
                {"Used memory (KB)", null},
                {"Free memory (%)", null},
                {"Used memory (%)", null}
            },
            new String [] {
                "Data", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setOpaque(false);
        jTable1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jTable1.setSelectionForeground(new java.awt.Color(255, 153, 0));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Close");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        memoryThread.stop();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables


    
    private class UpdateMemory implements Runnable {
        
        private boolean flag = true;
        
        @Override
        public void run() {
            while(flag){
                jTable1.setValueAt(myDecimalFormatter.format(Runtime.getRuntime().maxMemory()/1024.0F), 0, 1);
                jTable1.setValueAt(myDecimalFormatter.format(Runtime.getRuntime().totalMemory()/1024.0F), 1, 1);
                jTable1.setValueAt(myDecimalFormatter.format(Runtime.getRuntime().freeMemory()/1024.0F), 2, 1);
                jTable1.setValueAt(myDecimalFormatter.format((Runtime.getRuntime().totalMemory()-
                        Runtime.getRuntime().freeMemory())/1024.0F), 3, 1);
                jTable1.setValueAt(myDecimalFormatter.format((Runtime.getRuntime().freeMemory()*1.0F/
                        Runtime.getRuntime().totalMemory())*100), 4, 1);
                jTable1.setValueAt(myDecimalFormatter.format(((Runtime.getRuntime().totalMemory()-
                        Runtime.getRuntime().freeMemory())*1.0F/Runtime.getRuntime().totalMemory())*100), 5, 1);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MemoryUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        public void start(){
            new Thread(this).start();
        }
        
        public void stop(){
            flag = false;
        }
    }
}
