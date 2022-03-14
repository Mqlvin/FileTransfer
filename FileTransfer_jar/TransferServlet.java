import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class TransferServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        HashMap<String, String> parameters = new HashMap<>();
        request.getParameterMap().forEach((k, v) -> parameters.put(k, v[0]));
        if(!parameters.keySet().contains("file")) {
            JsonObject object = new JsonObject();
            object.addProperty("status", "error");
            object.addProperty("missing", "file");
            out.println(object);
            out.close();
            return;
        }





        JsonObject object = new JsonObject();
        object.addProperty("version", "0.0.1");
        object.addProperty("author", "Henry");
        out.println(new GsonBuilder().setPrettyPrinting().create().toJson(object));
    }
}