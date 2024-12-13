package student.management.system;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ViewStudent extends JFrame {

    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewStudent frame = new ViewStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewStudent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 782, 611);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.GRAY);
        JScrollPane scrollPane = new JScrollPane();
        
        JLabel lblNewLabel = new JLabel("Student Details");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel.setBounds(255, 27, 225, 52);
        desktopPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Go Back");
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                menu.show();
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.setBounds(10, 96, 113, 32);
        desktopPane.add(btnNewButton);
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 753, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(10)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 752, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Initialize table with columns
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Entry Number", "Student Name", "Email Address", "Contact Number", "Home City"
            }
        ));
        scrollPane.setViewportView(table);
        contentPane.setLayout(gl_contentPane);

        // Load data into table
        loadStudentData();
    }

    private void loadStudentData() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagementsystem", "root", "2100401");
            String sql = "SELECT * FROM student";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing rows

            while (rs.next()) {
                String entryNumber = rs.getString("entrynumber");
                String studentName = rs.getString("name");
                String email = rs.getString("email");
                String contactNumber = rs.getString("contactnumber");
                String homeCity = rs.getString("homecity");

                model.addRow(new Object[]{entryNumber, studentName, email, contactNumber, homeCity});
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
