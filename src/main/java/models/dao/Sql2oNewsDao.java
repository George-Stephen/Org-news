package models.dao;

import models.General;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oNewsDao implements newsDao {
    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(General general) {
        String sql = "INSERT INTO news ( news,author) VALUES (:news,:author)";
        try( Connection con = sql2o.open()){
            int id =(int)
                    con.createQuery(sql)
                    .bind(general)
                    .executeUpdate()
                    .getKey();
            general.setId(id);
        }

    }

    @Override
    public List<General> all() {
        String sql = "SELECT * FROM news";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(General.class);
        }
    }

    @Override
    public void FindById(int id) {
        String sql = "SELECT * FROM news WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }

    }

    @Override
    public void DeleteById(int id) {
        String sql = "DELETE FROM  news WHERE id = :id";
        try( Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }

    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM  news";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }

    }
}
