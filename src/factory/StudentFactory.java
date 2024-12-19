package factory;

import student.management.system.Student;


public class StudentFactory {

    public static Student createStudent(String studentType, String name, String entryNumber, String email, String contactNumber, String homeCity) {
        if (studentType == null) {
            return null;
        }

        if (studentType.equalsIgnoreCase("Graduate")) {
            return new GraduateStudent(name, entryNumber, email, contactNumber, homeCity);
        } else if (studentType.equalsIgnoreCase("Undergraduate")) {
            return new UndergraduateStudent(name, entryNumber, email, contactNumber, homeCity);
        }

        return null;
    }
}
