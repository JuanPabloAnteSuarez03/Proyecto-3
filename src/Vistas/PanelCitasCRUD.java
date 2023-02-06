/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RYZEN
 */
public class PanelCitasCRUD extends javax.swing.JPanel {
    
    DefaultTableModel modelo;
    private boolean btnAceptarActivo = false;
    private boolean btnCancelarActivo = false;
    private boolean btnEditarActivo = false;
    private boolean textoEditables;
    private String[] datosActuales;
    private String accionActual;

    /**
     * Creates new form PanelDashboard
     */
    public PanelCitasCRUD() {
        initComponents();
        setSize(1086, 503);

    }
    
    public void ponerFondoCRUD(String accion){
        Icon fondoCRUD = new ImageIcon("src//Imagenes//CitasCRUD//00-"+accion+"Cita-img.png"); 
        fondoAfiliados.setIcon(fondoCRUD);     
        accionActual = accion;
    }
    
    public void addBtnEditarListener(MouseListener listener){
        btnEditar.addMouseListener(listener);
    }
    
    public void addBtnVolverListener(MouseListener listener){
        btnVolver.addMouseListener(listener);
    }
    
    public void addBtnAceptarListener(MouseListener listener){
        btnAceptar.addMouseListener(listener);
    }
    
    public void addBtnCancelarListener(MouseListener listener){
        btnCancelar.addMouseListener(listener);
    }
    
    public void activarBotones(){
        btnAceptarActivo = true;
        btnCancelarActivo = true;
        setBotonInactivo("Cancelar", btnCancelar);
        setBotonInactivo("Aceptar", btnAceptar);
    }
    
    public void ocultarComboBox(){
        cbxAfiliado.setVisible(false);
        cbxHora.setVisible(false);
        cbxHorario.setVisible(false);
        cbxMinutos.setVisible(false);
        cbxPiso.setVisible(false);
        cbxTrabajador.setVisible(false);
    }
    
    public void activarComboBox(){
        cbxAfiliado.setVisible(true);
        txtAfiliado.setVisible(false);
        cbxHora.setVisible(true);
        txtHora.setVisible(false);
        cbxHorario.setVisible(true);
        cbxMinutos.setVisible(true);
        cbxPiso.setVisible(true);
        txtPiso.setVisible(false);
        cbxTrabajador.setVisible(true);
        txtTrabajador.setVisible(false);
    }
    
    public void activarBtnEditar(){
        btnEditarActivo = true;
        setBotonInactivo("Editar", btnEditar);
    }
    
    public void limpiarCampos(){
        limpiarComponenteTexto(txtFecha);
        limpiarComponenteTexto(txtAfiliado);
        limpiarComponenteTexto(txtServicio);
        limpiarComponenteTexto(txtSala);
        limpiarComponenteTexto(txtHora);
        limpiarComponenteTexto(txtTrabajador);
        limpiarComponenteTexto(txtPiso);
    }
    
    public boolean validarCampos(){
        boolean camposValidos = false;
        if(!"".equals(txtFecha.getText()) && !"".equals(txtAfiliado.getText()) && !"".equals(txtServicio.getText()) && !"".equals(txtSala.getText()) && !"".equals(txtHora.getText()) && !"".equals(txtTrabajador.getText()) && !"".equals(txtPiso.getText()) ){
            camposValidos = true;
        }
        return camposValidos;
    }
     
    public void activarComponentes(){
        textoEditables = true;
        txtFecha.setEnabled(true);
        txtFecha.setForeground(Color.BLACK);
        txtAfiliado.setVisible(false);
        
        txtSala.setEnabled(true);
        txtSala.setForeground(Color.BLACK);
        txtHora.setVisible(false);
        txtPiso.setVisible(false);
        
        txtTrabajador.setVisible(false);
    }
    
    public void ingresarInformacion(String[] datos){
        txtFecha.setText(datos[0]);
        txtAfiliado.setText(datos[1]);
        txtServicio.setText(datos[2]);
        txtSala.setText(datos[3]);
        txtHora.setText(datos[4]);
        txtTrabajador.setText(datos[5]);
        txtPiso.setText(datos[6]);
        /*
        if("Male".equals(datos[5])){
            cbxSexo.setSelectedIndex(1);
        }else if ("Female".equals(datos[5])){
            cbxSexo.setSelectedIndex(2);
        }
        */
    }
    
    public String[] obtenerInformacion(){
        String[] datos = new String[6];
        
        datos[0] = txtFecha.getText();
        datos[1] = txtAfiliado.getText();
        datos[2] = txtServicio.getText();
        datos[3] = txtSala.getText();
        datos[4] = txtHora.getText();
        datos[5] = txtTrabajador.getText();
        datos[6] = txtPiso.getText();

        /*
        if(cbxSexo.getSelectedIndex() == 1){
            datos[5] = "Male";
        }else if(cbxSexo.getSelectedIndex() == 2){
            datos[5] = "Female";
        }
        */
        return datos;
    }
    
    public String[] obtenerInformacionTrabajador(){
        String[] datos = new String[7];
        
        datos[0] = txtFecha.getText();
        datos[1] = txtAfiliado.getText();
        datos[2] = txtServicio.getText();
        datos[3] = txtSala.getText();
        datos[4] = txtHora.getText();
        /*
        if(cbxSexo.getSelectedIndex() == 1){
            datos[5] = "Male";
        }else if(cbxSexo.getSelectedIndex() == 2){
            datos[5] = "Female";
        }
        datos[6] = txtTrabajador.getText();
        */
        return datos;
    }
    
    private void setBotonActivo(String boton, JLabel imagenBoton){
        if(imagenBoton == btnEditar && btnEditarActivo){
            Icon btnActivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Activo.png"); 
            imagenBoton.setIcon(btnActivo);
        }else if(imagenBoton != btnEditar && (btnAceptarActivo || btnCancelarActivo)){
            Icon btnActivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Activo.png"); 
            imagenBoton.setIcon(btnActivo);
        }else if(imagenBoton != btnEditar && ("Volver".equals(boton) || "Editar".equals(boton))){
            Icon btnActivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Activo.png"); 
            imagenBoton.setIcon(btnActivo);
        }
        
        
    }
    
    private void setBotonInactivo(String boton, JLabel imagenBoton){
        
        if(imagenBoton == btnEditar && btnEditarActivo){
            Icon btnInactivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Inactivo.png"); 
            imagenBoton.setIcon(btnInactivo);
        }else if(imagenBoton != btnEditar && (btnAceptarActivo || btnCancelarActivo)){
            Icon btnInactivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Inactivo.png"); 
            imagenBoton.setIcon(btnInactivo);
        }else if(imagenBoton != btnEditar && ("Volver".equals(boton) || "Editar".equals(boton))){
            Icon btnInactivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Inactivo.png"); 
            imagenBoton.setIcon(btnInactivo);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxHorario = new javax.swing.JComboBox<>();
        cbxMinutos = new javax.swing.JComboBox<>();
        cbxHora = new javax.swing.JComboBox<>();
        cbxTrabajador = new javax.swing.JComboBox<>();
        txtTrabajador = new javax.swing.JTextField();
        txtSala = new javax.swing.JTextField();
        txtServicio = new javax.swing.JTextField();
        cbxAfiliado = new javax.swing.JComboBox<>();
        txtAfiliado = new javax.swing.JTextField();
        cbxPiso = new javax.swing.JComboBox<>();
        txtFecha = new javax.swing.JTextField();
        btnEditar = new javax.swing.JLabel();
        btnVolver = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JLabel();
        fondoAfiliados = new javax.swing.JLabel();
        txtPiso = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1086, 503));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        cbxHorario.setBorder(null);
        add(cbxHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 175, 110, 26));

        cbxMinutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "10", "20", "30", "40", "50" }));
        cbxMinutos.setBorder(null);
        add(cbxMinutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 175, 60, 26));

        cbxHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbxHora.setBorder(null);
        add(cbxHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 175, 40, 26));

        cbxTrabajador.setBorder(null);
        add(cbxTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 238, 210, 26));

        txtTrabajador.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txtTrabajador.setForeground(new java.awt.Color(255, 0, 0));
        txtTrabajador.setBorder(null);
        txtTrabajador.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtTrabajador.setEnabled(false);
        txtTrabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTrabajadorMouseClicked(evt);
            }
        });
        txtTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrabajadorActionPerformed(evt);
            }
        });
        add(txtTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 238, 210, 26));

        txtSala.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txtSala.setForeground(new java.awt.Color(255, 0, 0));
        txtSala.setBorder(null);
        txtSala.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtSala.setEnabled(false);
        txtSala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSalaMouseClicked(evt);
            }
        });
        txtSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaActionPerformed(evt);
            }
        });
        add(txtSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 372, 210, 26));

        txtServicio.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txtServicio.setForeground(new java.awt.Color(255, 0, 0));
        txtServicio.setBorder(null);
        txtServicio.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtServicio.setEnabled(false);
        txtServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtServicioMouseClicked(evt);
            }
        });
        txtServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServicioActionPerformed(evt);
            }
        });
        add(txtServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 307, 210, 26));

        cbxAfiliado.setBorder(null);
        add(cbxAfiliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 241, 210, 26));

        txtAfiliado.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txtAfiliado.setForeground(new java.awt.Color(255, 0, 0));
        txtAfiliado.setBorder(null);
        txtAfiliado.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtAfiliado.setEnabled(false);
        txtAfiliado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAfiliadoMouseClicked(evt);
            }
        });
        txtAfiliado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAfiliadoActionPerformed(evt);
            }
        });
        add(txtAfiliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 241, 210, 26));

        cbxPiso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", " " }));
        cbxPiso.setBorder(null);
        add(cbxPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 308, 210, 26));

        txtFecha.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(255, 0, 0));
        txtFecha.setBorder(null);
        txtFecha.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtFecha.setEnabled(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 175, 210, 26));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesCRUD/00-EditarDesactivado.png"))); // NOI18N
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarMouseExited(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 140, 144, 55));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesCRUD/00-VolverInactivo.png"))); // NOI18N
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVolverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVolverMouseExited(evt);
            }
        });
        add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 350, 144, 55));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesCRUD/00-CancelarDesactivado.png"))); // NOI18N
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 280, 144, 55));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesCRUD/00-AceptarDesactivado.png"))); // NOI18N
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 144, 55));

        fondoAfiliados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CitasCRUD/00-VerCita-img.png"))); // NOI18N
        add(fondoAfiliados, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 1090, 510));

        txtPiso.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txtPiso.setForeground(new java.awt.Color(255, 0, 0));
        txtPiso.setBorder(null);
        txtPiso.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtPiso.setEnabled(false);
        txtPiso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPisoMouseClicked(evt);
            }
        });
        txtPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPisoActionPerformed(evt);
            }
        });
        add(txtPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 308, 210, 26));

        txtHora.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txtHora.setForeground(new java.awt.Color(255, 0, 0));
        txtHora.setBorder(null);
        txtHora.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtHora.setEnabled(false);
        txtHora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHoraMouseClicked(evt);
            }
        });
        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });
        add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 175, 210, 26));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        setBotonActivo("Aceptar", btnAceptar);
    }//GEN-LAST:event_btnAceptarMouseEntered

    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        setBotonInactivo("Aceptar", btnAceptar);
    }//GEN-LAST:event_btnAceptarMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        setBotonActivo("Cancelar", btnCancelar);
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        setBotonInactivo("Cancelar", btnCancelar);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void txtAfiliadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAfiliadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAfiliadoActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServicioActionPerformed

    private void txtSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaActionPerformed

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

    private void txtAfiliadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAfiliadoMouseClicked
        
    }//GEN-LAST:event_txtAfiliadoMouseClicked

    private void txtServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtServicioMouseClicked
        
    }//GEN-LAST:event_txtServicioMouseClicked

    private void txtSalaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalaMouseClicked
        
    }//GEN-LAST:event_txtSalaMouseClicked

    private void txtHoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHoraMouseClicked
        
    }//GEN-LAST:event_txtHoraMouseClicked

    private void btnVolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseEntered
        setBotonActivo("Volver", btnVolver);
    }//GEN-LAST:event_btnVolverMouseEntered

    private void btnVolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseExited
        setBotonInactivo("Volver", btnVolver);
    }//GEN-LAST:event_btnVolverMouseExited

    private void btnEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseEntered
        setBotonActivo("Editar", btnEditar);
    }//GEN-LAST:event_btnEditarMouseEntered

    private void btnEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseExited
        setBotonInactivo("Editar", btnEditar);
    }//GEN-LAST:event_btnEditarMouseExited

    private void txtTrabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTrabajadorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrabajadorMouseClicked

    private void txtTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrabajadorActionPerformed

    private void txtPisoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPisoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPisoMouseClicked

    private void txtPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPisoActionPerformed

    private void limpiarComponenteTexto(JTextField texto){
        if(textoEditables){
            texto.setText("");
            texto.setForeground(Color.black);
        }
    }

    public String[] getDatosActuales() {
        return datosActuales;
    }

    public void setDatosActuales(String[] datosActuales) {
        this.datosActuales = datosActuales;
    }

    public JLabel getBtnAceptar() {
        return btnAceptar;
    }

    public JLabel getBtnCancelar() {
        return btnCancelar;
    }

    public JLabel getBtnEditar() {
        return btnEditar;
    }

    public JLabel getBtnVolver() {
        return btnVolver;
    }

    public String getAccionActual() {
        return accionActual;
    }

    public boolean isBtnEditarActivo() {
        return btnEditarActivo;
    }

    public boolean isBtnAceptarActivo() {
        return btnAceptarActivo;
    }

    public boolean isBtnCancelarActivo() {
        return btnCancelarActivo;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAceptar;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnEditar;
    private javax.swing.JLabel btnVolver;
    private javax.swing.JComboBox<String> cbxAfiliado;
    private javax.swing.JComboBox<String> cbxHora;
    private javax.swing.JComboBox<String> cbxHorario;
    private javax.swing.JComboBox<String> cbxMinutos;
    private javax.swing.JComboBox<String> cbxPiso;
    private javax.swing.JComboBox<String> cbxTrabajador;
    private javax.swing.JLabel fondoAfiliados;
    private javax.swing.JTextField txtAfiliado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtPiso;
    private javax.swing.JTextField txtSala;
    private javax.swing.JTextField txtServicio;
    private javax.swing.JTextField txtTrabajador;
    // End of variables declaration//GEN-END:variables
}
