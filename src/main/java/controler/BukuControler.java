/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Buku;

/**
 *
 * @author USER
 */
@WebServlet(urlPatterns="/buku/new")
public class BukuControler extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        req.getRequestDispatcher("/pages/buku/tambahBuku/tambahBuku.jsp").forward(req, resp);
        System.out.println("Get Method");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("Post Method");
        Buku buku = new Buku();
        buku.setJudulBuku(req.getParameter("judulBuku"));
        buku.setTahunTerbit(Integer.valueOf(req.getParameter("tahunTerbit")));
        buku.setPengarang(req.getParameter("pengarang"));
        buku.setJumlahBuku(Integer.valueOf((req.getParameter("jumlahBuku"))));
        System.out.println(buku.toString());
        
    }
    
}
