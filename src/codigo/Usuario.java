/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author alber
 */
public class Usuario {
    
    int DNI;
    String nombre;
    String apellido;
    String email;
    int penalizacion;
    
    public Usuario( int dni, String nombre, String apellido, String email, int penalizacion){
        this.DNI = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.penalizacion = penalizacion;
    }
}
