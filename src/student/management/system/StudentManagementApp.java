package student.management.system;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JDesktopPane;
import java.sql.*;
import javax.swing.LayoutStyle;

public class StudentManagementApp extends JFrame {

    private JPanel contentPane;
    private JTextField sname;
    private JTextField sentry;
    private JTextField semail;
    private JTextField scontact;
    private JTextField shome;
    private JTextField studentTypeField;
    
    Connection con = null;
    PreparedStatement pst = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentManagementApp frame = new StudentManagementApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StudentManagementApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 588, 720);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel studentDetails = new JLabel("Student Details");
        studentDetails.setForeground(Color.BLACK);
        studentDetails.setFont(new Font("Perpetua Titling MT", Font.BOLD, 22));

        JLabel studentName = new JLabel("Student Name");
        studentName.setForeground(Color.BLACK);
        studentName.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));

        JLabel entryNumber = new JLabel("Entry Number");
        entryNumber.setForeground(Color.BLACK);
        entryNumber.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));

        JLabel emailAddress = new JLabel("Email Address");
        emailAddress.setForeground(Color.BLACK);
        emailAddress.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));

        JLabel contactNumber = new JLabel("Contact Number");
        contactNumber.setForeground(Color.BLACK);
        contactNumber.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));

        JLabel homeCity = new JLabel("Home City");
        homeCity.setForeground(Color.BLACK);
        homeCity.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));

        JLabel studentTypeLabel = new JLabel("Student Type");
        studentTypeLabel.setForeground(Color.BLACK);
        studentTypeLabel.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));

        sname = new JTextField();
        sname.setColumns(10);

        sentry = new JTextField();
        sentry.setColumns(10);

        semail = new JTextField();
        semail.setColumns(10);

        scontact = new JTextField();
        scontact.setColumns(10);

        shome = new JTextField();
        shome.setColumns(10);

        studentTypeField = new JTextField();
        studentTypeField.setColumns(10);

        JButton submit = new JButton("Submit");
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Tahoma", Font.BOLD, 14));

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String studentType = studentTypeField.getText();
                    String name = sname.getText();
                    String entryNumber = sentry.getText();
                    String email = semail.getText();
                    String contactNumber = scontact.getText();
                    String homeCity = shome.getText();

                    if (name.isEmpty() || entryNumber.isEmpty() || email.isEmpty() || contactNumber.isEmpty() || homeCity.isEmpty() || studentType.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Fill all the details :(");
                    } else {
                        Student student = StudentFactory.createStudent(studentType, name, entryNumber, email, contactNumber, homeCity);

                        saveStudentToDatabase(student);

                        CourseRegistrationSystem.getInstance().registerCourse(name, "Sample Course");
                        GradeProcessingSystem.getInstance().processGrade(name, "Sample Course", "A");

                        JOptionPane.showMessageDialog(null, "Student added Successfully with course and grade processing :)");
                        dispose();
                        Menu menu = new Menu();
                        menu.show();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancel.addActionListener(e -> {
            Menu menu = new Menu();
            menu.show();
            dispose();
        });

        GroupLayout layout = new GroupLayout(contentPane);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(studentDetails)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(studentName)
                                .addComponent(entryNumber)
                                .addComponent(emailAddress)
                                .addComponent(contactNumber)
                                .addComponent(homeCity)
                                .addComponent(studentTypeLabel))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(sname, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sentry, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                .addComponent(semail, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                .addComponent(scontact, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                .addComponent(shome, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                .addComponent(studentTypeField, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(submit, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(studentDetails)
                    .addGap(18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(studentName)
                        .addComponent(sname, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addGap(28)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sentry, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(entryNumber))
                    .addGap(41)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(semail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailAddress))
                    .addGap(37)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(contactNumber)
                        .addComponent(scontact, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                    .addGap(41)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(shome, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addComponent(homeCity))
                    .addGap(43)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(studentTypeField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addComponent(studentTypeLabel))
                    .addGap(43)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(submit, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPane.setLayout(layout);
    }

    private void saveStudentToDatabase(Student student) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagementsystem", "root", "2100401");
            String query = "INSERT INTO student (name, entrynumber, email, contactnumber, homecity, studenttype) VALUES (?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            pst.setString(1, student.getName());
            pst.setString(2, student.getEntryNumber());
            pst.setString(3, student.getEmail());
            pst.setString(4, student.getContactNumber());
            pst.setString(5, student.getHomeCity());
            pst.setString(6, student.getStudentType());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Student added successfully to the database.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
//    private void saveStudentToDatabase(Student student) {
