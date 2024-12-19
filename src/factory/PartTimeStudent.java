
import student.management.system.Student;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


class PartTimeStudent extends Student {
    public PartTimeStudent(String name, String entryNumber, String email, String contactNumber, String homeCity) {
        super(name, entryNumber, email, contactNumber, homeCity);
    }

    @Override
    public String getStudentType() {
        return "Part-Time";
    }
}