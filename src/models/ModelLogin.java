package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author EstebanIslas
 */
public class ModelLogin extends Conexion {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    private String usuario;
    private String password;
    private boolean Value;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValue() {
        return Value;
    }

    public void setValue(boolean Value) {
        this.Value = Value;
    }

    public void loguear(String usuario, String contra) {
        try {
            conexion = getConexion();
            ps = conexion.prepareStatement("Select username, password from usuario where username=? AND password=?");
            ps.setString(1, usuario);
            ps.setString(2, contra);
            rs = ps.executeQuery();
            rs.next();
            
            if (usuario.equals(rs.getString("username")) && contra.equals(rs.getString("password"))) {
                JOptionPane.showMessageDialog(null, "Bienvenido!!!");
                Value = true;
            } else {
                JOptionPane.showMessageDialog(null, "Acceso Denegado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Login " + ex.getMessage());
        }
    }

}
