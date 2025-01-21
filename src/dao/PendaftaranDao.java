package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pendaftaran;

public class PendaftaranDao {
     private SiswaDao siswaDao;
      private MapelDao mapelDao;
       private PengajarDao pengajarDao;
    private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;

    private final String queryInsert = "INSERT INTO pendaftaran (id, id_siswa, id_mapel, id_pengajar, status_pembayaran) VALUES (?, ?, ?, ?, ?)";
    private final String queryUpdate = "UPDATE pendaftaran SET id_siswa=?, id_mapel=?, id_pengajar=?, status_pembayaran=? WHERE id=?";
    private final String queryDelete = "DELETE FROM pendaftaran WHERE id=?";
    private final String querySelectAll = "SELECT * FROM pendaftaran";
    private final String querySelectById = "SELECT * FROM pendaftaran WHERE id=?";

    public void setConnection(Connection connection, SiswaDao siswaDao, MapelDao mapeldao, PengajarDao pengajarDao ) throws SQLException {
        this.connection = connection;
         this.siswaDao = siswaDao;
          this.mapelDao = mapelDao;
           this.pengajarDao = pengajarDao;
        simpanStatement = connection.prepareStatement(queryInsert);
        ubahStatement = connection.prepareStatement(queryUpdate);
        hapusStatement = connection.prepareStatement(queryDelete);
        getAllStatement = connection.prepareStatement(querySelectAll);
        getByIdStatement = connection.prepareStatement(querySelectById);
    }

 public Pendaftaran simpan(Pendaftaran p) throws SQLException {
    simpanStatement.setInt(1, p.getId());
    simpanStatement.setInt(2, p.getSiswa().getId());
    simpanStatement.setInt(3, p.getMapel().getId());
    simpanStatement.setInt(4, p.getPengajar().getId());
    simpanStatement.setString(5, p.getStatus_pembayaran());
    simpanStatement.executeUpdate();
    return p;
}


    public Pendaftaran ubah(Pendaftaran p) throws SQLException {
      ubahStatement.setInt(1, p.getId());
    ubahStatement.setInt(2, p.getSiswa().getId());
    ubahStatement.setInt(3, p.getMapel().getId());
    ubahStatement.setInt(4, p.getPengajar().getId());
    ubahStatement.setString(5, p.getStatus_pembayaran());
    ubahStatement.executeUpdate();
        return p;
    }

    public Pendaftaran hapus(Pendaftaran p) throws SQLException {
        hapusStatement.setInt(1, p.getId());
        hapusStatement.executeUpdate();
        return p;
    }

 public List<Pendaftaran> getAll() throws SQLException {
    List<Pendaftaran> list = new ArrayList<>();
    ResultSet rs = getAllStatement.executeQuery();
    while (rs.next()) {
        Pendaftaran p = new Pendaftaran();
        p.setId(rs.getInt("id"));
     p.setSiswa(siswaDao.getById(rs.getInt("id_siswa")));
       p.setMapel(mapelDao.getById(rs.getInt("id_mapel")));
        p.setPengajar(pengajarDao.getById(rs.getInt("id_pengajar")));
        p.setStatus_pembayaran(rs.getString("status_pembayaran"));
        list.add(p);
    }
    return list;
}


    public Pendaftaran getById(String id) throws SQLException {
        Pendaftaran p = null;
        getByIdStatement.setString(1, id);
        ResultSet rs = getByIdStatement.executeQuery();
        if (rs.next()) {
            p = new Pendaftaran();
              p.setId(rs.getInt("id"));
     p.setSiswa(siswaDao.getById(rs.getInt("id_siswa")));
       p.setMapel(mapelDao.getById(rs.getInt("id_mapel")));
        p.setPengajar(pengajarDao.getById(rs.getInt("id_pengajar")));
        p.setStatus_pembayaran(rs.getString("status_pembayaran"));
        }
        return p;
    }
}
