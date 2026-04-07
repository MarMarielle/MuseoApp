package controller;

import java.io.IOException;
import java.util.List;

import dao.VisitaDAO;
import model.Reporte;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/reporte")
public class ReporteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VisitaDAO dao = new VisitaDAO();
        List<Reporte> lista = dao.reporteMensual();

        request.setAttribute("reporte", lista);

        request.getRequestDispatcher("reporte.jsp").forward(request, response);
    }
}