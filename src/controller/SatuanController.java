/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.Satuan;
import view.SatuanView;

/**
 *
 * @author anzt0
 */
public class SatuanController {
    
    private final SatuanView satuanView;
    
    public SatuanController(SatuanView satuanView) {
        this.satuanView = satuanView;
    }
    
    public void clearForm(){
        satuanView.getTextId().setText(null);
        satuanView.getTextNama().setText(null);
        satuanView.getTabelSatuan().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
        satuanView.getTextId().setEnabled(kondisi);
        satuanView.getTextNama().setEnabled(kondisi);
        satuanView.getTombolSimpan().setEnabled(kondisi);
        satuanView.getTombolUbah().setEnabled(!kondisi);
        satuanView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public boolean validasiInput(){
        if(satuanView.getTextId().getText().equals("")){
            JOptionPane.showMessageDialog(satuanView, "ID harus di isi !", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
    }
    
    public void loadData(Satuan satuan, List<Satuan> list){
        if(satuanView.getTabelSatuan().getSelectedRow() >= 0){
            int row = satuanView.getTabelSatuan().getSelectedRow();
            satuan = list.get(row);
            satuanView.getTextId().setText(satuan.getId());
            satuanView.getTextNama().setText(satuan.getNama());
            enableForm(false);
            satuanView.getTextNama().setEnabled(true);
        }else{
            
        }
    }
} 
