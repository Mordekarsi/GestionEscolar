/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.gestionescolar.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uv.fei.gestionescolar.dataaccess.DataBaseConnection;
import uv.fei.gestionescolar.domain.Alumno;

/**
 *
 * @author oscar
 */
public class AlumnoDAO implements IAlumnoDAO {
    public boolean registrarAlumno(Alumno alumnoRegistrado)throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = null;
        boolean registroRealizado= false;
        int columnasAfectadas = 0;
        try {
            connection = dataBaseConnection.getConnection();
            String query = "Insert into alumno(matricula, nombre, apellidoPaterno, apellidoMaterno, correoInstitucional, correoPersonal ) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query); 
            statement.setString(1, alumnoRegistrado.getMatricula());
            statement.setString(2, alumnoRegistrado.getNombre());
            statement.setString(3, alumnoRegistrado.getApellidoPaterno());
            statement.setString(4, alumnoRegistrado.getApellidoMaterno());
            statement.setString(5, alumnoRegistrado.getCorreoInstitucional());
            statement.setString(6, alumnoRegistrado.getCorreoPersonal());
            columnasAfectadas = statement.executeUpdate();
            if(columnasAfectadas == 0){
                throw new SQLException ("Revise los datos ingresados");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public ArrayList<Alumno> consultarClases (int nrc) throws SQLException {
        ArrayList<Alumno> alumnosObtenidos = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "select * from asiste where nrc = ?;";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setInt(1, nrc);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException ("No se encontraron Experiencias Educativas");
            }
            else {
                String matricula = "";
                do {
                    matricula = resultSet.getString("matricula");
                    Alumno alumnoObtenido = new Alumno();
                    alumnoObtenido.setMatricula(matricula);
                    alumnosObtenidos.add(alumnoObtenido);
                } while (resultSet.next());
            }
        }
        catch (SQLException ex) {
            String mensajeDeError = "";
            if (!ex.getMessage().equals("No se encontraron Experiencias Educativas")) {
                mensajeDeError = "No hay conexión con la base de datos";
            }
            else {
                mensajeDeError = ex.getMessage();
            }
            throw new SQLException(mensajeDeError);
        }
        return alumnosObtenidos;
    }
    public Alumno consultarPorMatricula (String matricula) throws SQLException {
        Alumno alumnoObtenido = new Alumno();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "select * from alumno where matricula = ?;";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, matricula);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException ("No se encontraron Experiencias Educativas");
            }
            else {
                String nombre = "";
                String apellidoPaterno = "";
                String apellidoMaterno = "";
                do {
                    nombre = resultSet.getString("nombre");
                    apellidoPaterno = resultSet.getString("apellidoPaterno");
                    apellidoMaterno = resultSet.getString("apellidoMaterno");
                    alumnoObtenido.setNombre(nombre);
                    alumnoObtenido.setApellidoPaterno(apellidoPaterno);
                    alumnoObtenido.setApellidoMaterno(apellidoMaterno);
                } while (resultSet.next());
            }
        }
        catch (SQLException ex) {
            String mensajeDeError = "";
            if (!ex.getMessage().equals("No se encontraron Experiencias Educativas")) {
                mensajeDeError = "No hay conexión con la base de datos";
            }
            else {
                mensajeDeError = ex.getMessage();
            }
            throw new SQLException(mensajeDeError);
        }
        return alumnoObtenido;
    }
}

