/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import DAO.CitaDaoImplementation;
import DAO.CuentaDaoImplementation;
import DAO.ICitaDao;
import DAO.ICuentaDao;
import DAO.IUsuarioDao;
import DAO.UsuarioDaoImplementation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/* Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(contacto.getFechaNacimiento());   */

/**
 *
 * @author RYZEN
 */
public class Informacion {
    private ICitaDao citaDao;
    private ICuentaDao cuentaDao;
    private IUsuarioDao usuarioDao;
    private Usuario usuarioActualInfo;
    private Cita citaActualInfo;

    public Informacion() {
        this.citaDao = new CitaDaoImplementation();
        this.cuentaDao = new CuentaDaoImplementation();
        this.usuarioDao = new UsuarioDaoImplementation();
    }
    
    /* Getters and Setters */
    
    public List<Usuario> getAfiliados(){
        List<Usuario> listaAfiliados = new LinkedList<>();
        for (Usuario usuario : usuarioDao.getAllUsuarios()) {
            if("Afiliado".equals(usuario.getRolUsuario())){
                listaAfiliados.add(usuario);
            }
        }
        
        return  listaAfiliados;
    }
    
    public List<Usuario> getTrabajadores(){
        List<Usuario> listaTrabajadores = new LinkedList<>();
        for (Usuario usuario : usuarioDao.getAllUsuarios()) {
            if(!"Afiliado".equals(usuario.getRolUsuario())){
                listaTrabajadores.add(usuario);
            }
        }
        
        
        
        return  listaTrabajadores;
    }
    
    /* Citas */
    
    public boolean agregarCita(Cita cita){
        return this.citaDao.addCita(cita);
    }
    
    public List<Cita> getListadoCitas(){
        return this.citaDao.getAllCitas();
    }  
    
    public boolean eliminarCita(Cita cita){
        return this.citaDao.deleteCita(cita);
    }
    
    public boolean actualizarCita(Cita cita){
        return this.citaDao.updateCita(cita);
    }
    
    public void cargarCitas(){
        cargarDatos("Citas");
    }
    
    public void crearCitas(String[] citas){
        int idCita = (int) Integer.parseInt(citas[0]);
        String fecha = citas[1];
        String hora = citas[2];
        String piso = citas[3];
        String sala = citas[4];
        int idAfiliado = (int) Integer.parseInt(citas[5]);
        int idTrabajador = (int) Integer.parseInt(citas[6]);
        Cita nuevaCita = new Cita(idCita, fecha, hora, piso, sala, idAfiliado, idTrabajador);
        
        agregarCita(nuevaCita);
    }
    
    /* Usuarios */
    
    public Usuario getUsuario(int idUsuario){
        return this.usuarioDao.getUsuario(idUsuario);
    }
    
    public boolean agregarUsuario(Usuario usuario){
        return this.usuarioDao.addUsuario(usuario);
    }
    
    public List<Usuario> getListadoUsuario(){
        return  this.usuarioDao.getAllUsuarios();
    }  
    
    public boolean eliminarUsuario(Usuario usuario){
        return this.usuarioDao.deleteUsuario(usuario);
    }
    
    public boolean actualizarUsuario(Usuario usuario, Usuario nuevoUsuario){
        return this.usuarioDao.updateUsuario(usuario,  nuevoUsuario);
    }
    
    public void crearUsuarios(String[] usuarios){
        int idUsuario = (int) Integer.parseInt(usuarios[0]);
        String cedula = usuarios[1];
        String nombre = usuarios[2];
        String telefono = usuarios[3];
        String email = usuarios[4];
        String direccion = usuarios[5];
        String sexo = usuarios[6];
        String rol = usuarios[7];
        
        Usuario nuevoUsuario = new Usuario(idUsuario ,cedula, nombre, telefono, email, direccion, sexo, rol);
        
        agregarUsuario(nuevoUsuario);
    }
    
    public void crearUsuario(String[] usuario, String rol){
        String nombre = usuario[0];
        String cedula = usuario[1];
        String telefono = usuario[2]; 
        String email = usuario[3];
        String direccion = usuario[4];
        String sexo = usuario[5];
        
        Usuario nuevoUsuario = new Usuario(cedula, nombre, telefono, email, direccion, sexo, rol);
        
        agregarUsuario(nuevoUsuario);
    }
    
    public void cambiarInfoUsuario(String[] datos, int idUsuario, String rol){
        String nombre = datos[0];
        String cedula = datos[1];
        String telefono = datos[2];
        String email = datos[3];
        String direccion = datos[4];
        String sexo = datos[5];
        
        Usuario nuevoUsuario = new Usuario(idUsuario ,cedula, nombre, telefono, email, direccion, sexo, rol);
        
        actualizarUsuario(usuarioActualInfo, nuevoUsuario);
    }
    
    public void cargarUsuarios(){
        cargarDatos("Usuarios");
    }
    
    /* Cuentas */
    
    public boolean agregarCuenta(Cuenta cuenta){
        return this.cuentaDao.addCuenta(cuenta);
    }
    
    public List<Cuenta> getListadoCuentas(){
        return  this.cuentaDao.getAllCuentas();
    }  
    
    public boolean eliminarCuenta(Cuenta cuenta){
        return this.cuentaDao.deleteCuenta(cuenta);
    }
    
    public boolean actualizarCuenta(Cuenta cuenta){
        return this.cuentaDao.updateCuenta(cuenta);
    }
     
    /* Cargar Datos */
    
    public void cargarDatos(String datosArchivo){
        File archivo = null;
        FileReader reader = null;
        BufferedReader buffered = null;
     
        try {
          archivo = new File ("src//Archivos//"+datosArchivo+".txt");
          reader = new FileReader (archivo);
          buffered = new BufferedReader(reader);
          String linea="";

          while((linea=buffered.readLine())!= null){
              StringTokenizer tokens = new StringTokenizer(linea, ";");
              int nDatos=tokens.countTokens();

              String[] datos = new String[nDatos];

              int i=0;
              while(tokens.hasMoreTokens()){
                  String str = tokens.nextToken();
                  datos[i]= String.valueOf(str);
                  i++;
              }


              if("Usuarios".equals(datosArchivo)){
                  crearUsuarios(datos);
              }

              else if("Citas".equals(datosArchivo)){
                  crearCitas(datos);
              }

              System.out.println(linea);

              System.out.println("EMPIEZA OTRO DATO");
        }

        }catch(IOException ioe){
            System.out.println(ioe);
        }finally{
           try{                   
              if( null != reader ){  
                 reader.close();    
              }                 
           }catch (IOException e2){
               System.out.println(e2);
           }
        }
    }

    public Usuario getUsuarioActualInfo() {
        return usuarioActualInfo;
    }

    public void setUsuarioActualInfo(Usuario usuarioActualInfo) {
        this.usuarioActualInfo = usuarioActualInfo;
    }

    public Cita getCitaActualInfo() {
        return citaActualInfo;
    }

    public void setCitaActualInfo(Cita citaActualInfo) {
        this.citaActualInfo = citaActualInfo;
    }
    
    
    
    
    
    
    
    
}
