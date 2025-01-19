/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import main.App;
import model.Produk;
import view.ProdukView;

/**
 *
 * @author anzt0
 */
public class ProdukController {
    
    private final ProdukView produkView;

    public ProdukController(ProdukView produkView) {
        this.produkView = produkView;
    }
    
    public void clearForm(){
        produkView.getTextId().setText(null);
        produkView.getTextNama().setText(null);
        produkView.getComboSatuan().setSelectedIndex(0);
        produkView.getTextPokok().setText(null);
        produkView.getTextJual().setText(null);
        produkView.getTextStok().setText(null);
        produkView.getTabelProduk().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
        produkView.getTextId().setEnabled(kondisi);
        produkView.getTextNama().setEnabled(kondisi);
        produkView.getComboSatuan().setEnabled(kondisi);
        produkView.getTextPokok().setEnabled(kondisi);
        produkView.getTextJual().setEnabled(kondisi);
        produkView.getTextStok().setEnabled(kondisi);
        produkView.getTombolSimpan().setEnabled(kondisi);
        produkView.getTombolUbah().setEnabled(!kondisi);
        produkView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public void loadSatuan(){
        ComboBoxModel cbm = new DefaultComboBoxModel(App.masterService.getAllName());
        produkView.getComboSatuan().setModel(cbm);
    }
    
    public void loadData(Produk produk, List<Produk> list){
        if(produkView.getTabelProduk().getSelectedRow() >= 0){
            int row = produkView.getTabelProduk().getSelectedRow();
            produk = list.get(row);
            produkView.getTextId().setText(produk.getId());
            produkView.getTextNama().setText(produk.getNama());
            produkView.getComboSatuan().setSelectedItem(produk.getSatuan().getNama());
            produkView.getTextPokok().setText(String.valueOf(produk.getHargaPokok()));
            produkView.getTextJual().setText(String.valueOf(produk.getHargaJual()));
            produkView.getTextStok().setText(String.valueOf(produk.getStok()));
            produkView.getTextId().setEnabled(false);
            produkView.getTombolUbah().setEnabled(false);
            produkView.getTombolHapus().setEnabled(false);
        }
    }
}
