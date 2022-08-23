/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uv.fei.gestionescolar.bussinesslogic;

import java.sql.SQLException;
import uv.fei.gestionescolar.domain.Usuario;

/**
 *
 * @author oscar
 */
public interface IUsuarioDAO {
    public Usuario obtenerUsuarioPorNombreDeUsuarioYContraseña(String nombreDeUsuario, String contraseña) throws SQLException;
    public boolean registrarUsuarioAlumno(Usuario usuario) throws SQLException;
    public int obtenerIdUsuario(Usuario usuario) throws SQLException;
    public boolean asignarUsuarioRol (int idUsuario, int idRol) throws SQLException;
    public boolean registrarUsuarioAcademico(Usuario usuarioRegistrado)throws SQLException;
}
