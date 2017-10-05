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
import model.pengunjung;

/**
 *
 * @author USER
 */
public class PengunjungDao {
    public List<pengunjung> findAll() throws SQLException{
        List<pengunjung> listpengunjung = new ArrayList<>();
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="SELECT id, nama, alamat FROM perpus.pengunjung";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            pengunjung pengunjung = new pengunjung();
            pengunjung.setId(resultSet.getInt("id"));
            pengunjung.setNama(resultSet.getString("alamat"));
            pengunjung.setAlamat(resultSet.getString("alamat"));
            listpengunjung.add(pengunjung);
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        
        return listpengunjung;
    }
    
    public void save(pengunjung x){
        
    }
    
    public void update(pengunjung x){
        
    }
    public void hapus(Integer id){
        
    }

    public pengunjung findById(Integer pengunjungId) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="SELECT id, nama, alamat FROM perpus.pengunjung WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pengunjungId);
        ResultSet resultSet = statement.executeQuery();
        pengunjung pengunjung = new pengunjung();
        if(resultSet.next()){
            
            pengunjung.setId(resultSet.getInt("id"));
            pengunjung.setNama(resultSet.getString("alamat"));
            pengunjung.setAlamat(resultSet.getString("alamat"));
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        
        return pengunjung;
    }
}
