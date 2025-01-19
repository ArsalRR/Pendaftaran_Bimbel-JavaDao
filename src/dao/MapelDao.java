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
        simpanStatement = connection.prepareStatement("INSERT INTO mata_pelajaran (id, nama_mapel, tingkat, biaya) VALUES (?, ?, ?, ?)");
        ubahStatement = connection.prepareStatement("UPDATE mata_pelajaran SET nama_mapel = ?, tingkat = ?, biaya = ? WHERE id = ?");
        hapusStatement = connection.prepareStatement("DELETE FROM mata_pelajaran WHERE id = ?");
        getAllStatement = connection.prepareStatement("SELECT * FROM mata_pelajaran");
        getByIdStatement = connection.prepareStatement("SELECT * FROM mata_pelajaran WHERE id = ?");
        getAllNameStatement = connection.prepareStatement("SELECT nama_mapel FROM mata_pelajaran");
        getByNameStatement = connection.prepareStatement("SELECT * FROM mata_pelajaran WHERE nama_mapel = ?");
    }

    public Mapel simpan(Mapel m) throws SQLException {
        simpanStatement.setInt(1, m.getId());
        simpanStatement.setString(2, m.getNama_mapel());
        simpanStatement.setString(3, m.getTingkat());
        simpanStatement.setInt(4, m.getBiaya());
        simpanStatement.executeUpdate();
        return m;
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
        List<Mapel> list = new ArrayList<>();
        try (ResultSet rs = getAllStatement.executeQuery()) {
            while (rs.next()) {
                Mapel a = new Mapel();
                a.setId(rs.getInt("id"));
                a.setNama_mapel(rs.getString("nama_mapel"));
                a.setTingkat(rs.getString("tingkat"));
                a.setBiaya(rs.getInt("biaya"));
                list.add(a);
            }
        }
        return list;
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
