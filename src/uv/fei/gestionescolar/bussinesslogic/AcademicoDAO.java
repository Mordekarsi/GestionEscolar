/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.gestionescolar.bussinesslogic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uv.fei.gestionescolar.dataaccess.DataBaseConnection;
import uv.fei.gestionescolar.domain.Alumno;
import uv.fei.gestionescolar.domain.Usuario;
import uv.fei.sistemadetutorias.domain.Academico;

/**
 *
 * @author oscar
 */
public class AcademicoDAO implements IAcademicoDAO {
    public boolean registrarAcademico(Academico academicoRegistrado)throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = null;
        boolean registroRealizado= false;
        int columnasAfectadas = 0;
        try {
            connection = dataBaseConnection.getConnection();
            String query = "Insert into academico(numeroPersonal, nombre, apellidoPaterno, apellidoMaterno, correoInstitucional, correoPersonal ) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query); 
            statement.setInt(1, academicoRegistrado.getNumeroDePersonal());
            statement.setString(2, academicoRegistrado.getNombre());
            statement.setString(3, academicoRegistrado.getApellidoPaterno());
            statement.setString(4, academicoRegistrado.getApellidoMaterno());
            statement.setString(5, academicoRegistrado.getCorreoInstitucional());
            statement.setString(6, academicoRegistrado.getCorreoPersonal());
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
    public Academico consultarPorNumeroPersonal (int numeroPersonal) throws SQLException {
        Academico academicoObtenido = new Academico();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "select * from academico where numeroPersonal = ?;";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setInt(1, numeroPersonal);
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
                    academicoObtenido.setNombre(nombre);
                    academicoObtenido.setApellidoPaterno(apellidoPaterno);
                    academicoObtenido.setApellidoMaterno(apellidoMaterno);
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
        return academicoObtenido;
    }
        public ArrayList<Academico> consultarClases (int nrc) throws SQLException {
        ArrayList<Academico> academicosObtenidos = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "select * from imparte where nrc = ?;";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setInt(1, nrc);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException ("No se encontraron Experiencias Educativas");
            }
            else {
                int numeroDePersonal = 0;
                do {
                    numeroDePersonal = resultSet.getInt("numeroPersonal");
                    Academico academicoObtenido = new Academico();
                    academicoObtenido.setNumeroDePersonal(numeroDePersonal);
                    academicosObtenidos.add(academicoObtenido);
                } while (resultSet.next());
            }                    Academico alumnoObtenido = new Academico();

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
        return academicosObtenidos;
    }
}
