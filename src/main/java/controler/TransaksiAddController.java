/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.BukuDao;
import dao.PengunjungDao;
import dao.TransaksiDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Buku;
import model.pengunjung;
import model.transaksi;

/**
 *
 * @author USER
 */
@WebServlet(urlPatterns="/transaksi/pinjam")
public class TransaksiAddController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.

        try {
            List<Buku> listBuku;
            listBuku = new BukuDao().findAll();
            List<pengunjung> listpengunjung = new PengunjungDao().findAll();

            req.setAttribute("listBuku", listBuku);
            req.setAttribute("listPengunjung", listpengunjung);
             req.getRequestDispatcher("/pages/transaksi/addTransaksi.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiAddController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
            transaksi transaksi = new transaksi();


            
        try {
            Integer bukuId = Integer.valueOf(req.getParameter("bukuId"));
            transaksi.setBuku(new BukuDao().findById(bukuId));
//            Buku buku = new BukuDao().findById(bukuId);
            Integer pengunjungId = Integer.valueOf(req.getParameter("pengunjungId"));
            transaksi.setPengunjung(new PengunjungDao().findById(pengunjungId));
            new TransaksiDao().pinjamBuku(transaksi);
            
            resp.sendRedirect(req.getServletContext().getContextPath()+"/transaksi/list");

        } catch (SQLException ex) {
            Logger.getLogger(TransaksiAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    
}
