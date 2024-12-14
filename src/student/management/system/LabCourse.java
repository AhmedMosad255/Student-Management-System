/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.management.system;

class LabCourse extends Course {
    public LabCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getCourseType() {
        return "Lab";
    }
}
