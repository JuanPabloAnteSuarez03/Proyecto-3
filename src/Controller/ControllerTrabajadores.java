/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Modelo.Usuario;
import Vistas.PanelAfiliados;
import Vistas.PanelTrabajadores;
import Vistas.PanelUsuariosCRUD;
import Vistas.VistaDashboard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author evalab
 */
public class ControllerTrabajadores {
    
    private ModeloPrincipal modelo;
    private PanelTrabajadores vistaTrabajadores;
    private VistaDashboard vistaDashboard;
    

    public ControllerTrabajadores(ModeloPrincipal modelo, PanelTrabajadores vista, VistaDashboard dashboard) {
        this.modelo = modelo;
        this.vistaTrabajadores = vista;
        this.vistaDashboard = dashboard;
        
        agregarListenersBtnDashBoard();
        
        llenarTabla();
        
    }
    
    private void agregarListenersBtnDashBoard(){
        DashboardListener listener = new DashboardListener();
        
        vistaTrabajadores.addTablaTrabajadoresListener(listener);
        vistaTrabajadores.addBtnVerListener(listener);
        vistaTrabajadores.addBtnEditarListener(listener);
        vistaTrabajadores.addBtnEliminarListener(listener);
        vistaTrabajadores.addBtnCrearListener(listener);
    }
    
    
    
    private void llenarTabla(){
        List<Usuario> trabajadores = modelo.getInformacion().getTrabajadores();
        String[] dato = new String[7];
        System.out.println(trabajadores.toString());
        for (Usuario trabajador : trabajadores) {
            dato[0] = trabajador.getCedula();
            dato[1] = trabajador.getNombre();
            dato[2] = trabajador.getTelefono();
            dato[3] = trabajador.getEmail();
            dato[4] = trabajador.getDireccion();
            dato[5] = trabajador.getSexo();
            dato[6] = trabajador.getRolUsuario();
            vistaTrabajadores.agregarDatosTabla(dato);
        }
        
    }
    
    class DashboardListener implements MouseListener{
        
        private boolean elementoSeleccionado = false; 
        private int valorSeleccionado;
        
        private void enviarInformacion(Usuario usuarioSeleccionado, PanelUsuariosCRUD panel){
            String[] dato = new String[7];
                    
                    dato[0] = usuarioSeleccionado.getNombre();
                    dato[1] = usuarioSeleccionado.getCedula();
                    dato[2] = usuarioSeleccionado.getTelefono();
                    dato[3] = usuarioSeleccionado.getEmail();
                    dato[4] = usuarioSeleccionado.getDireccion();
                    dato[5] = usuarioSeleccionado.getSexo();
                    dato[6] = usuarioSeleccionado.getRolUsuario();
                    
                    panel.ingresarInformacionTrabajador(dato);
                    panel.setDatosActuales(dato);
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getSource() == vistaTrabajadores.getTablaTrabajadores()){
                vistaTrabajadores.activarBotones();
                valorSeleccionado = vistaTrabajadores.getTablaTrabajadores().getSelectedRow();
                elementoSeleccionado = vistaTrabajadores.getTablaTrabajadores().getRowSelectionAllowed();
            }
            
            if(elementoSeleccionado){
                if(me.getSource() == vistaTrabajadores.getBtnVer()){
                    PanelUsuariosCRUD panelAfiliadosVer = new PanelUsuariosCRUD();
                    vistaDashboard.realizarCambioPanelDashboard(panelAfiliadosVer);
                    panelAfiliadosVer.ponerFondoCRUDTrabajadores("Ver");
                    panelAfiliadosVer.activarBtnEditar();
                    
                    List<Usuario> datosAfiliados = modelo.getInformacion().getTrabajadores();
                    Usuario afiliadoSeleccionado =  datosAfiliados.get(valorSeleccionado);
                    modelo.getInformacion().setUsuarioActualInfo(afiliadoSeleccionado);
                    
                    enviarInformacion(afiliadoSeleccionado, panelAfiliadosVer);
                    
                    ControllerUsuariosCRUD afiliados = new ControllerUsuariosCRUD(modelo, panelAfiliadosVer, vistaDashboard);
                    
                }else if(me.getSource() == vistaTrabajadores.getBtnEditar()){
                    
                    PanelUsuariosCRUD panelAfiliadosEditar = new PanelUsuariosCRUD();
                    vistaDashboard.realizarCambioPanelDashboard(panelAfiliadosEditar);
                    panelAfiliadosEditar.ponerFondoCRUDTrabajadores("Editar");
                    panelAfiliadosEditar.activarBotones();
                    panelAfiliadosEditar.activarComponentes();
                    
                    List<Usuario> datosAfiliados = modelo.getInformacion().getTrabajadores();
                    Usuario afiliadoSeleccionado =  datosAfiliados.get(valorSeleccionado);
                    modelo.getInformacion().setUsuarioActualInfo(afiliadoSeleccionado);
                    
                    enviarInformacion(afiliadoSeleccionado, panelAfiliadosEditar);
                    
                    ControllerUsuariosCRUD afiliados = new ControllerUsuariosCRUD(modelo, panelAfiliadosEditar, vistaDashboard);
                }else if(me.getSource() == vistaTrabajadores.getBtnEliminar()){
                    
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar este afiliado?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        List<Usuario> datosAfiliados = modelo.getInformacion().getTrabajadores();
                        Usuario afiliadoSeleccionado =  datosAfiliados.get(valorSeleccionado);
                        modelo.getInformacion().eliminarUsuario(afiliadoSeleccionado);
                        
                        PanelTrabajadores panelTrabajadores = new PanelTrabajadores();
                        vistaDashboard.realizarCambioPanelDashboard(panelTrabajadores);
                        ControllerTrabajadores afiliados = new ControllerTrabajadores(modelo, panelTrabajadores,vistaDashboard);
                    }
                }
            }
            if(me.getSource() == vistaTrabajadores.getBtnCrear()){
                    
                PanelUsuariosCRUD panelTrabajadoresCrear = new PanelUsuariosCRUD();
                vistaDashboard.realizarCambioPanelDashboard(panelTrabajadoresCrear);
                panelTrabajadoresCrear.ponerFondoCRUDTrabajadores("Crear");
                panelTrabajadoresCrear.activarBotones();
                panelTrabajadoresCrear.activarComponentes();
                panelTrabajadoresCrear.limpiarCampos();
                    
                ControllerUsuariosCRUD afiliados = new ControllerUsuariosCRUD(modelo, panelTrabajadoresCrear, vistaDashboard);
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
