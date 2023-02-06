/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Cita;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public interface ICitaDao {
    public List<Cita> getAllCitas();
    public Cita getCita(int citaId);
    public boolean addCita(Cita cita);
    public boolean updateCita(Cita cita);
    public boolean deleteCita(Cita cita);
    
}
