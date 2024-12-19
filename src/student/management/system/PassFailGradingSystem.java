/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.management.system;

import strategy.GradingStrategy;

/**
 *
 * @author Ahmed
 */
class PassFailGradingSystem implements GradingStrategy {
    @Override
    public String calculateGrade(String rawGrade) {
        int score = Integer.parseInt(rawGrade);
        return score >= 50 ? "Pass" : "Fail";
    }
}