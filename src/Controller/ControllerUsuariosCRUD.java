/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.PanelAfiliados;
import Vistas.PanelTrabajadores;
import Vistas.PanelUsuariosCRUD;
import Vistas.VistaDashboard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author RYZEN
 */
public class ControllerUsuariosCRUD {
    
    private ModeloPrincipal modelo;
    private PanelUsuariosCRUD vistaUsuario;
    private VistaDashboard vistaDashboard;
    

    public ControllerUsuariosCRUD(ModeloPrincipal modelo, PanelUsuariosCRUD vista, VistaDashboard dashboard) {
        this.modelo = modelo;
        this.vistaUsuario = vista;
        this.vistaDashboard = dashboard;
        
        agregarListenersBtnDashBoard();
        
    }
    
    private void agregarListenersBtnDashBoard(){
        DashboardListener listener = new DashboardListener();
        
        vistaUsuario.addBtnEditarListener(listener);
        vistaUsuario.addBtnAceptarListener(listener);
        vistaUsuario.addBtnCancelarListener(listener);
        vistaUsuario.addBtnVolverListener(listener);
    }
    
    class DashboardListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            
            if(me.getSource() == vistaUsuario.getBtnEditar() && vistaUsuario.isBtnEditarActivo()){
                activarVentanaEditar(vistaDashboard.getTipoAccionActual());
                
            }else if(me.getSource() == vistaUsuario.getBtnVolver()){
                
                regresarVentana(vistaDashboard.getTipoAccionActual());
                
            }else if(me.getSource() == vistaUsuario.getBtnCancelar() && vistaUsuario.isBtnCancelarActivo()){
                if (JOptionPane.showConfirmDialog(null, "¿Seguro que cancelar la edición?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    regresarVentana(vistaDashboard.getTipoAccionActual());
                }
                
            }else if(me.getSource() == vistaUsuario.getBtnAceptar() && vistaUsuario.isBtnAceptarActivo()){
                if(vistaUsuario.validarCampos()){
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere crear un afiliado con la información ingresada?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        
                        accionAceptar(vistaDashboard.getTipoAccionActual());
                        
                        regresarVentana(vistaDashboard.getTipoAccionActual());
                        
                    }
                }else{
                    if (JOptionPane.showConfirmDialog(null, "Debe completar todos los campos", "Mensaje", JOptionPane.CLOSED_OPTION) == JOptionPane.YES_OPTION) {
                    }
                    
                }
                
                
            }
            
            
            
        }
        
        private void regresarVentana(String ventanaActual){
            if("Afiliado".equals(ventanaActual)){
                vistaDashboard.setTipoAccionActual("Afiliado");
                PanelAfiliados panelAfiliados = new PanelAfiliados();
                vistaDashboard.realizarCambioPanelDashboard(panelAfiliados);
                ControllerAfiliados afiliados = new ControllerAfiliados(modelo, panelAfiliados ,vistaDashboard);
            }else if("Trabajador".equals(ventanaActual)){
                vistaDashboard.setTipoAccionActual("Trabajador");
                PanelTrabajadores panelTrabajadores = new PanelTrabajadores();
                vistaDashboard.realizarCambioPanelDashboard(panelTrabajadores);
                ControllerTrabajadores trabajadores = new ControllerTrabajadores(modelo, panelTrabajadores ,vistaDashboard);
            
                
            }
        }
        
        private void activarVentanaEditar(String ventanaActual){
            if("Afiliado".equals(ventanaActual)){
                vistaUsuario.activarBotones();
                vistaUsuario.ponerFondoCRUD("Editar");
                vistaUsuario.activarComponentes();
            
            }else if("Trabajador".equals(ventanaActual)){
                vistaUsuario.activarBotones();
                vistaUsuario.ponerFondoCRUDTrabajadores("Editar");
                vistaUsuario.activarComponentes();
            }  
        }
        
        private void accionAceptar(String ventanaActual){
            String[] datos = new String[0];
            if("Afiliado".equals(ventanaActual)){
                datos = vistaUsuario.obtenerInformacion();
            
            }else if("Trabajador".equals(ventanaActual)){
                datos = vistaUsuario.obtenerInformacionTrabajador();
            }
            
               
            if("Crear".equals(vistaUsuario.getAccionActual())){
                modelo.getInformacion().crearUsuario(datos, vistaDashboard.getTipoAccionActual());
            }else if("Editar".equals(vistaUsuario.getAccionActual()) && "Afiliado".equals(ventanaActual) ){
                modelo.getInformacion().cambiarInfoUsuario(datos, modelo.getInformacion().getUsuarioActualInfo().getId(), vistaDashboard.getTipoAccionActual());
            }else if("Editar".equals(vistaUsuario.getAccionActual()) && "Trabajador".equals(ventanaActual) ){
                modelo.getInformacion().cambiarInfoUsuario(datos, modelo.getInformacion().getUsuarioActualInfo().getId(), datos[6]);

            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {           
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    }
    
}
