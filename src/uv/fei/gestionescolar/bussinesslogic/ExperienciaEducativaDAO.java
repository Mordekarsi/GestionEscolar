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
import uv.fei.gestionescolar.domain.ExperienciaEducativa;

/**
 *
 * @author oscar
 */
public class ExperienciaEducativaDAO implements IExperienciaEducativaDAO {
        public ArrayList<ExperienciaEducativa> consultarOfertaEducativa () throws SQLException {
        ArrayList<ExperienciaEducativa> experienciasEducativas = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "select * from experienciaeducativa;";
            PreparedStatement statement = connection.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException ("No se encontraron Experiencias Educativas");
            }
            else {
                int nrc = 0;
                String nombreExperienciaEducativa = "";
                String horaInicio = "";
                String horaFin = "";
                String ubicacion = "";
                String dias = "";
                do {
                    nrc = resultSet.getInt("nrc");
                    nombreExperienciaEducativa = resultSet.getString("nombre");
                    horaInicio = resultSet.getString("horaInicio");
                    horaFin = resultSet.getString("horaFin");
                    ubicacion = resultSet.getString("ubicacion");
                    dias = resultSet.getString("dias");
                    ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
                    experienciaEducativa.setNrc(nrc);
                    experienciaEducativa.setNombre(nombreExperienciaEducativa);
                    experienciaEducativa.setHorarioInicio(horaInicio);
                    experienciaEducativa.setHorarioFin(horaFin);
                    experienciaEducativa.setUbicacion(ubicacion);
                    experienciaEducativa.setDias(dias);
                    experienciasEducativas.add(experienciaEducativa);
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
        return experienciasEducativas;
    }
        public ArrayList<ExperienciaEducativa> consultarNrc (String nombreExperiencia) throws SQLException {
        ArrayList<ExperienciaEducativa> experienciasEducativas = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "select * from experienciaeducativa where nombre = ?;";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, nombreExperiencia);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException ("No se encontraron Experiencias Educativas");
            }
            else {
                int nrc = 0;
                String nombreExperienciaEducativa = "";
                String horaInicio = "";
                String horaFin = "";
                String ubicacion = "";
                String dias = "";
                do {
                    nrc = resultSet.getInt("nrc");
                    nombreExperienciaEducativa = resultSet.getString("nombre");
                    horaInicio = resultSet.getString("horaInicio");
                    horaFin = resultSet.getString("horaFin");
                    ubicacion = resultSet.getString("ubicacion");
                    dias = resultSet.getString("dias");
                    ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
                    experienciaEducativa.setNrc(nrc);
                    experienciaEducativa.setNombre(nombreExperienciaEducativa);
                    experienciaEducativa.setHorarioInicio(horaInicio);
                    experienciaEducativa.setHorarioFin(horaFin);
                    experienciaEducativa.setUbicacion(ubicacion);
                    experienciaEducativa.setDias(dias);
                    experienciasEducativas.add(experienciaEducativa);
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
        return experienciasEducativas;
    }
    public ExperienciaEducativa consultarPorNrc (int nrc) throws SQLException {
        ExperienciaEducativa experienciaObtenida = new ExperienciaEducativa();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
        try(Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "select * from experienciaeducativa where nrc = ?;";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setInt(1, nrc);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException ("No se encontraron Experiencias Educativas");
            }
            else {
                int rc = 0;
                String nombreExperienciaEducativa = "";
                String horaInicio = "";
                String horaFin = "";
                String ubicacion = "";
                String dias = "";
                rc = resultSet.getInt("nrc");
                nombreExperienciaEducativa = resultSet.getString("nombre");
                horaInicio = resultSet.getString("horaInicio");
                horaFin = resultSet.getString("horaFin");
                ubicacion = resultSet.getString("ubicacion");
                dias = resultSet.getString("dias");
                experienciaEducativa.setNrc(nrc);
                experienciaEducativa.setNombre(nombreExperienciaEducativa);
                experienciaEducativa.setHorarioInicio(horaInicio);
                experienciaEducativa.setHorarioFin(horaFin);
                experienciaEducativa.setUbicacion(ubicacion);
                experienciaEducativa.setDias(dias);
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
        return experienciaEducativa;
    }

}
