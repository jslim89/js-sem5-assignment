/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Register.java
 *
 * Created on Nov 7, 2009, 5:56:19 PM
 */

/**
 *
 * @author Js Lim
 */

import javax.swing.JOptionPane;
import java.lang.Throwable;
import javax.swing.ImageIcon;

public class RegisterPage extends javax.swing.JFrame {

private Database db = new Database();
private LogFile file;
    /** Creates new form Register */
    public RegisterPage() {
        initComponents();
        file = new LogFile();
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

        jbgGender = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jbtSubmit = new javax.swing.JButton();
        jlbPassword = new javax.swing.JLabel();
        jtfPhoneNo = new javax.swing.JTextField();
        jtfAnswer = new javax.swing.JTextField();
        jtfIC = new javax.swing.JTextField();
        jlbAnswer = new javax.swing.JLabel();
        jtfLastName = new javax.swing.JTextField();
        jrbFemale = new javax.swing.JRadioButton();
        jtfFirstName = new javax.swing.JTextField();
        jrbMale = new javax.swing.JRadioButton();
        jlbPhone = new javax.swing.JLabel();
        jbtReset = new javax.swing.JButton();
        jpfPassword = new javax.swing.JPasswordField();
        jlbIC = new javax.swing.JLabel();
        jbtBack = new javax.swing.JButton();
        jpfConfirmPassword = new javax.swing.JPasswordField();
        jlbGender = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlbFirstName = new javax.swing.JLabel();
        jcbQuestion = new javax.swing.JComboBox();
        jlbLastName = new javax.swing.JLabel();
        jlbConfirmPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SMD Library Registration");
        setIconImage(new ImageIcon(getClass().getResource("images/HomeIcon.png")).getImage());
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SMD Library.jpg"))); // NOI18N

        jbtSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/260.png"))); // NOI18N
        jbtSubmit.setMnemonic('s');
        jbtSubmit.setText("Submit");
        jbtSubmit.setToolTipText("Yellow field cannot be blank");
        jbtSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSubmitActionPerformed(evt);
            }
        });

        jlbPassword.setText("Password");

        jtfAnswer.setText("Please enter your answer here");
        jtfAnswer.setToolTipText("Answer not more than 15 character");
        jtfAnswer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfAnswerMouseClicked(evt);
            }
        });
        jtfAnswer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfAnswerFocusLost(evt);
            }
        });

        jtfIC.setBackground(new java.awt.Color(255, 255, 51));
        jtfIC.setToolTipText("Must be 12 digits");

        jlbAnswer.setText("Answer");

        jtfLastName.setBackground(new java.awt.Color(255, 255, 51));
        jtfLastName.setToolTipText("Maximum 20 characters");
        jtfLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfLastNameActionPerformed(evt);
            }
        });

        jbgGender.add(jrbFemale);
        jrbFemale.setText("Female");

        jtfFirstName.setBackground(new java.awt.Color(255, 255, 51));
        jtfFirstName.setToolTipText("Maximum 20 characters");
        jtfFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFirstNameActionPerformed(evt);
            }
        });
        jtfFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfFirstNameKeyTyped(evt);
            }
        });

        jbgGender.add(jrbMale);
        jrbMale.setSelected(true);
        jrbMale.setText("Male");

        jlbPhone.setText("Phone No.");

        jbtReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_reset.png"))); // NOI18N
        jbtReset.setMnemonic('r');
        jbtReset.setText("Reset");
        jbtReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtResetActionPerformed(evt);
            }
        });

        jpfPassword.setBackground(new java.awt.Color(255, 255, 51));

        jlbIC.setText("IC No.");

        jbtBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackButton.png"))); // NOI18N
        jbtBack.setMnemonic('b');
        jbtBack.setText("Back");
        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBackActionPerformed(evt);
            }
        });

        jpfConfirmPassword.setBackground(new java.awt.Color(255, 255, 51));

        jlbGender.setText("Gender");

        jLabel2.setText("Security Question");

        jlbFirstName.setText("First Name");

        jcbQuestion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "What is your father's name?", "What is your mother's name?", "What is your favourite food?", "Where is your hometown?", "What is your secondary school's name?" }));
        jcbQuestion.setToolTipText("Enable you to trace back the password when you forgot the password");

        jlbLastName.setText("Last Name");

        jlbConfirmPassword.setText("Confirm Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbFirstName)
                    .addComponent(jlbConfirmPassword)
                    .addComponent(jlbIC)
                    .addComponent(jlbPhone)
                    .addComponent(jlbPassword))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpfConfirmPassword)
                    .addComponent(jpfPassword)
                    .addComponent(jtfPhoneNo)
                    .addComponent(jtfIC)
                    .addComponent(jtfFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jcbQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbLastName)
                            .addComponent(jlbGender)
                            .addComponent(jlbAnswer))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jrbMale)
                                .addGap(28, 28, 28)
                                .addComponent(jrbFemale))
                            .addComponent(jtfLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfAnswer))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jbtSubmit)
                .addGap(98, 98, 98)
                .addComponent(jbtReset)
                .addGap(98, 98, 98)
                .addComponent(jbtBack))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbLastName))
                                .addGap(18, 18, 18)
                                .addComponent(jlbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jrbMale)
                                    .addComponent(jrbFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(14, 14, 14)
                        .addComponent(jlbPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbIC))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jpfConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtReset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfAnswerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfAnswerMouseClicked
        // TODO add your handling code here:
        if(jtfAnswer.getText().equalsIgnoreCase("Please enter your answer here"))
            jtfAnswer.setText("");
}//GEN-LAST:event_jtfAnswerMouseClicked

    private void jtfAnswerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfAnswerFocusLost
        // TODO add your handling code here:
        if(jtfAnswer.getText().equalsIgnoreCase(""))
            jtfAnswer.setText("Please enter your answer here");
}//GEN-LAST:event_jtfAnswerFocusLost

    private void jtfLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfLastNameActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jtfLastNameActionPerformed

    private void jtfFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFirstNameActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jtfFirstNameActionPerformed

    private void jbtResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtResetActionPerformed
        // TODO add your handling code here:
        jtfFirstName.setText("");
        jtfLastName.setText("");
        jtfIC.setText("");
        jtfPhoneNo.setText("");
        jrbMale.setSelected(true);
        jpfPassword.setText("");
        jpfConfirmPassword.setText("");
        jcbQuestion.setSelectedIndex(0);
        jtfAnswer.setText("Please enter your answer here");
}//GEN-LAST:event_jbtResetActionPerformed

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_jbtBackActionPerformed

    private void jbtSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSubmitActionPerformed
        // TODO add your handling code here:
        boolean isOk = true;
        Member mem = new Member();
        Object options[] = {"Confirm","Cancel"};
        if(jtfFirstName.getText().equals("") || jtfLastName.getText().equals("") || jtfIC.getText().equals("") ||
            jpfPassword.getPassword().length<1 || jpfConfirmPassword.getPassword().length<1)
            JOptionPane.showMessageDialog(null,"Incomplete Information! Please fill up all the yellow fields.","ERROR",JOptionPane.ERROR_MESSAGE);
        else{
            try{
                Long.parseLong(jtfIC.getText());
                mem.setFirstName(jtfFirstName.getText());
                mem.setLastName(jtfLastName.getText());
                mem.setIC(jtfIC.getText());
                if(jrbMale.isSelected())
                    mem.setGender(jrbMale.getText());
                else
                    mem.setGender(jrbFemale.getText());
                if(!jtfPhoneNo.getText().equals("")){
                    if(jtfPhoneNo.getText().length()>=9 && jtfPhoneNo.getText().length()<=12){
                        Long.parseLong(jtfPhoneNo.getText());
                        mem.setPhone(jtfPhoneNo.getText());
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Phone no. should be in 9 - 12 digits!","Phone number out of range",JOptionPane.WARNING_MESSAGE);
                        isOk = false;
                    }
                }
                if(isOk){
                    String pw = getStringPassword(jpfPassword.getPassword());
                    String confirmPw = getStringPassword(jpfConfirmPassword.getPassword());
                    if(!pw.equals(confirmPw))
                        JOptionPane.showMessageDialog(null,"Password has not confirmed!","Password matched",JOptionPane.WARNING_MESSAGE);
                else
                    mem.setPassword(pw);
                if(jtfAnswer.getText().equals("Please enter your answer here"))
                {
                    mem.setAnswer("");
                    mem.setQuestion("");
                }
                else if(jtfAnswer.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Please enter your answer according to your question","Security answer",JOptionPane.WARNING_MESSAGE);
                else{
                    mem.setQuestion((String)jcbQuestion.getSelectedItem());
                    mem.setAnswer(jtfAnswer.getText());
                }
                String confirm = "First Name : "+mem.getFirstName()+
                                "\nLast Name : "+mem.getLastName()+
                                "\nIC : "+mem.getIC()+
                                "\nGender : "+mem.getGender();
                if(!mem.getPhone().equals("")){
                                confirm += "\nPhone no. : "+mem.getPhone();
                }
                if(!mem.getQuestion().equals("") && !mem.getAnswer().equals(""))
                {
                              confirm +=  "\nQuestion : "+mem.getQuestion()+
                                "\nAnswer : "+mem.getAnswer();
                }
                if(mem.getPassword().equals(""))
                    JOptionPane.showMessageDialog(null,"Incomplete information! You should enter password!","Incomplete information",JOptionPane.WARNING_MESSAGE);
                else{
                    int yesNo = JOptionPane.showOptionDialog(null,confirm,"Confirm?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(yesNo == JOptionPane.YES_OPTION)
                    {
                        mem = db.memberRegister(mem);
                        if(mem!=null)
                        {
                            JOptionPane.showMessageDialog(null,"Your member ID is: "+mem.getID());
                            new UserPage(mem).setVisible(true);
                            this.dispose();
                        }
                    }
                else
                    JOptionPane.showMessageDialog(null,"Please re-enter your information!","Register cancelled",JOptionPane.PLAIN_MESSAGE);
            }
            }

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
            JOptionPane.showMessageDialog(null,"IC & Phone no. should contain digits only!","Invalid Input",JOptionPane.ERROR_MESSAGE);
            file.exceptionRecord(e.getStackTrace());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Exception: "+e.getMessage(),"Invalid Input",JOptionPane.ERROR_MESSAGE);
            file.exceptionRecord(e.getStackTrace());
        }
        }
    }//GEN-LAST:event_jbtSubmitActionPerformed

    private void jtfFirstNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfFirstNameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfFirstNameKeyTyped

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.ButtonGroup jbgGender;
    private javax.swing.JButton jbtBack;
    private javax.swing.JButton jbtReset;
    private javax.swing.JButton jbtSubmit;
    private javax.swing.JComboBox jcbQuestion;
    private javax.swing.JLabel jlbAnswer;
    private javax.swing.JLabel jlbConfirmPassword;
    private javax.swing.JLabel jlbFirstName;
    private javax.swing.JLabel jlbGender;
    private javax.swing.JLabel jlbIC;
    private javax.swing.JLabel jlbLastName;
    private javax.swing.JLabel jlbPassword;
    private javax.swing.JLabel jlbPhone;
    private javax.swing.JPasswordField jpfConfirmPassword;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JRadioButton jrbFemale;
    private javax.swing.JRadioButton jrbMale;
    private javax.swing.JTextField jtfAnswer;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfIC;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfPhoneNo;
    // End of variables declaration//GEN-END:variables

}
