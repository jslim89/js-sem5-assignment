/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StaffEditProfile.java
 *
 * Created on Dec 7, 2009, 4:37:28 PM
 */

/**
 *
 * @author Js Lim
 */

import javax.swing.*;
import java.awt.*;

public class StaffEditProfile extends javax.swing.JFrame {

    private ImageIcon img;
    private Staff stf;
    /** Creates new form StaffEditProfile */
    public StaffEditProfile(Staff stf) {
        this.stf = stf;
        img = new ImageIcon(this.getClass().getResource("images/SMD_Library_Background.jpg"));
        initComponents();
        setBackground();
        jlbWelcome.setText("Hi, "+this.stf.getLastName());
        jlbID.setText("ID: "+this.stf.getID());
        setLocationRelativeTo(null);
        jtfAddress.setText(stf.getAddress());
        jtfPostcode.setText(stf.getPostcode());
        jtfTown.setText(stf.getTown());
        jtfState.setText(stf.getState());
        jtfCountry.setText(stf.getCountry());
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
        jpfPassword = new javax.swing.JPasswordField();
        jpfConfirmPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfAddress = new javax.swing.JTextField();
        jtfPostcode = new javax.swing.JTextField();
        jtfTown = new javax.swing.JTextField();
        jtfState = new javax.swing.JTextField();
        jtfCountry = new javax.swing.JTextField();
        jtfPhoneNo = new javax.swing.JTextField();
        jlbOldPassword = new javax.swing.JLabel();
        jpfOldPassword = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jbtClear = new javax.swing.JButton();
        jbtEdit = new javax.swing.JButton();
        jlbWelcome = new javax.swing.JLabel();
        jlbID = new javax.swing.JLabel();
        jbtReset = new javax.swing.JButton();
        jbtBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Staff Edit Profile");
        setIconImage(new ImageIcon(getClass().getResource("images/HomeIcon.png")).getImage());
        setResizable(false);

        jpfPassword.setBackground(new java.awt.Color(255, 255, 51));
        jpfPassword.setToolTipText("Yellow field cannot be blank");

        jpfConfirmPassword.setBackground(new java.awt.Color(255, 255, 51));
        jpfConfirmPassword.setToolTipText("Yellow field cannot be blank");

        jLabel3.setText("Password");

        jLabel4.setText("Confirm Password");

        jtfAddress.setBackground(new java.awt.Color(255, 255, 51));
        jtfAddress.setToolTipText("Yellow field cannot be blank");

        jtfPostcode.setBackground(new java.awt.Color(255, 255, 51));
        jtfPostcode.setToolTipText("Yellow field cannot be blank");

        jtfTown.setBackground(new java.awt.Color(255, 255, 51));
        jtfTown.setToolTipText("Yellow field cannot be blank");

        jtfState.setBackground(new java.awt.Color(255, 255, 51));
        jtfState.setToolTipText("Yellow field cannot be blank");

        jtfCountry.setBackground(new java.awt.Color(255, 255, 51));
        jtfCountry.setText("Malaysia");
        jtfCountry.setToolTipText("Yellow field cannot be blank");

        jlbOldPassword.setText("Old Password");

        jpfOldPassword.setBackground(new java.awt.Color(255, 255, 51));
        jpfOldPassword.setToolTipText("Yellow field cannot be blank");

        jLabel9.setText("Postcode");

        jLabel8.setText("Address");

        jLabel14.setText("Phone No.");

        jLabel11.setText("Country");

        jLabel10.setText("State");

        jLabel12.setText("Town");

        jbtClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Symbols-Delete-256x256.png"))); // NOI18N
        jbtClear.setMnemonic('C');
        jbtClear.setText("Clear");
        jbtClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtClearActionPerformed(evt);
            }
        });

        jbtEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil-128x128.png"))); // NOI18N
        jbtEdit.setMnemonic('E');
        jbtEdit.setText("Edit");
        jbtEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEditActionPerformed(evt);
            }
        });

        jlbWelcome.setFont(new java.awt.Font("Arial", 1, 14));
        jlbWelcome.setText("Hi");

        jlbID.setFont(new java.awt.Font("Arial", 1, 14));
        jlbID.setText("ID:");

        jbtReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_reset.png"))); // NOI18N
        jbtReset.setMnemonic('C');
        jbtReset.setText("Reset");
        jbtReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtResetActionPerformed(evt);
            }
        });

        jbtBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/240.png"))); // NOI18N
        jbtBack.setMnemonic('B');
        jbtBack.setText("Back To Main Page");
        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnOuterLayout = new javax.swing.GroupLayout(jpnOuter);
        jpnOuter.setLayout(jpnOuterLayout);
        jpnOuterLayout.setHorizontalGroup(
            jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnOuterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbWelcome)
                    .addComponent(jlbID))
                .addContainerGap(610, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnOuterLayout.createSequentialGroup()
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnOuterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtEdit)
                        .addGap(49, 49, 49)
                        .addComponent(jbtReset)
                        .addGap(48, 48, 48)
                        .addComponent(jbtClear)
                        .addGap(26, 26, 26))
                    .addGroup(jpnOuterLayout.createSequentialGroup()
                        .addContainerGap(89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jlbOldPassword)
                            .addComponent(jLabel3))
                        .addGap(21, 21, 21)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jpfOldPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jpfPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jpfConfirmPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnOuterLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTown, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfState, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnOuterLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jbtBack)))
                .addGap(40, 40, 40))
        );
        jpnOuterLayout.setVerticalGroup(
            jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnOuterLayout.createSequentialGroup()
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnOuterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlbWelcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlbID)
                        .addGap(54, 54, 54)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jpfOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbOldPassword))
                        .addGap(31, 31, 31)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jpfConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnOuterLayout.createSequentialGroup()
                        .addContainerGap(62, Short.MAX_VALUE)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnOuterLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jtfState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnOuterLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfTown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnOuterLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10))
                                    .addGroup(jpnOuterLayout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jtfCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))))))
                        .addGap(18, 18, 18)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtEdit)
                    .addComponent(jbtReset)
                    .addComponent(jbtBack)
                    .addComponent(jbtClear))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnOuter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnOuter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtClearActionPerformed
        // TODO add your handling code here:
        jpfOldPassword.setText("");
        jpfPassword.setText("");
        jpfConfirmPassword.setText("");
        jtfAddress.setText("");
        jtfPostcode.setText("");
        jtfTown.setText("");
        jtfState.setText("");
        jtfCountry.setText("Malaysia");
        jtfPhoneNo.setText("");
}//GEN-LAST:event_jbtClearActionPerformed

    private void jbtEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEditActionPerformed
        // TODO add your handling code here:
        if(jpfPassword.getPassword().length<1 || jpfOldPassword.getPassword().length<1 || jpfConfirmPassword.getPassword().length<1 ||
           jtfAddress.getText().equals("") || jtfPostcode.getText().equals("") || jtfTown.getText().equals("") ||
           jtfState.getText().equals("") || jtfCountry.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Please fill in all the neccessary information!","Incomplete Information",JOptionPane.PLAIN_MESSAGE);
        else if(!stf.getPassword().equals(getStringPassword(jpfOldPassword.getPassword())))
            JOptionPane.showMessageDialog(null,"Old password does not match!","Invalid Password",JOptionPane.PLAIN_MESSAGE);
        else if(!getStringPassword(jpfPassword.getPassword()).equals(getStringPassword(jpfConfirmPassword.getPassword())))
            JOptionPane.showMessageDialog(null,"Password does not confirm!","Password not confirmed",JOptionPane.PLAIN_MESSAGE);
        else
        {
            try{
                boolean isValid = true;
                if(!jtfPhoneNo.getText().equals(""))
                    Long.parseLong(jtfPhoneNo.getText());
                Integer.parseInt(jtfPostcode.getText());
                Staff tempStaff = new Staff();
                tempStaff.setID(stf.getID());
                tempStaff.setPassword(getStringPassword(jpfPassword.getPassword()));
                tempStaff.setAddress(jtfAddress.getText());
                tempStaff.setPostcode(jtfPostcode.getText());
                tempStaff.setState(jtfState.getText());
                tempStaff.setTown(jtfTown.getText());
                tempStaff.setCountry(jtfCountry.getText());

                String msg = "Address: "+tempStaff.getAddress()+
                            "\nPostcode: "+tempStaff.getPostcode()+
                            "\nTown: "+tempStaff.getTown()+
                            "\nState: "+tempStaff.getState()+
                            "\nCountry: "+tempStaff.getCountry();

                if(!jtfPhoneNo.getText().equals(""))
                {
                    if(jtfPhoneNo.getText().length()>8 && jtfPhoneNo.getText().length()<=12)
                    {
                        tempStaff.setPhone(jtfPhoneNo.getText());
                        msg += "\nPhone No.: "+tempStaff.getPhone();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Phone no range should between 9 and 12!","Password not confirmed",JOptionPane.PLAIN_MESSAGE);
                        isValid = false;
                    }
                }
                if(isValid){
                    int x = JOptionPane.showConfirmDialog(null, msg,"Confirm?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(x==JOptionPane.YES_OPTION)
                    {
                            tempStaff = new Database().editStaffProfile(tempStaff);
                            new StaffPage(tempStaff).setVisible(true);
                            this.dispose();
                    }
                }
            }
            catch(ICFormatException e)
            {
                JOptionPane.showMessageDialog(null,e.getMessage(),"Invalid Input",JOptionPane.ERROR_MESSAGE);
                new LogFile().exceptionRecord(e.getStackTrace());
            }
            
            catch(NameFormatException e)
            {
                JOptionPane.showMessageDialog(null,e.getMessage(),"Invalid Input",JOptionPane.ERROR_MESSAGE);
                new LogFile().exceptionRecord(e.getStackTrace());
            }
            catch(PostcodeException e)
            {
                JOptionPane.showMessageDialog(null,e.getMessage(),"Invalid Input",JOptionPane.ERROR_MESSAGE);
                new LogFile().exceptionRecord(e.getStackTrace());
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,"Please check your phone no.!","Invalid Input",JOptionPane.ERROR_MESSAGE);
                new LogFile().exceptionRecord(e.getStackTrace());
            }
        }
    }//GEN-LAST:event_jbtEditActionPerformed

    private void jbtResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtResetActionPerformed
        // TODO add your handling code here:
        jpfOldPassword.setText("");
        jpfPassword.setText("");
        jpfConfirmPassword.setText("");
        jtfAddress.setText(stf.getAddress());
        jtfPostcode.setText(stf.getPostcode());
        jtfTown.setText(stf.getTown());
        jtfState.setText(stf.getState());
        jtfCountry.setText(stf.getCountry());
        jtfPhoneNo.setText("");

    }//GEN-LAST:event_jbtResetActionPerformed

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
        // TODO add your handling code here:
        new StaffPage(stf).setVisible(true);
        this.dispose();
}//GEN-LAST:event_jbtBackActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbtBack;
    private javax.swing.JButton jbtClear;
    private javax.swing.JButton jbtEdit;
    private javax.swing.JButton jbtReset;
    private javax.swing.JLabel jlbID;
    private javax.swing.JLabel jlbOldPassword;
    private javax.swing.JLabel jlbWelcome;
    private javax.swing.JPasswordField jpfConfirmPassword;
    private javax.swing.JPasswordField jpfOldPassword;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JPanel jpnOuter;
    private javax.swing.JTextField jtfAddress;
    private javax.swing.JTextField jtfCountry;
    private javax.swing.JTextField jtfPhoneNo;
    private javax.swing.JTextField jtfPostcode;
    private javax.swing.JTextField jtfState;
    private javax.swing.JTextField jtfTown;
    // End of variables declaration//GEN-END:variables

}
