/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;


public class StudentAddedObserver implements Observer {
    @Override
    public void update(String studentName, String studentType) {
        System.out.println("New student added: " + studentName + " (" + studentType + ")");
        // You could also update the UI or perform other actions based on the new student info.
    }
}
