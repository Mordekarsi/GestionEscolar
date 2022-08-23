/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uv.fei.gestionescolar.bussinesslogic;

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uv.fei.gestionescolar.domain.Alumno;
import uv.fei.sistemadetutorias.domain.Academico;

/**
 *
 * @author oscar
 */
public class AlumnoDAOTest {
    
    
    @Test
    public void testRegistrarAlumnoExitoso() throws Exception {
        Alumno alumnoRegistrado = new Alumno();
        String matricula = "S20015696";
        String nombre = "Saraí";
        String apellidoPaterno = "Castillo";
        String apellidoMaterno = "Hernandez";
        String correoInstitucional = "zs20015696@estudiantes.uv.mx";
        String correoPersonal = "saraiche@gmail.com";
        alumnoRegistrado.setMatricula(matricula);
        alumnoRegistrado.setNombre(nombre);
        alumnoRegistrado.setApellidoPaterno(apellidoPaterno);
        alumnoRegistrado.setApellidoMaterno(apellidoMaterno);
        alumnoRegistrado.setCorreoInstitucional(correoInstitucional);
        alumnoRegistrado.setCorreoPersonal(correoPersonal);
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        try{
            boolean expResult = true;
            boolean result = alumnoDAO.registrarAlumno(alumnoRegistrado);
            assertEquals(expResult, result);
        }catch (SQLException mensajeError){
            System.out.println(mensajeError);
        }
    }
    @Test(expected = SQLException.class)
    public void testMatriculaDuplicada() throws Exception {
        Alumno alumnoRegistrado = new Alumno();
        String matricula = "S20015696";
        String nombre = "Saraí";
        String apellidoPaterno = "Castillo";
        String apellidoMaterno = "Hernandez";
        String correoInstitucional = "zs20015696@estudiantes.uv.mx";
        String correoPersonal = "saraiche@gmail.com";
        alumnoRegistrado.setMatricula(matricula);
        alumnoRegistrado.setNombre(nombre);
        alumnoRegistrado.setApellidoPaterno(apellidoPaterno);
        alumnoRegistrado.setApellidoMaterno(apellidoMaterno);
        alumnoRegistrado.setCorreoInstitucional(correoInstitucional);
        alumnoRegistrado.setCorreoPersonal(correoPersonal);
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumnoDAO.registrarAlumno(alumnoRegistrado);
        boolean expResult = true;
        boolean result = alumnoDAO.registrarAlumno(alumnoRegistrado);
        assertEquals(expResult, result);
    }
    @Test(expected = SQLException.class)
    public void testCampoFaltante() throws Exception {
        Alumno alumnoRegistrado = new Alumno();
        String matricula = "S20015715";
        String nombre = null;
        String apellidoPaterno = "Olivares";
        String apellidoMaterno = "Carsi";
        String correoInstitucional = "zs20015715@estudiantes.uv.mx";
        String correoPersonal = "oscarcarsi@gmail.com";
        alumnoRegistrado.setMatricula(matricula);
        alumnoRegistrado.setNombre(nombre);
        alumnoRegistrado.setApellidoPaterno(apellidoPaterno);
        alumnoRegistrado.setApellidoMaterno(apellidoMaterno);
        alumnoRegistrado.setCorreoInstitucional(correoInstitucional);
        alumnoRegistrado.setCorreoPersonal(correoPersonal);
         AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumnoDAO.registrarAlumno(alumnoRegistrado);

    }
    @Test(expected = NullPointerException.class)
    public void testRegistrarAlumnoFallido() throws Exception {
        Alumno alumnoRegistrado = null;
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        boolean expResult = false;
        boolean result = alumnoDAO.registrarAlumno(alumnoRegistrado);
        assertEquals(expResult, result);
    }

    
}
