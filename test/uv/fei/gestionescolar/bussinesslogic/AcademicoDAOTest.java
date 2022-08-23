/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uv.fei.gestionescolar.bussinesslogic;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uv.fei.gestionescolar.domain.Alumno;
import uv.fei.gestionescolar.domain.Usuario;
import uv.fei.sistemadetutorias.domain.Academico;

/**
 *
 * @author oscar
 */
public class AcademicoDAOTest {
    

    /**
     * Test of registrarAcademico method, of class AcademicoDAO.
     */
    @Test
    public void testRegistrarAcademicoExitoso() throws Exception {
        Academico academicoRegistrado = new Academico();
        int numeroPersonal = 12345;
        String nombre = "Raul";
        String apellidoPaterno = "Perez";
        String apellidoMaterno = "Ramirez";
        String correoInstitucional = "raulacademico@uv.mx";
        String correoPersonal = "raul@gmail.com";
        academicoRegistrado.setNumeroDePersonal(numeroPersonal);
        academicoRegistrado.setNombre(nombre);
        academicoRegistrado.setApellidoPaterno(apellidoPaterno);
        academicoRegistrado.setApellidoMaterno(apellidoMaterno);
        academicoRegistrado.setCorreoInstitucional(correoInstitucional);
        academicoRegistrado.setCorreoPersonal(correoPersonal);
        AcademicoDAO academicoDAO = new AcademicoDAO();
        try{
            boolean expResult = true;
            boolean result = academicoDAO.registrarAcademico(academicoRegistrado);
            assertEquals(expResult, result);
        }catch (SQLException mensajeError){
            System.out.println(mensajeError);
        }
    }
    
    @Test(expected = SQLException.class)
    public void testNumeroPersonalDuplicado() throws Exception {
        Academico academicoRegistrado = new Academico();
        int numeroPersonal = 12345;
        String nombre = "Jesus";
        String apellidoPaterno = "Olivares";
        String apellidoMaterno = "Ramirez";
        String correoInstitucional = "jesusacademico@uv.mx";
        String correoPersonal = "jesus@gmail.com";
        academicoRegistrado.setNumeroDePersonal(numeroPersonal);
        academicoRegistrado.setNombre(nombre);
        academicoRegistrado.setApellidoPaterno(apellidoPaterno);
        academicoRegistrado.setApellidoMaterno(apellidoMaterno);
        academicoRegistrado.setCorreoInstitucional(correoInstitucional);
        academicoRegistrado.setCorreoPersonal(correoPersonal);
        AcademicoDAO academicoDAO = new AcademicoDAO();
        academicoDAO.registrarAcademico(academicoRegistrado);
        boolean expResult = true;
        boolean result = academicoDAO.registrarAcademico(academicoRegistrado);
        assertEquals(expResult, result);
        
    }
    @Test(expected = SQLException.class)
    public void testNombreVacio() throws Exception {
        Academico academicoRegistrado = new Academico();
        int numeroPersonal = 4567;
        String nombre = null;
        String apellidoPaterno = "Olivares";
        String apellidoMaterno = "Ramirez";
        String correoInstitucional = "jesusacademico@uv.mx";
        String correoPersonal = "jesus@gmail.com";
        AcademicoDAO academicoDAO = new AcademicoDAO();
        academicoRegistrado.setNumeroDePersonal(numeroPersonal);
        academicoRegistrado.setNombre(nombre);
        academicoRegistrado.setApellidoPaterno(apellidoPaterno);
        academicoRegistrado.setApellidoMaterno(apellidoMaterno);
        academicoRegistrado.setCorreoInstitucional(correoInstitucional);
        academicoRegistrado.setCorreoPersonal(correoPersonal);
        academicoDAO.registrarAcademico(academicoRegistrado);
    }
    @Test(expected = NullPointerException.class)
    public void testRegistrarAcademicoFallido() throws Exception {
        Academico academicoRegistrado = null;
        AcademicoDAO academicoDAO = new AcademicoDAO();
        boolean expResult = false;
        boolean result = academicoDAO.registrarAcademico(academicoRegistrado);
        assertEquals(expResult, result);
    }
    
    

    
}
