/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pengajar;


/**
 *
 * @author ASUS
 */
public class PengajarDao {
        private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getAllNameStatement;
    private PreparedStatement getByNameStatement;

 private final String queryInsert = "INSERT INTO pengajar (id, nama_pengajar, email, no_telp) VALUES (?, ?, ?, ?)";
    private final String queryUpdate = "UPDATE pengajar SET nama_pengajar = ?,email = ?,no_telp = ? WHERE id =?";
    private final String queryDelete = "DELETE FROM pengajar WHERE id = ?";
    private final String querySelectAll = "SELECT * FROM pengajar";
    private final String querySelectById = "SELECT * FROM pengajar WHERE id = ?";
    private final String querySelectAllName = "SELECT nama_pengajar FROM pengajar";
    private final String querySelectByName = "SELECT * FROM pengajar WHERE nama_pengajar =?";

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

public Pengajar simpan(Pengajar a) throws SQLException {
    simpanStatement = connection.prepareStatement(
        "INSERT INTO pengajar (nama_pengajar, email, no_telp) VALUES (?, ?, ?)", 
        PreparedStatement.RETURN_GENERATED_KEYS
    );

    simpanStatement.setString(1, a.getNama_pengajar());
    simpanStatement.setString(2, a.getEmail());
    simpanStatement.setString(3, a.getNo_tlp());

    int rowsAffected = simpanStatement.executeUpdate();
    if (rowsAffected == 0) {
        throw new SQLException("Gagal menyimpan data pengajar!");
    }
    ResultSet rs = simpanStatement.getGeneratedKeys();
    if (rs.next()) {
        a.setId(rs.getInt(1)); 
    }

    return a;
}


public Pengajar ubah(Pengajar a) throws SQLException {
    ubahStatement.setString(1, a.getNama_pengajar());
    ubahStatement.setString(2, a.getEmail());
    ubahStatement.setString(3, a.getNo_tlp()); 
    ubahStatement.setInt(4, a.getId());  
    int rowsAffected = ubahStatement.executeUpdate();

    if (rowsAffected == 0) {
        throw new SQLException("ID pengajar tidak ditemukan! Data harus sudah ada sebelum diubah.");
    }
    
    return a;
}


    public Pengajar hapus(Pengajar a) throws SQLException {
        hapusStatement.setInt(1, a.getId());
        hapusStatement.executeUpdate();
        return a;
    }

    public List<Pengajar> getAll() throws SQLException {
        List<Pengajar> list = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();

        while (rs.next()) {
            Pengajar a = new Pengajar();
            a.setId(rs.getInt("id"));
            a.setNama_pengajar(rs.getString("nama_pengajar"));
            a.setEmail(rs.getString("email"));
            a.setNo_tlp(rs.getString("no_telp"));
            list.add(a);
        }

        return list;
    }

 public Pengajar getById(int id) throws SQLException { // Ubah String ke int
    Pengajar a = new Pengajar();
    
    getByIdStatement.setInt(1, id); // Ubah setString ke setInt
    ResultSet rs = getByIdStatement.executeQuery();
    
    if (rs.next()) { 
        a.setId(rs.getInt("id"));
            a.setNama_pengajar(rs.getString("nama_pengajar"));
            a.setEmail(rs.getString("email"));
            a.setNo_tlp(rs.getString("no_telp"));
    }
    
    return a;
}


    public Object[] getAllName() throws SQLException {
        List<Object> names = new ArrayList<>();
        ResultSet rs = getAllNameStatement.executeQuery();

        while (rs.next()) {
            names.add(rs.getString("nama_siswa"));
        }

        return names.toArray();
    }

  public Pengajar getByName(String name) throws SQLException {
    Pengajar a = new Pengajar();
    
    getByNameStatement.setString(1, name);
    ResultSet rs = getByNameStatement.executeQuery();
    
    if (rs.next()) { // Ubah while ke if
        a.setId(rs.getInt("id"));
            a.setNama_pengajar(rs.getString("nama_pengajar"));
            a.setEmail(rs.getString("email"));
            a.setNo_tlp(rs.getString("no_telp"));
    }
    
    return a;
}

    
}
