package models.dao;

import models.Departments;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentsDao {
    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Departments departments) {
        String sql = "INSERT INTO departments(Name,Description,Employees) VALUES (:Name,:Description,:Employees)";
        try(Connection con = sql2o.open()){
            int id= (int)
            con.createQuery(sql)
                    .bind(departments)
                    .executeUpdate()
                    .getKey();
            departments.setId(id);
        }

    }

    @Override
    public List<Departments> all() {
        String sql = "SELECT *  FROM departments ";
        try(Connection con = sql2o.open()){
            return  con.createQuery(sql)
                    .executeAndFetch(Departments.class);
        }
    }

    @Override
    public void FindById(int id) {
        String sql = "SELECT *  FROM departments WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Departments.class);
        }

    }

    @Override
    public void update(int id, String newName,String newDescription,int newEmployees) {
        String sql = "UPDATE departments SET(Name,Description,Employees) = (:newName,:newDescription,:newEmployees)WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("newName",newName)
                    .addParameter("newDescription",newDescription)
                    .addParameter("newEmployees",newEmployees)
                    .addParameter("id",id)
                    .executeUpdate();
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM departments WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }

    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM departments";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }

    }
}
