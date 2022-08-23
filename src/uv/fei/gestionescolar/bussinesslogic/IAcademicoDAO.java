/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uv.fei.gestionescolar.bussinesslogic;

import java.sql.SQLException;
import java.util.ArrayList;
import uv.fei.gestionescolar.domain.Alumno;
import uv.fei.gestionescolar.domain.Usuario;
import uv.fei.sistemadetutorias.domain.Academico;

/**
 *
 * @author oscar
 */
public interface IAcademicoDAO {
    public boolean registrarAcademico (Academico academicoRegistrado) throws SQLException;
    public ArrayList <Academico> consultarClases (int nrc) throws SQLException;
    public Academico consultarPorNumeroPersonal (int numeroPersonal) throws SQLException;
}

