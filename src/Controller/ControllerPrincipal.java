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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

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
                String correo = vistaLogin.getTxtUsuario().getText();
                String password = vistaLogin.getTxtPassword().getText();

                String passwordEncriptada = encriptarPassword("secretKey", password);
                if (modelo.verificarCuenta(correo, passwordEncriptada)) {
                    vistaLogin.dispose();
                    VistaDashboard vistaDashboard = new VistaDashboard();
                    ControllerDashboard dashboard = new ControllerDashboard(modelo, vistaDashboard);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            } else if (event.getSource() == vistaLogin.getBtnRegistrarse()) {
                String correo = vistaLogin.getTxtUsuario().getText();
                String password = vistaLogin.getTxtPassword().getText();

                String passwordEncriptada = encriptarPassword("secretKey", password);
                modelo.guardarCuenta(correo, passwordEncriptada);
                JOptionPane.showMessageDialog(null, "Registro exitoso");
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

    private String encriptarPassword(String secretKey, String password) {
        String encriptacion = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(secretKey.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
            encriptacion = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
            return encriptacion;
        }
}

