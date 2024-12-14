package student.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class RemoveCourse extends JFrame {
    private JTextField courseIdField;

    public RemoveCourse() {
        setTitle("Remove Course");
        setBounds(100, 100, 400, 250);
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

        // Remove button
        JButton btnRemove = new JButton("Remove");
        btnRemove.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnRemove.setBounds(50, 100, 120, 30);
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeCourse();
            }
        });
        panel.add(btnRemove);

        // Close button
        JButton btnClose = new JButton("Close");
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnClose.setBounds(200, 100, 120, 30);
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(btnClose);
    }

    private void removeCourse() {
        String courseId = courseIdField.getText();

        if (courseId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the Course ID.");
            return;
        }

        String query = "DELETE FROM courses WHERE id = ?";

        try (Connection connection = DBHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setInt(1, Integer.parseInt(courseId));

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Course removed successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Course not found.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error removing course: " + e.getMessage());
        }
    }
}
