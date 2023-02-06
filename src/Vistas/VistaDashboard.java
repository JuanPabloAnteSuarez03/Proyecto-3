/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author RYZEN
 */
public class VistaDashboard extends javax.swing.JFrame {

    private PanelDashboard panelDashboard = new PanelDashboard();
    private PanelAfiliados panelAfiliados = new PanelAfiliados();
    private PanelTrabajadores panelTrabajadores = new PanelTrabajadores();
    private PanelCitas panelCitas = new PanelCitas();
    
    
    private boolean btnDashboardActivo = false;
    private boolean btnAfiliadosActivo = false;
    private boolean btnTrabajadoresActivo = false;
    private boolean btnCitasActivo = false;
    
    private String tipoAccionActual;
    
    
    public VistaDashboard() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(1363, 765);
    }
    
    public void addBtnAfiliadosListener(MouseListener listener){
        btnAfiliados.addMouseListener(listener);
    }
    
    public void addBtnTrabajadoresListener(MouseListener listener){
        btnTrabajadores.addMouseListener(listener);
    }
    
    public void addBtnCitasListener(MouseListener listener){
        btnCitas.addMouseListener(listener);
    }
    
    public void realizarCambioPanelDashboard(JPanel contenidoPanel){
        ubicarPanelEnDashboard(contenidoPanel);
        agregarPanelSeleccionado(contenidoPanel);
    }
    
    private void agregarPanelSeleccionado(JPanel contenidoPanel){
        jPanel1.removeAll();
        jPanel1.add(contenidoPanel, BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    private void ubicarPanelEnDashboard(JPanel panel){
        panel.setSize(1086, 503);
        panel.setLocation(0,0);
    }
    
    
    private void setColorAzul(String boton, JLabel imagenBoton){
        Icon btnCitasAzul = new ImageIcon("src//Imagenes//BotonesDashboard//00-Btn"+boton+"Azul-img.png"); 
        imagenBoton.setIcon(btnCitasAzul);
        activarEstadoBoton(boton);
    }
    
    private void setColorGris(String boton, JLabel imagenBoton){
        Icon btnCitasGris = new ImageIcon("src//Imagenes//BotonesDashboard//00-Btn"+boton+"Gris-img.png");  
        imagenBoton.setIcon(btnCitasGris);
        desactivarEstadoBoton(boton);
    }
    
    private void activarEstadoBoton(String boton){
        if(null != boton)
            switch (boton) {
                case "Dashboard":
                    btnDashboardActivo = true;
                    break;
                case "Afiliados":
                    btnAfiliadosActivo = true;
                    break;
                case "Trabajadores":
                    btnTrabajadoresActivo = true;
                    break;
                case "Citas":
                    btnCitasActivo = true;
                    break;
                default:
                    break;
        }
    }
    
    private void desactivarEstadoBoton(String boton){
        if(null != boton)
            switch (boton) {
                case "Dashboard":
                    btnDashboardActivo = false;
                    break;
                case "Afiliados":
                    btnAfiliadosActivo = false;
                    break;
                case "Trabajadores":
                    btnTrabajadoresActivo = false;
                    break;
                case "Citas":
                    btnCitasActivo = false;
                    break;
                default:
                    break;
        }
    }
    
    private void mostrarBotonDashboardActivado(){
        setColorAzul("Dashboard",btnDashboard);
        setColorGris("Afiliados", btnAfiliados);
        setColorGris("Trabajadores", btnTrabajadores);
        setColorGris("Citas", btnCitas);
    }
    
    private void mostrarBotonAfiliadosActivado(){
        setColorGris("Dashboard",btnDashboard);
        setColorAzul("Afiliados", btnAfiliados);
        setColorGris("Trabajadores", btnTrabajadores);
        setColorGris("Citas", btnCitas);
    }
    
    private void mostrarBotonTrabajadoresActivado(){
        setColorGris("Dashboard",btnDashboard);
        setColorGris("Afiliados", btnAfiliados);
        setColorAzul("Trabajadores", btnTrabajadores);
        setColorGris("Citas", btnCitas);
    }
    
    private void mostrarBotonCitasActivado(){
        setColorGris("Dashboard",btnDashboard);
        setColorGris("Afiliados", btnAfiliados);
        setColorGris("Trabajadores", btnTrabajadores);
        setColorAzul("Citas", btnCitas);
    }
    
    private void cambiarImagenPrincipal(String titulo){
        fondoDashboard.setIcon(new ImageIcon("src//Imagenes//ImagenesDashboard//00-" + titulo + "-img.png"));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnCitas = new javax.swing.JLabel();
        btnTrabajadores = new javax.swing.JLabel();
        btnAfiliados = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JLabel();
        fondoDashboard = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1366, 768));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1086, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 262, 1086, 503));

        btnCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesDashboard/00-BtnCitasGris-img.png"))); // NOI18N
        btnCitas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCitasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCitasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCitasMouseExited(evt);
            }
        });
        jPanel2.add(btnCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, -1, -1));

        btnTrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesDashboard/00-BtnTrabajadoresGris-img.png"))); // NOI18N
        btnTrabajadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrabajadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrabajadoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTrabajadoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrabajadoresMouseExited(evt);
            }
        });
        jPanel2.add(btnTrabajadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 400, -1, -1));

        btnAfiliados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesDashboard/00-BtnAfiliadosGris-img.png"))); // NOI18N
        btnAfiliados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAfiliados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAfiliadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAfiliadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAfiliadosMouseExited(evt);
            }
        });
        jPanel2.add(btnAfiliados, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 330, -1, -1));

        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesDashboard/00-BtnDashboardGris-img.png"))); // NOI18N
        btnDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDashboardMouseExited(evt);
            }
        });
        jPanel2.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 262, -1, -1));

        fondoDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImagenesDashboard/00-Dashboard-img.png"))); // NOI18N
        jPanel2.add(fondoDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 1370, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseEntered
        if(btnDashboardActivo == true){
            setColorAzul("Dashboard", btnDashboard);
        }
    }//GEN-LAST:event_btnDashboardMouseEntered

    private void btnAfiliadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAfiliadosMouseEntered
        if(btnAfiliadosActivo == true){
            setColorAzul("Afiliados", btnAfiliados);
        } 
    }//GEN-LAST:event_btnAfiliadosMouseEntered

    private void btnTrabajadoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrabajadoresMouseEntered
        if(btnTrabajadoresActivo == true){
            setColorAzul("Trabajadores", btnTrabajadores);
        }   
    }//GEN-LAST:event_btnTrabajadoresMouseEntered

    private void btnCitasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCitasMouseEntered
        if(btnCitasActivo == true){
            setColorAzul("Citas", btnCitas);
        }  
    }//GEN-LAST:event_btnCitasMouseEntered

    private void btnAfiliadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAfiliadosMouseExited
        if(validarEstadoBotones("Afiliados")){
            setColorGris("Afiliados", btnAfiliados);
        }
    }//GEN-LAST:event_btnAfiliadosMouseExited

    private void btnDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseExited
        if(validarEstadoBotones("Dashboard")){
            setColorGris("Dashboard", btnDashboard);
        }
    }//GEN-LAST:event_btnDashboardMouseExited

    private void btnTrabajadoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrabajadoresMouseExited
        if(validarEstadoBotones("Trabajadores")){
            setColorGris("Trabajadores", btnTrabajadores);
        }
    }//GEN-LAST:event_btnTrabajadoresMouseExited

    private void btnCitasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCitasMouseExited
        if(validarEstadoBotones("Citas")){
            setColorGris("Citas", btnCitas);
        }
    }//GEN-LAST:event_btnCitasMouseExited

    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
        mostrarBotonDashboardActivado();
        realizarCambioPanelDashboard(panelDashboard);
        cambiarImagenPrincipal("Dashboard");
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void btnAfiliadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAfiliadosMouseClicked
        mostrarBotonAfiliadosActivado();
        /*realizarCambioPanelDashboard(panelAfiliados);*/
        cambiarImagenPrincipal("Afiliados");
    }//GEN-LAST:event_btnAfiliadosMouseClicked

    private void btnTrabajadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrabajadoresMouseClicked
        mostrarBotonTrabajadoresActivado();
        //realizarCambioPanelDashboard(panelTrabajadores);
        cambiarImagenPrincipal("Trabajadores");
    }//GEN-LAST:event_btnTrabajadoresMouseClicked

    private void btnCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCitasMouseClicked
        mostrarBotonCitasActivado();
        //realizarCambioPanelDashboard(panelCitas);
        cambiarImagenPrincipal("Citas");
    }//GEN-LAST:event_btnCitasMouseClicked

    
    private boolean validarEstadoBotones(String boton){
        boolean respuesta = false;
        if(null != boton)
            switch (boton) {
                case "Dashboard":
                    respuesta = btnAfiliadosActivo || btnCitasActivo || btnTrabajadoresActivo;
                    break;
                case "Afiliados":
                    respuesta = btnDashboardActivo || btnCitasActivo || btnTrabajadoresActivo;
                    break;
                case "Trabajadores":
                    respuesta = btnDashboardActivo || btnCitasActivo || btnAfiliadosActivo;
                    break;
                case "Citas":
                    respuesta = btnDashboardActivo || btnTrabajadoresActivo || btnAfiliadosActivo;
                    break;
                default:
                    break;
        }
        return respuesta;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaDashboard().setVisible(true);
            }
        });
    }

    public JLabel getBtnAfiliados() {
        return btnAfiliados;
    }

    public JLabel getBtnTrabajadores() {
        return btnTrabajadores;
    }  

    public JLabel getBtnCitas() {
        return btnCitas;
    }
    
    

    public String getTipoAccionActual() {
        return tipoAccionActual;
    }

    public void setTipoAccionActual(String tipoAccionActual) {
        this.tipoAccionActual = tipoAccionActual;
    }
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAfiliados;
    private javax.swing.JLabel btnCitas;
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnTrabajadores;
    private javax.swing.JLabel fondoDashboard;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
