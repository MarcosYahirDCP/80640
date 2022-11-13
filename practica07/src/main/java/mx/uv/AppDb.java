package mx.uv;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

public class App 
{
    public static Gson gson = new Gson();
    //Base de datos en memoria
    public static Map<String, usuario> usuarios = new HashMap<>();
    
    public static void main( String[] args )
    {
        port(80);
        // Inicializacion de datos
        usuario u1 = new usuario("1", "pablo", "1234");
        usuario u2 = new usuario("2", "ana", "1234");
        usuarios.put(u1.getId(), u1);
        usuarios.put(u2.getId(), u2);
        System.out.println( "Hello World!" );
       // before((req,res)-> res.type("application/json"));
        get("/usuario", (req,res)-> gson.toJson(u1));
        get("/usuarios", (req,res)-> gson.toJson(usuarios));
        post("/", (req,res)->{
            String datosFormulario = req.body();
            usuario u = gson.fromJson(datosFormulario, usuario.class);
            usuarios.put(u.getId(), u);
            return "Usuario agregado!";
        });
    }
}