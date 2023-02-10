/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author RYZEN
 */
public class ModeloPrincipal {
    
    private final Informacion informacion;

    public ModeloPrincipal() {
        this.informacion = new Informacion();
    }

    public Informacion getInformacion() {
        return informacion;
    }
    public boolean verificarCuenta(String nombreUsuario, String password){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Archivos/Cuentas.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(nombreUsuario) && parts[1].equals(password)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo de cuentas");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de cuentas");
        }
        return false;
    }
    
    public void guardarCuenta(String nombreUsuario, String password) {
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Archivos/Cuentas.txt", true));
        writer.write(nombreUsuario + "," + password);
        writer.newLine();
        writer.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    
}
    
    public void guardarUsuario(int id, String cedula, String nombre, String telefono, String email, String direccion, String sexo, String rolUsuario) {
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Usuarios.txt", true));
        writer.write(id + ";" + cedula + ";" + nombre + ";" + telefono + ";" + email + ";" + direccion + ";" + sexo + ";" + rolUsuario);
        writer.newLine();
        writer.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
    public void guardarCita(int idCita, String fecha, String hora, String piso, String sala, int idAfiliado, int idTrabajador) {
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Citas.txt", true));
        writer.write(idCita + ";" + fecha + ";" + hora + ";" + piso + ";" + sala + ";" + idAfiliado + ";" + idTrabajador);
        writer.newLine();
        writer.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}


    
}
