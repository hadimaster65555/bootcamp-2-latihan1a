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

    public void update(Buku buku) throws SQLException {
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource datasource = koneksiDB.getDataSource();
        Connection connection = datasource.getConnection();
           
        String sql ="update perpus.buku set judul_buku=?, pengarang=?,jumlah_buku=?,tahun_terbit=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        //tempat isi recordnya
        statement.setString(1,buku.getJudulBuku());
        statement.setInt(4,buku.getTahunTerbit());
        statement.setString(2,buku.getPengarang());
        statement.setInt(3,buku.getJumlahBuku());
        statement.setInt(5,buku.getId());
        
        
        
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void delete(Integer idBuku) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="delete from perpus.buku where id=?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1,idBuku);
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public List<Buku> findAll() throws SQLException {
        List<Buku> listBuku = new ArrayList<>();
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="select id,judul_buku,tahun_terbit,pengarang,jumlah_buku from perpus.buku";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Buku buku = new Buku();
            //inputkan informasi
            buku.setId(resultSet.getInt("id"));
            buku.setJudulBuku(resultSet.getString("judul_buku"));
            buku.setTahunTerbit(resultSet.getInt("tahun_terbit"));
            buku.setPengarang(resultSet.getString("pengarang"));
            buku.setJumlahBuku(resultSet.getInt("jumlah_buku"));
            //hasi; input dimasukkan kedalam variabel listBuku
            listBuku.add(buku);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return listBuku;
    }

    public Buku findById(Integer idBuku) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="select id,judul_buku,tahun_terbit,pengarang,jumlah_buku from perpus.buku where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idBuku);
        ResultSet resultSet = statement.executeQuery();
        Buku buku = new Buku();

        if (resultSet.next()){
            
            //inputkan informasi
            buku.setId(resultSet.getInt("id"));
            buku.setJudulBuku(resultSet.getString("judul_buku"));
            buku.setTahunTerbit(resultSet.getInt("tahun_terbit"));
            buku.setPengarang(resultSet.getString("pengarang"));
            buku.setJumlahBuku(resultSet.getInt("jumlah_buku"));
            //hasi; input dimasukkan kedalam variabel listBuku
        }
        resultSet.close();
        statement.close();
        connection.close();
        return buku;
        
    }
}
