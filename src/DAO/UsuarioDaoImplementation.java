/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public class UsuarioDaoImplementation implements IUsuarioDao{

    List<Usuario> usuarios;
    
    public UsuarioDaoImplementation() {
        this.usuarios = new ArrayList<>();
    }
    
 
    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarios;
    }

    @Override
    public Usuario getUsuario(int usuarioId) {
        Usuario usuario = null;
        
        for(Usuario usuarioActual : usuarios){
            if(usuarioActual.getId() == usuarioId){
                usuario = usuarioActual;
                break;
            }
        }
        return usuario;
    }

    @Override
    public boolean addUsuario(Usuario usuario) {
        usuarios.add(usuario);
        return true;
    }

    @Override
    public boolean updateUsuario(Usuario usuario, Usuario nuevoUsuario) {
        System.out.println("Hola");
        if(usuarios.contains(usuario)){
            
            int pos = usuarios.indexOf(usuario);
            usuarios.set(pos, nuevoUsuario);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUsuario(Usuario usuario) {
        usuarios.remove(usuario);
        return true;
    }
}
