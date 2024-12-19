/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

import strategy.GradingStrategy;

/**
 *
 * @author Ahmed
 */
public class GradingContext {
    private GradingStrategy gradingStrategy;

    // Set the grading strategy at runtime
    public void setGradingStrategy(GradingStrategy strategy) {
        this.gradingStrategy = strategy;
    }

    // Use the selected grading strategy to calculate the grade
    public String calculateGrade(String rawGrade) {
        if (gradingStrategy == null) {
            throw new IllegalStateException("Grading strategy not set.");
        }
        return gradingStrategy.calculateGrade(rawGrade);
    }
}