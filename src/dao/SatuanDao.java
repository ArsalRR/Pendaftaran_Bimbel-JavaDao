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
import model.Satuan;

/**
 *
 * @author deirn
 */
public class SatuanDao {

    private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getAllNameStatement;
    private PreparedStatement getByNameStatement;
    
    private final String queryInsert = "INSERT INTO satuan (id_satuan, nama) VALUES (?,?)";
    private final String queryUpdate = "UPDATE satuan SET nama=? WHERE id_satuan=?";
    private final String queryDelete = "DELETE FROM satuan WHERE id_satuan=?";
    private final String querySelectAll = "SELECT * FROM satuan";
    private final String querySelectById = "SELECT * from satuan WHERE id_satuan=?";
    private final String querySelectAllName = "SELECT nama from satuan";
    private final String querySelectByName = "SELECT * from satuan WHERE nama=?";

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

    public Satuan simpan(Satuan s) throws SQLException {
        simpanStatement.setString(1, s.getId());
        simpanStatement.setString(2, s.getNama());
        simpanStatement.executeUpdate();
        return s;
    }

    public Satuan ubah(Satuan s) throws SQLException {
        ubahStatement.setString(1, s.getNama());
        ubahStatement.setString(2, s.getId());
        ubahStatement.executeUpdate();
        return s;
    }

    public Satuan hapus(Satuan s) throws SQLException {
        hapusStatement.setString(1, s.getId());
        hapusStatement.executeUpdate();
        return s;
    }

    public List<Satuan> getAll() throws SQLException {
        List<Satuan> list = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();

        while (rs.next()) {
            Satuan s = new Satuan();
            s.setId(rs.getString("id_satuan"));
            s.setNama(rs.getString("nama"));
            list.add(s);
        }

        return list;
    }

    public Satuan getById(String id) throws SQLException {
        Satuan s = new Satuan();
        
        getByIdStatement.setString(1, id);
        ResultSet rs = getByIdStatement.executeQuery();

        while (rs.next()) {
            s.setId(rs.getString("id_satuan"));
            s.setNama(rs.getString("nama"));
        }

        return s;
    }
    
    public Object[] getAllName() throws SQLException{
        Object[] name = new Object[] {};
        ArrayList<Object> newObj = new ArrayList<>();
        ResultSet rs = getAllNameStatement.executeQuery();
        while(rs.next()){
            newObj.add(rs.getString("nama"));
        }
        return newObj.toArray();
    }
    
    public Satuan getByName(String name) throws SQLException {
        Satuan s = new Satuan();
        
        getByNameStatement.setString(1, name);
        ResultSet rs = getByNameStatement.executeQuery();
        while (rs.next()) {
            s.setId(rs.getString("id_satuan"));
            s.setNama(rs.getString("nama"));
        }
        return s;
    }

}
