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
import uv.fei.gestionescolar.domain.Usuario;

/**
 *
 * @author oscar
 */
public class UsuarioDAOTest {
    
    @Test
    public void testRegistrarUsuarioExitoso() throws Exception {
        Usuario usuarioRegistrado = new Usuario();
        String nombreDeUsuario = "zs20015715";
        String contraseña = "carsi1212";
        String matricula = "S20015715";
        usuarioRegistrado.setNombreDeUsuario(nombreDeUsuario);
        usuarioRegistrado.setContraseña(contraseña);
        usuarioRegistrado.setMatricula(matricula);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try{
            boolean expResult = true;
            boolean result = usuarioDAO.registrarUsuarioAlumno(usuarioRegistrado);
            assertEquals(expResult, result);
        }catch (SQLException mensajeError){
             System.out.println(mensajeError);
        }
    }
        
    @Test(expected = SQLException.class)
    public void testUsuarioCampoFaltante() throws Exception {
        Usuario usuarioRegistrado = new Usuario();
        String nombreUsuario = null;
        String contraseña = "carsi1212";
        String matricula = "S20015715";
        usuarioRegistrado.setNombreDeUsuario(nombreUsuario);
        usuarioRegistrado.setContraseña(contraseña);
        usuarioRegistrado.setMatricula(matricula);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.registrarUsuarioAlumno(usuarioRegistrado);
    }
    @Test(expected = NullPointerException.class)
    public void testRegistrarAcademicoFallido() throws Exception {
        Usuario usuarioRegistrado = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean expResult = false;
        boolean result = usuarioDAO.registrarUsuarioAlumno(usuarioRegistrado);
        assertEquals(expResult, result);
    }

    @Test
    public void testObtenerIdUsuarioExitoso()throws Exception {
        Usuario usuarioEncontrar = new Usuario ();
        String nombreUsuario = "zs20015715";
        usuarioEncontrar.setNombreDeUsuario(nombreUsuario);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        int expResult = 20;
        int result = usuarioDAO.obtenerIdUsuario(usuarioEncontrar);
        assertEquals(expResult, result);
    }
    @Test
    public void testObtenerIdUsuarioFallido() throws Exception{
        Usuario usuarioEncontrar = new Usuario ();
        String nombreUsuario = "zs20015715";
        usuarioEncontrar.setNombreDeUsuario(nombreUsuario);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        int expResult = 8;
        int result = usuarioDAO.obtenerIdUsuario(usuarioEncontrar);
        assertNotEquals(expResult, result);
    }
    @Test(expected = SQLException.class)
    public void testObtenerIdUsuarioSinNombreUsuario() throws Exception{
        Usuario usuarioEncontrar = new Usuario ();
        String nombreUsuario = null;
        usuarioEncontrar.setNombreDeUsuario(nombreUsuario);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        int expResult = 8;
        int result = usuarioDAO.obtenerIdUsuario(usuarioEncontrar);
        assertNotEquals(expResult, result);
    }
    @Test
    public void testAsignarRolUsuarioExitoso() throws Exception{
        int idRol = 1;
        int idUsuario = 20;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean expResult = true;
        boolean result = usuarioDAO.asignarUsuarioRol(idUsuario, idRol);
        assertEquals(expResult, result);
        }
    @Test(expected = SQLException.class)
    public void testAsignarRolUsuarioFallido() throws Exception{
        int idRol = 1;
        int idUsuario = 7;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean expResult = true;
        boolean result = usuarioDAO.asignarUsuarioRol(idUsuario, idRol);
        assertNotEquals(expResult, result);
        }
}
