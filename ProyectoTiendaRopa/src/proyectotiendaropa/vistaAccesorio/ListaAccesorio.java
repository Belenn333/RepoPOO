package proyectotiendaropa.vistaAccesorio;

import javax.swing.JOptionPane;
import proyectotiendaropa.Accesorio;
import proyectotiendaropa.Menu;
import proyectotiendaropa.Principal;
import javax.swing.table.DefaultTableModel;

/**
 * Formularios del modulo Accesorios, siguiendo las vistas de Prendas.
 */
public class ListaAccesorio extends javax.swing.JFrame {
    private DefaultTableModel modelo;

    public ListaAccesorio() {
        initComponents();
        Principal.asegurarCargaAccesorios();
        configurarTabla();
        cargarTabla();
        setLocationRelativeTo(null);
    }

    // Opciones de entrada desde el menu principal.
    public ListaAccesorio(String opcion) {
        this();
        if ("codigo".equals(opcion)) {
            txtCodigo.requestFocus();
        } else if ("nombre".equals(opcion)) {
            txtNombre.requestFocus();
        } else if ("stock".equals(opcion)) {
            txtCodigo.requestFocus();
        } else if ("eliminar".equals(opcion)) {
            txtCodigo.requestFocus();
        }
    }

    private void configurarTabla() {
        modelo = new DefaultTableModel(
                new Object[]{"CODIGO", "NOMBRE", "COLOR", "PRECIO", "STOCK"}, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        tbAccesorios.setModel(modelo);
        tbAccesorios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbAccesorios.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting() && tbAccesorios.getSelectedRow() >= 0) {
                int fila = tbAccesorios.getSelectedRow();
                txtCodigo.setText(modelo.getValueAt(fila, 0).toString());
                txtNombre.setText(modelo.getValueAt(fila, 1).toString());
                txtColor.setText(modelo.getValueAt(fila, 2).toString());
            }
        });
    }

    private void cargarTabla() {
        modelo.setRowCount(0);
        for (Accesorio a : Principal.listaAccesorios) {
            modelo.addRow(a.mostrar(true));
        }
    }

    private void limpiarTabla() {
        modelo.setRowCount(0);
    }

    /** Componentes editables desde el disenador de NetBeans. */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        btnBuscarCodigo = new javax.swing.JButton();
        btnBuscarNombre = new javax.swing.JButton();
        btnBuscarNombreColor = new javax.swing.JButton();
        btnConsultarStock = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnMostrarTodos = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAccesorios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista De Accesorios");

        lblTitulo.setText("LISTA DE ACCESORIOS");

        lblCodigo.setText("Codigo:");

        lblNombre.setText("Nombre:");

        lblColor.setText("Color:");

        btnBuscarCodigo.setText("Buscar Codigo");
        btnBuscarCodigo.addActionListener(this::btnBuscarCodigoActionPerformed);

        btnBuscarNombre.setText("Buscar Nombre");
        btnBuscarNombre.addActionListener(this::btnBuscarNombreActionPerformed);

        btnBuscarNombreColor.setText("Nombre + Color");
        btnBuscarNombreColor.addActionListener(this::btnBuscarNombreColorActionPerformed);

        btnConsultarStock.setText("Consultar Stock");
        btnConsultarStock.addActionListener(this::btnConsultarStockActionPerformed);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnMostrarTodos.setText("Mostrar Todos");
        btnMostrarTodos.addActionListener(this::btnMostrarTodosActionPerformed);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(this::btnRegistrarActionPerformed);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(this::btnModificarActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        jScrollPane1.setViewportView(tbAccesorios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnConsultarStock)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMostrarTodos))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegistrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVolver))
                            .addComponent(lblTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigo)
                                .addGap(30, 30, 30)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(25, 25, 25)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblColor)
                                .addGap(40, 40, 40)
                                .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscarCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarNombreColor))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColor)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarCodigo)
                    .addComponent(btnBuscarNombre)
                    .addComponent(btnBuscarNombreColor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultarStock)
                    .addComponent(btnEliminar)
                    .addComponent(btnMostrarTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCodigoActionPerformed
        String codigo = txtCodigo.getText().trim();
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el codigo.");
            return;
        }
        limpiarTabla();
        for (Accesorio a : Principal.listaAccesorios) {
            if (a.getCodigo().equalsIgnoreCase(codigo) && a.buscar(codigo)) {
                modelo.addRow(a.mostrar(true));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Accesorio no encontrado.");
    }//GEN-LAST:event_btnBuscarCodigoActionPerformed

    private void btnBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNombreActionPerformed
        String nombre = txtNombre.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre.");
            return;
        }
        limpiarTabla();
        for (Accesorio a : Principal.listaAccesorios) {
            // Utiliza buscar(String nombre, int stockMinimo).
            if (a.buscar(nombre, 0) >= 0) {
                modelo.addRow(a.mostrar(true));
            }
        }
        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Accesorio no encontrado.");
        }
    }//GEN-LAST:event_btnBuscarNombreActionPerformed

    private void btnBuscarNombreColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNombreColorActionPerformed
        String nombre = txtNombre.getText().trim();
        String color = txtColor.getText().trim();
        if (nombre.isEmpty() || color.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese nombre y color.");
            return;
        }
        limpiarTabla();
        for (Accesorio a : Principal.listaAccesorios) {
            // Utiliza la sobrecarga buscar(String nombre, String color).
            if (a.buscar(nombre, color)) {
                modelo.addRow(a.mostrar(true));
            }
        }
        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Accesorio no encontrado.");
        }
    }//GEN-LAST:event_btnBuscarNombreColorActionPerformed

    private void btnConsultarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarStockActionPerformed
        String codigo = txtCodigo.getText().trim();
        for (Accesorio a : Principal.listaAccesorios) {
            if (a.getCodigo().equalsIgnoreCase(codigo)) {
                JOptionPane.showMessageDialog(this,
                        "Stock disponible de " + a.getNombre() + ": " + a.getStock());
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Accesorio no encontrado.");
    }//GEN-LAST:event_btnConsultarStockActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String codigo = txtCodigo.getText().trim();
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese o seleccione el codigo.");
            return;
        }
        for (int i = 0; i < Principal.listaAccesorios.size(); i++) {
            // Utiliza eliminar(String codigo) de la clase Accesorio.
            if (Principal.listaAccesorios.get(i).eliminar(codigo)) {
                int respuesta = JOptionPane.showConfirmDialog(this,
                        "¿Eliminar el accesorio " + codigo + "?",
                        "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    Principal.listaAccesorios.remove(i);
                    Principal.guardarTodosLosAccesorios();
                    cargarTabla();
                    txtCodigo.setText("");
                    txtNombre.setText("");
                    txtColor.setText("");
                    JOptionPane.showMessageDialog(this, "Accesorio eliminado correctamente.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Accesorio no encontrado.");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnMostrarTodosActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        new RegistrarAccesorio().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        new ModificarAccesorio().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ListaAccesorio().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCodigo;
    private javax.swing.JButton btnBuscarNombre;
    private javax.swing.JButton btnBuscarNombreColor;
    private javax.swing.JButton btnConsultarStock;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tbAccesorios;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
