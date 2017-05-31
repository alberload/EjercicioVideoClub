package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaPrincipal extends javax.swing.JFrame {

    static int TAMANO_BARRA = 200;
    static int NUM_PELICULAS_PANTALLA = 30;
    static int CARATULA_X = 120;
    static int CARATULA_Y = 180;
    static int MARGEN_X = 215;
    static int MARGEN_Y = 80;
    static int TAM_BOTON = 50;
    static Color rojo = new Color(202, 0, 0);
    static Color gris = new Color(51, 51, 52);
    static Font fuente1 = new Font("Verdana", Font.BOLD, 17);
    static Font fuente2 = new Font("Verdana", Font.BOLD, 10);
    static Font fuente3 = new Font("Verdana", Font.PLAIN, 10);
    static Font fuente4 = new Font("Verdana", Font.BOLD, 14);

    JLabel select1 = new JLabel();
    JLabel select2 = new JLabel();
    JLabel select3 = new JLabel();
    JLabel select4 = new JLabel();
    JLabel select5 = new JLabel();

    VentanaLogin login;
    Usuario usuario;
    ResultSet resultado;
    int panel = 0;

    JButton botonNext;
    JButton botonBack;
    JPanel menu;

    ArrayList<Pelicula> peliculas = new ArrayList();
    ArrayList<JPanel> panelesPelis;

    public VentanaPrincipal(VentanaLogin login, Usuario usuario) {
        this.login = login;
        this.usuario = usuario;
        initComponents();
        editComponents();
        initPerfil();
        cargarPeliculas("SELECT * FROM videoclub.peliculas");
        panelesPelis = initPanelPelis();
        panelesPelis.get(0).setVisible(true);
        actualizarBotones();
    }

    public void editBotonesMenu() {
        select1.setFont(fuente4);
        select2.setFont(fuente4);
        select3.setFont(fuente4);
        select4.setFont(fuente4);
        select5.setFont(fuente4);
        select1.setForeground(Color.WHITE);
        select2.setForeground(Color.WHITE);
        select3.setForeground(Color.WHITE);
        select4.setForeground(Color.WHITE);
        select5.setForeground(Color.WHITE);
        select1.setBounds(30, 350, 150, 20);
        select2.setBounds(30, 380, 150, 20);
        select3.setBounds(30, 410, 150, 20);
        select4.setBounds(30, 440, 150, 20);
        select5.setBounds(30, 470, 150, 20);
        select1.setText("TODAS");
        select2.setText("CIENCIA FICCION");
        select3.setText("DRAMA");
        select4.setText("ACCION");
        select5.setText("COMEDIA");

        select1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cargarPeliculas("SELECT * FROM videoclub.peliculas");
            for (int i = 0; i < panelesPelis.size(); i++){
                panelesPelis.get(i).setVisible(false);
            }
            panelesPelis.clear();
            panelesPelis = initPanelPelis();
            panelesPelis.get(0).setVisible(true);
            panel = 0;
            actualizarBotones();
            }
        });
        select2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cargarPeliculas("SELECT * FROM videoclub.peliculas "
                          + "WHERE videoclub.peliculas.genero "
                          + "LIKE '%" + "Ciencia Ficción" + "%'");
            for (int i = 0; i < panelesPelis.size(); i++){
                panelesPelis.get(i).setVisible(false);
            }
            panelesPelis.clear();
            panelesPelis = initPanelPelis();
            panelesPelis.get(0).setVisible(true);
            panel = 0;
            actualizarBotones();
            }
        });
        select3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cargarPeliculas("SELECT * FROM videoclub.peliculas "
                          + "WHERE videoclub.peliculas.genero "
                          + "LIKE '%" + "Drama" + "%'");
            for (int i = 0; i < panelesPelis.size(); i++){
                panelesPelis.get(i).setVisible(false);
            }
            panelesPelis.clear();
            panelesPelis = initPanelPelis();
            panelesPelis.get(0).setVisible(true);
            panel = 0;
            actualizarBotones();
            }
        });
        select4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cargarPeliculas("SELECT * FROM videoclub.peliculas "
                          + "WHERE videoclub.peliculas.genero "
                          + "LIKE '%" + "Acción" + "%'");
            for (int i = 0; i < panelesPelis.size(); i++){
                panelesPelis.get(i).setVisible(false);
            }
            panelesPelis.clear();
            panelesPelis = initPanelPelis();
            panelesPelis.get(0).setVisible(true);
            panel = 0;
            actualizarBotones();
            }
        });
        select5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cargarPeliculas("SELECT * FROM videoclub.peliculas "
                          + "WHERE videoclub.peliculas.genero "
                          + "LIKE '%" + "Comedia" + "%'");
            for (int i = 0; i < panelesPelis.size(); i++){
                panelesPelis.get(i).setVisible(false);
            }
            panelesPelis.clear();
            panelesPelis = initPanelPelis();
            panelesPelis.get(0).setVisible(true);
            panel = 0;
            actualizarBotones();
            }
        });
    }

    public void initPerfil() {
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBounds(0, 0, MARGEN_X, this.getHeight());
        menu.setBackground(rojo);
        this.add(menu);
        JLabel nombre = new JLabel(usuario.nombre + " " + usuario.apellido);
        JLabel email = new JLabel(usuario.email);
        JLabel avatar = new JLabel();
        //------
        editBotonesMenu();
        //----
        nombre.setFont(fuente1);
        nombre.setForeground(Color.WHITE);
        email.setFont(fuente2);
        email.setForeground(Color.WHITE);
        avatar.setBounds(30, 40, 150, 150);
        nombre.setBounds(30, 200, 150, 20);
        email.setBounds(30, 220, 150, 20);
        menu.add(email);
        menu.add(nombre);
        menu.add(select1);
        menu.add(select2);
        menu.add(select3);
        menu.add(select4);
        menu.add(select5);
        try {
            Image image = ImageIO.read(
                    new File("C:\\Users\\alber\\Documents\\NetBeansProjects"
                            + "\\JavaVideoclub\\src\\fotosUsuarios\\"
                            + usuario.DNI + ".jpg"));
            Image aux = image.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(aux);
            avatar.setIcon(icon);
            menu.add(avatar);
        } catch (IOException ex) {
            System.out.println("ERROR 06: No se ha podido cargar el avatar");
        }
    }

    public void actualizarBotones() {
        if (panel == 0) {
            botonBack.setEnabled(false);
        } else {
            botonBack.setEnabled(true);
        }
        if (panel == panelesPelis.size() - 1) {
            botonNext.setEnabled(false);
        } else {
            botonNext.setEnabled(true);
        }
    }

    public ArrayList<JPanel> initPanelPelis() {
        int peli = 0;
        ArrayList<JPanel> lista = new ArrayList();

        while (peli < peliculas.size()) {
            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(gris);
            panel.setBounds(MARGEN_X, MARGEN_Y, this.getWidth() - MARGEN_X, this.getHeight() - MARGEN_Y);
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 8; col++) {
                    if (peli < peliculas.size()) {
                        JLabel label = new JLabel();
                        label.setBounds(20 + col * (CARATULA_X + 20), 20 + row * (CARATULA_Y + 20), CARATULA_X, CARATULA_Y);
                        try {
                            Image image = ImageIO.read(
                                    new File("C:\\Users\\alber\\Documents\\NetBeansProjects"
                                            + "\\JavaVideoclub\\src\\caratulas\\"
                                            + String.format("%06d", peliculas.get(peli).id) + ".jpg"));
                            Image aux = image.getScaledInstance(CARATULA_X, CARATULA_Y, java.awt.Image.SCALE_SMOOTH);
                            ImageIcon icon = new ImageIcon(aux);
                            label.setIcon(icon);
                            label.setText(String.valueOf(peliculas.get(peli).id));
                            label.addMouseListener(new MouseAdapter() {
                                public void mouseClicked(MouseEvent e) {
                                    initFichaPeli(label.getText());
                                }
                            });
                            //border
                            panel.add(label);
                        } catch (IOException ex) {
                            System.out.println("ERROR 05: No se ha podido cargar las caratulas");
                        }
                        peli++;
                    }
                }
            }
            lista.add(panel);
        }
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).setVisible(false);
            this.add(lista.get(i));
        }
        return lista;
    }

    public void initFichaPeli(String id) {
        Pelicula select = null;
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).id == Integer.parseInt(id)) {
                select = peliculas.get(i);
            }
        }
        try {
            Image image = ImageIO.read(
                    new File("C:\\Users\\alber\\Documents\\NetBeansProjects"
                            + "\\JavaVideoclub\\src\\caratulas\\"
                            + String.format("%06d", select.id) + ".jpg"));
            Image aux = image.getScaledInstance(CARATULA_X + 80, CARATULA_Y + 100, java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(aux);
            fotoPeli.setIcon(icon);
        } catch (IOException ex) {
            System.out.println("ERROR 05: No se ha podido cargar las caratulas");
        }
        titulo.setText(select.titulo);
        pais.setText(select.pais);
        imdb.setText(select.imdb + " | " + select.clasificacion_imdb);
        ano.setText(String.valueOf(select.ano));
        genero.setText("");
        for (int i = 0; i < select.genero.length; i++) {
            genero.setText(genero.getText() + " " + select.genero[i]);
        }
        resumen.setText("<html>");
        for (int i = 0; i < select.resumen.length(); i++) {
            resumen.setText(resumen.getText() + select.resumen.charAt(i));
            if (i % 50 == 0 && i > 5) {
                resumen.setText(resumen.getText() + "<br>");
            }
        }
        resumen.setText(resumen.getText() + "</html>");
        ventanaPeli.setVisible(true);
    }

    public void cargarPeliculas(String query) {
        peliculas.clear();
        try {

            resultado = login.estado.executeQuery(query);
            resultado.first();

            do {
                // Separo el campo genero por cada genero uno a uno
                String aux = resultado.getString("genero");
                String[] generos = aux.split(", ");
                // Creo la pelicula
                peliculas.add(new Pelicula(
                        resultado.getInt("id_pelicula"),
                        resultado.getString("titulo"),
                        resultado.getInt("año"),
                        resultado.getString("pais"),
                        generos,
                        resultado.getString("imdb"),
                        resultado.getString("clasificacion_imdb"),
                        resultado.getString("resumen")));
            } while (resultado.next());
        } catch (SQLException ex) {
            System.out.println("ERROR 04: No se ha podido cargar las peliculas");
        }
        System.out.print("prueba");
    }

    public void editComponents() {
        this.setLayout(null);
        this.setSize(1366, 740);
        this.setVisible(true);
        this.setTitle("VideoClub");
        editDialog();

        botonBack = new JButton("<");
        botonBack.setBounds(this.getWidth() - TAM_BOTON * 3, MARGEN_Y - TAM_BOTON - 22, TAM_BOTON, TAM_BOTON);
        botonNext = new JButton(">");
        botonNext.setBounds(this.getWidth() - TAM_BOTON * 2, MARGEN_Y - TAM_BOTON - 22, TAM_BOTON, TAM_BOTON);
        botonBack.addActionListener((e) -> {
            panelesPelis.get(panel).setVisible(false);
            panelesPelis.get(panel - 1).setVisible(true);
            panel--;
            actualizarBotones();
        });
        botonNext.addActionListener((e) -> {
            panelesPelis.get(panel).setVisible(false);
            panelesPelis.get(panel + 1).setVisible(true);
            panel++;
            actualizarBotones();
        });
        botonBack.setBackground(rojo);
        botonNext.setBackground(rojo);
        this.add(botonBack);
        this.add(botonNext);

        JTextField buscador = new JTextField();
        buscador.setBounds(MARGEN_X + 20, 20, 200, 40);
        buscador.setVisible(true);
        buscador.addActionListener((ActionListener) -> {
            cargarPeliculas("SELECT * FROM videoclub.peliculas "
                    + "WHERE videoclub.peliculas.titulo "
                    + "LIKE '%" + buscador.getText().toString() + "%'");
            for (int i = 0; i < panelesPelis.size(); i++) {
                panelesPelis.get(i).setVisible(false);
            }
            panelesPelis.clear();
            panelesPelis = initPanelPelis();
            panelesPelis.get(0).setVisible(true);
            panel = 0;
            actualizarBotones();
        });
        this.add(buscador);
    }

    public void editDialog() {
        ventanaPeli.setTitle("Pelicula");
        ventanaPeli.setSize(600, 400);
        ventanaPeli.setLocationRelativeTo(null);
        titulo.setFont(fuente1);
        ano.setFont(fuente2);
        pais.setFont(fuente2);
        genero.setFont(fuente2);
        imdb.setFont(fuente2);
        resumen.setFont(fuente3);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventanaPeli = new javax.swing.JDialog();
        fotoPeli = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        ano = new javax.swing.JLabel();
        pais = new javax.swing.JLabel();
        genero = new javax.swing.JLabel();
        imdb = new javax.swing.JLabel();
        resumen = new javax.swing.JLabel();

        ventanaPeli.setBackground(new java.awt.Color(0, 0, 0));

        titulo.setText("jLabel1");

        ano.setText("jLabel1");

        pais.setText("jLabel1");

        genero.setText("jLabel1");

        imdb.setText("imdb");

        resumen.setText("ddddddddddddddddddddddddddddddddddddddd");

        javax.swing.GroupLayout ventanaPeliLayout = new javax.swing.GroupLayout(ventanaPeli.getContentPane());
        ventanaPeli.getContentPane().setLayout(ventanaPeliLayout);
        ventanaPeliLayout.setHorizontalGroup(
            ventanaPeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaPeliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fotoPeli, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ventanaPeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ventanaPeliLayout.createSequentialGroup()
                        .addGroup(ventanaPeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventanaPeliLayout.createSequentialGroup()
                                .addComponent(ano)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pais))
                            .addComponent(genero)
                            .addComponent(imdb))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(resumen, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                .addContainerGap())
        );
        ventanaPeliLayout.setVerticalGroup(
            ventanaPeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaPeliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ventanaPeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaPeliLayout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ventanaPeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ano)
                            .addComponent(pais))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genero)
                        .addGap(18, 18, 18)
                        .addComponent(imdb)
                        .addGap(18, 18, 18)
                        .addComponent(resumen, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                    .addComponent(fotoPeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 901, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ano;
    private javax.swing.JLabel fotoPeli;
    private javax.swing.JLabel genero;
    private javax.swing.JLabel imdb;
    private javax.swing.JLabel pais;
    private javax.swing.JLabel resumen;
    private javax.swing.JLabel titulo;
    private javax.swing.JDialog ventanaPeli;
    // End of variables declaration//GEN-END:variables
}
