/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author RYZEN
 */
public class Usuario {
    private static int numero;
    private final int idUsuario;
    private final String cedula;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    private String sexo;
    private final String rolUsuario;

    public Usuario(String cedula, String nombre, String telefono, String email, String direccion, String sexo, String rolUsuario) {
        this.idUsuario = numero++;
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.sexo = sexo;
        this.rolUsuario = rolUsuario;
        
    }

    public Usuario(int id, String cedula, String nombre, String telefono, String email, String direccion, String sexo, String rolUsuario) {
        numero++;
        this.idUsuario = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.sexo = sexo;
        this.rolUsuario = rolUsuario;
    }
    
    
    
    /* Getters and Setters */

    public int getId() {
        return idUsuario;
    }

    public String getCedula() {
        return cedula;
    }
    
    
    
    

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Usuario.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }
    
    

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", cedula=" + cedula + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + ", sexo=" + sexo + ", rolUsuario=" + rolUsuario + '}';
    }
    
    
    
    
    
    
    
    
    
    
}
