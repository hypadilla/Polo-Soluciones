/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Entidades.Facturacion;

/**
 *
 * @author hypadilla
 */
public class IntFacturacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form IntFacturacion
     */
    public IntFacturacion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtIdConcepto = new javax.swing.JTextField();
        txtConcepto = new javax.swing.JTextField();
        txtPrefijoConsecutivo = new javax.swing.JTextField();
        txtConsecutivo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdTercero = new javax.swing.JTextField();
        txtTercero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtGuardar = new javax.swing.JButton();
        txtLimpiar = new javax.swing.JButton();
        txtEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbFormaPago = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel1.setText("FECHA");

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel2.setText("CONSECUTIVO");

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel3.setText("CONCEPTO");

        txtFecha.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtFecha.setText("12/02/2019");

        txtIdConcepto.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtIdConcepto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdConcepto.setText("1");

        txtConcepto.setEditable(false);
        txtConcepto.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtConcepto.setText("COMPRAS");

        txtPrefijoConsecutivo.setEditable(false);
        txtPrefijoConsecutivo.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtPrefijoConsecutivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrefijoConsecutivo.setText("SB");

        txtConsecutivo.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtConsecutivo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtConsecutivo.setText("123456789");
        txtConsecutivo.setMargin(new java.awt.Insets(2, 2, 2, 5));

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel4.setText("TERCERO");

        txtIdTercero.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtIdTercero.setText("1038117288-7");

        txtTercero.setEditable(false);
        txtTercero.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtTercero.setText("HAROLD YESID PADILLA BARRETO");

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel5.setText("TÉLEFONO");

        txtTelefono.setEditable(false);
        txtTelefono.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtTelefono.setText("3124193639");

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel6.setText("DIRECCIÓN");

        txtDireccion.setEditable(false);
        txtDireccion.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtDireccion.setText("CRA 9 NUMERO 26 50");

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel7.setText("CIUDAD");

        txtCiudad.setEditable(false);
        txtCiudad.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtCiudad.setText("CAUCASIA");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel9.setText("SUB TOTAL");

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel10.setText("DESCUENTO");

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel11.setText("IVA");

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel12.setText("TOTAL");

        txtSubtotal.setEditable(false);
        txtSubtotal.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtSubtotal.setText("jTextField1");

        txtDescuento.setEditable(false);
        txtDescuento.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtDescuento.setText("jTextField1");

        txtIva.setEditable(false);
        txtIva.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtIva.setText("jTextField1");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtTotal.setText("jTextField1");

        txtGuardar.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        txtGuardar.setText("GUARDAR");
        txtGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuardarActionPerformed(evt);
            }
        });

        txtLimpiar.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        txtLimpiar.setText("LIMPIAR");

        txtEliminar.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        txtEliminar.setText("ELIMINAR");

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel8.setText("FORMA DE PAGO");

        cbFormaPago.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        cbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "CRÉDITO" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtIdTercero, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTercero, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEliminar)
                        .addGap(9, 9, 9)
                        .addComponent(txtGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtIdConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtConcepto)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPrefijoConsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtConsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8)
                            .addComponent(cbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPrefijoConsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtConsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdTercero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTercero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5)
                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLimpiar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGuardar)
                        .addComponent(txtEliminar)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuardarActionPerformed
        Facturacion var = new Facturacion();
        var.setIdConceptos(Integer.parseInt(txtIdConcepto.getText()));
        var.setIdTerceros(Integer.parseInt(txtIdTercero.getText()));
        var.setIdUsuarios(1);
        //var.setFecha(txtFecha.getText());
        /*
        try {
            var.setCostoNeto(Double.parseDouble(txtVrNetoCosto.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El vr del costo neto debe ser numerico.");
            return;
        }
        
        try {
            var.setCostoIva(Double.parseDouble(txtPorcIvaCosto.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El vr del costo del Iva debe ser numerico.");
            return;
        }
        
        try {
            var.setVentaNeto(Double.parseDouble(txtVrNetoVenta.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El vr de la venta Neta debe ser numerico.");
            return;
        }
        
        try {
            var.setVentaIva(Double.parseDouble(txtPorcIvaVenta.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El vr del Iva debe ser numerico.");
            return;
        }
        try {
            var.setVentaUtilidad(Double.parseDouble(txtVrUtilidad.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El vr de la Utilidad debe ser numerico.");
            return;
        }
        
        ControladorProductos controladorProductos = new ControladorProductos();
        Object[] object = new Object[2];
        object = (Object[]) controladorProductos.Insertar(var);
        if (object[0] == "String") {
            JOptionPane.showMessageDialog(this, object[1]);
            return;
        }
        if (object[0] == "Boolean") {
            if (((boolean) object[1])) {
                JOptionPane.showMessageDialog(this, "Registro Exitoso");
            } else {
                JOptionPane.showMessageDialog(this, "Registro Fallido");
            }
            return;
        }
        */
    }//GEN-LAST:event_txtGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbFormaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtConcepto;
    private javax.swing.JTextField txtConsecutivo;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JButton txtEliminar;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JButton txtGuardar;
    private javax.swing.JTextField txtIdConcepto;
    private javax.swing.JTextField txtIdTercero;
    private javax.swing.JTextField txtIva;
    private javax.swing.JButton txtLimpiar;
    private javax.swing.JTextField txtPrefijoConsecutivo;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTercero;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
