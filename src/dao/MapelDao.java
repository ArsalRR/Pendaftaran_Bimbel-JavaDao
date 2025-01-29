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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Mapel;

/**
 *
 * @author ASUS
 */
public class MapelDao {
    private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getAllNameStatement;
    private PreparedStatement getByNameStatement;

    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
        prepareStatements();
    }

    private void prepareStatements() throws SQLException {
        simpanStatement = connection.prepareStatement("INSERT INTO mata_pelajaran (id, nama_mapel, tingkat, biaya) VALUES (?, ?, ?,?)");
        ubahStatement = connection.prepareStatement( "UPDATE mata_pelajaran SET nama_mapel = ?, tingkat = ?, biaya = ? WHERE id = ?");
        hapusStatement = connection.prepareStatement("DELETE FROM mata_pelajaran WHERE id = ?");
        getAllStatement = connection.prepareStatement("SELECT * FROM mata_pelajaran");
        getByIdStatement = connection.prepareStatement("SELECT * FROM mata_pelajaran WHERE id = ?");
        getAllNameStatement = connection.prepareStatement("SELECT nama_mapel FROM mata_pelajaran");
        getByNameStatement = connection.prepareStatement("SELECT * FROM mata_pelajaran WHERE nama_mapel = ?");
    }

public Mapel simpan(Mapel m) throws SQLException {
    simpanStatement = connection.prepareStatement(
        "INSERT INTO mata_pelajaran (nama_mapel, tingkat, biaya) VALUES (?, ?, ?)", 
        PreparedStatement.RETURN_GENERATED_KEYS
    );

    try {
        simpanStatement.setString(1, m.getNama_mapel());
        simpanStatement.setString(2, m.getTingkat());
        simpanStatement.setInt(3, m.getBiaya());  

        int rowsAffected = simpanStatement.executeUpdate();
        if (rowsAffected == 0) {
            throw new SQLException("Gagal menyimpan data mapel!");
        }
        ResultSet rs = simpanStatement.getGeneratedKeys();
        if (rs.next()) {
            m.setId(rs.getInt(1)); 
        }

        return m;
    } catch (SQLException e) {
        throw new SQLException("Error menyimpan mapel: " + e.getMessage(), e);
    }
}

    public Mapel ubah(Mapel m) throws SQLException {
        ubahStatement.setString(1, m.getNama_mapel());
        ubahStatement.setString(2, m.getTingkat());
        ubahStatement.setInt(3, m.getBiaya());
        ubahStatement.setInt(4, m.getId());
        ubahStatement.executeUpdate();
        return m;
    }

    public Mapel hapus(Mapel m) throws SQLException {
        hapusStatement.setInt(1, m.getId());
        hapusStatement.executeUpdate();
        return m;
    }

public List<Mapel> getAll() throws SQLException {
        List<Mapel> result = new ArrayList<>();
        String sql = "SELECT * FROM mata_pelajaran";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Mapel mapel = new Mapel();
                mapel.setId(rs.getInt("id"));
                mapel.setNama_mapel(rs.getString("nama_mapel"));
                mapel.setTingkat(rs.getString("tingkat"));
                mapel.setBiaya(rs.getInt("biaya"));
                result.add(mapel);
            }
            
            return result;
        }
    }

    public Mapel getById(int id) throws SQLException {
        Mapel a = null;
        getByIdStatement.setInt(1, id);
        try (ResultSet rs = getByIdStatement.executeQuery()) {
            if (rs.next()) {
                a = new Mapel();
                a.setId(rs.getInt("id"));
                a.setNama_mapel(rs.getString("nama_mapel"));
                a.setTingkat(rs.getString("tingkat"));
                a.setBiaya(rs.getInt("biaya"));
            }
        }
        return a;
    }

    public String[] getAllName() throws SQLException {
        List<String> names = new ArrayList<>();
        try (ResultSet rs = getAllNameStatement.executeQuery()) {
            while (rs.next()) {
                names.add(rs.getString("nama_mapel"));
            }
        }
        return names.toArray(new String[0]);
    }

    public Mapel getByName(String name) throws SQLException {
        Mapel a = null;
        getByNameStatement.setString(1, name);
        try (ResultSet rs = getByNameStatement.executeQuery()) {
            if (rs.next()) {
                a = new Mapel();
                a.setId(rs.getInt("id"));
                a.setNama_mapel(rs.getString("nama_mapel"));
                a.setTingkat(rs.getString("tingkat"));
                a.setBiaya(rs.getInt("biaya"));
            }
        }
        return a;
    }
   
}
