package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.Siswa;
import view.SiswaView;

public class SiswaController {
    
    private final SiswaView siswaView;
    
    public SiswaController(SiswaView siswaView) {
        this.siswaView = siswaView;
    }
    
    public void clearForm(){
        siswaView.getTextNama_Siswa().setText(null);
        siswaView.getTextNoTelpon().setText(null);
        siswaView.getTextAlamat().setText(null);
        siswaView.getjRadioLaki().setSelected(false);
        siswaView.getjRadioPerempuan().setSelected(false);
        siswaView.getTabelSiswa().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
        siswaView.getTextNama_Siswa().setEnabled(kondisi);
        siswaView.getTextNoTelpon().setEnabled(kondisi);
        siswaView.getTextAlamat().setEnabled(kondisi);
        siswaView.getjRadioLaki().setEnabled(kondisi);
        siswaView.getjRadioPerempuan().setEnabled(kondisi);
        siswaView.getTombolSimpan().setEnabled(kondisi);
        siswaView.getTombolUbah().setEnabled(!kondisi);
        siswaView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public boolean validasiInput(){
        if(siswaView.getTextNama_Siswa().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(siswaView, "Nama Siswa harus di isi!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(siswaView.getTextNoTelpon().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(siswaView, "No Telepon harus di isi!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(siswaView.getTextAlamat().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(siswaView, "Alamat harus di isi!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!siswaView.getjRadioLaki().isSelected() && !siswaView.getjRadioPerempuan().isSelected()){
            JOptionPane.showMessageDialog(siswaView, "Jenis Kelamin harus dipilih!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public void loadData(Siswa siswa, List<Siswa> list){
        if(siswaView.getTabelSiswa().getSelectedRow() >= 0){
            int row = siswaView.getTabelSiswa().getSelectedRow();
            siswa = list.get(row);
            
            siswaView.getTextNama_Siswa().setText(siswa.getNama_siswa());
            siswaView.getTextNoTelpon().setText(siswa.getNo_tlp());
            siswaView.getTextAlamat().setText(siswa.getAlamat());        
            enableForm(false);
                 siswaView.getjRadioPerempuan().setEnabled(true);
                       siswaView.getjRadioLaki().setEnabled(true);
            // Enable fields that should be editable when loading data
            siswaView.getTextNama_Siswa().setEnabled(true);
            siswaView.getTextNoTelpon().setEnabled(true);
            siswaView.getTextAlamat().setEnabled(true);
        }
    }
}

