package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.VisitaDAO;
import model.Reporte;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/excel")
public class ExcelServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=reporte.xls");

        PrintWriter out = response.getWriter();

        VisitaDAO dao = new VisitaDAO();
        List<Reporte> lista = dao.reporteMensual();

        out.println("Fecha\tTotal");

        for (Reporte r : lista) {
            out.println(r.getFecha() + "\t" + r.getTotal());
        }

        out.close();
    }
}