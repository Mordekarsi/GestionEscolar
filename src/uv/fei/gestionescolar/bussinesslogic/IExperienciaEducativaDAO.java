/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uv.fei.gestionescolar.bussinesslogic;

import java.sql.SQLException;
import java.util.ArrayList;
import uv.fei.gestionescolar.domain.ExperienciaEducativa;

/**
 *
 * @author oscar
 */
public interface IExperienciaEducativaDAO {
    public ArrayList<ExperienciaEducativa> consultarOfertaEducativa() throws SQLException;
    public ArrayList<ExperienciaEducativa> consultarNrc(String nombreExperiencia) throws SQLException;
    public ExperienciaEducativa consultarPorNrc(int nrc) throws SQLException;
}
