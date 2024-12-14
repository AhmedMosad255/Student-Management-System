/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.management.system;

class CoreCourse extends Course {
    public CoreCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getCourseType() {
        return "Core";
    }
}
