package controller;

import java.io.IOException;
import java.util.List;

import dao.VisitaDAO;
import model.Visita;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/historial")
public class HistorialServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VisitaDAO dao = new VisitaDAO();
        List<Visita> lista = dao.listar();

        request.setAttribute("visitas", lista);

        request.getRequestDispatcher("historial.jsp").forward(request, response);
    }
}