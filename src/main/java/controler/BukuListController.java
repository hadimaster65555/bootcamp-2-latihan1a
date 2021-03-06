/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.BukuDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Buku;

@WebServlet(urlPatterns = {"/buku/list", "/buku/"})
public class BukuListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
     List<Buku> listBuku;
        try {
            listBuku = new BukuDao().findAll();
            req.setAttribute("listBuku", listBuku);
        } catch (SQLException ex) {
            Logger.getLogger(BukuListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
//        Buku buku = new Buku();
//        buku.setId(1);
//        buku.setJudulBuku("Java Programming");
//        buku.setJumlahBuku(10);
//        buku.setTahunTerbit(2017);
//        buku.setPengarang("Siswanto");
////        System.out.println(buku.toString());
//        listBuku.add(buku);
//
//        buku = new Buku();
//        buku.setId(2);
//        buku.setJudulBuku("Java Programmming Part 2");
//        buku.setJumlahBuku(20);
//        buku.setTahunTerbit(2015);
//        buku.setPengarang("Siswanto");
//        System.out.println(buku.toString());
//        listBuku.add(buku);

       

        req.getRequestDispatcher("/pages/buku/listBuku.jsp").forward(req, resp);
    }

}
