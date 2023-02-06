/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Cuenta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public class CuentaDaoImplementation implements ICuentaDao{
    
    List<Cuenta> cuentas;
    
    public CuentaDaoImplementation() {
        this.cuentas = new ArrayList<>();
    }

    @Override
    public List<Cuenta> getAllCuentas() {
        return cuentas;
    }

    @Override
    public Cuenta getCuenta(int cuentaId) {
        Cuenta cuenta = null;
        
        for(Cuenta cuentaActual : cuentas){
            if(cuentaActual.getIdCuenta() == cuentaId){
                cuenta = cuentaActual;
                break;
            }
        }
        return cuenta;
    }

    @Override
    public boolean addCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
        return true;
    }

    @Override
    public boolean updateCuenta(Cuenta cuenta) {
        if(cuentas.contains(cuenta)){
            int pos = cuentas.indexOf(cuenta);
            cuentas.set(pos, cuenta);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCuenta(Cuenta cuenta) {
        cuentas.remove(cuenta);
        return true;
    }
    
}
