package student.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

class ViewCourses extends JFrame {
    private JTable courseTable;
    private DefaultTableModel tableModel;

    public ViewCourses() {
        setTitle("View Courses");
        setBounds(100, 100, 600, 400);
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        setContentPane(panel);
        panel.setLayout(new BorderLayout());

        // Create a table to display courses
        tableModel = new DefaultTableModel(new Object[]{"Course ID", "Course Name"}, 0);
        courseTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(courseTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Button to close the window
        JButton btnClose = new JButton("Close");
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(btnClose, BorderLayout.SOUTH);

        // Fetch courses from the database
        fetchCourses();
    }

    private void fetchCourses() {
        String query = "SELECT * FROM courses";  // Make sure this is your correct table and query
        
        try (Connection connection = DBHelper.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Clear existing rows in the table
            tableModel.setRowCount(0);

            // Loop through the result set and add courses to the table
            while (resultSet.next()) {
                int courseId = resultSet.getInt("id");  // Make sure to replace with your actual column name
                String courseName = resultSet.getString("course_name");  // Make sure to replace with your actual column name
                tableModel.addRow(new Object[]{courseId, courseName});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching courses: " + e.getMessage());
        }
    }
}
