/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uv.fei.gestionescolar.bussinesslogic;

import java.sql.SQLException;
import java.util.ArrayList;
import uv.fei.gestionescolar.domain.Alumno;

/**
 *
 * @author oscar
 */
public interface IAlumnoDAO {
    public boolean registrarAlumno (Alumno alumnoRegistrado) throws SQLException;
    public ArrayList <Alumno> consultarClases (int nrc) throws SQLException;
    public Alumno consultarPorMatricula (String matricula) throws SQLException;
}
