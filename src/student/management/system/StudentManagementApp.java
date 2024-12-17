package student.management.system;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class StudentManagementApp extends JFrame {

    private JPanel contentPane;
    private JTextField sname;
    private JTextField sentry;
    private JTextField semail;
    private JTextField scontact;
    private JTextField shome;
    private JComboBox<String> studentTypeComboBox;

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
        studentName.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));

        JLabel entryNumber = new JLabel("Entry Number");
        entryNumber.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));

        JLabel emailAddress = new JLabel("Email Address");
        emailAddress.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));

        JLabel contactNumber = new JLabel("Contact Number");
        contactNumber.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));

        JLabel homeCity = new JLabel("Home City");
        homeCity.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));

        JLabel studentTypeLabel = new JLabel("Student Type");
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

        studentTypeComboBox = new JComboBox<>();
        studentTypeComboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
        studentTypeComboBox.addItem("Graduate");
        studentTypeComboBox.addItem("Undergraduate");

        JButton submit = new JButton("Submit");
        submit.setFont(new Font("Tahoma", Font.BOLD, 14));
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = sname.getText();
                    String entryNumber = sentry.getText();
                    String email = semail.getText();
                    String contactNumber = scontact.getText();
                    String homeCity = shome.getText();
                    String studentType = (String) studentTypeComboBox.getSelectedItem();

                    // Validate input fields
                    if (name.isEmpty() || entryNumber.isEmpty() || email.isEmpty() || contactNumber.isEmpty() || homeCity.isEmpty() || studentType == null) {
                        JOptionPane.showMessageDialog(null, "Please fill all the details.");
                    } else {
                        Student student = StudentFactory.createStudent(studentType, name, entryNumber, email, contactNumber, homeCity);
                        saveStudentToDatabase(student);
                        JOptionPane.showMessageDialog(null, "Student added successfully.");
                        
                        dispose();
                        Menu menu = new Menu();
                        menu.show();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancel.addActionListener(e -> {
            Menu menu = new Menu();
            menu.show();
            dispose();
        });

        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(studentDetails)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addComponent(studentName)
                                .addComponent(entryNumber)
                                .addComponent(emailAddress)
                                .addComponent(contactNumber)
                                .addComponent(homeCity)
                                .addComponent(studentTypeLabel))
                            .addGap(18)
                            .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(studentTypeComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sname)
                                .addComponent(sentry)
                                .addComponent(semail)
                                .addComponent(scontact)
                                .addComponent(shome, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addComponent(submit, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(studentDetails)
                    .addGap(18)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(studentName)
                        .addComponent(sname, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addGap(28)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(entryNumber)
                        .addComponent(sentry, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                    .addGap(28)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(emailAddress)
                        .addComponent(semail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                    .addGap(28)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(contactNumber)
                        .addComponent(scontact, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                    .addGap(28)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(homeCity)
                        .addComponent(shome, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                    .addGap(28)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(studentTypeLabel)
                        .addComponent(studentTypeComboBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                    .addGap(28)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(submit, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
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
