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
import model.Produk;

/**
 *
 * @author deirn
 */
public class ProdukDao {

    private SatuanDao satuanDao;

    private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;

    private final String queryInsert = "INSERT INTO produk (id_produk, nama, harga_jual, harga_pokok, stok, id_satuan) VALUES (?,?,?,?,?,?)";
    private final String queryUpdate = "UPDATE produk SET nama=?,harga_jual=?,harga_pokok=?,stok=?,id_satuan=? WHERE id_produk=?";
    private final String queryDelete = "DELETE FROM produk WHERE id_produk=?";
    private final String querySelectAll = "SELECT * FROM produk";
    private final String querySelectById = "SELECT * from produk WHERE id_produk=?";

    public void setConnection(Connection connection, SatuanDao satuanDao) throws SQLException {
        this.connection = connection;
        this.satuanDao = satuanDao;

        simpanStatement = connection.prepareStatement(queryInsert);
        ubahStatement = connection.prepareStatement(queryUpdate);
        hapusStatement = connection.prepareStatement(queryDelete);
        getAllStatement = connection.prepareStatement(querySelectAll);
        getByIdStatement = connection.prepareStatement(querySelectById);
    }

    public Produk simpan(Produk p) throws SQLException {
        simpanStatement.setString(1, p.getId());
        simpanStatement.setString(2, p.getNama());
        simpanStatement.setDouble(3, p.getHargaJual());
        simpanStatement.setDouble(4, p.getHargaPokok());
        simpanStatement.setInt(5, p.getStok());
        simpanStatement.setString(6, p.getSatuan().getId());
        simpanStatement.executeUpdate();
        return p;
    }

    public Produk ubah(Produk p) throws SQLException {
        ubahStatement.setString(1, p.getNama());
        ubahStatement.setDouble(2, p.getHargaJual());
        ubahStatement.setDouble(3, p.getHargaPokok());
        ubahStatement.setInt(4, p.getStok());
        ubahStatement.setString(5, p.getSatuan().getId());
        ubahStatement.setString(6, p.getId());
        ubahStatement.executeUpdate();
        return p;
    }

    public Produk hapus(Produk p) throws SQLException {
        hapusStatement.setString(1, p.getId());
        hapusStatement.executeUpdate();
        return p;
    }

    public List<Produk> getAll() throws SQLException {
        List<Produk> list = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();

        while (rs.next()) {
            Produk p = new Produk();
            p.setId(rs.getString("id_produk"));
            p.setNama(rs.getString("nama"));
            p.setHargaJual(rs.getDouble("harga_jual"));
            p.setHargaPokok(rs.getDouble("harga_pokok"));
            p.setStok(rs.getInt("stok"));
            p.setSatuan(satuanDao.getById(rs.getString("id_satuan")));
            list.add(p);
        }

        return list;
    }

    public Produk getById(String id) throws SQLException {
        Produk p = new Produk();

        getByIdStatement.setString(1, id);
        ResultSet rs = getByIdStatement.executeQuery();

        while (rs.next()) {
            p.setId(rs.getString("id_produk"));
            p.setNama(rs.getString("nama"));
            p.setHargaJual(rs.getDouble("harga_jual"));
            p.setHargaPokok(rs.getDouble("harga_pokok"));
            p.setStok(rs.getInt("stok"));
            p.setSatuan(satuanDao.getById(rs.getString("id_satuan")));
        }

        return p;
    }

    public void setConnection(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
