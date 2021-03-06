/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ethan
 */
public class ClientGUI extends javax.swing.JFrame {

    /**
     * Creates new form ClientGUI
     */
    
    private PersonClient p = new PersonClient();
    private Person myPerson = new Person("","");
    private Date myDate = new Date();
    private Message myMessage = new Message();
    private String Language;
    

    public ClientGUI(Person myPerson, String fileName) throws IOException {

            initComponents();
            Language = fileName;
            UpdateLanguage();
            this.myPerson = myPerson;
            jLabel3.setText(myPerson.getUserName());
            AutoConnect();
            ReadMessage.start();
            
    }

    ClientGUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        Messagetxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Chattxt = new javax.swing.JTextArea();
        Sendbtn = new javax.swing.JButton();
        Connectbtn = new javax.swing.JButton();
        Connectiontxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        chckQuestion = new javax.swing.JCheckBox();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Message:");

        Chattxt.setColumns(20);
        Chattxt.setRows(5);
        jScrollPane1.setViewportView(Chattxt);

        Sendbtn.setText("Send");
        Sendbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendbtnActionPerformed(evt);
            }
        });

        Connectbtn.setText("LogOut");
        Connectbtn.setToolTipText("");
        Connectbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectbtnActionPerformed(evt);
            }
        });

        Connectiontxt.setEditable(false);

        jLabel2.setText("Logged in as:");

        jLabel3.setText("jLabel3");

        chckQuestion.setSelected(true);
        chckQuestion.setText("Question");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(Sendbtn)
                                    .addGap(15, 15, 15))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(Connectbtn))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Messagetxt, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                .addComponent(Connectiontxt))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chckQuestion)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(chckQuestion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Connectbtn)
                    .addComponent(Connectiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Messagetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sendbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AutoListen(){
        String text1 = null;
     try {
            text1 = p.listen();
        } catch (IOException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
     Chattxt.append( text1 + "\n");
    
    }
    
    private void UpdateLanguage(){
    try{
         Properties prop = new Properties(); 
         FileInputStream in =  new FileInputStream(Language);
         prop.load(in);
         jLabel2.setText(prop.getProperty("CurrentUser"));
         chckQuestion.setText(prop.getProperty("Question"));
         jLabel1.setText(prop.getProperty("Message"));
         Sendbtn.setText(prop.getProperty("Send"));
         Connectbtn.setText(prop.getProperty("Logout"));
    
    
    
    }
    catch(IOException exc){
      exc.printStackTrace(); 
      }
    
    
    }
    
    
    private void AutoConnect(){
        
        try {
            p.connect();
            Connectiontxt.setText("CONNECTED");
        } catch (IOException ex) {
            Connectiontxt.setText("Not Connected");
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
    }
    private void ConnectbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectbtnActionPerformed
        // TODO add your handling code here:
          
        String mesg = "Bye";
        myMessage.sendMessage(mesg);
        try {
                p.send(myMessage.ReceiveMessage());
            } catch (IOException ex) {
                Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        Connectiontxt.setText("Logged-Out");
            
        
    }//GEN-LAST:event_ConnectbtnActionPerformed

    private void SendbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendbtnActionPerformed
       
        if(chckQuestion.isSelected()){
        
         String mesg = "Sender Name:  " + myPerson.getUserName() + "\n" +"("+ myDate.toString()+ ")  " + myPerson.getUserName()+ ": " + Messagetxt.getText() + "?";
                ///Chattxt.append(mesg);
                myMessage.sendMessage(mesg);
        }
        else{ 
        String mesg = "Sender Name:  " + myPerson.getUserName() + "\n" +"("+ myDate.toString()+ ")  " + myPerson.getUserName()+ ": " + Messagetxt.getText();
        ///Chattxt.append(mesg);
           myMessage.sendMessage(mesg);
        }
         try {
                p.send(myMessage.ReceiveMessage());
            } catch (IOException ex) {
                Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
         
         

        
    }//GEN-LAST:event_SendbtnActionPerformed
        Thread ReadMessage = new Thread(new Runnable(){
        @Override
        public void run() {
           while(true) {
              AutoListen();
        }   
        }
    });
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
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
                
            }
      
            
            
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Chattxt;
    private javax.swing.JButton Connectbtn;
    private javax.swing.JTextField Connectiontxt;
    private javax.swing.JTextField Messagetxt;
    private javax.swing.JButton Sendbtn;
    private javax.swing.JCheckBox chckQuestion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
