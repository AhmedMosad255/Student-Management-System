package student.management.system;

import singleton.GradeProcessingSystem;
import singleton.GradingContext;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ManageGrades extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldCourseId;
    private JTextField textFieldStudentId;
    private JTextField textFieldGrade;
    private GradingContext gradingContext = new GradingContext();

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
        setBounds(100, 100, 500, 500);  // Adjusted the window size
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

        JLabel lblGrade = new JLabel("Raw Grade:");
        lblGrade.setFont(new Font("Tahoma", Font.BOLD, 14));

        textFieldGrade = new JTextField();
        textFieldGrade.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFieldGrade.setColumns(10);

        JButton btnSave = new JButton("Save Grade");
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));

        JButton btnSetPercentage = new JButton("Use Percentage System");
        btnSetPercentage.setFont(new Font("Tahoma", Font.PLAIN, 14));

        JButton btnSetPassFail = new JButton("Use Pass/Fail System");
        btnSetPassFail.setFont(new Font("Tahoma", Font.PLAIN, 14));

        // Action listener to set Percentage Grading System
        btnSetPercentage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gradingContext.setGradingStrategy(new PercentageGradingSystem());
                JOptionPane.showMessageDialog(null, "Percentage Grading System Selected.");
            }
        });

        // Action listener to set Pass/Fail Grading System
        btnSetPassFail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gradingContext.setGradingStrategy(new PassFailGradingSystem());
                JOptionPane.showMessageDialog(null, "Pass/Fail Grading System Selected.");
            }
        });

        // Action listener to save grade to database and process grade
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Capture the input data
                    String courseId = textFieldCourseId.getText();
                    String studentId = textFieldStudentId.getText();
                    String rawGrade = textFieldGrade.getText();

                    // Calculate the final grade using the selected grading system
                    String calculatedGrade = gradingContext.calculateGrade(rawGrade);

                    // Save grade to database
                    saveGradeToDatabase(courseId, studentId, calculatedGrade);

                    // Process grade using GradeProcessingSystem singleton
                    GradeProcessingSystem gradeProcessor = GradeProcessingSystem.getInstance();
                    gradeProcessor.processGrade(studentId, courseId, calculatedGrade);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please select a grading system and provide valid inputs.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
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
                        .addComponent(btnSave)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(btnSetPercentage)
                            .addGap(10)
                            .addComponent(btnSetPassFail)))
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
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnSetPercentage)
                        .addComponent(btnSetPassFail))
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