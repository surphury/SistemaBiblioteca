/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Dimension;

/**
 *
 * @author LAPTOP-404
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        //agregar iconos al menu principal
        MenuArchivo.setIcon(new javax.swing.ImageIcon("iconos/archivos.png"));
        MenuLibros.setIcon(new javax.swing.ImageIcon("iconos/libros.png"));
        MenuPrestamos.setIcon(new javax.swing.ImageIcon("iconos/prestamo.png"));
        MenuUsuarios.setIcon(new javax.swing.ImageIcon("iconos/usuarios.png"));
        MenuReportes.setIcon(new javax.swing.ImageIcon("iconos/reportes.png"));
        MenuConfiguracion.setIcon(new javax.swing.ImageIcon("iconos/configuracion.png"));
        MenuAyuda.setIcon(new javax.swing.ImageIcon("iconos/ayuda.png"));
        
        //AGREGAR BORDER AL BOTON
        
        javax.swing.border.Border borde=javax.swing.BorderFactory.createRaisedBevelBorder();
        btnNuevo.setBorder(borde);
        btnNuevo.setBackground(new java.awt.Color(200,200,200));
        btnNuevo.setOpaque(true);
        
        btnEditar.setBorder(borde);
        btnEditar.setBackground(new java.awt.Color(200,200,200));
        btnEditar.setOpaque(true);
        
        btnEliminar.setBorder(borde);
        btnEliminar.setBackground(new java.awt.Color(200,200,200));
        btnEliminar.setOpaque(true);
        
        //agregar la configuracion del panel central
         pnlContenido.setLayout(new java.awt.BorderLayout());
          //aca coloque el tamano para evitar problema
         
         
         
        //Mejorar menu principal
        java.awt.Font fuenteMenu = new java.awt.Font("Segoe UI",java.awt.Font.BOLD,14);
        MenuArchivo.setFont(fuenteMenu);
        MenuLibros.setFont(fuenteMenu);
        MenuPrestamos.setFont(fuenteMenu);
        MenuUsuarios.setFont(fuenteMenu);
        MenuReportes.setFont(fuenteMenu);
        MenuConfiguracion.setFont(fuenteMenu);
        MenuAyuda.setFont(fuenteMenu);
        
        //agregar iconos a los botones
        btnNuevo.setIcon(new javax.swing.ImageIcon("iconos/nuevo.png"));
        btnNuevo.setText("Nuevo");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        
        
        btnEditar.setIcon(new javax.swing.ImageIcon("iconos/editarlibros.png"));
        btnEditar.setText("Editar");
        
        btnEliminar.setIcon(new javax.swing.ImageIcon("iconos/eliminar.png"));
        btnEliminar.setText("Eliminar");
        
        btnBuscar.setIcon(new javax.swing.ImageIcon("iconos/buscar.png"));
        btnBuscar.setText("Buscar");
        
        btnImprimir.setIcon(new javax.swing.ImageIcon("iconos/impresora.png"));
        btnImprimir.setText("Imprimir");
        
        btnActualizar.setIcon(new javax.swing.ImageIcon("iconos/actualizar.png"));
        btnActualizar.setText("Actualizar");
        
        btnSalir.setIcon(new javax.swing.ImageIcon("iconos/salir.png"));
        btnSalir.setText("Salir");
        
        //AUMENTAR DE FUENTES EN LOS BOTONES
        
        java.awt.Font fuenteGrande = new java.awt.Font("Segoe UI",java.awt.Font.BOLD,14);
        btnNuevo.setFont(fuenteGrande);
        //HACER MAS GRANDES LOS BOTONES DE TOOL BAR
        java.awt.Dimension tamaño=new java.awt.Dimension (80,350);
        btnNuevo.setPreferredSize(tamaño);
        btnNuevo.setMaximumSize(tamaño);
        
        //botones de panel modulo
        Dimension tamañoBoton = new Dimension(250, 50);
        btnGesLibro.setPreferredSize(tamañoBoton);
        btnGesLibro.setMinimumSize(tamañoBoton);
        btnGesLibro.setMaximumSize(tamañoBoton);    
        btnGesPres.setPreferredSize(tamañoBoton);
        btnGesPres.setMinimumSize(tamañoBoton);
        btnGesPres.setMaximumSize(tamañoBoton);
        btnGesUsu.setPreferredSize(tamañoBoton);
        btnGesUsu.setMinimumSize(tamañoBoton);
        btnGesUsu.setMaximumSize(tamañoBoton);
        btnVer.setPreferredSize(tamañoBoton);
        btnVer.setMinimumSize(tamañoBoton);
        btnVer.setMaximumSize(tamañoBoton);
        btnConfi.setPreferredSize(tamañoBoton);
        btnConfi.setMinimumSize(tamañoBoton);
        btnConfi.setMaximumSize(tamañoBoton);   
        
        
        
        btnGesLibro.setIcon(new javax.swing.ImageIcon("iconos/libros.png"));
        btnGesLibro.setText("Gestionar Libro");
        btnGesLibro.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
            
        btnGesPres.setIcon(new javax.swing.ImageIcon("iconos/prestamo.png"));
        btnGesPres.setText("Gestionar Prestamo");
        btnGesPres.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        
        btnGesUsu.setIcon(new javax.swing.ImageIcon("iconos/usuarios.png"));
        btnGesUsu.setText("Gestionar Usuarios");
        btnGesUsu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        
        btnVer.setIcon(new javax.swing.ImageIcon("iconos/reportes.png"));
        btnVer.setText("Ver Reportes");
        btnVer.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        
        btnConfi.setIcon(new javax.swing.ImageIcon("iconos/configuracion.png"));
        btnConfi.setText("Configuracion");
        btnConfi.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        

        
        
        //Se  configura la ventana principal para permitir navegar con los paneles
        setLocationRelativeTo(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setTitle("Sistema de Gestión de Biblioteca");
         setSize(1000, 700);
        // cargar panel de libros por defecto
        cargarPanel(new VentanaLibros());
    }
    //se creara la funcion cargaPanel
    private void cargarPanel(javax.swing.JPanel panel) {
    try {
        System.out.println("Intentando cargar panel: " + panel.getClass().getName());
        
        pnlContenido.removeAll();
        pnlContenido.add(panel, java.awt.BorderLayout.CENTER);
        pnlContenido.revalidate();
        pnlContenido.repaint();    
        System.out.println("✓ Panel cargado correctamente");
    } catch (Exception e) {
        System.err.println("✗ Error al cargar panel: " + e.getMessage());
        e.printStackTrace();
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

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGesLibro = new javax.swing.JButton();
        btnGesPres = new javax.swing.JButton();
        btnGesUsu = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();
        btnConfi = new javax.swing.JButton();
        pnlContenido = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuArchivo = new javax.swing.JMenu();
        MenuLibros = new javax.swing.JMenu();
        MenuPrestamos = new javax.swing.JMenu();
        MenuUsuarios = new javax.swing.JMenu();
        MenuReportes = new javax.swing.JMenu();
        MenuConfiguracion = new javax.swing.JMenu();
        MenuAyuda = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setRollover(true);

        btnNuevo.setText("jButton1");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnNuevo);

        btnEditar.setText("jButton2");
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnEditar);

        btnEliminar.setText("jButton3");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnEliminar);

        btnBuscar.setText("jButton4");
        btnBuscar.setFocusable(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnBuscar);

        btnImprimir.setText("jButton5");
        btnImprimir.setFocusable(false);
        btnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnImprimir);

        btnActualizar.setText("jButton6");
        btnActualizar.setFocusable(false);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnActualizar);

        btnSalir.setText("jButton7");
        btnSalir.setFocusable(false);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnSalir);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 848, 90));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jPanel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("MODULOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 7, 69, -1));

        btnGesLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGesLibroActionPerformed(evt);
            }
        });
        jPanel1.add(btnGesLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        btnGesPres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGesPresActionPerformed(evt);
            }
        });
        jPanel1.add(btnGesPres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        btnGesUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGesUsuActionPerformed(evt);
            }
        });
        jPanel1.add(btnGesUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        jPanel1.add(btnVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));
        jPanel1.add(btnConfi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 290, 360));

        pnlContenido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0)));

        javax.swing.GroupLayout pnlContenidoLayout = new javax.swing.GroupLayout(pnlContenido);
        pnlContenido.setLayout(pnlContenidoLayout);
        pnlContenidoLayout.setHorizontalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        pnlContenidoLayout.setVerticalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(pnlContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 510, 360));

        MenuArchivo.setText("Archivo");
        jMenuBar1.add(MenuArchivo);

        MenuLibros.setText("Libros");
        jMenuBar1.add(MenuLibros);

        MenuPrestamos.setText("Prestamos");
        jMenuBar1.add(MenuPrestamos);

        MenuUsuarios.setText("Usuarios");
        jMenuBar1.add(MenuUsuarios);

        MenuReportes.setText("Reportes");
        jMenuBar1.add(MenuReportes);

        MenuConfiguracion.setText("Configuracion");
        jMenuBar1.add(MenuConfiguracion);

        MenuAyuda.setText("Ayuda");
        jMenuBar1.add(MenuAyuda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGesLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGesLibroActionPerformed
        // TODO add your handling code here:
        cargarPanel(new VentanaLibros());
    }//GEN-LAST:event_btnGesLibroActionPerformed

    private void btnGesPresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGesPresActionPerformed
        // TODO add your handling code here:
        //
        cargarPanel(new VentanaPrestamos());
    }//GEN-LAST:event_btnGesPresActionPerformed

    private void btnGesUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGesUsuActionPerformed
        // TODO add your handling code here:
        
        cargarPanel(new VentanaUsuarios());
    }//GEN-LAST:event_btnGesUsuActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuArchivo;
    private javax.swing.JMenu MenuAyuda;
    private javax.swing.JMenu MenuConfiguracion;
    private javax.swing.JMenu MenuLibros;
    private javax.swing.JMenu MenuPrestamos;
    private javax.swing.JMenu MenuReportes;
    private javax.swing.JMenu MenuUsuarios;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConfi;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGesLibro;
    private javax.swing.JButton btnGesPres;
    private javax.swing.JButton btnGesUsu;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel pnlContenido;
    // End of variables declaration//GEN-END:variables
}
