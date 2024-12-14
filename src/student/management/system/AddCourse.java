package student.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class AddCourse extends JFrame {
    private JTextField courseNameField;

    public AddCourse() {
        setTitle("Add Course");
        setBounds(100, 100, 400, 300);
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        setContentPane(panel);
        panel.setLayout(null);

        JLabel lblCourseName = new JLabel("Course Name:");
        lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCourseName.setBounds(20, 50, 150, 30);
        panel.add(lblCourseName);

        courseNameField = new JTextField();
        courseNameField.setBounds(150, 50, 200, 30);
        panel.add(courseNameField);

        JButton btnSave = new JButton("Save");
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSave.setBounds(150, 100, 100, 30);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String courseName = courseNameField.getText();
                if (!courseName.isEmpty()) {
                    try {
                        // Database connection details
                        String url = "jdbc:mysql://localhost:3306/studentmanagementsystem"; // Change this to your DB URL
                        String user = "root"; // Your DB username
                        String password = "2100401"; // Your DB password

                        // Establish the connection
                        Connection conn = DriverManager.getConnection(url, user, password);

                        // Insert course into the database
                        String sql = "INSERT INTO courses (course_name) VALUES (?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, courseName);
                        int rowsAffected = pstmt.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Course added successfully: " + courseName);
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to add course.");
                        }

                        conn.close(); // Close the connection
                        dispose(); // Close the AddCourse window

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error connecting to database: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Course name cannot be empty.");
                }
            }
        });
        panel.add(btnSave);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCancel.setBounds(270, 100, 100, 30);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(btnCancel);
    }
}
