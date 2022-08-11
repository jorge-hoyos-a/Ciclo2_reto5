package reto4.controller;
import reto4.model.dao.*;
import reto4.model.vo.*;

import java.sql.SQLException;
import java.util.List;

public class ReportesController {
    private Consulta1Dao consulta1Dao;
    private Consulta3Dao consulta3Dao;
    private Consulta2Dao consulta2Dao;

    public ReportesController(){
        consulta2Dao = new Consulta2Dao();
        consulta3Dao = new Consulta3Dao();
        consulta1Dao = new Consulta1Dao();
    }

    public List<Consulta2Vo> listarInforme2Proyectos() throws SQLException{
        return consulta2Dao.listar();
    }
    public List<Consulta3Vo> listarInforme3Compras() throws SQLException{
        return consulta3Dao.listar();
    }
    public List<Consulta1Vo> listarInforme1Lider() throws SQLException{
        return consulta1Dao.listar();
    }


}
