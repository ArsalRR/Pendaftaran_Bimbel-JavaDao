/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MapelController;
import controller.PengajarController;
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
import model.Mapel;


/**
 *
 * @author anzt0
 */
public class MapelView extends javax.swing.JInternalFrame {

    private final Mapel mapel;
    private List<Mapel> listMapel;
    private final MapelController mapelController;

    /**
     * Creates new form SatuanView
     */
    public MapelView() {
        initComponents();
        mapel = new Mapel();
        mapelController = new MapelController(this);
        mapelController.enableForm(false);
        refreshTable();
        initListener();
    }

    public JTable getTabelMapel() {
        return tabelMapel;
    }

  

    public JTextField getTextBiaya() {
        return textBiaya;
    }

    public JTextField getTextNama_Mapel() {
        return textNama_Mapel;
    }

    public JTextField getTextTingkat() {
        return textTingkat;
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
        listMapel = App.masterService.getAllMapel(); // memanggil interface
        // memasukkan nilai list ke inner class
        tabelMapel.setModel(new SatuanTableModel(listMapel)); 
    }
    
    private void initListener(){ // memindahkan nilai di tabel ke form
        tabelMapel.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            mapelController.loadData(mapel, listMapel);
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
        textNama_Mapel = new javax.swing.JTextField();
        textBiaya = new javax.swing.JTextField();
        textTingkat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tombolBaru = new javax.swing.JButton();
        tombolSimpan = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        tombolUbah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMapel = new javax.swing.JTable();

        setClosable(true);
        setTitle("Form Input Siswa");
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

        jLabel1.setText("Nama Mata Pelajaran");

        jLabel2.setText("Biaya");

        jLabel3.setText("Tingkat");

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
                    .addComponent(textBiaya, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(textNama_Mapel)
                    .addComponent(textTingkat))
                .addContainerGap(424, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textNama_Mapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTingkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        tabelMapel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelMapel);

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
     if (mapelController.validasiInput()) {
        mapel.setNama_mapel(textNama_Mapel.getText());
        mapel.setTingkat(textTingkat.getText());
        mapel.setBiaya(Integer.parseInt(textBiaya.getText()));
        App.masterService.simpanMapel(mapel);
        JOptionPane.showMessageDialog(this, "Data siswa berhasil disimpan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        refreshTable();
    }
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBaruActionPerformed
        // TODO add your handling code here:
        mapelController.clearForm();
        mapelController.enableForm(true);
        textNama_Mapel.requestFocusInWindow();
    }//GEN-LAST:event_tombolBaruActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
         if (mapelController.validasiInput()) {
        int konfirmasi = JOptionPane.showConfirmDialog(this, 
            "Apakah anda yakin akan menghapus data ini?", 
            "Konfirmasi", 
            JOptionPane.WARNING_MESSAGE);
        if(konfirmasi == 0) {
            App.masterService.hapusMapel(mapel);
            JOptionPane.showMessageDialog(this, "Data siswa berhasil dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        }
    }
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
           if (mapelController.validasiInput()) {
         mapel.setNama_mapel(textNama_Mapel.getText());
        mapel.setTingkat(textTingkat.getText());
        mapel.setBiaya(Integer.parseInt(textBiaya.getText()));
        App.masterService.ubahMapel(mapel);
        JOptionPane.showMessageDialog(this, "Data siswa berhasil diubah!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        refreshTable();
    }
    }//GEN-LAST:event_tombolUbahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelMapel;
    private javax.swing.JTextField textBiaya;
    private javax.swing.JTextField textNama_Mapel;
    private javax.swing.JTextField textTingkat;
    private javax.swing.JButton tombolBaru;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables
    
    // inner class
    public class SatuanTableModel extends AbstractTableModel {

        private List<Mapel> listMapel = new ArrayList<>();

        private final String HEADER[] = {"Nama Pengajar", "Email","No Telpon"};

        public SatuanTableModel(List<Mapel> listMapel) {
            this.listMapel = listMapel;
        }

        @Override
        public int getRowCount() { // jumlah baris
            return listMapel.size();
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
        Mapel a = listMapel.get(row);
        switch (col) {
            case 0:
                return a.getNama_mapel();
            case 1:
                return a.getTingkat();
            case 2:
                return a.getBiaya();
            default:
                return null;
        }
    }
    }
}
