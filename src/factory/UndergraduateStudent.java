/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import student.management.system.Student;

/**
 *
 * @author Ahmed
 */
class UndergraduateStudent extends Student {
    public UndergraduateStudent(String name, String entryNumber, String email, String contactNumber, String homeCity) {
        super(name, entryNumber, email, contactNumber, homeCity);
    }

    @Override
    public String getStudentType() {
        return "Undergraduate";
    }
}
