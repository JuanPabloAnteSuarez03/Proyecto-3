/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author RYZEN
 */
public class Cita {
    private final int idCita;
    private String fecha;
    private String hora;
    private String piso;
    private String sala;
    private int idAfiliado;
    private int idTrabajador;
    private static int numero; 

    public Cita(int idCita, String fecha, String hora, String piso, String sala, int idAfiliado, int idTrabajador) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.piso = piso;
        this.sala = sala;
        this.idAfiliado = idAfiliado;
        this.idTrabajador = idTrabajador;
        numero++;
    }

    public Cita(String fecha, String hora, String piso, String sala, int idAfiliado, int idTrabajador) {
        this.fecha = fecha;
        this.hora = hora;
        this.piso = piso;
        this.sala = sala;
        this.idAfiliado = idAfiliado;
        this.idTrabajador = idTrabajador;
        this.idCita = numero++;
    }
    
    
    
    /* Getters And Setters */

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getIdCita() {
        return idCita;
    }

    public int getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(int idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Cita.numero = numero;
    }

    @Override
    public String toString() {
        return "Cita{" + "idCita=" + idCita + ", fecha=" + fecha + ", hora=" + hora + ", piso=" + piso + ", sala=" + sala + ", idAfiliado=" + idAfiliado + ", idTrabajador=" + idTrabajador + '}';
    }
    
}
