/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Mapel;
import model.Pendaftaran;
import model.Pengajar;
import model.Siswa;

/**
 *
 * @author deirn
 */
public interface MasterService {
    
    // Siswa
    Siswa simpanSiswa(Siswa s);
    Siswa ubahSiswa(Siswa s);
    Siswa hapusSiswa(Siswa s);
    List<Siswa> getAllSiswa();
    
    // Pengajar
    Pengajar simpanPengajar(Pengajar a);
    Pengajar ubahPengajar(Pengajar a);
    Pengajar hapusPengajar(Pengajar a);
    List<Pengajar> getAllPengajar();
    
   //Mapel
     Mapel simpanMapel(Mapel m);
    Mapel ubahMapel(Mapel m);
    Mapel hapusMapel(Mapel m);
    List<Mapel> getAllMapel();
    
    //Pendaftaran
      Pendaftaran simpanPendaftaran(Pendaftaran p);
    Pendaftaran ubahPendaftaran(Pendaftaran p);
    Pendaftaran hapusPendaftaran(Pendaftaran p);
    List<Pendaftaran> getAllPendaftaran();
    Pendaftaran getByIdPendaftaran(String id);
    List<Pendaftaran> findPendaftaranByName(String nama);

    public Siswa getByNameSiswa(String toString);

    public Mapel getByNameMapel(String toString);

    public Pengajar getByNamePengajar(String toString);

}
