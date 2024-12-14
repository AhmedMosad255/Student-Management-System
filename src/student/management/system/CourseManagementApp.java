/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.management.system;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;

public class CourseManagementApp extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CourseManagementApp frame = new CourseManagementApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CourseManagementApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 700);
        contentPane = new JPanel();
        contentPane.setBackground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.LIGHT_GRAY);

        // Add Course Button
        JButton btnAddCourse = new JButton("Add Course");
        btnAddCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnAddCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CourseManagementApp.this.setVisible(true);  // Hide the current window
                AddCourse addCourse = new AddCourse();
                addCourse.setVisible(true);  // Show the AddCourse window
            }
        });
        btnAddCourse.setBounds(32, 37, 287, 52);
        desktopPane.add(btnAddCourse);

        // View Courses Button
        JButton btnViewCourses = new JButton("View Courses");
        btnViewCourses.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnViewCourses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CourseManagementApp.this.setVisible(true);  // Hide the current window
                ViewCourses viewCourses = new ViewCourses();
                viewCourses.setVisible(true);  // Show the ViewCourses window
            }
        });
        btnViewCourses.setBounds(32, 113, 287, 52);
        desktopPane.add(btnViewCourses);

        // Update Course Button
        JButton btnUpdateCourse = new JButton("Update Course");
        btnUpdateCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnUpdateCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CourseManagementApp.this.setVisible(true);  // Hide the current window
                UpdateCourse updateCourse = new UpdateCourse();
                updateCourse.setVisible(true);  // Show the UpdateCourse window
            }
        });
        btnUpdateCourse.setBounds(32, 195, 287, 52);
        desktopPane.add(btnUpdateCourse);

        // Remove Course Button
        JButton btnRemoveCourse = new JButton("Remove Course");
        btnRemoveCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnRemoveCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CourseManagementApp.this.setVisible(true);  // Hide the current window
                RemoveCourse removeCourse = new RemoveCourse();
                removeCourse.setVisible(true);  // Show the RemoveCourse window
            }
        });
        btnRemoveCourse.setBounds(32, 272, 287, 52);
        desktopPane.add(btnRemoveCourse);

        // Back to Menu Button
        JButton btnBackToMenu = new JButton("Back to Menu");
        btnBackToMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnBackToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CourseManagementApp.this.setVisible(false);  // Hide the current window
                Menu menu = new Menu();
                menu.setVisible(true);  // Show the Menu window
            }
        });
        btnBackToMenu.setBounds(32, 348, 287, 52);
        desktopPane.add(btnBackToMenu);

        // Layout setup
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }
}
