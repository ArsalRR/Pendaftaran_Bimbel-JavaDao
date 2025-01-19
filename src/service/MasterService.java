/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Produk;
import model.Siswa;

/**
 *
 * @author deirn
 */
public interface MasterService {
    
    // SATUAN
    Siswa simpanSiswa(Siswa s);
    Siswa ubahSiswa(Siswa s);
    Siswa hapusSiswa(Siswa s);
    List<Siswa> getAllSiswa();
    
    // PRODUK
    Produk simpanProduk(Produk p);
    
    Produk ubahProduk(Produk p);
    
    Produk hapusProduk(Produk p);
    
    List<Produk> getAllProduk();
    
    Produk getByIdProduk(String id);
    
    
}
