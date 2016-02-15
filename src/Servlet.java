import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by georgipavlov on 15.02.16.
 */
@WebServlet("/")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uglyJSONString = request.getParameter("json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je= null;
        try{
            JsonParser jp = new JsonParser();
            je = jp.parse(uglyJSONString);
        }catch (NullPointerException e){
            System.out.println("invalid json");
        }
        String prettyJsonString = gson.toJson(je);
        response.getWriter().write(prettyJsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
