/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.hadi.perpus.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import model.Buku;

/**
 *
 * @author USER
 */
public class BukuDao {
    public void save(Buku buku) throws SQLException{
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource datasource = koneksiDB.getDataSource();
        Connection connection = datasource.getConnection();
           
        String sql ="INSERT INTO perpus.buku(judul_buku,tahun_terbit,pengarang,jumlah_buku) VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        //tempat isi recordnya
        statement.setString(1,buku.getJudulBuku());
        statement.setInt(2,buku.getTahunTerbit());
        statement.setString(3,buku.getPengarang());
        statement.setInt(4,buku.getJumlahBuku());
        
        
        
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void update() {
    }

    public void delete() {
    }

    public List<Buku> findAll() {
        return null;
    }

    public Buku findById(Integer idBuku) {
        return null;
    }
}
