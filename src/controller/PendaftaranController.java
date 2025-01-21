/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import main.App;
import model.Pendaftaran;
import model.Produk;
import view.PendaftaranView;
import view.ProdukView;

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
        pendaftaranView.getTombolUbah().setEnabled(!kondisi);
        pendaftaranView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public void loadSatuan(){
        ComboBoxModel cbm = new DefaultComboBoxModel((Vector) App.masterService.getAllMapel());
        pendaftaranView.getComboSiswa().setModel(cbm);
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
            pendaftaranView.getTombolUbah().setEnabled(false);
            pendaftaranView.getTombolHapus().setEnabled(false);
        }
    }
}
    }
