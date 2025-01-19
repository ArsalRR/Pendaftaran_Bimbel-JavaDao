package service.impl;

import config.Koneksi;
import dao.SiswaDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produk;
import model.Siswa;
import service.MasterService;

public class MasterServiceImpl implements MasterService {

    private SiswaDao siswaDao;
    private Koneksi koneksi;
    private Connection connection;

    public MasterServiceImpl() {
        try {
            koneksi = new Koneksi();
            connection = koneksi.getConnection();
            
            siswaDao = new SiswaDao();
            siswaDao.setConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

public Siswa simpanSiswa(Siswa s) {
    try {
        // Start transaction
        connection.setAutoCommit(false);
        
        // Validate siswa data before saving
        if (s == null || s.getNama_siswa() == null || s.getNama_siswa().trim().isEmpty()) {
            throw new IllegalArgumentException("Data siswa tidak valid");
        }
        
        // Attempt to save
        Siswa savedSiswa = siswaDao.simpan(s);
        
        // If successful, commit the transaction
        connection.commit();
        
        return savedSiswa;
        
    } catch (SQLException ex) {
        // Handle SQL related exceptions
        try {
            connection.rollback();
            Logger.getLogger(MasterServiceImpl.class.getName())
                  .log(Level.SEVERE, "Error saat menyimpan siswa: " + ex.getMessage(), ex);
        } catch (SQLException rollbackEx) {
            Logger.getLogger(MasterServiceImpl.class.getName())
                  .log(Level.SEVERE, "Error saat rollback: " + rollbackEx.getMessage(), rollbackEx);
        }
        throw new RuntimeException("Gagal menyimpan data siswa", ex);
        
    } catch (Exception ex) {
        // Handle other exceptions
        try {
            connection.rollback();
            Logger.getLogger(MasterServiceImpl.class.getName())
                  .log(Level.SEVERE, "Error tidak terduga: " + ex.getMessage(), ex);
        } catch (SQLException rollbackEx) {
            Logger.getLogger(MasterServiceImpl.class.getName())
                  .log(Level.SEVERE, "Error saat rollback: " + rollbackEx.getMessage(), rollbackEx);
        }
        throw new RuntimeException("Gagal menyimpan data siswa", ex);
        
    } finally {
        try {
            // Reset auto-commit to true
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName())
                  .log(Level.WARNING, "Error saat reset auto-commit", ex);
        }
    }
}


    public Siswa ubahSiswa(Siswa s) {
        try {
            connection.setAutoCommit(false);
            siswaDao.ubah(s);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }

    public Siswa hapusSiswa(Siswa s) {
        try {
            connection.setAutoCommit(false);
            siswaDao.hapus(s);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public List<Siswa> getAllSiswa() {
        try {
            return siswaDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    @Override
    public Produk simpanProduk(Produk p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produk ubahProduk(Produk p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produk hapusProduk(Produk p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produk> getAllProduk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produk getByIdProduk(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
