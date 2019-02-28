/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorConceptos;
import controlador.ControladorFacturacion;
import controlador.ControladorProductos;
import controlador.ControladorTerceros;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Entidades.Conceptos;
import modelo.Entidades.DetalleFacturacion;
import modelo.Entidades.Facturacion;
import modelo.Entidades.Productos;
import modelo.Entidades.Terceros;
import src.Sesion;

/**
 *
 * @author hypadilla
 */
public final class IntFacturacion extends javax.swing.JInternalFrame {

    Date date;
    DateFormat dateFormat;
    ArrayList<Conceptos> conceptos;
    ArrayList<DetalleFacturacion>DetalleFactura;
    DefaultTableModel tableModel;

    /**
     * Creates new form IntFacturacion
     */
    public IntFacturacion() {
        initComponents();
        date = new Date();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtFecha.setText(dateFormat.format(date));

        conceptos = new ArrayList<>();
        DetalleFactura = new ArrayList<>();
        LlenarConceptos();
        String col[] = {"ID", "CÓDIGO", "DESCRIPCIÓN", "VR NETO", "% DESCUENTO", "% IVA", "SUBTOTAL", "CANTIDAD", "TOTAL"};
        tableModel = new DefaultTableModel(col, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        jTable1.setModel(tableModel);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }

    /*int ObtenerConcepto() {
        int i;
        boolean flat = false;
        for (i = 0; i < conceptos.size(); i++) {
            if (conceptos.get(i).getCodigo().equals(txtConceptos.getText())) {
                flat = true;
                break;
            }
        }
        if (flat) {
            return i;
        }else{return -1;}
    }*/
    void LlenarConceptos() {
        conceptos.clear();
        ArrayList<Object> objects = new ArrayList<>();
        ControladorConceptos controladorConceptos = new ControladorConceptos();
        objects = controladorConceptos.MostrarTodos("");
        for (Object object : objects) {
            Conceptos concepto = (Conceptos) object;
            conceptos.add(concepto);
            cbConceptos.addItem(concepto.getDescripcion());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtConceptos = new javax.swing.JTextField();
        txtPrefijoConsecutivo = new javax.swing.JTextField();
        txtConsecutivo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdTercero = new javax.swing.JTextField();
        txtTercero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
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
        cbConceptos = new javax.swing.JComboBox<>();
        txtCodigoProducto = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtVrVenta = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtAreaObservacion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel1.setText("FECHA");

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel2.setText("CONSECUTIVO");

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel3.setText("CONCEPTO");

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtFecha.setText("12/02/2019");

        txtConceptos.setEditable(false);
        txtConceptos.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtConceptos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPrefijoConsecutivo.setEditable(false);
        txtPrefijoConsecutivo.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtPrefijoConsecutivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtConsecutivo.setEditable(false);
        txtConsecutivo.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtConsecutivo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtConsecutivo.setMargin(new java.awt.Insets(2, 2, 2, 5));

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel4.setText("TERCERO");

        txtIdTercero.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtIdTercero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdTerceroFocusLost(evt);
            }
        });

        txtTercero.setEditable(false);
        txtTercero.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel5.setText("TÉLEFONO");

        txtTelefono.setEditable(false);
        txtTelefono.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel6.setText("DIRECCIÓN");

        txtDireccion.setEditable(false);
        txtDireccion.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "DESCRIPCIÓN", "NETO", "DESCUENTO", "IVA", "SUBTOTAL", "CANTIDAD", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
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
        txtSubtotal.setText("0.0");

        txtDescuento.setEditable(false);
        txtDescuento.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtDescuento.setText("0.0");

        txtIva.setEditable(false);
        txtIva.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtIva.setText("0.0");
        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtTotal.setText("0.0");

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
        txtEliminar.setText("ANULAR");

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel8.setText("FORMA DE PAGO");

        cbFormaPago.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        cbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "CRÉDITO" }));

        cbConceptos.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        cbConceptos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbConceptosItemStateChanged(evt);
            }
        });

        txtCodigoProducto.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtCodigoProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoProductoFocusLost(evt);
            }
        });

        txtProducto.setEditable(false);
        txtProducto.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel7.setText("PRODUCTO");

        jCheckBox1.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jCheckBox1.setText("LECTOR CODIGO BARRA");

        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel13.setText("VR VENTA");

        txtVrVenta.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtVrVenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtVrVentaFocusLost(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFocusLost(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel14.setText("CANT");

        txtAreaObservacion.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel15.setText("OBSERVACIÓN");

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
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
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
                                .addComponent(txtConceptos, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbConceptos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPrefijoConsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtConsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtVrVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 28, Short.MAX_VALUE))
                            .addComponent(txtCantidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(txtAreaObservacion)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox1))
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
                            .addComponent(jLabel15))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtConceptos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbConceptos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel13))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(txtVrVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(5, 5, 5)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAreaObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuardarActionPerformed
        Facturacion facturacion = new Facturacion();
        facturacion.setIdConceptos(Integer.parseInt(txtConceptos.getText()));
        facturacion.setIdTerceros(Integer.parseInt(txtIdTercero.getToolTipText()));
        facturacion.setIdUsuarios(Sesion.usuarios.getId());
        facturacion.setFecha(txtFecha.getText());
        facturacion.setObservacion(txtAreaObservacion.getText());
        facturacion.setFormaPago(cbFormaPago.getSelectedItem().toString());
        facturacion.setSubTotal(Double.parseDouble(txtSubtotal.getText()));
        facturacion.setIVA(Double.parseDouble(txtIva.getText()));
        facturacion.setTotal(Double.parseDouble(txtTotal.getText()));
        
        ArrayList<Object> Parametros = new ArrayList<>();
        Parametros.add(facturacion);
        Parametros.add(DetalleFactura);

        ControladorFacturacion controladorFacturacion = new ControladorFacturacion();
        Object[] object = (Object[]) controladorFacturacion.Insertar(Parametros);

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
        }
    }//GEN-LAST:event_txtGuardarActionPerformed

    void Limpiar() {
        txtFecha.setText(dateFormat.format(date));
    }

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaActionPerformed

    private void cbConceptosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbConceptosItemStateChanged
        txtConceptos.setText(conceptos.get(cbConceptos.getSelectedIndex()).getCodigo());
        txtPrefijoConsecutivo.setText(conceptos.get(cbConceptos.getSelectedIndex()).getPrefijo());
        txtConsecutivo.setText("");
        txtConsecutivo.setEditable(!conceptos.get(cbConceptos.getSelectedIndex()).isManejaConsecutivo());
    }//GEN-LAST:event_cbConceptosItemStateChanged

    private void txtIdTerceroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdTerceroFocusLost
        Terceros tercero;
        ArrayList<String> Filtro = new ArrayList<>();
        Filtro.add("Documento");
        Filtro.add(txtIdTercero.getText());
        Filtro.add("String");
        ControladorTerceros controladorTerceros = new ControladorTerceros();
        tercero = (Terceros) controladorTerceros.Mostrar(Filtro);

        if (tercero != null) {
            txtIdTercero.setToolTipText(String.valueOf(tercero.getIdTerceros()));
            txtTercero.setText(tercero.getNombre());
            txtDireccion.setText(tercero.getDireccion());
            txtTelefono.setText(tercero.getTelefono());
        } else {
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "El Tercero no existe ¿Consulte o cree un tercero?",
                    "EL TERCERO NO EXISTE",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, // null para icono por defecto.
                    new Object[]{"Crear", "Consultar"}, // null para YES, NO y CANCEL
                    "Consultar");

            if (seleccion != -1) {
                System.out.println("seleccionada opcion " + (seleccion + 1));
            }
        }
    }//GEN-LAST:event_txtIdTerceroFocusLost

    private void txtVrVentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVrVentaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVrVentaFocusLost

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadFocusLost

    private void txtCodigoProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoProductoFocusLost
        Productos producto;
        ArrayList<String> Filtro = new ArrayList<>();
        Filtro.add("Codigo");
        Filtro.add(txtCodigoProducto.getText());
        Filtro.add("String");
        ControladorProductos controladorProductos = new ControladorProductos();
        producto = (Productos) controladorProductos.Mostrar(Filtro);

        if (producto != null) {
            txtCodigoProducto.setToolTipText(String.valueOf(producto.getId()));
            txtProducto.setText(producto.getDescripcion());
            txtVrVenta.setText(String.valueOf(producto.getVentaNeto()));
        } else {
            txtCodigoProducto.setText("");
            txtProducto.setText("");
            txtVrVenta.setText("");
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "El Producto no existe ¿Deseas Consultar?",
                    "EL PRODUCTO NO EXISTE",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Consultar"}, // null para YES, NO y CANCEL
                    "Consultar");

            if (seleccion != -1) {
                System.out.println("seleccionada opcion " + (seleccion + 1));
            }
        }
    }//GEN-LAST:event_txtCodigoProductoFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtCodigoProducto.getText().equals("")) {
            txtCodigoProducto.requestFocus();
            JOptionPane.showMessageDialog(this, "No hay un producto seleccionado.");
            return;
        }
        if (txtVrVenta.getText().equals("")) {
            txtVrVenta.requestFocus();
            JOptionPane.showMessageDialog(this, "El valor del producto no puede estar vacío.");
            return;
        }
        if (txtCantidad.getText().equals("")) {
            txtCantidad.requestFocus();
            JOptionPane.showMessageDialog(this, "La cantidad no puede estar vacía.");
            return;
        }
        
        DetalleFacturacion detalleFacturacion = new DetalleFacturacion(0, 0, Integer.parseInt(txtCodigoProducto.getToolTipText()),Double.parseDouble(txtCantidad.getText()),Double.parseDouble(txtVrVenta.getText()),19,0);
        DetalleFactura.add(detalleFacturacion);
        tableModel.addRow(new Object[]  {Integer.parseInt(txtCodigoProducto.getToolTipText()), txtCodigoProducto.getText(), txtProducto.getText(), Double.parseDouble(txtVrVenta.getText()), 0, 19, (Double.parseDouble(txtVrVenta.getText()) * 1.19), Double.parseDouble(txtCantidad.getText()), Double.parseDouble(txtCantidad.getText()) * (Double.parseDouble(txtVrVenta.getText()) * 1.19)});
        CalcularTotales();
    }//GEN-LAST:event_jButton1ActionPerformed

    void CalcularTotales(){
        double SubTotales = 0;
        double IVA = 0;
        double Total = 0;
        for (DetalleFacturacion detalleFacturacion : DetalleFactura) {
            SubTotales += (detalleFacturacion.getVrProducto() * detalleFacturacion.getCantidad());
            IVA += (detalleFacturacion.getVrProducto() * (detalleFacturacion.getVrIVA()) /100 * detalleFacturacion.getCantidad());
            Total += (SubTotales + IVA);
        }
        txtSubtotal.setText(String.valueOf(SubTotales));
        txtIva.setText(String.valueOf(IVA));
        txtTotal.setText(String.valueOf(Total));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbConceptos;
    private javax.swing.JComboBox<String> cbFormaPago;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JTextField txtAreaObservacion;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtConceptos;
    private javax.swing.JTextField txtConsecutivo;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JButton txtEliminar;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JButton txtGuardar;
    private javax.swing.JTextField txtIdTercero;
    private javax.swing.JTextField txtIva;
    private javax.swing.JButton txtLimpiar;
    private javax.swing.JTextField txtPrefijoConsecutivo;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTercero;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVrVenta;
    // End of variables declaration//GEN-END:variables
}
