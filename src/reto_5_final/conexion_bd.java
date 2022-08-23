package reto_5_final;
import java.sql.*;

// ESTUDIANTES MISION TIC 2022;

/**
* RETO #5 Oscar  B 
 */


public class conexion_bd {
        
    public static Connection conexionBD(){
        
        /**
         * se requiere que se cree la bd y se cambie el nombre,usuario,base_datos
         */
        
        try{
        String URL = "jdbc:mysql://localhost:3306/EcoDosRuedas";
        String UserName = "root";
        String Password = "123456789";
        String base_datos = "EcoDosRuedas";
        
        Connection conn = DriverManager.getConnection(URL, UserName, Password);
        if(conn!=null){
            //System.out.println("");
        }else{
            System.out.println("sin acceso a la BD");
        }
        return conn;
        }catch(SQLException error){
            System.out.println("falla acceso "+error.getMessage()+"codigo"+error.getErrorCode());
        }
        return null;
        
    }
    
}
