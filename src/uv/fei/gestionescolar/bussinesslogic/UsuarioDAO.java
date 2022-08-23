/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.gestionescolar.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uv.fei.gestionescolar.dataaccess.DataBaseConnection;
import uv.fei.gestionescolar.domain.Usuario;
/**
 *
 * @author oscar
 */
public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public Usuario obtenerUsuarioPorNombreDeUsuarioYContraseña(String nombreDeUsuario, String contraseña) throws SQLException {
        Usuario usuarioEncontrado = new Usuario();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try (Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "select * from usuario natural join  rolusuario natural join rol where nombreusuario = ? and contraseña = sha2(?,256);";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, nombreDeUsuario);
            statement.setString(2, contraseña);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException("No se encontraron coincidencias con las credenciales proporcionadas");
            }
            else {
                int idRol = 0;
                String matricula = "";
                int numeroDePersonal = 0;
                String nombreRol = "";
                idRol = resultSet.getInt("idRol");
                matricula = resultSet.getString("matricula");
                numeroDePersonal = resultSet.getInt("numeroPersonal");
                nombreRol = resultSet.getString("nombreRol");
                usuarioEncontrado.setIdRol(idRol);
                usuarioEncontrado.setNumeroDePersonal(numeroDePersonal);
                usuarioEncontrado.setNombreRol(nombreRol);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            String mensajeDeError = ex.getMessage();
            if (!ex.getMessage().equals("No se encontraron coincidencias con el nombre de usuario proporcionado")) {
                mensajeDeError = ex.getMessage();
            }
            throw new SQLException (mensajeDeError);
        }
        return usuarioEncontrado;
    }
    public boolean registrarUsuarioAlumno(Usuario usuarioRegistrado)throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = null;
        boolean registroRealizado= false;
        int columnasAfectadas = 0;
        try {
            connection = dataBaseConnection.getConnection();
            String query = "Insert into usuario(nombreUsuario, contraseña, matricula ) values (?, sha2(?,256), ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usuarioRegistrado.getNombreDeUsuario());
            statement.setString(2, usuarioRegistrado.getContraseña());
            statement.setString(3, usuarioRegistrado.getMatricula());
            columnasAfectadas = statement.executeUpdate();
            if(columnasAfectadas == 0){
                throw new SQLException ("Revise los datos ingresados");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(AcademicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            String mensajeDeError = ex.getMessage();
            if (!ex.getMessage().equals("Revise los datos ingresados")) {
                mensajeDeError = "No hay conexión a la base de datos";
            }
            throw new SQLException (mensajeDeError);
        }
        finally {
            dataBaseConnection.cerrarConexion();
        } 
        if (columnasAfectadas > 0) {
            registroRealizado = true;
        }
        return registroRealizado;   
    }
    
    public int obtenerIdUsuario(Usuario usuario) throws SQLException{
        int idUsuario = 0;
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try (Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "select idUsuario from usuario where nombreusuario = ?;"; 
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, usuario.getNombreDeUsuario());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException("No se encontraron coincidencias con el nombre de usuario proporcionado");
            } else{
                idUsuario = resultSet.getInt("idUsuario");
            }
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            String mensajeDeError = ex.getMessage();
            if (!ex.getMessage().equals("No se encontraron coincidencias con el nombre de usuario proporcionado")) {
                mensajeDeError = "No hay conexión a la base de datos";
            }
            throw new SQLException (mensajeDeError);
        }
        return idUsuario;
    }
    public boolean registrarUsuarioAcademico(Usuario usuarioRegistrado)throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = null;
        boolean registroRealizado= false;
        int columnasAfectadas = 0;
        try {
            connection = dataBaseConnection.getConnection();
            String query = "Insert into usuario(numeroPersonal, nombreUsuario, contraseña ) values (?, ?, sha2(?,256))";
            PreparedStatement statement = connection.prepareStatement(query); 
            statement.setInt(1, usuarioRegistrado.getNumeroDePersonal());
            statement.setString(2, usuarioRegistrado.getNombreDeUsuario());
            statement.setString(3, usuarioRegistrado.getContraseña());
            columnasAfectadas = statement.executeUpdate();
            if(columnasAfectadas == 0){
                throw new SQLException ("Revise los datos ingresados");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(AcademicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            String mensajeDeError = ex.getMessage();
            if (!ex.getMessage().equals("Revise los datos ingresados")) {
                mensajeDeError = "No hay conexión a la base de datos";
            }
            throw new SQLException (mensajeDeError);
        }
        finally {
            dataBaseConnection.cerrarConexion();
        } 
        if (columnasAfectadas > 0) {
            registroRealizado = true;
        }
        return registroRealizado;   
    }
    public boolean asignarUsuarioRol (int idUsuario, int idRol) throws SQLException{
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = null;
        boolean registroRealizado= false;
        int columnasAfectadas = 0;
        try {
            connection = dataBaseConnection.getConnection();
            String query = "Insert into rolusuario (idUsuario, idRol) values (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idUsuario);
            statement.setInt(2, idRol);
            columnasAfectadas = statement.executeUpdate();
            if(columnasAfectadas == 0){
                throw new SQLException ("Revise los datos ingresados");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(AcademicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            String mensajeDeError = ex.getMessage();
            if (!ex.getMessage().equals("Revise los datos ingresados")) {
                mensajeDeError = "No hay conexión a la base de datos";
            }
            throw new SQLException (mensajeDeError);
        }
        finally {
            dataBaseConnection.cerrarConexion();
        } 
        if (columnasAfectadas > 0) {
            registroRealizado = true;
        }
        return registroRealizado;
    }
}
