package reto_5_final;

import java.sql.*;


/**
 * RETO #5 Oscar  B 
 */

public class consultas {

    /**
     * CONSULTA 1
     *
     * 5.1. Mostrar el nombre de los fabricantes de todas las bicicletas y
     * motocicletas eléctricas ordenadas alfabéticamente.
     *
     */
    
    public static void  consulta_9() {
        try {
            String sql = "select Nombre_fabricante from Bicicletas union all select Nombre_fabricante from Moto_electrica order by Nombre_fabricante";
            Statement statement = conexion_bd.conexionBD().createStatement();
            ResultSet resul = statement.executeQuery(sql);
            System.out.println("****** CONSULTA 1 ******");
            while(resul.next()){
                String Nomre_fabricante = resul.getString(1);
                System.out.println("    "+Nomre_fabricante);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getMessage());
        }

    }

    /**
     * CONSULTA 2
     * 
     * 5.2. Mostrar la información de las bicicletas (fabricante, precio unitario, año)
     * que se han estrenado posteriormente al año 2019, ordenadas por Fabricante.
     * 
     */
    
    public static void consulta_10(){
        try{
            String sql = "select * from Bicicletas where Año_construccion>2019 order by Nombre_fabricante";
            Statement statement = conexion_bd.conexionBD().createStatement();
            ResultSet resul = statement.executeQuery(sql);
            System.out.println("****** CONSULTA 2 ******");
            while(resul.next()){
             String fabricante = resul.getString(1);
             String precio = resul.getString(2);
             String año = resul.getString(3);
             System.out.println("FABRICANTE| "+fabricante+" |PRECIO| "+precio+" |AÑO| "+año);
         }   
            
        }catch(SQLException ex){
            System.out.println("resultado falla"+ex.getMessage()+" "+ex.getErrorCode());
        }
    }
    
    
    /**
     * consulta 3
     * 5.3. Mostrar los fabricantes de las motocicletas eléctricas donde Auteco les provee el motor.
     */
    
    public static void consulta_11(){
        try{
        
        String sql ="select Nombre_fabricante from Moto_electrica where Proveedor_motor ='Auteco' order by Nombre_fabricante desc";
        Statement statement = conexion_bd.conexionBD().createStatement();
        ResultSet resul = statement.executeQuery(sql);
        System.out.println("****** CONSULTA 3 ******");
        while(resul.next()){
            String fabricante = resul.getString(1);
            System.out.println("    "+fabricante);
        }
                   
        }catch(SQLException error){
            System.out.println("falla"+error.getMessage()+" codigo"+error.getErrorCode());
        }  
    }
    
    
    /**
     * consulta 4
     * 5.4. Mostrar la información de las bicicletas y motocicletas eléctricas (solo los fabricantes)
     * que ha visto un cliente con alias "lucky", ordenadas por fabricante.
     */
    
    public static void consulta_12(){
        try{
            String sql = "select id_nom_moto AS fabricante from Registro_compra where id_cliente=\"lucky\" and id_nom_moto is not null union all select id_nom_bici as fabricante from Registro_compra where id_cliente=\"lucky\" and id_nom_bici is not null order by fabricante";
            Statement statement = conexion_bd.conexionBD().createStatement();
            ResultSet resul = statement.executeQuery(sql);
            System.out.println("****** CONSULTA 4 ******");
            while(resul.next()){
                String fabricante = resul.getString(1);
                System.out.println("    "+fabricante);
            }
        }catch(SQLException ex){
            System.out.println("falla"+ex.getMessage()+" codigo"+ex.getErrorCode());
        }
    }
    
    /**
     * consulta 5
     * 5.5. Mostrar la información de los clientes (alias y nombre y apellidos)
     * que tienen la intención de comprar la bicicleta "Yeti" ordenados alfabéticamente.
     */
    
    public static void  consulta_13(){
        try{

        String sqL ="select c.Alias,c.Nombre,c.Apellido from Clientes c left join Registro_compra r on id_cliente=Alias where id_nom_bici=\"yeti\" order by c.Nombre";
        Statement statement = conexion_bd.conexionBD().createStatement();
        ResultSet resul = statement.executeQuery(sqL);
        System.out.println("****** CONSULTA 5 ******");
        while(resul.next()){
            String Alias = resul.getString(1);
            String Nombre = resul.getString(2);
            String Apellido = resul.getString(3);
            System.out.println("| Alias |"+Alias+"| Nombre |"+Nombre+"|Apellido|"+Apellido);
        }            
        }catch(SQLException error){
            System.out.println("falla"+error.getMessage()+"codigo "+error.getErrorCode());
        }
        
    }
        /**
         * consulta 6
         * 5.6. Mostrar cuantas bicicletas se han fabricado después del año 2019.
         */
        
        public static void Consulta_14(){
            
            try{
            String sql = "select count(*) from Bicicletas where Año_construccion>=2019";
            Statement statement = conexion_bd.conexionBD().createStatement();
            ResultSet resul = statement.executeQuery(sql);
            System.out.println("****** CONSULTA 6 MISION TIC ******");
            while(resul.next()){
                Integer numero = resul.getInt(1);
                System.out.println(numero);
            }
            }catch(SQLException error){
                System.out.println("falla"+error.getMessage()+"codigo"+error.getErrorCode());
            }
         
         /**
         * consultar toda la informacion de la bicicleta
         */

        }
        public static void consultar_bicicletas(){
            try{
            String sql = "select * from Bicicletas";
            Statement statement = conexion_bd.conexionBD().createStatement();
            ResultSet resul = statement.executeQuery(sql);
            System.out.println("****** CONSULTA BICICLETA ******");
                System.out.println(" | NOMBRE FABRICANTE | PRECIO UNITARIO | AÑO | ");
            while(resul.next()){
                String nombre_fabricante = resul.getString(1);
                String precio_unirario = resul.getString(2);
                int año_p = resul.getInt(3);
                System.out.println("|- "+nombre_fabricante+" -|- "+precio_unirario+" -|- "+año_p+" -|");
                
            }
            }catch(SQLException error){
                System.out.println("falla"+error.getMessage()+"codigo"+error.getErrorCode());
            }
        }
        
        /**
         * consultar toda la informacion del cliente
         */
        
        public static void consultar_clientes(){
            try{
            String sql = "select * from Clientes";
            Statement statement = conexion_bd.conexionBD().createStatement();
            ResultSet resul = statement.executeQuery(sql);
            System.out.println("****** CONSULTA CLIENTES ******");
            System.out.println("| ALIAS | NOMBRE | APELLIDO | CELULAR | CONTRASEÑA | FECHA");
            while(resul.next()){
                String alias = resul.getString(1);
                String nombre = resul.getString(2);
                String apellido = resul.getString(3);
                String celular = resul.getString(4);
                int contraseña = resul.getInt(5);
                Date fecha = resul.getDate(6);
            
                System.out.println("|- "+alias+" -|- "+nombre+" -|- "+apellido+" -|- "+celular+" -|- "+contraseña+" -|-"+fecha+" -|");
                
            }
            }catch(SQLException error){
                System.out.println("falla"+error.getMessage()+"codigo"+error.getErrorCode());
            }
        }
        
        
        /**
         * consultar toda la informacion moto electrica
         */
        
        public static void consultar_moto_electrica(){
            try {
                String sql="select * from Moto_electrica";
                Statement statement = conexion_bd.conexionBD().createStatement();
                ResultSet resul = statement.executeQuery(sql);
                System.out.println("****** CONSULTA MOTO ELECTRICA ******");
                System.out.println(" | NOMBRE | PRECIO UNITARIO | PROVEEDOR MOTOR");
                while(resul.next()){
                    String nombre = resul.getString(1);
                    int precio_U = resul.getInt(2);
                    String autonomia = resul.getString(3);
                    String proveedor_Motor =  resul.getString(4);
                    System.out.println("|- "+nombre+" -|- "+precio_U+" -|- "+autonomia+" -|- "+proveedor_Motor+" |");
                }
            } catch (Exception e) {
            }
        }
        /**
         * consultar toda la informacion del proveedor
         */
        public static void consulta_proveedor(){
            try {
                String sql = "select * from proveedor";
                Statement statement = conexion_bd.conexionBD().createStatement();
                ResultSet resul = statement.executeQuery(sql);
                System.out.println(" | ID |  NOMBRE | DIRECCION | TELEFONO |");
                while (resul.next()) {
                   int id = resul.getInt(1);
                   String nombre = resul.getString(2);
                   String direccion = resul.getString(3);
                   String telefono = resul.getString(4);
                    System.out.println("|- "+id+" -|- "+nombre+" -|- "+direccion+" -|- "+telefono+" |");
                }
                
            } catch (SQLException error) {
                System.out.println("falla = "+error.getMessage());
            }
        }
        
        
        /**
         * consultar toda la informacion del registro compra
         */
        
        public static void consulta_registro_compra(){
            try {
                String sql ="select * from Registro_compra";
                Statement statement = conexion_bd.conexionBD().createStatement();
                ResultSet resul = statement.executeQuery(sql);
                System.out.println(" | ID REGISTRO COMPRA |  CLIENTE | ID MOTO | ID BICI | FECHA |");
                while(resul.next()){
                    int id_Registro_compra = resul.getInt(1);
                    String id_cliente = resul.getString(2);
                    String id_nom_moto = resul.getString(3);
                    String id_nom_bici = resul.getString(4);
                    String fecha = resul.getString(5);
                    System.out.println("|- "+id_Registro_compra+" -|- "+id_cliente+" -|- "+id_nom_moto+" -|- "+id_nom_bici+" -|- "+fecha);
                }
            } catch (SQLException error) {
                System.out.println("falla "+error.getMessage());
            }
        }

    }
    

