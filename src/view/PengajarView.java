/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PengajarController;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;
import main.App;
import model.Pengajar;


/**
 *
 * @author anzt0
 */
public class PengajarView extends javax.swing.JInternalFrame {

    private final Pengajar pengajar;
    private List<Pengajar> listPengajar;
    private final PengajarController pengajarController;

    /**
     * Creates new form SatuanView
     */
    public PengajarView() {
        initComponents();
        pengajar = new Pengajar();
        pengajarController = new PengajarController(this);
        pengajarController.enableForm(false);
        refreshTable();
        initListener();
    }

    public JTable getTabelPengajar() {
        return tabelPengajar;
    }

    public JTextField getTextEmail() {
        return textEmail;
    }

    public JTextField getTextNama_Pengajar() {
        return textNama_Pengajar;
    }

    public JTextField getTextNoTelpon() {
        return textNoTelpon;
    }

    public JButton getTombolBaru() {
        return tombolBaru;
    }

    public JButton getTombolHapus() {
        return tombolHapus;
    }

    public JButton getTombolSimpan() {
        return tombolSimpan;
    }

    public JButton getTombolUbah() {
        return tombolUbah;
    }



    private void refreshTable() {
        listPengajar = App.masterService.getAllPengajar(); // memanggil interface
        // memasukkan nilai list ke inner class
        tabelPengajar.setModel(new SatuanTableModel(listPengajar)); 
    }
    
    private void initListener(){ // memindahkan nilai di tabel ke form
        tabelPengajar.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            pengajarController.loadData(pengajar, listPengajar);
        });
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNama_Pengajar = new javax.swing.JTextField();
        textNoTelpon = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tombolBaru = new javax.swing.JButton();
        tombolSimpan = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        tombolUbah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPengajar = new javax.swing.JTable();

        setClosable(true);
        setTitle("Form Input Pengajar");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setText("Nama Pengajar");

        jLabel2.setText("No Telpon");

        jLabel3.setText("Email");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textNoTelpon, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(textNama_Pengajar)
                    .addComponent(textEmail))
                .addContainerGap(465, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textNama_Pengajar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNoTelpon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        tombolBaru.setText("Baru");
        tombolBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBaruActionPerformed(evt);
            }
        });

        tombolSimpan.setText("Simpan");
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        tombolHapus.setText("Hapus");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        tombolUbah.setText("Ubah");
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });

        tabelPengajar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelPengajar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(tombolBaru)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tombolSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(tombolUbah)
                                .addGap(30, 30, 30)
                                .addComponent(tombolHapus)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolHapus)
                    .addComponent(tombolUbah)
                    .addComponent(tombolSimpan)
                    .addComponent(tombolBaru))
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        App.menuView.pengajarView = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
     if (pengajarController.validasiInput()) {
        pengajar.setNama_pengajar(textNama_Pengajar.getText());
        pengajar.setEmail(textEmail.getText());
        pengajar.setNo_tlp(textNoTelpon.getText());
        App.masterService.simpanPengajar(pengajar);
        JOptionPane.showMessageDialog(this, "Data siswa berhasil disimpan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        refreshTable();
    }
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBaruActionPerformed
        // TODO add your handling code here:
        pengajarController.clearForm();
        pengajarController.enableForm(true);
        textNama_Pengajar.requestFocusInWindow();
    }//GEN-LAST:event_tombolBaruActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
 try {
    int selectedRow = tabelPengajar.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data pengajar yang akan dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data pengajar ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }
    Pengajar pengajar = listPengajar.get(selectedRow);
    App.masterService.hapusPengajar(pengajar);
    refreshTable();

    JOptionPane.showMessageDialog(this, "Data pengajar berhasil dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
   try {
    if (pengajarController.validasiInput()) {
        pengajar.setNama_pengajar(textNama_Pengajar.getText());
        pengajar.setEmail(textEmail.getText());
        pengajar.setNo_tlp(textNoTelpon.getText());

        App.masterService.ubahPengajar(pengajar);
        JOptionPane.showMessageDialog(this, "Data pengajar berhasil diperbarui!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        refreshTable();
    }
} catch (HeadlessException e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_tombolUbahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelPengajar;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textNama_Pengajar;
    private javax.swing.JTextField textNoTelpon;
    private javax.swing.JButton tombolBaru;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables
    
    // inner class
    public class SatuanTableModel extends AbstractTableModel {

        private List<Pengajar> listPengajar = new ArrayList<>();

        private final String HEADER[] = {"Nama Pengajar", "Email","No Telpon"};

        public SatuanTableModel(List<Pengajar> listPengajar) {
            this.listPengajar = listPengajar;
        }

        @Override
        public int getRowCount() { // jumlah baris
            return listPengajar.size();
        }

        @Override
        public int getColumnCount() { // jumlah kolom
            return HEADER.length;
        }

        @Override
        public String getColumnName(int i) { // nama kolom
            return HEADER[i];
        }

        @Override
         public Object getValueAt(int row, int col) {
        Pengajar a = listPengajar.get(row);
        switch (col) {
            case 0:
                return a.getNama_pengajar();
            case 1:
                return a.getEmail();
            case 2:
                return a.getNo_tlp();
            default:
                return null;
        }
    }
    }
}
