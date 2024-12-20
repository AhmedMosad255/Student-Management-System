/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

public class LoggingAuthenticationDecorator extends AuthenticationDecorator {
    public LoggingAuthenticationDecorator(Authentication authentication) {
        super(authentication);
    }

    @Override
    public boolean authenticate(String username, String password) {
        boolean result = super.authenticate(username, password);
        System.out.println("Login attempt: Username=" + username + ", Success=" + result);
        return result;
    }
}