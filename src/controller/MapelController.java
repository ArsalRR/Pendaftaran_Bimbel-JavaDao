/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.Mapel;
import view.MapelView;

/**
 *
 * @author ASUS
 */
public class MapelController {
        private final MapelView MapelView;
    
    public MapelController(MapelView MapelView) {
        this.MapelView = MapelView;
    }
    
    public void clearForm(){
        MapelView.getTextNama_Mapel().setText(null);
        MapelView.getTextTingkat().setText(null);
        MapelView.getTextBiaya().setText(null);
        MapelView.getTabelMapel().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
        MapelView.getTextNama_Mapel().setEnabled(kondisi);
        MapelView.getTextTingkat().setEnabled(kondisi);
        MapelView.getTextBiaya().setEnabled(kondisi);
        MapelView.getTombolSimpan().setEnabled(kondisi);
        MapelView.getTombolUbah().setEnabled(!kondisi);
        MapelView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public boolean validasiInput(){
        if(MapelView.getTextNama_Mapel().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(MapelView, "Nama Siswa harus di isi!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(MapelView.getTextBiaya().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(MapelView, "No Telepon harus di isi!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
      
        return true;
    }
    
    public void loadData(Mapel mapel, List<Mapel> list){
        if(MapelView.getTabelMapel().getSelectedRow() >= 0){
            int row = MapelView.getTabelMapel().getSelectedRow();
            mapel = list.get(row);
            
            MapelView.getTextNama_Mapel().setText(mapel.getNama_mapel());
MapelView.getTextBiaya().setText(String.valueOf(mapel.getBiaya()));
            MapelView.getTextTingkat().setText(mapel.getTingkat()); 
            enableForm(false);
            // Enable fields that should be editable when loading data
            MapelView.getTextNama_Mapel().setEnabled(true);
            MapelView.getTextBiaya().setEnabled(true);
            MapelView .getTextTingkat().setEnabled(true);
        }
    }
}
