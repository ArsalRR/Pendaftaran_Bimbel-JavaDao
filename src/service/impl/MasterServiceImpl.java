package service.impl;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import config.Koneksi;
import dao.MapelDao;
import dao.PendaftaranDao;
import dao.SiswaDao;
import dao.PengajarDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.Mapel;
import model.Pendaftaran;
import model.Pengajar;
import model.Siswa;
import service.MasterService;

public class MasterServiceImpl implements MasterService {

    private SiswaDao siswaDao;
    private MapelDao mapelDao;
    private PengajarDao pengajarDao;
    private Pendaftaran pendaftaran;
    private Koneksi koneksi;
    private PendaftaranDao pendaftaranDao;
    private Connection connection;

    public MasterServiceImpl() {
        try {
            koneksi = new Koneksi();
            connection = koneksi.getConnection();
            
            siswaDao = new SiswaDao();
            siswaDao.setConnection(connection);
              mapelDao = new MapelDao();
            mapelDao.setConnection(connection);
              pengajarDao = new PengajarDao();
            pengajarDao.setConnection(connection);
             pendaftaranDao = new PendaftaranDao();
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
        Mapel savedMapel = mapelDao.simpan(m);
        
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
            mapelDao.ubah(m);
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
            mapelDao.hapus(m);
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
            return mapelDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }


    @Override

public Pendaftaran simpanPendaftaran(Pendaftaran p) {
    try {
        connection.setAutoCommit(false);
        
        // Validate pendaftaran data
        if (p == null || p.getSiswa() == null || p.getMapel() == null || 
            p.getPengajar() == null || p.getStatus_pembayaran() == null) {
            throw new IllegalArgumentException("Data pendaftaran tidak lengkap");
        }
        
        Pendaftaran savedPendaftaran = pendaftaranDao.simpan(p);
        connection.commit();
        return savedPendaftaran;
        
    } catch (SQLException ex) {
        handleTransactionException(ex, "menyimpan");
        throw new RuntimeException("Gagal menyimpan data pendaftaran", ex);
    } finally {
        resetAutoCommit();
    }
}

@Override
public Pendaftaran ubahPendaftaran(Pendaftaran p) {
    try {
        connection.setAutoCommit(false);
        
        // Validate pendaftaran data
        if (p == null || p.getId() == 0) {
            throw new IllegalArgumentException("Data pendaftaran tidak valid");
        }
        
        Pendaftaran updatedPendaftaran = pendaftaranDao.ubah(p);
        connection.commit();
        return updatedPendaftaran;
        
    } catch (SQLException ex) {
        handleTransactionException(ex, "mengubah");
        throw new RuntimeException("Gagal mengubah data pendaftaran", ex);
    } finally {
        resetAutoCommit();
    }
}

@Override
public Pendaftaran hapusPendaftaran(Pendaftaran p) {
    try {
        connection.setAutoCommit(false);
        
        if (p == null || p.getId() == 0) {
            throw new IllegalArgumentException("Data pendaftaran tidak valid");
        }
        
        Pendaftaran deletedPendaftaran = pendaftaranDao.hapus(p);
        connection.commit();
        return deletedPendaftaran;
        
    } catch (SQLException ex) {
        handleTransactionException(ex, "menghapus");
        throw new RuntimeException("Gagal menghapus data pendaftaran", ex);
    } finally {
        resetAutoCommit();
    }
}

@Override
public List<Pendaftaran> getAllPendaftaran() {
    try {
        return pendaftaranDao.getAll();
    } catch (SQLException ex) {
        Logger.getLogger(MasterServiceImpl.class.getName())
              .log(Level.SEVERE, "Error saat mengambil semua data pendaftaran", ex);
        throw new RuntimeException("Gagal mengambil data pendaftaran", ex);
    }
}

@Override
public Pendaftaran getByIdPendaftaran(String id) {
    try {
        return pendaftaranDao.getById(id);
    } catch (SQLException ex) {
        Logger.getLogger(MasterServiceImpl.class.getName())
              .log(Level.SEVERE, "Error saat mengambil data pendaftaran by ID", ex);
        throw new RuntimeException("Gagal mengambil data pendaftaran", ex);
    }
}

@Override
public List<Pendaftaran> findPendaftaranByName(String nama) {
    try {
        List<Pendaftaran> allPendaftaran = pendaftaranDao.getAll();
        return allPendaftaran.stream()
                .filter(p -> p.getSiswa().getNama_siswa().toLowerCase().contains(nama.toLowerCase()))
                .collect(Collectors.toList());
    } catch (SQLException ex) {
        Logger.getLogger(MasterServiceImpl.class.getName())
              .log(Level.SEVERE, "Error saat mencari pendaftaran by nama", ex);
        throw new RuntimeException("Gagal mencari data pendaftaran", ex);
    }
}

// Helper methods for exception handling
private void handleTransactionException(SQLException ex, String operation) {
    try {
        connection.rollback();
        Logger.getLogger(MasterServiceImpl.class.getName())
              .log(Level.SEVERE, "Error saat " + operation + " pendaftaran: " + ex.getMessage(), ex);
    } catch (SQLException rollbackEx) {
        Logger.getLogger(MasterServiceImpl.class.getName())
              .log(Level.SEVERE, "Error saat rollback: " + rollbackEx.getMessage(), rollbackEx);
    }
}


private void resetAutoCommit() {
    try {
        connection.setAutoCommit(true);
    } catch (SQLException ex) {
        Logger.getLogger(MasterServiceImpl.class.getName())
              .log(Level.WARNING, "Error saat reset auto-commit", ex);
    }
}

    @Override
    public Pendaftaran handleTransactionException(Pendaftaran p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pendaftaran resetAutoCommit(Pendaftaran p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 




}
