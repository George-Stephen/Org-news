package models.dao;

import models.Departmental;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oDepartmentalDao implements DepartmentalNewsDao {
    private final Sql2o sql2o;

    public Sql2oDepartmentalDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Departmental departmental) {
        String sql = "INSERT INTO departmental( news,author,departmentid) VALUES (:news,:author,:departmentId)";
        try(Connection con = sql2o.open()){
            int id =(int)
            con.createQuery(sql,true)
                    .bind(departmental)
                    .executeUpdate()
                    .getKey();
            departmental.setId(id);
        }

    }

    @Override
    public List<Departmental> all() {
        String sql = "SELECT * FROM  departmental ";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Departmental.class);
        }
    }

    @Override
    public Departmental FindById(int id) {
        String sql = "SELECT * FROM departmental WHERE id = :id ";
        try( Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Departmental.class);
        }

    }

    @Override
    public void DeleteById(int id) {
        String sql = "DELETE FROM  departmental WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }

    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM  departmental";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }

    }
}
