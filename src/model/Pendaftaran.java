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
public class Pendaftaran {
     private int id;
      private String Status_pembayaran;
      private Mapel mapel;
      private Siswa siswa;
      private Pengajar pengajar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus_pembayaran() {
        return Status_pembayaran;
    }

    public void setStatus_pembayaran(String Status_pembayaran) {
        this.Status_pembayaran = Status_pembayaran;
    }

    public Mapel getMapel() {
        return mapel;
    }

    public void setMapel(Mapel mapel) {
        this.mapel = mapel;
    }

    public Siswa getSiswa() {
        return siswa;
    }

    public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
    }

    public Pengajar getPengajar() {
        return pengajar;
    }

    public void setPengajar(Pengajar pengajar) {
        this.pengajar = pengajar;
    }
      
}
