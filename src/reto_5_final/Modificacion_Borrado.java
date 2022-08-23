package reto_5_final;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import java.sql.*;
import java.util.Scanner;


// ESTUDIANTES MISION TIC 2022;

/**
 * RETO #5 Oscar  B
 */


public class Modificacion_Borrado {
        
  /**
   * -- 4.3. Borrar la intención de compra del cliente "green" de la bicicleta "Trek"
   */
    
    public static void borrar_intencion_compra_bicicleta(){
            
            Scanner cp =  new Scanner(System.in);
            System.out.println("Ingrese el nombre del cliente ");
            String id_client = "green";
            System.out.println("el cliente ingresado es "+id_client);
            System.out.println("Ingrese el nombre de la bicicleta a eliminar ");
            String id_nom_bici = "Trek";
            System.out.println("el nombre de la bicicleta es "+id_nom_bici);
            
            try{
             
            
            String sql = "delete from Registro_compra where id_nom_bici= ? and id_cliente=?";
            PreparedStatement statement = conexion_bd.conexionBD().prepareStatement(sql);
            statement.setString(1, id_nom_bici);
            statement.setString(2, id_client);
            
            int captura = statement.executeUpdate();
            if(captura > 0) {
                System.out.println("se elimina correctamente el dato");
        }
            }catch(SQLException erro){
                System.out.println("falla "+ erro.getMessage());
            }
    }
    
    /**
     * -- 4.2. Cambiar el teléfono del cliente "ninja" por 3115678432
     */
    
    
    public static void cambiar_telefono_cliente(){
        
        Scanner cp = new Scanner(System.in);
        System.out.println("Ingrese el Alias del cliente que desea cambiar el numero ");
        String Alias = "ninja";
        System.out.println("El Alias ingresado es"+Alias);
        System.out.println("Ingrese el nuevo numero de celuar que va a tener "+Alias);
        String celular = "3115678432";
        System.out.println("el numero ingresado es "+celular);
        
        try {
        String sql = "update Clientes set Celular=? where Alias=?;";
        PreparedStatement statement = conexion_bd.conexionBD().prepareStatement(sql);
        statement.setString(1, celular);
        statement.setString(2, Alias);
        int modificacion = statement.executeUpdate();
        if(modificacion>0){
            System.out.println("se modifica el Cliente "+Alias);
        }
        } catch (SQLException error) {
            System.out.println("falla "+error.getMessage());
        }
    }
    
    
      /**
     * -- 4.1. Cambiar el año de la bicicleta "Cannondale" por 2017
     */
    
    
    public static void cambiar_anio_bicicleta(){
            
        Scanner cp = new Scanner(System.in);
        
            
        try {
            System.out.println("Ingrese el nombre del fabricante de la bicicleta para cambiar fecha");
            String Nombre_fabricante = "Cannondale";
            System.out.println("fabricante ingresado"+Nombre_fabricante);
            System.out.println("Ingrese el nuevo año de la bicicleta "+Nombre_fabricante);
            int Año_construccion = 2017;
            System.out.println("el año ingresado es"+Año_construccion);
            
            String sql="update bicicletas set Año_construccion=? where Nombre_fabricante=?";
            PreparedStatement statement = conexion_bd.conexionBD().prepareStatement(sql);
            statement.setInt(1,Año_construccion);
            statement.setString(2,Nombre_fabricante);
            int modificacion = statement.executeUpdate();
            if(modificacion>0){
                System.out.println("se modifico el año de "+Nombre_fabricante+" por "+Año_construccion);
            }
            
        } catch (SQLException error) {
            System.out.println("falla "+error.getMessage());
        }
    }
}
        

    

