/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.gui2;

import Excepciones.BaseException;
import Excepciones.MalformedAsignacion;
import fachada.Asignacion;
import fachada.Empresa;
import fachada.EmpresaAsignacion;
import fachada.Productor;
import fachada.Residuo;
import fachada.ResiduoSolicitud;
import fachada.Solicitud;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import logica.logica2.FabricaLogica;
import logica.logica2.ILogica;

/**
 *
 * @author Rosa Rodriguez
 */
public class FrmSolicitud extends javax.swing.JFrame {

    private Map<Integer, ResiduoSolicitud> residuos;
    private Map<Integer, Empresa> empresas;
    private ILogica logica = FabricaLogica.crearInstancia();
    
    //VARIABLE DE ESTADO
    private boolean hasPassed = false;
    
    /**
     * Creates new form FrmSolicitud
     */
    public FrmSolicitud(Solicitud s) {
        residuos = new TreeMap();
        empresas = new TreeMap();
        initComponents();
        lblProductor.setText(s.getProductor().getNombre());
        lblFecha.setText(s.getFechaSalida().toString());
        
        DefaultTableModel model = (DefaultTableModel)tablaResiduos.getModel();
        int i = 0;
        for(ResiduoSolicitud q : s.getResiduosSolicitud()) {
            residuos.put(i, q);
            Object[] row = {q.getResiduo().getNombre(), q.getCantidad()};
            model.addRow(row);
            i++;
        }
        
        tablaResiduos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                if(hasPassed) {
                    hasPassed = false;
                    return;
                }
                
                try {
                    List<Empresa> empresasRaw = logica.obtenerTodasLasEmpresas();
                    for (int j = 0; j < empresasRaw.size(); j++) {
                        empresas.put(j, empresasRaw.get(j));
                    }
                    
                    enseniaEmpresasDisponibles();
                    
                } catch (BaseException ex) {
                    System.out.println("ERRORRR");
                }
             
                hasPassed = true;
            }
            
        });
        
        
    }

    private void enseniaEmpresasDisponibles()
    {
        
        DefaultTableModel model = (DefaultTableModel)tablaEmpresas.getModel();
        for(Empresa e : empresas.values())
        {
            Object[] row = {e.getNombre(), false};
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResiduos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEmpresas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblProductor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaResiduos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
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
        jScrollPane1.setViewportView(tablaResiduos);
        if (tablaResiduos.getColumnModel().getColumnCount() > 0) {
            tablaResiduos.getColumnModel().getColumn(0).setResizable(false);
            tablaResiduos.getColumnModel().getColumn(1).setResizable(false);
        }

        tablaEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emprea", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaEmpresas);
        if (tablaEmpresas.getColumnModel().getColumnCount() > 0) {
            tablaEmpresas.getColumnModel().getColumn(0).setResizable(false);
            tablaEmpresas.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setText("Productor");

        lblProductor.setText("Label productor");

        jLabel2.setText("Fecha");

        lblFecha.setText("Label fecha");

        jButton1.setText("Asignar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAsignar(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblProductor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(271, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblFecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProductor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFecha))
                    .addComponent(jButton1))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectAsignar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAsignar
        int row = tablaResiduos.getSelectedRow();
        if(row < 0) {
            return;
        }
        
        DefaultTableModel dtm = (DefaultTableModel)tablaEmpresas.getModel();
        List<EmpresaAsignacion> empresasSeleccionadas = new LinkedList();
        for (int i = 0; i < empresas.size(); i++) {
            boolean b = (Boolean)dtm.getValueAt(0, 1);
            if(b) {
                empresasSeleccionadas.add(new EmpresaAsignacion(empresas.get(i), 0.0f));
            }
        }
        
        
        try {
            Asignacion s = new Asignacion(
                    residuos.get(row).getResiduo(), empresasSeleccionadas,
                    residuos.get(row).getCantidad(), new Productor(lblProductor.getText()));
            ILogica logica = FabricaLogica.crearInstancia();
            logica.asignarTraslado(s);
            muestraMensajeConfirmacion("Si se pudo guardar");
        } catch (MalformedAsignacion e) {
            //Mensaje de error
            mostrarError(e.getMessage());
        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
        
    }//GEN-LAST:event_selectAsignar

    private void muestraMensajeConfirmacion(String msg) {
        JOptionPane.showMessageDialog(this, msg, "YUPII", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblProductor;
    private javax.swing.JTable tablaEmpresas;
    private javax.swing.JTable tablaResiduos;
    // End of variables declaration//GEN-END:variables
}
