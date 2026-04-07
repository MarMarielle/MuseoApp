package controller;

import java.io.IOException;
import java.sql.Date;

import dao.VisitaDAO;
import model.Visita;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/registrarVisita")
public class VisitaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Visita v = new Visita();

            v.setFecha(Date.valueOf(request.getParameter("fecha")));
            v.setNombre(request.getParameter("nombre"));
            v.setProcedencia(request.getParameter("procedencia"));
            v.setMotivo(request.getParameter("motivo"));
            v.setAcompanantes(Integer.parseInt(request.getParameter("acompanantes")));

            VisitaDAO dao = new VisitaDAO();

            if (dao.registrar(v)) {
                response.sendRedirect("menu.jsp?ok=1");
            } else {
                response.sendRedirect("registro.jsp?error=1");
            }

        } catch (Exception e) {
            response.sendRedirect("registro.jsp?error=1");
        }
    }
}