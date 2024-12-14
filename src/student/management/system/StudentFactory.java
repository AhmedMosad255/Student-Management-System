
package student.management.system;

class StudentFactory {
    public static Student createStudent(String type, String name, String entryNumber, String email, String contactNumber, String homeCity) {
        switch (type.toLowerCase()) {
            case "undergraduate":
                return new UndergraduateStudent(name, entryNumber, email, contactNumber, homeCity);
            case "graduate":
                return new GraduateStudent(name, entryNumber, email, contactNumber, homeCity);
            case "part-time":
                return new PartTimeStudent(name, entryNumber, email, contactNumber, homeCity);
            default:
                throw new IllegalArgumentException("Invalid student type: " + type);
        }
    }
}

