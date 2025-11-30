/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import dao.LibroDAO;
import javax.swing.table.DefaultTableModel;

import model.Libro;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author surphury
 */
public class VentanaLibros extends javax.swing.JPanel {

    private LibroDAO libroDAO;

    /**
     * Creates new form PanelLibro
     */
    public VentanaLibros() {
        initComponents();
        //INICIALIZAR DAO
        libroDAO = new LibroDAO();

        //CONFIGURAR TABLA
        configurarTabla();
// Crear columnas
        String columnas[] = {"ID", "Título", "Autor", "ISBN", "Cantidad", "Disponibles", "Acciones"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

//Asignar el modelo a la tabla
        tblRegistrarLibros.setModel(modelo);

// 2. Agregar filas (ejemplo)
        tblRegistrarLibros.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        tblRegistrarLibros.getTableHeader().setForeground(new java.awt.Color(0, 102, 204)); // Azul bonito
    }

    //CREAR LA FUNCION CONFIGURAR TABLA
    private void configurarTabla() {
        tblRegistrarLibros.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Título", "Autor", "ISBN", "Cantidad", "Disponibles", "Acciones"}
        ) {
            //@Override
            public boolean isCalleditable(int row, int column) {
                return column == 7;
            }
        });
        //AJUSTAR ANCHO DE COLUMNA
        tblRegistrarLibros.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblRegistrarLibros.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblRegistrarLibros.getColumnModel().getColumn(2).setPreferredWidth(250);
        tblRegistrarLibros.getColumnModel().getColumn(3).setPreferredWidth(120);
        tblRegistrarLibros.getColumnModel().getColumn(4).setPreferredWidth(120);
        tblRegistrarLibros.getColumnModel().getColumn(5).setPreferredWidth(60);
        tblRegistrarLibros.getColumnModel().getColumn(6).setPreferredWidth(60);
        tblRegistrarLibros.getColumnModel().getColumn(7).setMinWidth(220);

        // agregar el renderiza y editor de botones
        tblRegistrarLibros.getColumnModel().getColumn(7).
                setCellRenderer(new ButtonRenderer());

        tblRegistrarLibros.getColumnModel().getColumn(7).
                setCellRenderer(new ButtonEditor(new javax.swing.JCheckBox()));
        // aumentar altura de filas
        tblRegistrarLibros.setRowHeight(50);
        // automentar fuente
        //
// AUMENTAR TAMAÑO DE FUENTE DE LA TABLA
        tblRegistrarLibros.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
// Mejorar apariencia general de la tabla
        tblRegistrarLibros.setShowGrid(true);
        tblRegistrarLibros.setGridColor(new java.awt.Color(230, 230, 230));
// Mejorar apariencia general de la tabla
        tblRegistrarLibros.setShowGrid(true);
        tblRegistrarLibros.setGridColor(new java.awt.Color(230, 230, 230));
        tblRegistrarLibros.getTableHeader().setReorderingAllowed(false);
        tblRegistrarLibros.setSelectionBackground(new java.awt.Color(173, 216, 230));
        tblRegistrarLibros.setSelectionForeground(java.awt.Color.BLACK);

// Configurar encabezado de la tabla (FORZADO)
        javax.swing.table.JTableHeader header = tblRegistrarLibros.getTableHeader();
        header.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));
        header.setBackground(new java.awt.Color(52, 73, 94));
        header.setForeground(java.awt.Color.WHITE);
        header.setOpaque(true);
        header.setPreferredSize(new java.awt.Dimension(header.getWidth(), 35));

        // Forzar el renderizador del encabezado
        header.setDefaultRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                javax.swing.JLabel label = new javax.swing.JLabel(value.toString());
                label.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));
                label.setBackground(new java.awt.Color(52, 73, 94));
                label.setForeground(java.awt.Color.WHITE);
                label.setOpaque(true);
                label.setHorizontalAlignment(javax.swing.JLabel.CENTER);
                label.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
                return label;
            }
        });
    }

    private void guardarLibro() {
        try {
            if (txtTituloLibro.getText().trim().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "El titulo es obligatorio", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
                txtTituloLibro.requestFocus();

                return;
            }

            if (txtAutor.getText().trim().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "El autor es obligatorio", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE
                );
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

    

    

    

    

    private void cargarDatosTabla() {
        try {
            List<Libro> libros = libroDAO.obtenerTodos();
            javax.swing.table.DefaultTableModel modelo
                    = (javax.swing.table.DefaultTableModel) tblRegistrarLibros.getModel();

            modelo.setRowCount(0);

            for (Libro libro : libros) {
                Object[] fila = {
                    libro.getIdLibro(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getIsbn(),
                    libro.getEditorial(),
                    libro.getAnoPublicacion(),
                    getCantidadTotal(),
                    "Acciones" // Esto será reemplazado por los botones
                };
                modelo.addRow(fila);
            }

            System.out.println(" Datos cargados: " + libros.size() + " libros");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al cargar datos: " + e.getMessage(),
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE
            );
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

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRegistrarLibros = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("LIBROS REGISTRADOS");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 350, -1));

        jButton9.setBackground(new java.awt.Color(255, 0, 0));
        jButton9.setForeground(new java.awt.Color(242, 242, 242));
        jButton9.setText("CANCELAR");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 110, 30));

        jButton10.setBackground(new java.awt.Color(0, 204, 0));
        jButton10.setForeground(new java.awt.Color(242, 242, 242));
        jButton10.setText("GUARDAR");
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 30));

        jButton11.setBackground(new java.awt.Color(0, 153, 255));
        jButton11.setForeground(new java.awt.Color(242, 242, 242));
        jButton11.setText("LIMPIAR");
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 120, 30));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 720, 180));

        jLabel10.setText("TIPO DE REPORTE");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 240, -1));

        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText("SELECCIONE EL TIPO DE REPORTE");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 350, -1));

        jLabel17.setText("TIPO DE REPORTE");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 240, 20));

        jLabel18.setText("TIPO DE REPORTE");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 240, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 230, -1));
        jPanel1.add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 240, -1));
        jPanel1.add(jFormattedTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 230, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 770, 360));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblRegistrarLibros;
    // End of variables declaration//GEN-END:variables
}
