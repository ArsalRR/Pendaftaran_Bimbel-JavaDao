/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



/**
 *
 * @author ASUS
 */
public class Siswa {
        private int id;
    private String Nama_siswa;
    private String Alamat;
    private String No_tlp;
 private String Jenis_kelamin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_siswa() {
        return Nama_siswa;
    }

    public void setNama_siswa(String Nama_siswa) {
        this.Nama_siswa = Nama_siswa;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getNo_tlp() {
        return No_tlp;
    }

    public void setNo_tlp(String No_tlp) {
        this.No_tlp = No_tlp;
    }

    public String getJenis_kelamin() {
        return Jenis_kelamin;
    }

    public void setJenis_kelamin(String Jenis_kelamin) {
        this.Jenis_kelamin = Jenis_kelamin;
    }
 
}
