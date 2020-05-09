import com.google.*;
import com.google.gson.Gson;
import models.*;
import models.dao.*;
import  exceptions.*;
import org.sql2o.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
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

/*        // Users
       post("/users/new", "application/json", (request, response) -> {
            User user = gson.fromJson(request.body(), User.class);
            userDao.add(user);
            response.status(201);
            return gson.toJson(user);
        });
        get("/users", "application/json", (request, response) -> {
            return gson.toJson(userDao.all());
        });
        get("user/:id", "application/json", (request, response) -> {
            response.type("application/json");
            int userId = Integer.parseInt(request.params("id"));
            User user = userDao.FindById(userId);
            if( user == null){
                throw new ApiException(404,String.format("No user with the id: \"%s\" exists",request.params("id")));
            }
            return gson.toJson(user);
        });
        // departments
        post("/department/new","application/json",(request, response) -> {
            Department department = gson.fromJson(request.body(),Department.class);
            departmentDao.add(department);
            response.status(201);
            return gson.toJson(department);
        });
        get("/departments","application/json",(request, response) -> {
            return gson.toJson(departmentDao.all());
        });
        get("/departments/:id","application/json",(request, response) -> {
            int depId = Integer.parseInt(request.params("id"));
            Department department = departmentDao.FindById(depId);
            if( department == null){
                throw new ApiException(404,String.format("No department with the id: \"%s\" exists",request.params("id")));
            }
            return gson.toJson(department);
        });
        get("/departments/:id/news","application/json",(request, response) -> {
            int depId = Integer.parseInt(request.params("id"));
            List<Departmental> allNews = departmentDao.allNewsbyId(depId);
            if(allNews == null){
                throw new ApiException(404,"No news has been recorded in the department");
            }
            return  gson.toJson(allNews);
        });
        get("/departments/:id/users","application/json",(request, response) -> {
            int depId = Integer.parseInt(request.params("id"));
            List<User>allUsers = departmentDao.allUsersbyId(depId);
            if (allUsers == null){
                throw new ApiException(404,"No members present in the department");
            }
            return gson.toJson(allUsers);
        });
        // general news
        post("/news/new","application/json",(request, response) -> {
           General general = gson.fromJson(request.body(),General.class);
           newsDao.add(general);
           response.status(201);
           return  gson.toJson(general);
        });
        get("/news","application/json",(request, response) -> {
            return gson.toJson(newsDao.all());
        });
        get("/news/:id","application/json",(request, response) -> {
            int newsId = Integer.parseInt(request.params("id"));
            General general =newsDao.FindById(newsId);
            if( general == null){
                throw new ApiException(404,String.format("No general news with the id: \"%s\" exists",request.params("id")));
            }
            return gson.toJson(general);
        });
        // departments news
        post("/special/news/new","application/json",(request, response) -> {
            Departmental departmental = gson.fromJson(request.body(),Departmental.class);
            departmentalDao.add(departmental);
            response.status(201);
            return gson.toJson(departmental);
        });
        get("/special/news","application/json",(request, response) -> {
            return gson.toJson(departmentalDao.all());
        });
        get("/special/news/:id","application/json",(request, response) -> {
            int DepId = Integer.parseInt(request.params("id"));
            Departmental departmental =departmentalDao.FindById(DepId);
            if( departmental == null){
                throw new ApiException(404,String.format("No departmental news  with the id: \"%s\" exists",request.params("id")));
            }
            return gson.toJson(departmental);
        });

        // filters
        exception(ApiException.class, (exc, req, res) -> {
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatus());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json"); //after does not run in case of an exception.
            res.status(err.getStatus()); //set the status
            res.body(gson.toJson(jsonMap));  //set the output.
        });

        after((request, response) -> {
           response.type("application/json");
        });

*/
get("/",(request, response) -> {
    Map<Object,String>model = new HashMap<>();
    return new ModelAndView("model","index.hbs");
},new HandlebarsTemplateEngine());
// all forms displayed
        get("/employees/new",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"employee-form.hbs");
        }, new HandlebarsTemplateEngine());
        get("departments/new",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "dep-form.hbs");
        },new HandlebarsTemplateEngine());
        get("/news/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"gen-form.hbs");
        }, new HandlebarsTemplateEngine());
        get("/special/new",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"special-form.hbs");
        }, new HandlebarsTemplateEngine());
        // post all data
        post("/employees",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String email = request.queryParams("email");
            String phone = request.queryParams("phone");
            String position = request.queryParams("position");
            int DepId = Integer.parseInt(request.queryParams("DepId"));
            User user = new User(name,email,phone,position,DepId);
            userDao.add(user);
            return new ModelAndView(model,"employees.hbs");
        }, new HandlebarsTemplateEngine());
        post("/departments", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String story = request.queryParams("story");
            int number = Integer.parseInt(request.queryParams("number"));
            Department department = new Department(name,story,number);
            departmentDao.add(department);
            return new ModelAndView(model,"departments.hbs");
        }, new HandlebarsTemplateEngine());
        post("/news",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String author = request.queryParams("author");
            String news = request.queryParams("news");
            General general = new General(news,author);
            newsDao.add(general);
            return new ModelAndView(model,"news.hbs");
        },new HandlebarsTemplateEngine());
        post("/special",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String author = request.queryParams("author");
            String news = request.queryParams("news");
            int DepId = Integer.parseInt(request.queryParams("depId"));
            Departmental departmental = new Departmental(news,author,DepId);
            departmentalDao.add(departmental);
            return new ModelAndView(model,"special.hbs");
        },new HandlebarsTemplateEngine());
        // display all data
        get("/departments",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Department>departments= departmentDao.all();
            model.put("department",departments);
            return new ModelAndView(model,"departments.hbs");
        }, new HandlebarsTemplateEngine());
        get("/employees", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<User> user= userDao.all();
            model.put("users",user);
            return new ModelAndView(model, "employees.hbs");
        }, new HandlebarsTemplateEngine());
        get("/news", (request, response) -> {
            Map<String,Object>model = new HashMap<>();
            List<General>news = newsDao.all();
            model.put("news",news);
            return new ModelAndView(model,"news.hbs");
        }, new HandlebarsTemplateEngine() );
        get("/special", (request, response) -> {
            Map<String,Object>model = new HashMap<>();
            List<Departmental>special = departmentalDao.all();
            model.put("special",special);
            return new ModelAndView(model,"special.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
