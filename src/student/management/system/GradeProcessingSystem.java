/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.management.system;

class GradeProcessingSystem {
    private static GradeProcessingSystem instance;

    private GradeProcessingSystem() {
        // Private constructor to prevent instantiation
    }

    public static synchronized GradeProcessingSystem getInstance() {
        if (instance == null) {
            instance = new GradeProcessingSystem();
        }
        return instance;
    }

    public void processGrade(String studentName, String courseName, String grade) {
        System.out.println("Processed grade: " + grade + " for student " + studentName + " in course: " + courseName);
    }
}
