/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Consulta;

import controlador.ControladorDepartamentos;
import controlador.ControladorTerceros;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Entidades.Departamentos;
import modelo.Entidades.Terceros;
import vista.IntDepartamentos;
import vista.frmInicio;
import vista.intTerceros;

/**
 *
 * @author hypadilla
 */
public class ConsultarDepartamentos extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultarTerceros
     */
    public ConsultarDepartamentos() {
        initComponents();
        LlenarTabla("");
        txtFiltro.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                LlenarTabla(txtFiltro.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                LlenarTabla(txtFiltro.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                LlenarTabla(txtFiltro.getText());
            }
        });
    }

    void LlenarTabla(String Consulta) {
        String col[] = {"ID", "CODIGO", "DEPARTAMENTO", "DESCRIPCION"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tblConsulta.setModel(tableModel);

        tblConsulta.getColumnModel().getColumn(0).setMaxWidth(0);
        tblConsulta.getColumnModel().getColumn(0).setMinWidth(0);
        tblConsulta.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblConsulta.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        ControladorDepartamentos controladorDepartamentos = new ControladorDepartamentos();
        ArrayList<Object> departamentos = controladorDepartamentos.MostrarTodos(Consulta);
        for (Object item : departamentos) {
            Departamentos departamento = (Departamentos) item;
            tableModel.addRow(new Object[]{departamento.getId(), departamento.getCodigo(), departamento.getDepartamento(), departamento.getDescripcion(), });
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
        txtFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consultar Departamentos");

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel1.setText("FILTRAR POR CÓDIGO O NOMBRE");

        txtFiltro.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
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
        tblConsulta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblConsultaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFiltro)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblConsultaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConsultaMousePressed
        if (evt.getClickCount() > 1) {
            Point point = evt.getPoint();
            int row = tblConsulta.rowAtPoint(point);
            int column = tblConsulta.columnAtPoint(point);
            TableModel model = tblConsulta.getModel();

            IntDepartamentos t = new IntDepartamentos(Integer.parseInt(model.getValueAt(row, 0).toString()));
            frmInicio.jdpEscritorio.add(t);
            t.show();
            dispose();
            //JOptionPane.showMessageDialog(this, );
        }
    }//GEN-LAST:event_tblConsultaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tblConsulta;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
