package mx.uv;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      //  System.out.println( "Hello World!" );
        get("/hello", (req, res) -> "Hello World");
        get("/Brandon", (req, res) -> "Hello Brandon");
        get("/", (req, res) -> "<h1> Bienvenido </h1><img src='https://play-lh.googleusercontent.com/8ddL1kuoNUB5vUvgDVjYY3_6HwQcrg1K2fd_R8soD-e2QYj8fT9cfhfh3G0hnSruLKec'>");
       


    }
}
