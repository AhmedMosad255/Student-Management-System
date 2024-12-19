/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import java.util.ArrayList;
import java.util.List;

public class StudentSubject implements Subject {
    private List<Observer> observers;
    private String studentName;
    private String studentType;

    public StudentSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(studentName, studentType);
        }
    }

    public void addStudent(String studentName, String studentType) {
        this.studentName = studentName;
        this.studentType = studentType;
        notifyObservers();
    }
}
