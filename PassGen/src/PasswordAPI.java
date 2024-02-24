package PassGen.src;

import static spark.Spark.*;
import spark.Request;
import spark.Response;

public class PasswordAPI {
    get("/hello/:name", (req,res)->{
        return "Hello, "+ req.params(":name");
    });
}

}
