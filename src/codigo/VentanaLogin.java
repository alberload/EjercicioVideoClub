package codigo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author XP
 */
public class VentanaLogin extends javax.swing.JFrame {
    
    static Color rojo = new Color(202,0,0);
    static Color gris = new Color(51,51,52);
    static Font fuente1 = new Font("Verdana", Font.BOLD, 25);
    static Font fuente2 = new Font("Verdana", Font.BOLD, 12);

    Connection conexion;    // Almacena la conexion al servidor de BBDD
    Statement estado;       // Almacena el estado de la conexion
    ResultSet resultado;    // Almacena el resultado de la consulta a la BBDD
    
    public VentanaLogin() {
        initComponents();
        editComponents();
        conectarBBDD();
    }
    
    public void editComponents(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        textoEmail.setHorizontalAlignment(SwingConstants.LEFT);
        textoPassword.setHorizontalAlignment(SwingConstants.LEFT);
        this.setTitle("VideoClub Login");
        botonLogin.setBackground(rojo);
        labelLogo.setFont(fuente1);
        labelLogo.setForeground(rojo);
        this.setBackground(Color.DARK_GRAY);
        label1.setFont(fuente2);
        label2.setFont(fuente2);
        botonLogin.setFont(fuente2);
        
        labelFeedback.setFont(new Font("Arial", Font.PLAIN, 10));
        labelFeedback.setForeground(Color.red);
    }
    
    public void conectarBBDD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://172.16.0.140/videoclub", "root", "1234");
            estado = conexion.createStatement();
        }
        catch (ClassNotFoundException ex){
            System.out.println("ERROR 01: No se ha podido acceder al driver");
        }
        catch (SQLException ex){
            System.out.println("ERROR 02: No se ha podido conectar a la BBDD");
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

        textoEmail = new javax.swing.JTextField();
        labelLogo = new javax.swing.JLabel();
        labelFeedback = new javax.swing.JLabel();
        botonLogin = new javax.swing.JButton();
        textoPassword = new javax.swing.JPasswordField();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textoEmail.setText("5036787");
        textoEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoEmailActionPerformed(evt);
            }
        });

        labelLogo.setText("VideoClub");

        botonLogin.setText("Login");
        botonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonLoginMousePressed(evt);
            }
        });

        label1.setText("Email:");

        label2.setText("Contraseña:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1)
                    .addComponent(label2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelFeedback)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonLogin))
                    .addComponent(textoPassword)
                    .addComponent(textoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelLogo)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFeedback)
                    .addComponent(botonLogin))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonLoginMousePressed
        String email = textoEmail.getText().toString();
        String password = textoPassword.getText().toString();
        try {
            resultado = estado.executeQuery("SELECT * "
                                          + "FROM videoclub.usuarios "
                                          + "WHERE usuarios.DNI = '" + email 
                                          + "' && usuarios.DNI = '" + password + "'");
            if (resultado.next()){
                this.setVisible(false);
                resultado.first();
                Usuario usuario;
                usuario = new Usuario(
                        resultado.getInt("DNI"), resultado.getString("nombre"),
                        resultado.getString("apellido"), resultado.getString("email"),
                        resultado.getInt("penalizacion"));
                new VentanaPrincipal(this, usuario);
            } else {
                labelFeedback.setText("Error al logear*");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR 03: No se ha podido ejecutar la query "
                             + "para comparar los datos con los de la BBDD");
        }
    }//GEN-LAST:event_botonLoginMousePressed

    private void textoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoEmailActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonLogin;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel labelFeedback;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JTextField textoEmail;
    private javax.swing.JPasswordField textoPassword;
    // End of variables declaration//GEN-END:variables
}
