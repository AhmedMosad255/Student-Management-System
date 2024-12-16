package student.management.system;

public class GradeProcessingSystem {

    // Step 1: Create a private static instance
    private static GradeProcessingSystem instance;

    // Step 2: Private constructor to prevent instantiation
    private GradeProcessingSystem() {
        // Initialization code if required
    }

    // Step 3: Public method to provide a single global access point
    public static synchronized GradeProcessingSystem getInstance() {
        if (instance == null) {
            instance = new GradeProcessingSystem();
        }
        return instance;
    }

    // Step 4: Method to process grades
    public void processGrade(String studentName, String courseName, String grade) {
        System.out.println("Processing grade for student: " + studentName);
        System.out.println("Course: " + courseName + " | Grade: " + grade);
        // Add actual grade processing logic here, e.g., saving to a database
    }
}
