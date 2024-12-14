package student.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class UpdateCourse extends JFrame {
    private JTextField courseIdField;
    private JTextField courseNameField;

    public UpdateCourse() {
        setTitle("Update Course");
        setBounds(100, 100, 400, 300);
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        setContentPane(panel);
        panel.setLayout(null);

        // Course ID label and field
        JLabel lblCourseId = new JLabel("Course ID:");
        lblCourseId.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCourseId.setBounds(50, 50, 100, 30);
        panel.add(lblCourseId);

        courseIdField = new JTextField();
        courseIdField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        courseIdField.setBounds(150, 50, 200, 30);
        panel.add(courseIdField);

        // Course Name label and field
        JLabel lblCourseName = new JLabel("Course Name:");
        lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCourseName.setBounds(50, 100, 100, 30);
        panel.add(lblCourseName);

        courseNameField = new JTextField();
        courseNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        courseNameField.setBounds(150, 100, 200, 30);
        panel.add(courseNameField);

        // Update button
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnUpdate.setBounds(50, 150, 120, 30);
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateCourse();
            }
        });
        panel.add(btnUpdate);

        // Close button
        JButton btnClose = new JButton("Close");
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnClose.setBounds(200, 150, 120, 30);
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(btnClose);
    }

    private void updateCourse() {
        String courseId = courseIdField.getText();
        String courseName = courseNameField.getText();

        if (courseId.isEmpty() || courseName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in both fields.");
            return;
        }

        String query = "UPDATE courses SET course_name = ? WHERE id = ?";

        try (Connection connection = DBHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, courseName);
            statement.setInt(2, Integer.parseInt(courseId));

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Course updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Course not found.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating course: " + e.getMessage());
        }
    }
}
