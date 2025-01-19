/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.Pengajar;
import view.PengajarView;

/**
 *
 * @author ASUS
 */
public class PengajarController {
    private final PengajarView PengajarView;
    
    public PengajarController(PengajarView PengajarView) {
        this.PengajarView = PengajarView;
    }
    
    public void clearForm(){
        PengajarView.getTextNama_Pengajar().setText(null);
        PengajarView.getTextNoTelpon().setText(null);
        PengajarView.getTextEmail().setText(null);
        PengajarView.getTabelPengajar().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
        PengajarView.getTextNama_Pengajar().setEnabled(kondisi);
        PengajarView.getTextNoTelpon().setEnabled(kondisi);
        PengajarView.getTextEmail().setEnabled(kondisi);
        PengajarView.getTombolSimpan().setEnabled(kondisi);
        PengajarView.getTombolUbah().setEnabled(!kondisi);
        PengajarView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public boolean validasiInput(){
        if(PengajarView.getTextNama_Pengajar().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(PengajarView, "Nama Siswa harus di isi!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(PengajarView.getTextNoTelpon().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(PengajarView, "No Telepon harus di isi!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
      
        return true;
    }
    
    public void loadData(Pengajar siswa, List<Pengajar> list){
        if(PengajarView.getTabelPengajar().getSelectedRow() >= 0){
            int row = PengajarView.getTabelPengajar().getSelectedRow();
            siswa = list.get(row);
            
            PengajarView.getTextNama_Pengajar().setText(siswa.getNama_pengajar());
            PengajarView.getTextNoTelpon().setText(siswa.getNo_tlp());
            PengajarView.getTextEmail().setText(siswa.getEmail()); 
            enableForm(false);
            // Enable fields that should be editable when loading data
            PengajarView.getTextNama_Pengajar().setEnabled(true);
            PengajarView.getTextNoTelpon().setEnabled(true);
            PengajarView.getTextEmail().setEnabled(true);
        }
    }
}
