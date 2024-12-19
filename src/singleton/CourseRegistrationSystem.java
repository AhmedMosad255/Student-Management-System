/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

/**
 *
 * @author Ahmed
 */
class CourseRegistrationSystem {
    private static CourseRegistrationSystem instance;

    private CourseRegistrationSystem() {
        // Private constructor to prevent instantiation
    }

    public static synchronized CourseRegistrationSystem getInstance() {
        if (instance == null) {
            instance = new CourseRegistrationSystem();
        }
        return instance;
    }

    public void registerCourse(String studentName, String courseName) {
        System.out.println("Registered " + studentName + " for course: " + courseName);
    }
}
