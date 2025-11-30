/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import dao.LibroDAO;
import model.Libro;
import java.util.List;


/**
 *
 * @author surphury
 */
public class VentanaLibros extends javax.swing.JPanel {

    private LibroDAO libroDAO;
    
     // Instancia del DAO

    public VentanaLibros() {
        initComponents();

        // Inicializar el DAO
        libroDAO = new LibroDAO();

        // Configurar la tabla
        configurarTabla();

        // Cargar datos en la tabla
        cargarDatosTabla();

        // Conectar eventos de los botones
        btnGuardar.addActionListener(e -> guardarLibro());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnCancelar.addActionListener(e -> limpiarCampos());
    }

    // MÉTODOS PARA CONECTAR CON LA BD
    private void configurarTabla() {
        tblRegistrarLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Título", "Autor", "ISBN", "Editorial", "Año", "Cantidad", "Acciones"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7;
            }
        });

        // Ajustar ancho de columnas
        tblRegistrarLibros.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblRegistrarLibros.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblRegistrarLibros.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblRegistrarLibros.getColumnModel().getColumn(3).setPreferredWidth(120);
        tblRegistrarLibros.getColumnModel().getColumn(4).setPreferredWidth(120);
        tblRegistrarLibros.getColumnModel().getColumn(5).setPreferredWidth(60);
        tblRegistrarLibros.getColumnModel().getColumn(6).setPreferredWidth(60);
        tblRegistrarLibros.getColumnModel().getColumn(7).setPreferredWidth(220);
        tblRegistrarLibros.getColumnModel().getColumn(7).setMinWidth(220);

        // Renderizador y editor de botones
        //tblRegistrarLibros.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        //tblRegistrarLibros.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new javax.swing.JCheckBox()));

        // Apariencia
        tblRegistrarLibros.setRowHeight(50);
        tblRegistrarLibros.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
        tblRegistrarLibros.setShowGrid(true);
        tblRegistrarLibros.setGridColor(new java.awt.Color(230, 230, 230));
        tblRegistrarLibros.getTableHeader().setReorderingAllowed(false);
        tblRegistrarLibros.setSelectionBackground(new java.awt.Color(173, 216, 230));
        tblRegistrarLibros.setSelectionForeground(java.awt.Color.BLACK);

        // Encabezado forzado
        javax.swing.table.JTableHeader header = tblRegistrarLibros.getTableHeader();
        header.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));
        header.setBackground(new java.awt.Color(52, 73, 94));
        header.setForeground(java.awt.Color.WHITE);
        header.setOpaque(true);
        header.setPreferredSize(new java.awt.Dimension(header.getWidth(), 35));
    }

    private void cargarDatosTabla() {
        try {
            List<Libro> libros = libroDAO.obtenerTodos();
            javax.swing.table.DefaultTableModel modelo =
                (javax.swing.table.DefaultTableModel) tblRegistrarLibros.getModel();
            modelo.setRowCount(0);

            for (Libro libro : libros) {
                Object[] fila = {
                    libro.getIdLibro(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getIsbn(),
                    libro.getEditorial(),
                    libro.getAnoPublicacion(),
                    libro.getCantidadTotal(),
                    "Acciones"
                };
                modelo.addRow(fila);
            }
            System.out.println("/ Datos cargados: " + libros.size() + " libros");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error al cargar datos: " + e.getMessage(),
                "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void guardarLibro() {
        try {
            if (txtTituloLibro.getText().trim().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "El título es obligatorio", "Advertencia",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
                txtTituloLibro.requestFocus();
                return;
            }
            if (txtAutor.getText().trim().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "El autor es obligatorio", "Advertencia",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
                txtAutor.requestFocus();
                return;
            }

            Libro libro = new Libro();
            libro.setTitulo(txtTituloLibro.getText().trim());
            libro.setAutor(txtAutor.getText().trim());
            libro.setIsbn(txtIsbn.getText().trim());
            libro.setEditorial(txtEditorial.getText().trim());

            try {
                int anio = Integer.parseInt(txtAñoPublicacion.getText().trim());
                libro.setAnoPublicacion(anio);
            } catch (NumberFormatException e) {
                libro.setAnoPublicacion(0);
            }

            try {
                int cantidad = Integer.parseInt(txtCantidad.getText().trim());
                libro.setCantidadTotal(cantidad);
                libro.setCantidadDisponible(cantidad);
            } catch (NumberFormatException e) {
                libro.setCantidadTotal(0);
                libro.setCantidadDisponible(0);
            }

            libro.setEstado("Activo");
            libro.setCategoria("General");

            Object idLibroObj = btnGuardar.getClientProperty("idLibro");
            if (idLibroObj != null) {
                // Actualizar
                int idLibro = (int) idLibroObj;
                libro.setIdLibro(idLibro);
                boolean actualizado = libroDAO.actualizarLibro(libro);
                if (actualizado) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                        "Libro actualizado exitosamente",
                        "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    btnGuardar.setText("Guardar");
                    btnGuardar.setBackground(new java.awt.Color(51, 153, 0));
                    btnGuardar.putClientProperty("idLibro", null);
                    limpiarCampos();
                    cargarDatosTabla();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this,
                        "No se pudo actualizar el libro",
                        "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Guardar nuevo
                boolean guardado = libroDAO.guardarLibro(libro);
                if (guardado) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                        "Libro guardado exitosamente",
                        "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                    cargarDatosTabla();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this,
                        "No se pudo guardar el libro",
                        "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error al guardar: " + e.getMessage(),
                "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
  
    private void limpiarCampos() {
        txtTituloLibro.setText("");
        txtAutor.setText("");
        txtIsbn.setText("");
        txtEditorial.setText("");
        txtAñoPublicacion.setText("");
        txtCantidad.setText("");
        txtTituloLibro.requestFocus();
    }

   /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRegistrarLibros = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTituloLibro = new javax.swing.JFormattedTextField();
        txtAutor = new javax.swing.JFormattedTextField();
        txtEditorial = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        txtAñoPublicacion = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("LIBROS REGISTRADOS");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 350, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setForeground(new java.awt.Color(242, 242, 242));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 110, 30));

        btnGuardar.setBackground(new java.awt.Color(0, 204, 0));
        btnGuardar.setForeground(new java.awt.Color(242, 242, 242));
        btnGuardar.setText("GUARDAR");
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 130, 30));

        btnLimpiar.setBackground(new java.awt.Color(0, 153, 255));
        btnLimpiar.setForeground(new java.awt.Color(242, 242, 242));
        btnLimpiar.setText("LIMPIAR");
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 120, 30));

        tblRegistrarLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblRegistrarLibros);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 720, 180));

        jLabel10.setText("TÍTULO DE LIBRO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 340, -1));

        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText("SELECCIONE EL TIPO DE REPORTE");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 350, -1));

        jLabel18.setText("AUTOR");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 380, -1));
        jPanel1.add(txtTituloLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 340, -1));
        jPanel1.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 380, -1));
        jPanel1.add(txtEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 380, -1));

        jLabel11.setText("ISBN");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 340, -1));
        jPanel1.add(txtIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 340, -1));

        jLabel19.setText("EDITORIAL");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 380, -1));

        txtAñoPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAñoPublicacionActionPerformed(evt);
            }
        });
        jPanel1.add(txtAñoPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 340, -1));

        jLabel12.setText("AÑO DE PUBLICACIÓN");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 340, -1));
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 380, -1));

        jLabel20.setText("CANTIDAD");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 380, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 770, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtAñoPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAñoPublicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAñoPublicacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblRegistrarLibros;
    private javax.swing.JFormattedTextField txtAutor;
    private javax.swing.JFormattedTextField txtAñoPublicacion;
    private javax.swing.JFormattedTextField txtCantidad;
    private javax.swing.JFormattedTextField txtEditorial;
    private javax.swing.JFormattedTextField txtIsbn;
    private javax.swing.JFormattedTextField txtTituloLibro;
    // End of variables declaration//GEN-END:variables
}
