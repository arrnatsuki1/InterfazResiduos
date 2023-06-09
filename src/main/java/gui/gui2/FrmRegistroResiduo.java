/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.gui2;

import Excepciones.BaseException;
import Excepciones.MalformedResiduo;
import Excepciones.ResiduoExistenteException;
import fachada.Quimico;
import fachada.Residuo;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.logica2.FabricaLogica;
import logica.logica2.ILogica;

/**
 *
 * @author Rosa Rodriguez
 */
public class FrmRegistroResiduo extends javax.swing.JFrame {

    private ILogica logica;
    
    /**
     * Creates new form FrmRegistroTraslados
     */
    public FrmRegistroResiduo(List<Quimico> lista, ILogica logica) {
        initComponents();
        DefaultTableModel model = (DefaultTableModel)tablaTodos.getModel();
        for(Quimico q : lista) {
            Object[] row = {0, q.getNombre()};
            model.addRow(row);
        }
        this.logica = logica;
    }

    private void mueveQuimicoALaLista() {
        int row = tablaTodos.getSelectedRow();
        
        if(row < 0 ) {
            return;
        }
        
        String n = (String)tablaTodos.getValueAt(row, 1);
        Quimico q = new Quimico();
        q.setNombre(n);
        
        DefaultTableModel dtm = (DefaultTableModel)tablaSelect.getModel();
        dtm.addRow(new Object[]{0, q.getNombre()});
        DefaultTableModel m = (DefaultTableModel)tablaTodos.getModel();
        m.removeRow(row);
    }
    
    private void regresaQuimicoALaLista() {
        int row = tablaSelect.getSelectedRow();
        
        if(row < 0 ) {
            return;
        }
        
        String n = (String)tablaSelect.getValueAt(row, 1);
        Quimico q = new Quimico();
        q.setNombre(n);
        
        DefaultTableModel dtm = (DefaultTableModel)tablaTodos.getModel();
        dtm.addRow(new Object[]{0, q.getNombre()});
        DefaultTableModel m = (DefaultTableModel)tablaSelect.getModel();
        m.removeRow(row);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSelect = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTodos = new javax.swing.JTable();
        agregar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(430, 320));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaSelect.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo", "quimico"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaSelect);
        if (tablaSelect.getColumnModel().getColumnCount() > 0) {
            tablaSelect.getColumnModel().getColumn(0).setResizable(false);
            tablaSelect.getColumnModel().getColumn(1).setResizable(false);
        }

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 170, 130));

        tablaTodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "quimico"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaTodos);
        if (tablaTodos.getColumnModel().getColumnCount() > 0) {
            tablaTodos.getColumnModel().getColumn(0).setResizable(false);
            tablaTodos.getColumnModel().getColumn(1).setResizable(false);
        }

        background.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 170, 130));

        agregar.setText("<");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        background.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        regresar.setText(">");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        background.add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar residuo");
        btnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 105, 97), 2, true));
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        background.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 110, 30));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 105, 97), 2, true));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setFocusPainted(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        background.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 90, 30));

        txtNombre.setBackground(new java.awt.Color(237, 237, 237));
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        txtNombre.setNextFocusableComponent(txtCodigo);
        background.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 150, -1));

        txtCodigo.setBackground(new java.awt.Color(237, 237, 237));
        txtCodigo.setForeground(new java.awt.Color(0, 0, 0));
        txtCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        txtCodigo.setNextFocusableComponent(btnGuardar);
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        background.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 170, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quimicos disponibles");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 170, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quimicos del residuo");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        mueveQuimicoALaLista();
    }//GEN-LAST:event_agregarActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        regresaQuimicoALaLista();
    }//GEN-LAST:event_regresarActionPerformed

    //SelectGuardar (No deja cambiar el nombre profe no sea malo)
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Residuo r = new Residuo();
        List<Quimico> quimicos = new ArrayList();
        DefaultTableModel seleccionados = (DefaultTableModel)tablaSelect.getModel();
        int rows = seleccionados.getRowCount();
        
        for(int i = 0; i<rows; i++) {
            quimicos.add(new Quimico((String)seleccionados.getValueAt(i, 1)));
        }
        
        r.setQuimicos(quimicos);
        r.setCodigo(txtCodigo.getText());
        r.setNombre(txtNombre.getText());
        //Comienzo del 
        ILogica logica = FabricaLogica.crearInstancia();
        
        try {
            logica.guardarResiduo(r);
            muestraMensajeConfirmacion("Se pudo guardar");
        } catch (MalformedResiduo e) {
            mostrarError(e.getMessage());
        } catch (ResiduoExistenteException e2) {
            mostrarError(e2.getMessage());
        } 
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        if(!Character.isDigit(evt.getKeyChar()) || txtCodigo.getText().length() == 6) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void muestraMensajeConfirmacion(String msg) {
        JOptionPane.showMessageDialog(this, msg, "YUPII", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JPanel background;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton regresar;
    private javax.swing.JTable tablaSelect;
    private javax.swing.JTable tablaTodos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
