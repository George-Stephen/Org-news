import com.google.*;
import com.google.gson.Gson;
import models.*;
import models.dao.*;
import org.sql2o.*;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        Sql2oUserDao userDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oDepartmentalDao departmentalDao;
        Sql2oNewsDao newsDao;
        Connection con;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/Org_news.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        userDao = new Sql2oUserDao(sql2o);
        departmentalDao = new Sql2oDepartmentalDao(sql2o);
        departmentalDao = new Sql2oDepartmentalDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        con = sql2o.open();

        // Users
        post("/users/new", "application/json", (request, response) -> {
            User user = gson.fromJson(request.body(), User.class);
            userDao.add(user);
            response.status(201);
            response.type("application/json");
            return gson.toJson(user);
        });
        get("/users", "application/json", (request, response) -> {
            response.type("application/json");
            return gson.toJson(userDao.all());
        });
        get("user/:id", "application/json", (request, response) -> {
            response.type("application/json");
            int userId = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(userDao.FindById(userId));
        });

    }
}
