/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;


import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public interface IUsuarioDao{
    
    public List<Usuario> getAllUsuarios();
    public Usuario getUsuario(int usuarioId);
    public boolean addUsuario(Usuario usuario);
    public boolean updateUsuario(Usuario usuario, Usuario nuevoUsuario);
    public boolean deleteUsuario(Usuario usuario);
    
}
