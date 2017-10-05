/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.hadi.perpus.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import model.Buku;
import model.pengunjung;
import model.transaksi;

/**
 *
 * @author USER
 */
public class TransaksiDao {
    public void pinjamBuku(transaksi transaksi) throws SQLException{
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        connection.setAutoCommit(false);
        
        String sql = "insert into perpus.transaksi (buku_id,pengunjung_id,tanggal_pinjam) VALUES (?,?,now())";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,transaksi.getBuku().getId());
        preparedStatement.setInt(2,transaksi.getPengunjung().getId());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
        
        sql="update perpus.buku SET jumlah_buku=? WHERE id=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,transaksi.getBuku().getJumlahBuku()-1);
        preparedStatement.setInt(2,transaksi.getBuku().getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        
        connection.commit();
        connection.close();
    }
    
    public List<transaksi> daftarTransaksi() throws SQLException{ 
       
        
    String sql="SELECT\n" +
    "b.id as id_buku,\n" +
    "b.judul_buku as judul_buku,\n" +
    "b.jumlah_buku as jumlah_buku,\n" +
    "b.tahun_terbit as tahun_terbit,\n"+
    "b.pengarang as nama_pengarang,\n" +
    "p.id as id_pengunjung,\n" +
    "p.nama as nama_pengunjung,\n" +
    "p.alamat as alamat_pengarang,\n" +
    "t.id as id_transaksi,\n" +
    "t.tanggal_pinjam as tanggal_pinjam,\n" +
    "t.tanggal_kembali as tanggal_kembali\n" +
    "FROM perpus.buku b\n" +
    "JOIN perpus.transaksi t on b.id=t.buku_id\n" +
    "JOIN perpus.pengunjung p on t.pengunjung_id=p.id";
    
        
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        List<transaksi> listTransaksi = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            transaksi transaksi = new transaksi();
            
            transaksi.setBuku(new Buku(
                    resultSet.getInt("id_buku"),
                    resultSet.getString("judul_buku"),
                    resultSet.getInt("tahun_terbit"),
                    resultSet.getString("nama_pengarang"),
                    resultSet.getInt("jumlah_buku")));
            
            transaksi.setPengunjung(new pengunjung(
            resultSet.getInt("id_pengunjung"),
            resultSet.getString("nama_pengunjung"),
            resultSet.getString("alamat_pengarang")));
            
            transaksi.setId(resultSet.getInt("id_transaksi"));
            transaksi.setTanggalPinjam(resultSet.getDate("tanggal_pinjam"));
            transaksi.setTanggalKembali(resultSet.getDate("tanggal_kembali"));
            
            listTransaksi.add(transaksi);
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        return listTransaksi;
}
}
    
