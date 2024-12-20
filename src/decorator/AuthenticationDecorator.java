/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

public abstract class AuthenticationDecorator implements Authentication {
    protected Authentication authentication;

    public AuthenticationDecorator(Authentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public boolean authenticate(String username, String password) {
        return authentication.authenticate(username, password);
    }
}