/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offloadingserver;

import java.io.IOException;
import serviceRegistry.ServiceRegistry;
import serviceRegistry.DeviceData;
import communication.SocketData;
import communication.TaskData;
import resourceAllocation.ResourceAllocator;
import resourceAllocation.TaskInfoData;
/**
 *
 * @author bansa
 */
public class ServerUi extends javax.swing.JFrame {

    /**
     * Creates new form ServerUi
     */
    public ServerUi() {
        initComponents();
    }
    
    public void init(){
        providers.setEditable(false);
        receivers.setEditable(false);
        logs.setEditable(false);
        
    }
    
    public void setProviders(){
        providers.setText("No.\t    Device Name\t\tBid Price\t       CPU Freq.   \t          Free/Busy\n");
        providers.append("----------------------------------------------------");
        providers.append("----------------------------------------------------");
        providers.append("-------------------------------------\n");
        int cnt=1;
        for(DeviceData deviceData : ServiceRegistry.deviceList)
        {
            try {
                if(deviceData.getIsbusy() == 0)
                    deviceData.getObjectOutputStream().writeObject((Object)new SocketData(OffloadingServer.ACTIVE_CHECK, -1));
                providers.append(cnt+".\t    ");
                providers.append(deviceData.getDeviceInfoData().getModel()+"\t");
                providers.append(""+deviceData.getDeviceInfoData().getBidPrice()+"\t       ");
                providers.append(""+deviceData.getDeviceInfoData().getCpuFreq()/1e6+" GHz \t          ");
                if(deviceData.getIsbusy() == 1)
                    providers.append("Busy\n");
                else
                    providers.append("Free\n");
            
                cnt++;
            } catch (IOException ex) {
                
            }
            
            
        }
    }
    
    public void setReceivers(){
        receivers.setText("No.\t        Task Name\tCPU Freq.      \t    Deadline   \t        Status\n");
        receivers.append("----------------------------------------------------");
        receivers.append("----------------------------------------------------");
        receivers.append("---------------------------------------\n");
        int cnt=1;
        for(TaskInfoData taskInfoData : ResourceAllocator.taskList){
            receivers.append(cnt+".\t        ");
            receivers.append(taskInfoData.getType()+"\t\t");
            receivers.append(""+((SocketData)taskInfoData.getTaskData()).getCpuFreq()/1e6+" GHz    \t    ");
            TaskData taskData = (TaskData)taskInfoData.getTaskData();
            receivers.append(taskData.getFinalHour()+" : "+taskData.getFinalMinute()+"   \t        ");
            receivers.append(taskInfoData.getStatus()+"\n");
        }
    }
    
    public void setLogs(String str){
        logs.append(str+"\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        providers = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        receivers = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        logs = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        providers.setColumns(20);
        providers.setRows(5);
        jScrollPane1.setViewportView(providers);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Offloading Server");

        receivers.setColumns(20);
        receivers.setRows(5);
        jScrollPane2.setViewportView(receivers);

        logs.setColumns(20);
        logs.setRows(5);
        jScrollPane3.setViewportView(logs);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Service Providers ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Service Receivers");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("logs");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 495, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(291, 291, 291))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34))))
            .addGroup(layout.createSequentialGroup()
                .addGap(589, 589, 589)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerUi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea logs;
    private javax.swing.JTextArea providers;
    private javax.swing.JTextArea receivers;
    // End of variables declaration//GEN-END:variables
}
