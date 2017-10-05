/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.BukuDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Buku;

@WebServlet(urlPatterns = "/buku/ubah")
public class BukuUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.

        try {
            Integer kodeBuku = Integer.valueOf(req.getParameter("kode_buku"));
            Buku sebuahBuku = new BukuDao().findById(kodeBuku);

            req.setAttribute("buku", sebuahBuku);
            req.getRequestDispatcher("/pages/buku/editBuku.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(BukuUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("Post Method");
        Buku buku = new Buku();
        buku.setId(Integer.valueOf(req.getParameter("id")));
        buku.setJudulBuku(req.getParameter("judulBuku"));
        buku.setTahunTerbit(Integer.valueOf(req.getParameter("tahunTerbit")));
        buku.setPengarang(req.getParameter("pengarang"));
        buku.setJumlahBuku(Integer.valueOf((req.getParameter("jumlahBuku"))));

        BukuDao bukuDao = new BukuDao();
        try {
            bukuDao.update(buku);
        } catch (SQLException ex) {
            Logger.getLogger(BukuControler.class.getName()).log(Level.SEVERE, null, ex);
        }
         resp.sendRedirect(req.getServletContext().getContextPath() + "/buku/");
    }
}
