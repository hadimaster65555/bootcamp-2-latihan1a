/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import lombok.Data;

/**
 *
 * @author USER
 */
@Data
public class transaksi {
    private Integer id;
    private Buku buku;
    private pengunjung pengunjung;
    private Date tanggalPinjam;
    private Date tanggalKembali;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Buku getBuku() {
//        return buku;
//    }
//
//    public void setBuku(Buku buku) {
//        this.buku = buku;
//    }
//
//    public pengunjung getPengunjung() {
//        return pengunjung;
//    }
//
//    public void setpengunjung(pengunjung pengunjung) {
//        this.pengunjung = pengunjung;
//    }
//
//    public Date getTanggalPinjam() {
//        return tanggalPinjam;
//    }
//
//    public void setTanggalPinjam(Date tanggalPinjam) {
//        this.tanggalPinjam = tanggalPinjam;
//    }
//
//    public Date getTanggalKembali() {
//        return tanggalKembali;
//    }
//
//    public void setTanggalKembali(Date tanggalKembali) {
//        this.tanggalKembali = tanggalKembali;
//    }
//    
//    
}
