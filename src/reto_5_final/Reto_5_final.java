package reto_5_final;

// ESTUDIANTES MISION TIC 2022;

/**
* RETO #5 Oscar  B
 */

import java.sql.*;
import java.util.Scanner;

public class Reto_5_final {

    public static void main(String[] args) {      
       try {
            System.out.println("*********************************************\n"
                        + "***********EcoDosRuedas Ltda*****************\n"
                        + "*********************************************\n"
                        + "******************MENU***********************\n"
                        + "******CREAR TABLA Y DATOS INICIALES**********\n"
                        + "*** 0 - crear todas las tablas e ingresos ****\n"
                        + "*************INGRESAR DATOS******************\n"
                        + "*** 1 - Ingresar datos Bicicleta*************\n"
                        + "*** 2 - Ingresar datos Moto Electrica *******\n"
                        + "*** 3 - Ingresar datos Proveedor motor ******\n"
                        + "*** 4 - Ingresar datos cliente **************\n"
                        + "*** 5 - Ingresar Registro compra ************\n"
                        + "*********************************************\n"
                        + "***************MODIFICAR*********************\n"
                        + "**** 6 - Modificar año bicicleta ************\n"
                        + "**** 7 - Modificar telefono cliente *********\n"
                        + "*********************************************\n"
                        + "******************BORRAR*********************\n"
                        + "**** 8 - Borrar intencion de compra *********\n"
                        + "*********************************************\n"
                        + "*****************CONSULTAS*******************\n"
                        + "***** 9 - Listado fabricantes B y M *********\n"
                        + "*** 10 - Listado bicicletas > 2019 **********\n"
                        + "* 11 - Listado fabricante Auteco ************\n"
                        + "* 12 - Listado B y M por cliente luky *******\n"
                        + "* 13 - Listado clientes intencion yeti ******\n"
                        + "* 14 - Cuantas bicicletas fabricadas > 2019 *\n"
                        + "*********************************************\n"
                        + "****************CONSULTA COMPLETA************\n"
                        + "*********************************************\n"
                        + "********* 15 - Consultar Bicicleta **********\n"
                        + "********* 16 - Consultar Clientes ***********\n"
                        + "********* 17 - Consultar Moto electrica *****\n"
                        + "********* 18 - Consultar Proveedor **********\n"
                        + "****** 19 - Consultar Registro compra *******\n"
                        + "*********************************************\n"
                        + "********* Salir programa escribir 20 ********\n"
                );
           
            Scanner cp = new Scanner(System.in);
            Integer ingreso=21;
            while (ingreso != 20) {
                
                
                switch(ingreso){
                    case 0:
                        System.out.println("se corren pruebas");
                        insertar.creacion_de_tablas_Clientes();
                        insertar.creacion_tabla_Bicicleta();
                        insertar.creacion_tabla_proveedor();
                        insertar.creacion_tabla_Moto_electrica();
                        insertar.creacion_tabla_registro_compra();
                        break;
                    case 1:
                        System.out.println("Ingrese el nombre del fabricante de la bicicleta");
                        String nombre_b = cp.next();
                        System.out.println("Ingresar precio unitario de la bicicleta : ");
                        String precio_b = cp.next();
                        System.out.println("Ingresar año de la bicicleta : ");
                        int año_ = Integer.parseInt(cp.next());
                        insertar.insertar_bicicleta(nombre_b, precio_b, año_);
                            break;
                    case 2:
                        System.out.println("****** INGRESO DE MOTO ELECTRICA ******");
                        System.out.println("Ingrese el nombre de la moto");
                        String nombre_M = cp.next();
                        System.out.println("Ingrese el precio unitario");
                        int precio_u_m = Integer.parseInt(cp.next());
                        System.out.println("Ingrese la autonomia");
                        String autonomia = cp.next();
                        System.out.println("Ingrese el proveedor de la moto");
                        String nombre_proveedor = cp.next();
            
                        insertar.insertar_moto_electrica(nombre_M, precio_u_m, autonomia,nombre_proveedor);
                        break;
                    case 3:
                        // datos proveedor motor
                        System.out.println("****** INGRESO DE PROVEEDOR MOTOR ******");
                        System.out.println("Ingrese el ID del nuevo proveedor");
                        int id_proveedor = Integer.parseInt(cp.next());
                        System.out.println("Ingrese nombre del proveedor");
                        String nombre_p = cp.next();
                        System.out.println("Ingrese direccion");
                        String direccion_P = cp.next();
                        System.out.println("Ingrese telefono");
                        String telefono_p = cp.next();
                        insertar.insertar_proveedor_moto(id_proveedor,nombre_p,direccion_P,telefono_p);
                        break;
                    case 4:
                        System.out.println("****** CLIENTE ******");
                        System.out.println("Ingrese el Alias ");
                        String Alias = cp.next();
                        System.out.println("Ingrese el Nombre ");
                        String nom = cp.next();
                        System.out.println("Ingrese el Apellido ");
                        String apel = cp.next();
                        System.out.println("Ingrese el celular ");
                        String cel = cp.next();
                        System.out.println("Ingrese el contraseña");
                        int contraseña = cp.nextInt();
                        System.out.println("Ingrese el Fecha nacimiento formato (AAAA/MM/DD)");
                        String fecha = cp.next();
                        insertar.ingreso_cliente(Alias, nom, apel, cel,contraseña ,fecha);
                        break;
                    case 5:
                        insertar.insertar_registro_compra();
                        break;
                    case 6:
                        //4.1. Cambiar el año de la bicicleta "Cannondale" por 2017
                        System.out.println("*** MODIFICACION AÑO BICICLETA ***");
                        Modificacion_Borrado.cambiar_anio_bicicleta();
                        break;
                    case 7:
                        //4.2. Cambiar el teléfono del cliente "ninja" por 3115678432
                        System.out.println("*** MODIFICACION DE NUMERO DE CLIENTE ***");
                        Modificacion_Borrado.cambiar_telefono_cliente();
                        break;
                    case 8:
                        //4.3. Borrar la intención de compra del cliente "green" de la bicicleta "Trek"
                        System.out.println("*** SE ELIMINA INTENCION DE COMPRA ***");
                        Modificacion_Borrado.borrar_intencion_compra_bicicleta();
                        break;
                    case 9:
                        System.out.println("********* CONSULTA 9 ******");
                        consultas.consulta_9();
                        break;
                    case 10:
                        System.out.println("********* CONSULTA 10 ******");
                        consultas.consulta_10();
                        break;   
                    case 11:
                        System.out.println("********* CONSULTA 11 ******");
                        consultas.consulta_11();
                        break;    
                    case 12:
                        System.out.println("********* CONSULTA 12 ******");
                        consultas.consulta_12();
                        break;
                    case 13:
                        System.out.println("********* CONSULTA 13 ******");
                        consultas.consulta_13();
                        break;
                    case 14:
                        System.out.println("********* CONSULTA 14 ******");
                        consultas.Consulta_14();
                        break;
                        
                    case 15:
                        // consultar bicicleta
                        consultas.consultar_bicicletas();
                        break;
                        
                    case 16:
                        // consultar clientes
                        consultas.consultar_clientes();
                        break;
                    case 17:
                        // consulta moto electrica
                        consultas.consultar_moto_electrica();
                        break;
                    case 18:
                        // consultar proveedor
                        consultas.consulta_proveedor();
                        break;
                        
                    case 19:
                        // consulta registro compra
                        consultas.consulta_registro_compra();
                        break;
                        
                    default:
                        System.out.println("INGRESE UN NUMERO VALIDO DEL MENU");
                        break;
                }
                
                System.out.println("**** INGRESE LA OPCION ****");
                ingreso = cp.nextInt();
            }

        } catch (Exception ex) {
            System.out.println("falla de dato ingresado");
        }
    }
    
}
