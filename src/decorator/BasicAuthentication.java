/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

/**
 *
 * @author Ahmed
 */
public class BasicAuthentication implements Authentication {
    @Override
    public boolean authenticate(String username, String password) {
        // Basic username and password check
        return "admin".equals(username) && "admin123".equals(password);
    }
}
