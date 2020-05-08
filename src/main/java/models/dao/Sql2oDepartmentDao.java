package models.dao;

import models.Department;
import org.sql2o.*;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentsDao {
    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Department department) {
        String sql = "INSERT INTO departments ( name , story , noofemployees) VALUES ( :name , :story, :noOfEmployees)";
        try(Connection con = sql2o.open()){
            int id = (int)
            con.createQuery(sql,true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Department> all() {
        try (Connection con = sql2o.open()){
           return con.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public Department FindById(int id) {
        try( Connection con = sql2o.open()){
            return  con.createQuery("SELECT * FROM  departments WHERE id = :id ")
                    .addParameter("id",id)
                    .executeAndFetchFirst(Department.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM departments WHERE id = :id";
        try(Connection con  = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }
   }
    @Override
    public void clearAll() {
        try(Connection con = sql2o.open()){
            con.createQuery("DELETE FROM departments")
                    .executeUpdate();
        }

    }
}
