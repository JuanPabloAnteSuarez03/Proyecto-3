/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Cuenta;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public interface ICuentaDao {
    
    public List<Cuenta> getAllCuentas();
    public Cuenta getCuenta(int cuentaId);
    public boolean addCuenta(Cuenta cuenta);
    public boolean updateCuenta(Cuenta cuenta);
    public boolean deleteCuenta(Cuenta cuenta);
    
}
