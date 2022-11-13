package mx.uv;
import static spark.Spark.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        // AXIOS
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        
        get("/hello",(req, res) -> "Hello World");
        get("/jair",(req, res) -> "Hola Jair");
        get("/alex",(req, res) -> "Hello Alex");
        get("/",(req, res) -> "<h1>Bienvenido</h1><img src='https://www.uv.mx/v2/images/logouv.jpg'>");

        post("/", (req, res) -> {
            System.out.println(req.queryParams("email") + " " + req.queryParams("password"));
            System.out.println(req.body());
            JsonParser parser = new JsonParser(); 
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticionDelCliente = arbol.getAsJsonObject();
            System.out.println(peticionDelCliente.get("email"));
            System.out.println(peticionDelCliente.get("password"));

            res.status (200); //Codigo de respuesta
            JsonObject oRespuesta = new JsonObject();
            oRespuesta.addProperty("msj", "Hola");
            //oRespuesta.addProperty("email",req.queryParams("email"));
            oRespuesta.addProperty("email",peticionDelCliente.get("email").getAsString());
            return oRespuesta;
        }); 
    }
}
