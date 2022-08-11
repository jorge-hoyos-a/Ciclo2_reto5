package reto4.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import reto4.model.vo.Consulta2Vo;
import reto4.util.JDBCUtilities;

public class Consulta2Dao {
    public List<Consulta2Vo> listar() throws SQLException{
        ArrayList<Consulta2Vo> respuesta = new ArrayList<Consulta2Vo>(); 
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "select ID_Proyecto as id, Constructora, Numero_Habitaciones as hab,Ciudad from Proyecto p where Clasificacion = 'Casa Campestre' and Ciudad in('Santa Marta','Cartagena','Barranquilla')";
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while (rs.next()){
                Consulta2Vo vo = new Consulta2Vo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setHabitaciones(rs.getInt("hab"));
                vo.setCiudad(rs.getString("ciudad"));
                respuesta.add(vo);
            }
        }
        finally{
            if (rs != null){
                rs.close();
            }
            if (stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return respuesta;
    }
}
