/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package student.management.system;

/**
 *
 * @author Ahmed
 */
class PercentageGradingSystem implements GradingStrategy {
    @Override
    public String calculateGrade(String rawGrade) {
        int percentage = Integer.parseInt(rawGrade);
        if (percentage >= 90) return "A";
        if (percentage >= 80) return "B";
        if (percentage >= 70) return "C";
        if (percentage >= 60) return "D";
        return "F";
    }
}
