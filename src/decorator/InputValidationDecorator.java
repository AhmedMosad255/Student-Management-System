/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

public class InputValidationDecorator extends AuthenticationDecorator {
    public InputValidationDecorator(Authentication authentication) {
        super(authentication);
    }

    @Override
    public boolean authenticate(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("Validation failed: Username or Password is empty.");
            return false;
        }
        return super.authenticate(username, password);
    }
}
