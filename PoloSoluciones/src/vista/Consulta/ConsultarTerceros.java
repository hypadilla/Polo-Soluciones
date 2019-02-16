/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Consulta;

import controlador.ControladorTerceros;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import modelo.Entidades.Terceros;

/**
 *
 * @author hypadilla
 */
public class ConsultarTerceros extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultarTerceros
     */
    public ConsultarTerceros() {
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
        String col[] = {"TIPO", "DOCUMENTO", "NOMBRE", "DIRECCIÓN", "CORREO", "TÉLEFONO"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        tblConsulta.setModel(tableModel);
        ControladorTerceros controladorTerceros = new ControladorTerceros();
        ArrayList<Object> terceros = controladorTerceros.MostrarTodos(Consulta);
        for (Object item : terceros) {
            Terceros tercero = (Terceros) item;
            tableModel.addRow(new Object[]{tercero.getTipoTercero(), tercero.getDocumento(), tercero.getNombre(), tercero.getTelefono(), tercero.getDireccion(), tercero.getCorreo()});
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConsulta;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
