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
public class Pengajar {
           private int id;
    private String Nama_pengajar;
    private String Email;
    private String No_tlp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_pengajar() {
        return Nama_pengajar;
    }

    public void setNama_pengajar(String Nama_pengajar) {
        this.Nama_pengajar = Nama_pengajar;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNo_tlp() {
        return No_tlp;
    }

    public void setNo_tlp(String No_tlp) {
        this.No_tlp = No_tlp;
    }
    
}
