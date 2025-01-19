package service.impl;

import config.Koneksi;
import dao.MapelDao;
import dao.SiswaDao;
import dao.PengajarDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mapel;
import model.Pengajar;
import model.Siswa;
import service.MasterService;

public class MasterServiceImpl implements MasterService {

    private SiswaDao siswaDao;
    private MapelDao MapelDao;
    private PengajarDao pengajarDao;
    private Koneksi koneksi;
    private Connection connection;

    public MasterServiceImpl() {
        try {
            koneksi = new Koneksi();
            connection = koneksi.getConnection();
            
            siswaDao = new SiswaDao();
            siswaDao.setConnection(connection);
              pengajarDao = new PengajarDao();
            pengajarDao.setConnection(connection);
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
        return s;
    } catch (SQLException ex) {
        try {
            connection.rollback();
            connection.setAutoCommit(true);  // Tambahan ini untuk memastikan autoCommit kembali ke true
        } catch (SQLException ex1) {
            Logger.getLogger(MasterServiceImpl.class.getName())
                  .log(Level.SEVERE, "Gagal melakukan rollback", ex1);
        }
        Logger.getLogger(MasterServiceImpl.class.getName())
              .log(Level.SEVERE, "Gagal mengubah data siswa", ex);
        return null;  // Mengembalikan null jika operasi gagal
    }
}

public Siswa hapusSiswa(Siswa s) {
    try {
        connection.setAutoCommit(false);
        siswaDao.hapus(s);
        connection.commit();
        connection.setAutoCommit(true);
        return s;
    } catch (SQLException ex) {
        try {
            connection.rollback();
            connection.setAutoCommit(true);  // Tambahan ini untuk memastikan autoCommit kembali ke true
        } catch (SQLException ex1) {
            Logger.getLogger(MasterServiceImpl.class.getName())
                  .log(Level.SEVERE, "Gagal melakukan rollback", ex1);
        }
        Logger.getLogger(MasterServiceImpl.class.getName())
              .log(Level.SEVERE, "Gagal menghapus data siswa", ex);
        return null;  // Mengembalikan null jika operasi gagal
    }
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
    public Pengajar simpanPengajar(Pengajar a) {
 //To change body of generated methods, choose Tools | Templates.
    try {
        // Start transaction
        connection.setAutoCommit(false);
        
        // Validate siswa data before saving
        if (a == null || a.getNama_pengajar() == null || a.getNama_pengajar().trim().isEmpty()) {
            throw new IllegalArgumentException("Data siswa tidak valid");
        }
        
        // Attempt to save
        Pengajar savedPengajar = pengajarDao.simpan(a);
        
        // If successful, commit the transaction
        connection.commit();
        
        return savedPengajar;
        
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

    @Override
    public Pengajar ubahPengajar(Pengajar a) {
       try {
            connection.setAutoCommit(false);
            pengajarDao.ubah(a);
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

        return a;
    }

    @Override
    public Pengajar hapusPengajar(Pengajar a) {
      try {
            connection.setAutoCommit(false);
            pengajarDao.hapus(a);
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
        return a;
    }

    @Override
    public List<Pengajar> getAllPengajar() {
         try {
            return pengajarDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    @Override
    public Mapel simpanMapel(Mapel m) {
        try {
        // Start transaction
        connection.setAutoCommit(false);
        
        // Validate siswa data before saving
        if (m == null || m.getNama_mapel() == null || m.getNama_mapel().trim().isEmpty()) {
            throw new IllegalArgumentException("Data siswa tidak valid");
        }
        
        // Attempt to save
        Mapel savedMapel = MapelDao.simpan(m);
        
        // If successful, commit the transaction
        connection.commit();
        
        return savedMapel;
        
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

    @Override
    public Mapel ubahMapel(Mapel m) {
        try {
            connection.setAutoCommit(false);
            MapelDao.ubah(m);
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

        return m;
    }

    @Override
    public Mapel hapusMapel(Mapel m) {
       try {
            connection.setAutoCommit(false);
            MapelDao.hapus(m);
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
        return m;
    }

    @Override
    public List<Mapel> getAllMapel() {
      try {
            return MapelDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    
    }



}
