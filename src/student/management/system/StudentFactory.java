
package student.management.system;

public class StudentFactory {
    public static Student createStudent(String studentType, String name, String entryNumber, String email, String contactNumber, String homeCity) {
        switch (studentType.toLowerCase()) {
            case "undergraduate":
                return new UndergraduateStudent(name, entryNumber, email, contactNumber, homeCity);
            case "graduate":
                return new GraduateStudent(name, entryNumber, email, contactNumber, homeCity);
            default:
                throw new IllegalArgumentException("Unknown student type: " + studentType);
        }
    }
}

