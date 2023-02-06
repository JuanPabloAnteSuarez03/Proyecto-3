/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Modelo.Usuario;
import Vistas.PanelAfiliados;
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
public class ControllerAfiliados {
    
    private ModeloPrincipal modelo;
    private PanelAfiliados vistaAfiliados;
    private VistaDashboard vistaDashboard;
    

    public ControllerAfiliados(ModeloPrincipal modelo, PanelAfiliados vista, VistaDashboard dashboard) {
        this.modelo = modelo;
        this.vistaAfiliados = vista;
        this.vistaDashboard = dashboard;
        
        agregarListenersBtnDashBoard();
        
        llenarTabla();
        
    }
    
    private void agregarListenersBtnDashBoard(){
        DashboardListener listener = new DashboardListener();
        
        vistaAfiliados.addTablaAfiliadosListener(listener);
        vistaAfiliados.addBtnVerListener(listener);
        vistaAfiliados.addBtnEditarListener(listener);
        vistaAfiliados.addBtnEliminarListener(listener);
        vistaAfiliados.addBtnCrearListener(listener);
    }
    
    
    
    private void llenarTabla(){
        List<Usuario> afiliados = modelo.getInformacion().getAfiliados();
        String[] dato = new String[6];
        
        for (Usuario afiliado : afiliados) {
            dato[0] = afiliado.getCedula();
            dato[1] = afiliado.getNombre();
            dato[2] = afiliado.getTelefono();
            dato[3] = afiliado.getEmail();
            dato[4] = afiliado.getDireccion();
            dato[5] = afiliado.getSexo();
            
            vistaAfiliados.agregarDatosTabla(dato);
        }
        
    }
    
    class DashboardListener implements MouseListener{
        
        private boolean elementoSeleccionado = false; 
        private int valorSeleccionado;
        
        private void enviarInformacion(Usuario usuarioSeleccionado, PanelUsuariosCRUD panel){
            String[] dato = new String[6];
                    
                    dato[0] = usuarioSeleccionado.getNombre();
                    dato[1] = usuarioSeleccionado.getCedula();
                    dato[2] = usuarioSeleccionado.getTelefono();
                    dato[3] = usuarioSeleccionado.getEmail();
                    dato[4] = usuarioSeleccionado.getDireccion();
                    dato[5] = usuarioSeleccionado.getSexo();
                    
                    panel.ingresarInformacion(dato);
                    panel.setDatosActuales(dato);
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getSource() == vistaAfiliados.getTablaAfiliados()){
                vistaAfiliados.activarBotones();
                valorSeleccionado = vistaAfiliados.getTablaAfiliados().getSelectedRow();
                elementoSeleccionado = vistaAfiliados.getTablaAfiliados().getRowSelectionAllowed();
            }
            
            if(elementoSeleccionado){
                if(me.getSource() == vistaAfiliados.getBtnVer()){
                    PanelUsuariosCRUD panelAfiliadosVer = new PanelUsuariosCRUD();
                    vistaDashboard.realizarCambioPanelDashboard(panelAfiliadosVer);
                    panelAfiliadosVer.ponerFondoCRUD("Ver");
                    panelAfiliadosVer.activarBtnEditar();
                    
                    List<Usuario> datosAfiliados = modelo.getInformacion().getAfiliados();
                    Usuario afiliadoSeleccionado =  datosAfiliados.get(valorSeleccionado);
                    modelo.getInformacion().setUsuarioActualInfo(afiliadoSeleccionado);
                    
                    enviarInformacion(afiliadoSeleccionado, panelAfiliadosVer);
                    
                    ControllerUsuariosCRUD afiliados = new ControllerUsuariosCRUD(modelo, panelAfiliadosVer, vistaDashboard);
                    
                }else if(me.getSource() == vistaAfiliados.getBtnEditar()){
                    
                    PanelUsuariosCRUD panelAfiliadosEditar = new PanelUsuariosCRUD();
                    vistaDashboard.realizarCambioPanelDashboard(panelAfiliadosEditar);
                    panelAfiliadosEditar.ponerFondoCRUD("Editar");
                    panelAfiliadosEditar.activarBotones();
                    panelAfiliadosEditar.activarComponentes();
                    
                    List<Usuario> datosAfiliados = modelo.getInformacion().getAfiliados();
                    Usuario afiliadoSeleccionado =  datosAfiliados.get(valorSeleccionado);
                    modelo.getInformacion().setUsuarioActualInfo(afiliadoSeleccionado);
                    
                    enviarInformacion(afiliadoSeleccionado, panelAfiliadosEditar);
                    
                    ControllerUsuariosCRUD afiliados = new ControllerUsuariosCRUD(modelo, panelAfiliadosEditar, vistaDashboard);
                }else if(me.getSource() == vistaAfiliados.getBtnEliminar()){
                    
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar este afiliado?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        List<Usuario> datosAfiliados = modelo.getInformacion().getAfiliados();
                        Usuario afiliadoSeleccionado =  datosAfiliados.get(valorSeleccionado);
                        modelo.getInformacion().eliminarUsuario(afiliadoSeleccionado);
                        
                        PanelAfiliados panelAfiliados = new PanelAfiliados();
                        vistaDashboard.realizarCambioPanelDashboard(panelAfiliados);
                        ControllerAfiliados afiliados = new ControllerAfiliados(modelo, panelAfiliados,vistaDashboard);
                    }
                }
            }
            if(me.getSource() == vistaAfiliados.getBtnCrear()){
                    
                PanelUsuariosCRUD panelAfiliadosCrear = new PanelUsuariosCRUD();
                vistaDashboard.realizarCambioPanelDashboard(panelAfiliadosCrear);
                panelAfiliadosCrear.ponerFondoCRUD("Crear");
                panelAfiliadosCrear.activarBotones();
                panelAfiliadosCrear.activarComponentes();
                panelAfiliadosCrear.limpiarCampos();
                    
                ControllerUsuariosCRUD afiliados = new ControllerUsuariosCRUD(modelo, panelAfiliadosCrear, vistaDashboard);
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
