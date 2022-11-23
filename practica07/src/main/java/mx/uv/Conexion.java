package mx.uv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url = "jdbc:mysql://localhost/nombreBD";
    private static String DriverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = ""; 
    private static Connection con = null;

    public static Connection getConnection(){
        try{
            Class.forName(DriverName);
            con = DriverManager.getConnection(url, username, password);
            return con;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }catch(ClassNotFoundException e){
            System.out.println("No se encontró el driver");
            return null;
        }
    }
}
