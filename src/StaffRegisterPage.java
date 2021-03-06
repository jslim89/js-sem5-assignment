/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StaffRegisterPage.java
 *
 * Created on Dec 7, 2009, 1:01:59 PM
 */

/**
 *
 * @author Js Lim
 */
import javax.swing.*;
import java.awt.*;

public class StaffRegisterPage extends javax.swing.JFrame {

    private ImageIcon img;
    private Staff adm;
    private LogFile file;
    /** Creates new form StaffRegisterPage */
    public StaffRegisterPage(Staff admin) {
        adm = admin;
        file = new LogFile();
        img = new ImageIcon(this.getClass().getResource("images/SMD_Library_Background.jpg"));
        initComponents();
        setBackground();
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

        buttonGroupGender = new javax.swing.ButtonGroup();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfFirstName = new javax.swing.JTextField();
        jtfLastName = new javax.swing.JTextField();
        jrbMale = new javax.swing.JRadioButton();
        jrbFemale = new javax.swing.JRadioButton();
        jpfPassword = new javax.swing.JPasswordField();
        jpfConfirmPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jcbPosition = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jtfSalary = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtfAddress = new javax.swing.JTextField();
        jtfPostcode = new javax.swing.JTextField();
        jtfTown = new javax.swing.JTextField();
        jtfState = new javax.swing.JTextField();
        jtfCountry = new javax.swing.JTextField();
        jbtRegister = new javax.swing.JButton();
        jbtClear = new javax.swing.JButton();
        jbtBack = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jtfIC = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtfPhoneNo = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Staff Register");
        setIconImage(new ImageIcon(getClass().getResource("images/HomeIcon.png")).getImage());
        setResizable(false);

        jLabel1.setText("First Name");

        jLabel2.setText("Last Name");

        jLabel3.setText("Password");

        jLabel4.setText("Confirm Password");

        jLabel5.setText("Gender");

        jtfFirstName.setBackground(new java.awt.Color(255, 255, 51));

        jtfLastName.setBackground(new java.awt.Color(255, 255, 51));

        buttonGroupGender.add(jrbMale);
        jrbMale.setSelected(true);
        jrbMale.setText("Male");

        buttonGroupGender.add(jrbFemale);
        jrbFemale.setText("Female");

        jpfPassword.setBackground(new java.awt.Color(255, 255, 51));

        jpfConfirmPassword.setBackground(new java.awt.Color(255, 255, 51));

        jLabel6.setText("Position");

        jcbPosition.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cashier", "Supervisor", "Manager" }));

        jLabel7.setText("Salary");

        jtfSalary.setBackground(new java.awt.Color(255, 255, 51));

        jLabel8.setText("Address");

        jLabel9.setText("Postcode");

        jLabel10.setText("State");

        jLabel11.setText("Country");

        jLabel12.setText("Town");

        jtfAddress.setBackground(new java.awt.Color(255, 255, 51));

        jtfPostcode.setBackground(new java.awt.Color(255, 255, 51));

        jtfTown.setBackground(new java.awt.Color(255, 255, 51));

        jtfState.setBackground(new java.awt.Color(255, 255, 51));

        jtfCountry.setBackground(new java.awt.Color(255, 255, 51));
        jtfCountry.setText("Malaysia");

        jbtRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/front_register.png"))); // NOI18N
        jbtRegister.setMnemonic('R');
        jbtRegister.setText("Register");
        jbtRegister.setToolTipText("Yellow field cannot be blank");
        jbtRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRegisterActionPerformed(evt);
            }
        });

        jbtClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Symbols-Delete-256x256.png"))); // NOI18N
        jbtClear.setMnemonic('C');
        jbtClear.setText("Clear");
        jbtClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtClearActionPerformed(evt);
            }
        });

        jbtBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackButton.png"))); // NOI18N
        jbtBack.setMnemonic('B');
        jbtBack.setText("Back");
        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBackActionPerformed(evt);
            }
        });

        jLabel13.setText("IC");

        jtfIC.setBackground(new java.awt.Color(255, 255, 51));

        jLabel14.setText("Phone No.");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Arial", 1, 24));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("STAFF REGISTRATION");
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField1.setEnabled(false);

        javax.swing.GroupLayout jpnOuterLayout = new javax.swing.GroupLayout(jpnOuter);
        jpnOuter.setLayout(jpnOuterLayout);
        jpnOuterLayout.setHorizontalGroup(
            jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnOuterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnOuterLayout.createSequentialGroup()
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                            .addGroup(jpnOuterLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jbtRegister)
                                .addGap(84, 84, 84)
                                .addComponent(jbtClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnOuterLayout.createSequentialGroup()
                        .addComponent(jbtBack)
                        .addGap(56, 56, 56))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnOuterLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(33, 33, 33)
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jpfConfirmPassword, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jpfPassword, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfIC, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfLastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jcbPosition, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnOuterLayout.createSequentialGroup()
                            .addComponent(jrbMale)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jrbFemale))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14))
                .addGap(26, 26, 26)
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTown, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfState, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        jpnOuterLayout.setVerticalGroup(
            jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnOuterLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnOuterLayout.createSequentialGroup()
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnOuterLayout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jLabel3))
                            .addGroup(jpnOuterLayout.createSequentialGroup()
                                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jtfIC, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGap(11, 11, 11)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpfConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnOuterLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addGroup(jpnOuterLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jrbMale)
                                    .addComponent(jrbFemale))))
                        .addGap(18, 18, 18)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnOuterLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtfSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jtfPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jtfTown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnOuterLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jtfPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jtfState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(jpnOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtBack)
                    .addComponent(jbtClear)
                    .addComponent(jbtRegister))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnOuter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnOuter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtClearActionPerformed
        // TODO add your handling code here:
        jtfFirstName.setText("");
        jtfLastName.setText("");
        jtfIC.setText("");
        jpfPassword.setText("");
        jpfConfirmPassword.setText("");
        jtfSalary.setText("");
        jtfAddress.setText("");
        jtfPostcode.setText("");
        jtfTown.setText("");
        jtfState.setText("");
        jtfCountry.setText("Malaysia");
        jcbPosition.setSelectedIndex(0);
        jrbMale.setSelected(true);
        jtfPhoneNo.setText("");
    }//GEN-LAST:event_jbtClearActionPerformed

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
        // TODO add your handling code here:
        new UpdateBookPage(adm).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtBackActionPerformed

    private void jbtRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRegisterActionPerformed
        // TODO add your handling code here:
        try{
            Staff stf = new Staff();
            String confirm ="";
            boolean isOk = true;
            Object options[] = {"Confirm","Cancel"};
            if(jtfFirstName.getText().equals("") || jtfLastName.getText().equals("") || jtfIC.getText().equals("") ||
                jpfPassword.getPassword().length<1 || jpfConfirmPassword.getPassword().length<1 || jtfSalary.getText().equals("") ||
                jtfAddress.getText().equals("") || jtfPostcode.getText().equals("") || jtfTown.getText().equals("") ||
                jtfState.getText().equals("") || jtfCountry.getText().equals(""))
                JOptionPane.showMessageDialog(null,"Incomplete Information! Please fill up all the yellow fields.","ERROR",JOptionPane.ERROR_MESSAGE);
            else{
                Long.parseLong(jtfIC.getText());
                Long.parseLong(jtfPostcode.getText());
                new PostcodeException().checkPostcode(jtfPostcode.getText());

                if(jrbMale.isSelected())
                    stf.setGender(jrbMale.getText());
                else
                    stf.setGender(jrbFemale.getText());
                if(!jtfPhoneNo.getText().equals("")){
                    if(jtfPhoneNo.getText().length()>=9 && jtfPhoneNo.getText().length()<=12){
                        Long.parseLong(jtfPhoneNo.getText());
                        stf.setPhone(jtfPhoneNo.getText());
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Phone no. should be in 9 - 12 digits!","Phone number out of range",JOptionPane.WARNING_MESSAGE);
                        isOk = false;
                    }
                }
                if(isOk)
                {
                    if(!getStringPassword(jpfPassword.getPassword()).equals(getStringPassword(jpfConfirmPassword.getPassword())))
                        JOptionPane.showMessageDialog(null,"Password has not confirmed!","Password matched",JOptionPane.WARNING_MESSAGE);
                    else
                    {
                        stf.setSalary(Double.parseDouble(jtfSalary.getText()));
                        stf.setPassword(getStringPassword(jpfPassword.getPassword()));
                        stf.setIC(jtfIC.getText());
                        stf.setAddress(jtfAddress.getText());
                        stf.setFirstName(jtfFirstName.getText());
                        stf.setLastName(jtfLastName.getText());
                        stf.setCountry(jtfCountry.getText());
                        stf.setPosition(String.valueOf(jcbPosition.getSelectedItem()));
                        stf.setPostcode(jtfPostcode.getText());
                        stf.setState(jtfState.getText());
                        stf.setTown(jtfTown.getText());

                        confirm += "First Name : "+stf.getFirstName()+
                                "\nLast Name : "+stf.getLastName()+
                                "\nIC : "+stf.getIC()+
                                "\nGender : "+stf.getGender();
                        if(!stf.getPhone().equals("")){
                                confirm += "\nPhone no. : "+stf.getPhone();
                        }
                        confirm += "\nPosition: "+stf.getPosition()+
                                "\nAddress: "+stf.getAddress()+
                                "\nPostcode: "+stf.getPostcode()+
                                "\nTown: "+stf.getTown()+
                                "\nState: "+stf.getState()+
                                "\nCountry: "+stf.getCountry()+
                                "\nSalary: "+stf.getSalary();

                        int yesNo = JOptionPane.showOptionDialog(null,confirm,"Confirm?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                        if(yesNo == JOptionPane.YES_OPTION)
                        {
                            new Database().staffRegister(stf);
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Please re-enter your information!","Register cancelled",JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        }
        catch(PostcodeException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Invalid Input",JOptionPane.ERROR_MESSAGE);
            file.exceptionRecord(e.getStackTrace());
        }
        catch(NameFormatException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Invalid Input",JOptionPane.ERROR_MESSAGE);
            file.exceptionRecord(e.getStackTrace());
        }
        catch(ICFormatException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Invalid Input",JOptionPane.ERROR_MESSAGE);
            file.exceptionRecord(e.getStackTrace());
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"IC & Phone no. & Salary & Postcode should contain digits only!","Invalid Input",JOptionPane.ERROR_MESSAGE);
            file.exceptionRecord(e.getStackTrace());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Exception: "+e.getMessage(),"Invalid Input",JOptionPane.ERROR_MESSAGE);
            file.exceptionRecord(e.getStackTrace());
        }
    }//GEN-LAST:event_jbtRegisterActionPerformed

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
    private javax.swing.ButtonGroup buttonGroupGender;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbtBack;
    private javax.swing.JButton jbtClear;
    private javax.swing.JButton jbtRegister;
    private javax.swing.JComboBox jcbPosition;
    private javax.swing.JPasswordField jpfConfirmPassword;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JPanel jpnOuter;
    private javax.swing.JRadioButton jrbFemale;
    private javax.swing.JRadioButton jrbMale;
    private javax.swing.JTextField jtfAddress;
    private javax.swing.JTextField jtfCountry;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfIC;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfPhoneNo;
    private javax.swing.JTextField jtfPostcode;
    private javax.swing.JTextField jtfSalary;
    private javax.swing.JTextField jtfState;
    private javax.swing.JTextField jtfTown;
    // End of variables declaration//GEN-END:variables

}
