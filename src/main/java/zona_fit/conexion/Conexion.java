package zona_fit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConnection(){
        Connection conexion = null;
        var USER = "root";
        var PASSWORD = "admin";
        var BD = "zona_fit_db";
        var URL = "jdbc:mysql://localhost:3306/" + BD;
        try{
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(Exception e){
            System.out.println("Error al conectar base de datos: " + e.getMessage());
        }
        return conexion;
    }


    public static void main(String[] args) {
        var conexion = Conexion.getConnection();
        if(conexion != null){
            System.out.println(conexion);
        }else{
            System.out.println("error");
        }
    }
}
