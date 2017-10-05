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
import javax.sql.DataSource;
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
    
    
}
