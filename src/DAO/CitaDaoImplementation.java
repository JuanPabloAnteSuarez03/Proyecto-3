/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Cita;
import Modelo.Cuenta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public class CitaDaoImplementation implements ICitaDao{
    
    List<Cita> citas;
    
    public CitaDaoImplementation() {
        this.citas = new ArrayList<>();
    }

    @Override
    public List<Cita> getAllCitas() {
        return citas;
    }

    @Override
    public Cita getCita(int citaId) {
        Cita cita = null;
        
        for(Cita citaActual : citas){
            if(citaActual.getIdCita() == citaId){
                cita = citaActual;
                break;
            }
        }
        return cita;
    }

    @Override
    public boolean addCita(Cita cita) {
        citas.add(cita);
        return true;
    }

    @Override
    public boolean updateCita(Cita cita) {
        if(citas.contains(cita)){
            int pos = citas.indexOf(cita);
            citas.set(pos, cita);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCita(Cita cita) {
        citas.remove(cita);
        return true;
    }
    
}
