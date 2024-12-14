/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.management.system;

class ElectiveCourse extends Course {
    public ElectiveCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getCourseType() {
        return "Elective";
    }
}