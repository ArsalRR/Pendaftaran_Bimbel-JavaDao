/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Siswa;

/**
 *
 * @author ICHWAN F
 */
public class SiswaDao {
    private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getAllNameStatement;
    private PreparedStatement getByNameStatement;

 private final String queryInsert = "INSERT INTO siswa (id, nama_siswa, alamat, jenis_kelamin, no_telp) VALUES (?, ?, ?, ?, ?)";
    private final String queryUpdate = "UPDATE siswa SET nama_siswa = ?, alamat = ?, jenis_kelamin = ?, no_telp = ? WHERE id = ?";
    private final String queryDelete = "DELETE FROM siswa WHERE id = ?";
    private final String querySelectAll = "SELECT * FROM siswa";
    private final String querySelectById = "SELECT * FROM siswa WHERE id = ?";
    private final String querySelectAllName = "SELECT nama_siswa FROM siswa";
    private final String querySelectByName = "SELECT * FROM siswa WHERE nama_siswa = ?";

    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;

        simpanStatement = connection.prepareStatement(queryInsert);
        ubahStatement = connection.prepareStatement(queryUpdate);
        hapusStatement = connection.prepareStatement(queryDelete);
        getAllStatement = connection.prepareStatement(querySelectAll);
        getByIdStatement = connection.prepareStatement(querySelectById);
        getAllNameStatement = connection.prepareStatement(querySelectAllName);
        getByNameStatement = connection.prepareStatement(querySelectByName);
    }

 public Siswa simpan(Siswa s) throws SQLException {
    simpanStatement.setInt(1, s.getId());
    simpanStatement.setString(2, s.getNama_siswa());
    simpanStatement.setString(3, s.getAlamat());
    simpanStatement.setString(4, s.getJenis_kelamin());
    simpanStatement.setString(5, s.getNo_tlp()); // Ubah dari 6 ke 5
    simpanStatement.executeUpdate();
    return s;
}


public Siswa ubah(Siswa s) throws SQLException {
    ubahStatement.setString(1, s.getNama_siswa());
    ubahStatement.setString(2, s.getAlamat());
    ubahStatement.setString(3, s.getJenis_kelamin());
    ubahStatement.setString(4, s.getNo_tlp()); 
     ubahStatement.setInt(5, s.getId());  
    ubahStatement.executeUpdate();
    return s;
}


    public Siswa hapus(Siswa s) throws SQLException {
        hapusStatement.setInt(1, s.getId());
        hapusStatement.executeUpdate();
        return s;
    }

    public List<Siswa> getAll() throws SQLException {
        List<Siswa> list = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();

        while (rs.next()) {
            Siswa s = new Siswa();
            s.setId(rs.getInt("id"));
            s.setNama_siswa(rs.getString("nama_siswa"));
            s.setAlamat(rs.getString("alamat"));
            s.setJenis_kelamin(rs.getString("jenis_kelamin"));
            s.setNo_tlp(rs.getString("no_telp"));
            list.add(s);
        }

        return list;
    }

 public Siswa getById(int id) throws SQLException { // Ubah String ke int
    Siswa s = new Siswa();
    
    getByIdStatement.setInt(1, id); // Ubah setString ke setInt
    ResultSet rs = getByIdStatement.executeQuery();
    
    if (rs.next()) { // Ubah while ke if karena ID harusnya unique
        s.setId(rs.getInt("id"));
        s.setNama_siswa(rs.getString("nama_siswa"));
        s.setAlamat(rs.getString("alamat"));
        s.setJenis_kelamin(rs.getString("jenis_kelamin"));
        s.setNo_tlp(rs.getString("no_telp"));
    }
    
    return s;
}


    public Object[] getAllName() throws SQLException {
        List<Object> names = new ArrayList<>();
        ResultSet rs = getAllNameStatement.executeQuery();

        while (rs.next()) {
            names.add(rs.getString("nama_siswa"));
        }

        return names.toArray();
    }

  public Siswa getByName(String name) throws SQLException {
    Siswa s = new Siswa();
    
    getByNameStatement.setString(1, name);
    ResultSet rs = getByNameStatement.executeQuery();
    
    if (rs.next()) { // Ubah while ke if
        s.setId(rs.getInt("id"));
        s.setNama_siswa(rs.getString("nama_siswa"));
        s.setAlamat(rs.getString("alamat"));
        s.setJenis_kelamin(rs.getString("jenis_kelamin"));
        s.setNo_tlp(rs.getString("no_telp"));
    }
    
    return s;
}

}
