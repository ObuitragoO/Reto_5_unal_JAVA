package reto_5_final;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
// ESTUDIANTES MISION TIC 2022;

/**
 * RETO #5 Oscar  B  
 * 
 */

public class insertar {

    /**
     * 
     * insertar bicicleta con parametros
     */
    
    public static void insertar_bicicleta(String n_fabricante, String p_unitario, int año) {
        try {

            String sql = "INSERT INTO Bicicletas(Nombre_fabricante,Precio_unitario,Año_construccion)VALUES(?,?,?)";
            PreparedStatement statement = conexion_bd.conexionBD().prepareStatement(sql);
            statement.setString(1, n_fabricante);
            statement.setString(2, p_unitario);
            statement.setInt(3, año);

            int resultado = statement.executeUpdate();
            if (resultado > 0) {
                System.out.println("campo ingresado" + n_fabricante);
            } else {
                System.out.println("fallo carga de datos");
            }
        } catch (SQLException error) {
            System.out.println("falla " + error.getMessage() + "codigo " + error.getErrorCode());
        }
    }

    
    /**
     * 
     * insertar moto electrica con parametros
     */
    
    public static void insertar_moto_electrica(String Nom_fabricante, int Precio_unitario, String Autonomia, String Proveedor_motor) {
        try {
            String sql = "INSERT INTO Moto_electrica(Nombre_fabricante,Precio_unitario,Autonomia,Proveedor_motor)VALUES(?,?,?,?)";
            PreparedStatement statement = conexion_bd.conexionBD().prepareStatement(sql);
            statement.setString(1, Nom_fabricante);
            statement.setInt(2, Precio_unitario);
            statement.setString(3, Autonomia);
            statement.setString(4, Proveedor_motor);
            int carga_datos = statement.executeUpdate();
            if (carga_datos > 0) {
                System.out.println("carga de datos fabricante " + Nom_fabricante);
            } else {
                System.out.println("fallo carga datos");
            }
        } catch (SQLException error) {

            System.out.println("falla" + error.getSQLState());
        }
    }

    /**
     * insertar proveedor moto con parametros
     */
    
    public static void insertar_proveedor_moto(int prov_id, String prov_nombre, String prov_direccion, String prov_telefono) {

        try {

            String Sql = "INSERT INTO proveedor VALUES(?,?,?,?)";
            PreparedStatement statement = conexion_bd.conexionBD().prepareStatement(Sql);
            statement.setInt(1, prov_id);
            statement.setString(2, prov_nombre);
            statement.setString(3, prov_direccion);
            statement.setString(4, prov_telefono);
            int resultado = statement.executeUpdate();
            if (resultado > 0) {
                System.out.println("Se ingresa proveedor " + prov_nombre);
            } else {
                System.out.println("el ingreso de los datos fallaron");
            }
        } catch (SQLException error) {

        }
    }

    /**
     * insertar ingreso_cliente con parametros
     */
    
    public static void ingreso_cliente(String Alias, String nombre, String apellido, String celular, int contraseña, String fecha) {
        try {

            String sql = "INSERT INTO Clientes values(?,?,?,?,?,?)";
            PreparedStatement statement = conexion_bd.conexionBD().prepareStatement(sql);
            Date fecha_f = Date.valueOf(fecha);
            statement.setString(1, Alias);
            statement.setString(2, nombre);
            statement.setString(3, apellido);
            statement.setString(4, celular);
            statement.setInt(5, contraseña);
            statement.setDate(6, fecha_f);

            int guardado = statement.executeUpdate();
            System.out.println(guardado);
            if (guardado > 0) {
                System.out.println("el cliente" + nombre + "se registro");
            } else {
                System.out.println("falla de registro");
            }

        } catch (SQLException error) {
            System.out.println("codigo " + error.getErrorCode() + "falla" + error.getMessage() + ".");
        }
    }

    /**
     * insertar registro compra sin parametros
     */
    
    public static void insertar_registro_compra() {
        Scanner cp = new Scanner(System.in);

        try {
            System.out.println("****** REGISTRO DE COMPRA ******");
            System.out.println("Ingrese el Id ");
            int id = Integer.parseInt(cp.nextLine());
            System.out.println("Ingrese el Id cliente ");
            String id_cliente = cp.nextLine();
            System.out.println("Ingrese el nombre de la moto, si no tiene moto escriba el numero 0 ");
            String id_moto = cp.nextLine();
            if (id_moto.length() == 1) {
                id_moto = null;
            }
            System.out.println("Ingrese el nombre de la biciclete, si no tiene bicicleta escriba el numero 0 ");
            String id_bici = cp.nextLine();
            if (id_bici.length() == 1) {
                id_bici = null;
            }
            System.out.println("Ingrese la fecha formato (AAAA-MM-DD)");
            String fecha = cp.nextLine();
            System.out.println("id_moto " + id_moto);
            System.out.println("id_bici" + id_bici);
            
            String sql = "INSERT INTO Registro_compra VALUES(?,?,?,?,?)";
            PreparedStatement statement = conexion_bd.conexionBD().prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, id_cliente);
            statement.setString(3, id_moto);
            statement.setString(4, id_bici);
            statement.setString(5, fecha);
            int ingreso = statement.executeUpdate();
            if (ingreso > 0) {
                System.out.println("Se ingreso " + id + " registro compra");
            } else {
                System.out.println("no funciono la falla");
            }

        } catch (SQLException error) {
            System.out.println("falla " + error.getErrorCode() + " in " + error.getMessage());
        }
    }

    /**
     * CREACION DE LAS TABLAS
     */
    public static void creacion_de_tablas_Clientes() {
        // creacion de tabla Clientes
        try {
            String sql_Clientes = "CREATE TABLE clientes(Alias VARCHAR(45) NOT NULL,Nombre VARCHAR(45) NOT NULL,Apellido VARCHAR(45) NOT NULL,Celular VARCHAR(45) NOT NULL,contraseña INT NOT NULL,Fecha_nacimiento DATE NOT NULL,PRIMARY KEY (Alias))";
            PreparedStatement statement = conexion_bd.conexionBD().prepareStatement(sql_Clientes);
            statement.executeUpdate();
            System.out.println("*** SE CREA TABLA CLIENTE ***");
            insertar_datos_Cliente();
        } catch (Exception e) {
            System.out.println("TABLA YA CREADA");
        }

    }

    /**
     * Ingresar los datos de las tablas CLIENTES
     */
    public static void insertar_datos_Cliente() {
        try {

            String[] Sql_c = {"insert into clientes values ('lucky','Pedro','Perez','3123647116',12345678,'1993-12-22')", "insert into clientes values ('malopez','Maria','Lopez','3135679834',12343237,'1994-06-30')", "insert into clientes values ('diva','Ana','Diaz','3224567235',90876543,'1950-05-05')", "insert into clientes values ('dreamer','Luis','Rojas','3448769835',87695436,'1960-10-27')", "insert into clientes values ('ninja','Andres','Cruz','3456871256',7695432,'2000-11-06')", "insert into clientes values ('neon','Nelson','Ruiz','3457689137',46873456,'2011-06-06')", "insert into clientes values ('rose','Claudia','Mendez','3114567345',99999999,'1990-08-17')", "insert into clientes values ('green','Jorge','Rodriguez','3123457893',12345674,'1995-01-01')"};
            for (String i : Sql_c) {
                PreparedStatement statement = conexion_bd.conexionBD().prepareStatement(i);
                statement.executeUpdate();
                System.out.println("*** SE INGRESAN DATOS A LA TABLA CLIENTE ***" + i);
            }
        } catch (Exception error) {
            System.out.println("fallassss  " + error.getMessage());
        }
    }

    /**
     * creacion de tabla bicicleta
     */
    public static void creacion_tabla_Bicicleta() {
        try {
            String sql_Bicicleta = "CREATE TABLE Bicicletas(Nombre_fabricante VARCHAR(45) NOT NULL,Precio_unitario VARCHAR(45) NOT NULL,Año_construccion INT NULL,PRIMARY KEY (Nombre_fabricante))";
            PreparedStatement statement = conexion_bd.conexionBD().prepareStatement(sql_Bicicleta);
            statement.executeUpdate();
            System.out.println("*** SE CREA TABLA BICICLETA ***");
            insertar_datos_bicicleta();
        } catch (Exception e) {
            System.out.println("TABLA YA CREADA");
        }
    }

    public static void insertar_datos_bicicleta() {
        try {
            String[] SQL_bici = {"insert into Bicicletas(Nombre_fabricante,Precio_unitario,Año_construccion) values ('Cannondale','1200000',2020)", "insert into Bicicletas(Nombre_fabricante,Precio_unitario,Año_construccion) values ('Trek','1450000',2019)", "insert into Bicicletas(Nombre_fabricante,Precio_unitario,Año_construccion) values ('Yeti','2000000',2020)", "insert into Bicicletas(Nombre_fabricante,Precio_unitario,Año_construccion) values ('Fuji','950000',2021)", "insert into Bicicletas(Nombre_fabricante,Precio_unitario,Año_construccion) values ('Bmc','1950000',1018)"};
            for (String i : SQL_bici) {
                PreparedStatement statement = conexion_bd.conexionBD().prepareCall(i);
                statement.executeUpdate();
                System.out.println("*** SE INGRESAN DATOS A LA TABLA BICICLETA ***" + i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * creacion de tabla proveedor
     */
    
    public static void creacion_tabla_proveedor() {
        try {
            String sql_proveedor = "CREATE TABLE Proveedor(prov_id INT NOT NULL,prov_nombre CHAR(20) NOT NULL,prov_direccion CHAR(45) NOT NULL,prov_telefono CHAR(11) NULL,PRIMARY KEY (prov_nombre))";
            PreparedStatement sttement = conexion_bd.conexionBD().prepareStatement(sql_proveedor);
            sttement.executeUpdate();
            System.out.println("*** SE CREA TABLA PROVEEDOR ***");
            insertar_datos_proveedor();

        } catch (Exception e) {
            System.out.println("TABLA YA CREADA **");
        }
    }

    /**
     * insertar datos de proveedor
     */
    public static void insertar_datos_proveedor() {

        try {
            String[] SQL_proveedor = {"insert into proveedor values (101, 'Auteco','calle 7 No. 45-17', '05713224459')", "insert into proveedor values (102, 'Hitachi', 'calle 19 No. 108-26', '05714223344')", "insert into proveedor values (103, 'Bosch', 'carrera 68 No. 26-45', '05715678798')", "insert into proveedor values (104, 'Teco', 'calle 77 No. 68-33', '05712213243')", "insert into proveedor values (105, 'General Electric', 'calle 29 No. 26-12', '05717239919')"};
            for (String i : SQL_proveedor) {
                PreparedStatement stament = conexion_bd.conexionBD().prepareStatement(i);
                stament.executeUpdate();
                System.out.println("*** SE CREA TABLA PROVEEDOR ***" + i);
            }
        } catch (Exception e) {
            System.out.println("DATOS REPETIDOS");
        }
    }

    /**
     * creacion de tabla moto electrica
     */
    
    public static void creacion_tabla_Moto_electrica() {
        try {
            String sql_Moto = "CREATE TABLE Moto_electrica(Nombre_fabricante varchar(50) NOT NULL,Moto_electricaPrecio_unitario INT NOT NULL,Autonomia VARCHAR(45) NULL,Proveedor_motor char(20) NULL,PRIMARY KEY(Nombre_fabricante),FOREIGN KEY (Proveedor_motor) REFERENCES Proveedor(prov_nombre))";
            PreparedStatement statement = conexion_bd.conexionBD().prepareStatement(sql_Moto);
            statement.executeUpdate();
            System.out.println("*** SE CREA TABLA MOTO ELECTRICA ***");
            insertar_dato_moto_electrica();

        } catch (Exception e) {
            System.out.println("** DATOS YA INGRESADOS **");
        }
    }

    
    /**
     * insertar de tabla moto electrica
     */
    
    
    public static void insertar_dato_moto_electrica() {
        try {
            String[] Sql_MOTO = {"insert into Moto_electrica values('Starker',4200000,'18 horas','Auteco')",
                "insert into Moto_electrica values('Lucky Lion',5600000,'14 horas','Hitachi')",
                "insert into Moto_electrica values('Be Electric',4600000,'26 horas','Auteco')",
                "insert into Moto_electrica values('Aima',8000000,'36 horas','Bosch')",
                "insert into Moto_electrica values('Mec de Colombia',5900000,'20 horas','Teco')",
                "insert into Moto_electrica values('Atom Electric',4500000,'12 horas','General Electric')"};

            for (String i : Sql_MOTO) {
                PreparedStatement statement = conexion_bd.conexionBD().prepareStatement(i);
                statement.executeUpdate();
                System.out.println("*** SE INGRESA MOTO ELECTRICA ***" + i);
            }
        } catch (Exception e) {
            System.out.println("** DATOS YA INGRESADOS **");
        }

    }

    /**
     * creacion de tabla bicicleta
     */
    
    public static void creacion_tabla_registro_compra() {
        try {
            String sql = "CREATE TABLE Registro_compra(idRegistro_compra INT NOT NULL,id_cliente VARCHAR(45) NOT NULL,id_nom_moto VARCHAR(45) NULL,id_nom_bici VARCHAR(45) NULL,fecha VARCHAR(45) NULL,PRIMARY KEY (idRegistro_compra),FOREIGN KEY (id_cliente) REFERENCES Clientes(Alias),FOREIGN KEY (id_nom_moto) REFERENCES Moto_electrica(Nombre_fabricante),FOREIGN KEY (id_nom_bici) REFERENCES Bicicletas(Nombre_fabricante))";
            PreparedStatement statement = conexion_bd.conexionBD().prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("*** SE CREA TABLA REGISTRO COMPRA ***");
            insertar_datos_registro_compra();
        } catch (Exception e) {
            System.out.println("TABLA YA CREADA **");
        }
    }

    /**
     * insertar de tabla registro compra
     */
    
    public static void insertar_datos_registro_compra() {
        try {
            String[] SQL_RC = {"insert into Registro_compra values (1,'lucky',null,'Cannondale','2017-10-25 20:00:00')",
                "insert into Registro_compra values (2,'lucky',null,'Trek','2019-03-15 18:30:00')",
                "insert into Registro_compra values (3,'lucky','Starker',null,'2019-05-20 20:30:00')",
                "insert into Registro_compra values (4,'malopez',null,'Cannondale','2018-05-20 20:30:00')",
                "insert into Registro_compra values (5,'malopez','Starker',null,'2020-01-20 20:30:00')",
                "insert into Registro_compra values (6,'diva',null,'Yeti','2019-05-20 20:30:00')",
                "insert into Registro_compra values (7,'diva',null,'Fuji','2018-06-22 21:30:00')",
                "insert into Registro_compra values (8,'diva','Lucky Lion',null,'2020-03-17 15:30:20')",
                "insert into Registro_compra values (9,'dreamer','Lucky Lion',null,'2020-03-17 15:30:20')",
                "insert into Registro_compra values (10,'dreamer','Be Electric',null,'2020-04-10 18:30:20')",
                "insert into Registro_compra values (11,'ninja','Aima',null,'2020-02-17 20:30:20')",
                "insert into Registro_compra values (12,'ninja','Starker',null,'2020-02-20 16:30:20')",
                "insert into Registro_compra values (13,'ninja','Mec de Colombia',null,'2020-03-27 18:30:20')",
                "insert into Registro_compra values (14,'rose','Atom Electric',null,'2020-03-20 21:30:20')",
                "insert into Registro_compra values (15,'green',null,'Yeti','2020-01-10 17:30:20')",
                "insert into Registro_compra values (16,'green',null,'Trek','2020-02-15 20:30:20')",
                "insert into Registro_compra values (17,'green',null,'Bmc','2020-03-17 18:30:20')"};
            for (String x : SQL_RC) {
                PreparedStatement statement = conexion_bd.conexionBD().prepareCall(x);
                statement.executeUpdate();
                System.out.println("*** SE INGRESA REGISTRO COMPRA ***" + x);

            }
        } catch (Exception e) {
            System.out.println("*** DATOS SE ENCUENTRAN INGRESADOS ***");
        }
    }

}
