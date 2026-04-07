package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import model.Visita;
import model.Reporte;
import util.Conexion;

public class VisitaDAO {

    public boolean registrar(Visita v) {

        boolean estado = false;

        try {
            Connection con = Conexion.getConexion();

            String sql = "INSERT INTO visitas (fecha, nombre, procedencia, motivo, acompanantes) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDate(1, v.getFecha());
            ps.setString(2, v.getNombre());
            ps.setString(3, v.getProcedencia());
            ps.setString(4, v.getMotivo());
            ps.setInt(5, v.getAcompanantes());

            ps.executeUpdate();

            estado = true;

        } catch (Exception e) {
            System.out.println("Error registro: " + e.getMessage());
        }

        return estado;
    }

    public List<Visita> listar() {

        List<Visita> lista = new ArrayList<>();

        try {
            Connection con = Conexion.getConexion();

            String sql = "SELECT * FROM visitas ORDER BY fecha DESC";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Visita v = new Visita();

                v.setFecha(rs.getDate("fecha"));
                v.setNombre(rs.getString("nombre"));
                v.setProcedencia(rs.getString("procedencia"));
                v.setMotivo(rs.getString("motivo"));
                v.setAcompanantes(rs.getInt("acompanantes"));

                lista.add(v);
            }

        } catch (Exception e) {
            System.out.println("Error listar: " + e.getMessage());
        }

        return lista;
    }

    public List<Reporte> reporteMensual() {

        List<Reporte> lista = new ArrayList<>();

        try {
            Connection con = Conexion.getConexion();

            String sql = "SELECT DATE(fecha) as fecha, SUM(acompanantes + 1) as total FROM visitas GROUP BY DATE(fecha) ORDER BY DATE(fecha)";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reporte r = new Reporte();

                r.setFecha(rs.getDate("fecha"));
                r.setTotal(rs.getInt("total"));

                lista.add(r);
            }

        } catch (Exception e) {
            System.out.println("Error reporte: " + e.getMessage());
        }

        return lista;
    }
}