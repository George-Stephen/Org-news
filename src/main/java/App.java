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

        userDao = new Sql2oUserDao(DB.sql2o);
        departmentalDao = new Sql2oDepartmentalDao(DB.sql2o);
        departmentDao = new Sql2oDepartmentDao(DB.sql2o);
        newsDao = new Sql2oNewsDao(DB.sql2o);
        con = DB.sql2o.open();

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
        // departments
        post("/department/new","application/json",(request, response) -> {
            Department department = gson.fromJson(request.body(),Department.class);
            departmentDao.add(department);
            response.status(201);
            response.type("application/json");
            return gson.toJson(department);
        });
        get("/departments","application/json",(request, response) -> {
            response.type("application/json");
            return gson.toJson(departmentDao.all());
        });
        get("/departments/:id","application/json",(request, response) -> {
            response.type("application/json");
            int depId = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(departmentDao.FindById(depId));
        });
        // general news
        post("/news/new","application/json",(request, response) -> {
           General general = gson.fromJson(request.body(),General.class);
           newsDao.add(general);
           response.status(201);
           response.type("application/json");
           return  gson.toJson(general);
        });
        get("/news","application/json",(request, response) -> {
            response.type("application/json");
            return gson.toJson(newsDao.all());
        });
        get("/news/:id","application/json",(request, response) -> {
            response.type("application/json");
            int newsId = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(newsDao.FindById(newsId));
        });
        // departments news
        post("/special/news/new","application/json",(request, response) -> {
            Departmental departmental = gson.fromJson(request.body(),Departmental.class);
            departmentalDao.add(departmental);
            response.status(201);
            response.type("application/json");
            return gson.toJson(departmental);
        });
        get("/special/news","application/json",(request, response) -> {
            response.type("application/json");
            return gson.toJson(departmentalDao.all());
        });
        get("/special/news/:id","application/json",(request, response) -> {
            response.type("application/json");
            int DepId = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(departmentalDao.FindById(DepId));
        });

    }
}
