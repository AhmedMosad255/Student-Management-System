package student.management.system;

public abstract class Student {
    private String name;
    private String entryNumber;
    private String email;
    private String contactNumber;
    private String homeCity;

    public Student(String name, String entryNumber, String email, String contactNumber, String homeCity) {
        this.name = name;
        this.entryNumber = entryNumber;
        this.email = email;
        this.contactNumber = contactNumber;
        this.homeCity = homeCity;
    }

    // Getters for each field
    public String getName() { return name; }
    public String getEntryNumber() { return entryNumber; }
    public String getEmail() { return email; }
    public String getContactNumber() { return contactNumber; }
    public String getHomeCity() { return homeCity; }

    // Abstract method to get the student type
    public abstract String getStudentType();

}
