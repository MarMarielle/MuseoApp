package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Usuario;
import util.Conexion;

public class UsuarioDAO {

	public Usuario login(String username, String password) {

	    Usuario user = null;

	    try {
	        Connection con = Conexion.getConexion();

	        System.out.println("Usuario recibido: " + username);
	        System.out.println("Password recibido: " + password);

	        String sql = "SELECT * FROM usuarios WHERE username=? AND password=?";
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, username);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            System.out.println("Usuario encontrado en BD");

	            user = new Usuario();
	            user.setUsername(rs.getString("username"));
	            user.setPassword(rs.getString("password"));
	        } else {
	            System.out.println("Usuario NO encontrado en BD");
	        }

	    } catch (Exception e) {
	        System.out.println("Error login: " + e.getMessage());
	    }

	    return user;
	}
}