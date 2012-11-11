/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginPage.java
 *
 * Created on Nov 7, 2009, 3:32:33 PM
 */

/**
 *
 * @author Js Lim
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends javax.swing.JFrame {

    private Database db;
    private Member mem = new Member();
    private Staff stf = new Staff();
    private Timer timer;
    private ImageIcon img;
    /** Creates new form LoginPage */
    public LoginPage() {
        try{
            db= new Database();
            img = new ImageIcon(this.getClass().getResource("images/SMD_Library_Background.jpg"));
        }
        catch(StringIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null,"StringIndexOutOfBoundsException: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
        setBackground();
        time();
        timer.start();
        setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnOuter = new javax.swing.JPanel()
        {
            protected void paintComponent(Graphics g){
                //  Scale image to size of component
                Dimension d = getSize();
                g.drawImage(img.getImage(), 0, 0, d.width, d.height, null);
                super.paintComponent(g);
            }
        }
        ;
        jlbRegister = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbtForgotPassword = new javax.swing.JButton();
        jpfPassword = new javax.swing.JPasswordField();
        jtfUserID = new javax.swing.JTextField();
        jlbUserID = new javax.swing.JLabel();
        jlbPassword = new javax.swing.JLabel();
        jbtLogin = new javax.swing.JButton();
        jbtExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SMD Library Login");
        setIconImage(new ImageIcon(getClass().getResource("images/HomeIcon.png")).getImage());
        setResizable(false);

        jlbRegister.setFont(new java.awt.Font("Tahoma", 3, 18));
        jlbRegister.setForeground(new java.awt.Color(255, 0, 0));
        jlbRegister.setText("Click here for Register");
        jlbRegister.setToolTipText("Sign Up");
        jlbRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbRegisterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbRegisterMouseExited(evt);
            }
        });
        jlbRegister.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jlbRegisterFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jlbRegisterFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("Not a member?");

        jbtForgotPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forgotpasswordIcon.png"))); // NOI18N
        jbtForgotPassword.setMnemonic('F');
        jbtForgotPassword.setText("Forgot Password ?");
        jbtForgotPassword.setToolTipText("Forgot your password? Please Click me...");
        jbtForgotPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtForgotPasswordActionPerformed(evt);
            }
        });

        jpfPassword.setFont(new java.awt.Font("Arial", 1, 14));
        jpfPassword.setToolTipText("Enter your password here");
        jpfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfPasswordActionPerformed(evt);
            }
        });

        jtfUserID.setFont(new java.awt.Font("Arial", 1, 14));
        jtfUserID.setToolTipText("Enter your ID here");
        jtfUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUserIDActionPerformed(evt);
            }
        });

        jlbUserID.setFont(new java.awt.Font("Arial", 1, 14));
        jlbUserID.setText("User ID:");

        jlbPassword.setFont(new java.awt.Font("Arial", 1, 14));
        jlbPassword.setText("Password:");

        jbtLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/153.png"))); // NOI18N
        jbtLogin.setMnemonic('L');
        jbtLogin.setText("Login");
        jbtLogin.setToolTipText("");
        jbtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLoginActionPerformed(evt);
            }
        });

        jbtExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/64px-Gnome-system-log-out.svg.png"))); // NOI18N
        jbtExit.setMnemonic('E');
        jbtExit.setText("Exit");
        jbtExit.setToolTipText("Quit the System");
        jbtExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnOuterLayout = new javax.swing.GroupLayout(jpnOuter);
        jpnOuter.setLayout(jpnOuterLayout);
        jpnOuterLayout.setHorizontalGroup(
            jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnOuterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnOuterLayout.createSequentialGroup()
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnOuterLayout.createSequentialGroup()
                                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbPassword)
                                    .addComponent(jlbUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfUserID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(jpfPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                                .addGap(36, 36, 36))
                            .addGroup(jpnOuterLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jbtForgotPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addGroup(jpnOuterLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtExit, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))))
                    .addGroup(jpnOuterLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpnOuterLayout.setVerticalGroup(
            jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnOuterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnOuterLayout.createSequentialGroup()
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbPassword)
                            .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtForgotPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtExit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbRegister)
                    .addComponent(jLabel1))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnOuter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpnOuter, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void time()
    {
        timer = new Timer(100,new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                jlbRegister.setForeground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
                jlbRegister.setBackground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
            }
        });
    }
    private void jpfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpfPasswordActionPerformed

    private void jtfUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUserIDActionPerformed

    private void jbtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLoginActionPerformed
        // TODO add your handling code here:

        if(jtfUserID.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Please enter your user ID!","Incomplete information",JOptionPane.WARNING_MESSAGE);
        else if(jpfPassword.getPassword().length==0)
            JOptionPane.showMessageDialog(null,"Please enter your password!","Incomplete information",JOptionPane.WARNING_MESSAGE);
        else{
            String id = jtfUserID.getText();
            String pw = getStringPassword(jpfPassword.getPassword());

            if(id.length()<6)
                JOptionPane.showMessageDialog(null,"Invalid ID or Password! Please re-check!","Login Fail",JOptionPane.WARNING_MESSAGE);
            else if(id.substring(0, 3).equalsIgnoreCase("stf"))
            {
                stf = db.staffLogin(id, pw);
                if(stf!=null)
                {
                    new LogFile().staffLogRecord(stf);
                    this.dispose();
                    new StaffPage(stf).setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null,"Invalid ID or Password! Please re-check!","Login Fail",JOptionPane.WARNING_MESSAGE);
            }
            else if(id.substring(0,3).equalsIgnoreCase("ADM"))
            {
                stf = db.staffLogin(id, pw);
                if(stf != null)
                {
                    new LogFile().adminLogRecord(stf);
                    this.dispose();
                    new UpdateBookPage(stf).setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null,"Invalid ID or Password! Please re-check!","Login Fail",JOptionPane.WARNING_MESSAGE);
            }
            else if(id.substring(0,3).equalsIgnoreCase("SMD")){
                mem = db.memberLogin(id,pw);
                if(mem!=null)
                {
                    new LogFile().memberLogRecord(mem);
                    new UserPage(mem).setVisible(true);
                    this.dispose();
                }
                else
                    JOptionPane.showMessageDialog(null,"Invalid ID or Password! Please re-check!","Login Fail",JOptionPane.WARNING_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null,"Invalid ID or Password! Please re-check!","Login Fail",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbtLoginActionPerformed

  private void setBackground()
  {
          java.net.URL url = this.getClass().getResource("images/SMD_Library_Background.jpg");
          ImageIcon imageBack = new ImageIcon(url);
          Dimension d = getSize();
          JLabel jlbBackground = new JLabel(imageBack);
          jlbBackground.setBounds(0, 0, imageBack.getIconWidth(),imageBack.getIconHeight());
          getLayeredPane().add(jlbBackground, new Integer(Integer.MIN_VALUE));
          jpnOuter.setOpaque(false);
          setContentPane(jpnOuter);
  }



    private void jbtForgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtForgotPasswordActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ForgotPasswordPage().setVisible(true);
    }//GEN-LAST:event_jbtForgotPasswordActionPerformed

    private void jbtExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jbtExitActionPerformed

    private void jlbRegisterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jlbRegisterFocusGained
        // TODO add your handling code here:
        jlbRegister.setForeground(Color.BLUE);
    }//GEN-LAST:event_jlbRegisterFocusGained

    private void jlbRegisterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jlbRegisterFocusLost
        // TODO add your handling code here:
        jlbRegister.setForeground(Color.RED);
    }//GEN-LAST:event_jlbRegisterFocusLost

    private void jlbRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbRegisterMouseClicked
        // TODO add your handling code here:
        new RegisterPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jlbRegisterMouseClicked

    private void jlbRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbRegisterMouseEntered
        // TODO add your handling code here:
        jlbRegister.setForeground(Color.RED);
        timer.stop();
    }//GEN-LAST:event_jlbRegisterMouseEntered

    private void jlbRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbRegisterMouseExited
        // TODO add your handling code here:
        timer.start();
    }//GEN-LAST:event_jlbRegisterMouseExited

    private String getStringPassword(char[] pw)
    {
        String password = "";
        for(int i=0;i<pw.length;i++)
        {
            password += pw[i];
        }
        return password;
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtExit;
    private javax.swing.JButton jbtForgotPassword;
    private javax.swing.JButton jbtLogin;
    private javax.swing.JLabel jlbPassword;
    private javax.swing.JLabel jlbRegister;
    private javax.swing.JLabel jlbUserID;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JPanel jpnOuter;
    private javax.swing.JTextField jtfUserID;
    // End of variables declaration//GEN-END:variables

}
