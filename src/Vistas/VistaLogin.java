/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author RYZEN
 */
public class VistaLogin extends javax.swing.JFrame {

    /**
     * Creates new form VistaLogin
     */
    public VistaLogin() {
        initComponents();
        setVisible(true);
        setSize(1363, 765);
        setLocationRelativeTo(null);
    }
    
    public void addBtnEntrarMouseEvent(MouseListener mouseListenControles){
        btnEntrar.addMouseListener(mouseListenControles);
    }
    
    public void addBtnRegistrarseMouseEvent(MouseListener mouseListenControles){
        btnRegistrarse.addMouseListener(mouseListenControles);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtPassword = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        btnRegistrarse = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JLabel();
        fondoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setSize(new java.awt.Dimension(1366, 768));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPassword.setFont(new java.awt.Font("Josefin Sans Medium", 0, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(204, 204, 204));
        txtPassword.setText("Ingrese su Contraseña...");
        txtPassword.setBorder(null);
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 573, 350, 30));

        txtUsuario.setFont(new java.awt.Font("Josefin Sans Medium", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setToolTipText("");
        txtUsuario.setBorder(null);
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseClicked(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 350, 30));

        btnRegistrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesLogin/00-RegistrarseGris-img.png"))); // NOI18N
        btnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarseMouseExited(evt);
            }
        });
        jPanel2.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 660, -1, -1));

        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesLogin/00-EntrarGris-img.png"))); // NOI18N
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarMouseExited(evt);
            }
        });
        jPanel2.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, -1, -1));

        fondoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/00-LoginPrincipal-img.png"))); // NOI18N
        jPanel2.add(fondoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 1370, 770));

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

    private void btnEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseEntered
        Icon btnEntrarAzul = new ImageIcon("src//Imagenes//BotonesLogin//00-EntrarAzul-img.png");
        btnEntrar.setIcon(btnEntrarAzul);
    }//GEN-LAST:event_btnEntrarMouseEntered

    private void btnEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseExited
        Icon btnEntrarGris = new ImageIcon("src//Imagenes//BotonesLogin//00-EntrarGris-img.png");
        btnEntrar.setIcon(btnEntrarGris);
    }//GEN-LAST:event_btnEntrarMouseExited

    private void btnRegistrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarseMouseEntered
        Icon btnRegistrarseAzul = new ImageIcon("src//Imagenes//BotonesLogin//00-RegistrarseAzul-img.png");
        btnRegistrarse.setIcon(btnRegistrarseAzul);
    }//GEN-LAST:event_btnRegistrarseMouseEntered

    private void btnRegistrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarseMouseExited
        Icon btnRegistrarseGris = new ImageIcon("src//Imagenes//BotonesLogin//00-RegistrarseGris-img.png");
        btnRegistrarse.setIcon(btnRegistrarseGris);
    }//GEN-LAST:event_btnRegistrarseMouseExited

    private void txtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseClicked

    }//GEN-LAST:event_txtUsuarioMouseClicked

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        
    }//GEN-LAST:event_txtPasswordMouseClicked

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        txtPassword.setText("");
        txtPassword.setForeground(Color.black);
    }//GEN-LAST:event_txtPasswordFocusGained

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
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaLogin().setVisible(true);
            }
        });
    }

    public JLabel getBtnEntrar() {
        return btnEntrar;
    }

    public JLabel getBtnRegistrarse() {
        return btnRegistrarse;
    }
    
    public JTextField getTxtUsuario() {
    return txtUsuario;
    }
    
    public JTextField getTxtPassword() {
    return txtPassword;
    }   



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnEntrar;
    private javax.swing.JLabel btnRegistrarse;
    private javax.swing.JLabel fondoLogin;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
