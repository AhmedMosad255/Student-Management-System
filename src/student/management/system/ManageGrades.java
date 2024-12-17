package student.management.system;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;

public class ManageGrades extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldCourseId;
    private JTextField textFieldStudentId;
    private JTextField textFieldGrade;

    // Database URL and credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/studentmanagementsystem"; // Modify the database URL
    private static final String DB_USER = "root";  // Modify with your database username
    private static final String DB_PASSWORD = "2100401";  // Modify with your database password

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManageGrades frame = new ManageGrades();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ManageGrades() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.GRAY);
        setContentPane(contentPane);

        JLabel lblCourseId = new JLabel("Course ID:");
        lblCourseId.setFont(new Font("Tahoma", Font.BOLD, 14));

        textFieldCourseId = new JTextField();
        textFieldCourseId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFieldCourseId.setColumns(10);

        JLabel lblStudentId = new JLabel("Student ID:");
        lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 14));

        textFieldStudentId = new JTextField();
        textFieldStudentId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFieldStudentId.setColumns(10);

        JLabel lblGrade = new JLabel("Grade:");
        lblGrade.setFont(new Font("Tahoma", Font.BOLD, 14));

        textFieldGrade = new JTextField();
        textFieldGrade.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFieldGrade.setColumns(10);

        JButton btnSave = new JButton("Save Grade");
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));

        // Action listener to save grade to database and process grade
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Capture the input data
                String courseId = textFieldCourseId.getText();
                String studentId = textFieldStudentId.getText();
                String grade = textFieldGrade.getText();

                // Save grade to database
                saveGradeToDatabase(courseId, studentId, grade);

                // Process grade using GradeProcessingSystem singleton
                GradeProcessingSystem gradeProcessor = GradeProcessingSystem.getInstance();
                gradeProcessor.processGrade(studentId, courseId, grade);
            }
        });

        // Layout setup
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblCourseId)
                        .addComponent(lblStudentId)
                        .addComponent(lblGrade))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(textFieldGrade, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldStudentId, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldCourseId, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave))
                    .addContainerGap(30, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblCourseId)
                        .addComponent(textFieldCourseId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblStudentId)
                        .addComponent(textFieldStudentId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblGrade)
                        .addComponent(textFieldGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addComponent(btnSave)
                    .addContainerGap(30, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

    // Method to save grade into the database
    private void saveGradeToDatabase(String courseId, String studentId, String grade) {
        try {
            // Establishing the database connection
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // SQL query to insert data into the grades table
            String sql = "INSERT INTO grades (course_id, student_id, grade) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, courseId);
            pstmt.setString(2, studentId);
            pstmt.setString(3, grade);

            // Execute the query
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                // Show success message in a dialog box
                JOptionPane.showMessageDialog(null, "Grade added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Show failure message in a dialog box
                JOptionPane.showMessageDialog(null, "Failed to add grade.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Close the connection
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
