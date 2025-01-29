/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ItemEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import main.App;
import model.Mapel;
import model.Pendaftaran;
import model.Pengajar;
import model.Siswa;
import view.PendaftaranView;

/**
 *
 * @author ASUS
 */
public class PendaftaranController {
      private final PendaftaranView pendaftaranView;

    public PendaftaranController(PendaftaranView pendaftaranView) {
        this.pendaftaranView = pendaftaranView;
    }
    
    public void clearForm(){
    
        pendaftaranView.getComboMapel().setSelectedIndex(0);
         pendaftaranView.getComboPengajar().setSelectedIndex(0);
          pendaftaranView.getComboSiswa().setSelectedIndex(0);
        pendaftaranView.getTabelPendaftaran().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
       pendaftaranView.getComboPengajar().setSelectedIndex(0);
          pendaftaranView.getComboSiswa().setSelectedIndex(0);
        pendaftaranView.getComboMapel().setEnabled(kondisi);
        pendaftaranView.getTombolSimpan().setEnabled(kondisi);
        pendaftaranView.getTombolHapus().setEnabled(!kondisi);
    }
    
public void loadSatuan() {
    try {
        List<Siswa> siswaList = App.masterService.getAllSiswa();
        Vector<String> siswaVector = new Vector<>();
        for (Siswa siswa : siswaList) {
            siswaVector.add(siswa.getNama_siswa());
        }
        DefaultComboBoxModel<String> siswaModel = new DefaultComboBoxModel<>(siswaVector);
        pendaftaranView.getComboSiswa().setModel(siswaModel);

        // Load Pengajar ComboBox
        List<Pengajar> pengajarList = App.masterService.getAllPengajar();
        Vector<String> pengajarVector = new Vector<>();
        for (Pengajar pengajar : pengajarList) {
            pengajarVector.add(pengajar.getNama_pengajar()); 
        }
        DefaultComboBoxModel<String> pengajarModel = new DefaultComboBoxModel<>(pengajarVector);
        pendaftaranView.getComboPengajar().setModel(pengajarModel);

        // Load Mapel ComboBox
        List<Mapel> mapelList = App.masterService.getAllMapel();
        Vector<String> mapelVector = new Vector<>();
        for (Mapel mapel : mapelList) {
            mapelVector.add(mapel.getNama_mapel());
        }
        DefaultComboBoxModel<String> mapelModel = new DefaultComboBoxModel<>(mapelVector);
        pendaftaranView.getComboMapel().setModel(mapelModel);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(pendaftaranView, 
            "Error loading data: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}

    
    public void loadData(Pendaftaran pendaftaran, List<Pendaftaran> list){
        if(pendaftaranView.getTabelPendaftaran().getSelectedRow() >= 0){
            int row = pendaftaranView.getTabelPendaftaran().getSelectedRow();
            pendaftaran = list.get(row);
            pendaftaranView.getComboSiswa().setSelectedItem(pendaftaran.getSiswa().getNama_siswa());
              pendaftaranView.getComboMapel().setSelectedItem(pendaftaran.getMapel().getNama_mapel());
          pendaftaranView.getComboSiswa().setSelectedItem(pendaftaran.getPengajar().getNama_pengajar());
              if(pendaftaran.getStatus_pembayaran().equals("Lunas")){
    pendaftaranView.getjRadioLunas().setSelected(true);
} else if(pendaftaran.getStatus_pembayaran().equals("Belum Lunas") ){
    pendaftaranView.getjRadioBelumLunas().setSelected(true);
            pendaftaranView.getTombolHapus().setEnabled(false);
        }
    }
}
    }
