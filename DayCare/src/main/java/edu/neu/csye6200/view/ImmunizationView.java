package edu.neu.csye6200.view;

import edu.neu.csye6200.controller.StudentController;
import edu.neu.csye6200.model.Student;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ImmunizationView extends javax.swing.JFrame {

    /**
     * Creates new form ImmunizationFrame
     */
    public ImmunizationView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jStudentLabel = new javax.swing.JLabel();
        jSudentTextField = new javax.swing.JTextField();
        jCheckImmunizationButton = new javax.swing.JButton();
        jTakePolioButton = new javax.swing.JButton();
        jTakeImmunizationLabel = new javax.swing.JLabel();
        jTakeHepatitsButton = new javax.swing.JButton();
        goBackButton = new javax.swing.JButton();
        jStudentValidationText = new javax.swing.JLabel();
        jImmunizationText = new javax.swing.JLabel();
        jStudentListScrollPane = new javax.swing.JScrollPane();
        jStudentList = new javax.swing.JList<>();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jStudentList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = StudentController.studentList.stream().map(student -> student.getName()+":"+student.getImmunizationRecord())
                    .collect(Collectors.toList()).toArray(new String[0]);

            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        goBackButton.setText("BACK");
        goBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStudentBackActionPerformed(evt);
            }
        });
        jCheckImmunizationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkImmunization(evt);
            }
        });
        jTakeHepatitsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHepatitisActionPerformed(evt);
            }
        });
        jTakePolioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPolioActionPerformed(evt);
            }
        });

        jStudentLabel.setText("Student Name");

        jCheckImmunizationButton.setText("Check Immunization");

        jTakePolioButton.setText("Polio");
        jTakePolioButton.setAlignmentX(6.0F);
        jTakePolioButton.setAlignmentY(66.0F);
        jTakePolioButton.setMargin(new java.awt.Insets(1, 14, 2, 14));
        jTakePolioButton.setPreferredSize(new java.awt.Dimension(30, 11));

        jTakeImmunizationLabel.setText("Take Immunization:");

        jTakeHepatitsButton.setText("Hepatits");

        goBackButton.setText("BACK");

        jImmunizationText.setText("");

        jStudentListScrollPane.setViewportView(jStudentList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(goBackButton)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jStudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jCheckImmunizationButton)
                                                                        .addComponent(jSudentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jStudentValidationText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(42, 42, 42)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTakeImmunizationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTakePolioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTakeHepatitsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jImmunizationText, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(31, 31, 31))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jStudentListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(180, 180, 180))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jStudentListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(goBackButton))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jStudentLabel)
                                                        .addComponent(jSudentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jCheckImmunizationButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jStudentValidationText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(39, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTakeImmunizationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTakeHepatitsButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTakePolioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jImmunizationText, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );

        pack();
    }// </editor-fold>


    private void buttonStudentBackActionPerformed(java.awt.event.ActionEvent evt){
        StudentController.writeStudentsToCsv();
        this.dispose();
    }
    private void checkImmunization(java.awt.event.ActionEvent evt){
        if(jSudentTextField.getText().equals("")){
            this.jStudentValidationText.setText("Please enter a student's name");
        } else {
            this.jStudentValidationText.setText(StudentController.trackImmunization(StudentController.findStudent(jSudentTextField.getText())));
        }
    }
    private void buttonHepatitisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDTaPActionPerformed
        // TODO add your handling code here:
        if(jSudentTextField.getText().equals(""))
            this.jImmunizationText.setText("Please select a student");
        try{//
           // this.jTakeImmunizationLabel.setText(StudentController.takeHepatits(StudentController.findStudent(jSudentTextField.getText())));
            this.jImmunizationText.setText(StudentController.takeHepatits(StudentController.findStudent(jSudentTextField.getText())));
        }catch(NoSuchElementException e){
            this.jTakeImmunizationLabel.setText("No such student");
        }
        updateStudentListUI(StudentController.studentList);
    }
    private void buttonPolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDTaPActionPerformed
        // TODO add your handling code here:
        if(jSudentTextField.getText().equals(""))
            this.jImmunizationText.setText("Please select a student");
        try{
            this.jImmunizationText.setText(StudentController.takePolio(StudentController.findStudent(jSudentTextField.getText())));
        }catch(NoSuchElementException e){
            this.jTakeImmunizationLabel.setText("No such student");
        }
        updateStudentListUI(StudentController.studentList);
    }

    private void updateStudentListUI(List<Student> list){
        jStudentList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = list.stream().map(student -> student.getName()+":"+student.getImmunizationRecord())
                    .collect(Collectors.toList()).toArray(new String[0]);

            @Override
            public int getSize() { return strings.length; }
            @Override
            public String getElementAt(int i) { return strings[i]; }
        });
    }

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
            java.util.logging.Logger.getLogger(ImmunizationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImmunizationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImmunizationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImmunizationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImmunizationView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton goBackButton;
    private javax.swing.JButton jCheckImmunizationButton;
    private javax.swing.JLabel jImmunizationText;
    private javax.swing.JLabel jStudentLabel;
    private javax.swing.JList<String> jStudentList;
    private javax.swing.JScrollPane jStudentListScrollPane;
    private javax.swing.JLabel jStudentValidationText;
    private javax.swing.JTextField jSudentTextField;
    private javax.swing.JButton jTakeHepatitsButton;
    private javax.swing.JLabel jTakeImmunizationLabel;
    private javax.swing.JButton jTakePolioButton;
    // End of variables declaration
}