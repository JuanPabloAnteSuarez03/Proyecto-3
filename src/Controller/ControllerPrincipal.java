/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.VistaDashboard;
import Vistas.VistaLogin;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author RYZEN
 */
public class ControllerPrincipal {
    
    private ModeloPrincipal modelo;
    private VistaLogin vistaLogin;

    public ControllerPrincipal(ModeloPrincipal modelo, VistaLogin vista) {
        this.modelo = modelo;
        this.vistaLogin = vista;
        
        agregarListenersBtnDashBoard();
        
    }
    
    private void agregarListenersBtnDashBoard(){
        vistaLogin.addBtnEntrarMouseEvent(new MouseListenerController());
        vistaLogin.addBtnRegistrarseMouseEvent(new MouseListenerController());
    }
    
    public class MouseListenerController implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent event) {
            if (event.getSource() == vistaLogin.getBtnEntrar()){
                vistaLogin.dispose();
                VistaDashboard vistaDashboard = new VistaDashboard();
                ControllerDashboard dashboard = new ControllerDashboard(modelo, vistaDashboard);
                
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
        
    }
    
}
