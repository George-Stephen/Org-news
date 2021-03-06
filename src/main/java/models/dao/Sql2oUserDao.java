package models.dao;

import models.User;
import org.sql2o.*;

import java.util.List;

public class Sql2oUserDao implements UserDao {

    private final Sql2o sql2o;
    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(User user) {
        String sql= "INSERT INTO users(name,email,phone,position,departmentsid) VALUES (:name,:email,:phone,:position,:departmentsId)";
        try(Connection con = sql2o.open()){
            int id = (int)
            con.createQuery(sql,true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        }

    }

    @Override
    public List<User> all() {
        String sql = "SELECT * FROM users";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public User FindById(int id) {
        String sql = "SELECT * FROM users WHERE id = :id";
        try( Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(User.class);
        }

    }

    @Override
    public void update(int id,String newName,int newAge,String newPhone,String newEmail,String newPosition,int newDepartmentId) {
        String sql ="UPDATE users SET(Name,Age, email, phone, position,departmentsId) =(:name, :age, :email, :phone, :position,:departmentId)WHERE id=:id ";
        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name",newName)
                    .addParameter("Age",newAge)
                    .addParameter("email",newEmail)
                    .addParameter("phone",newPhone)
                    .addParameter("position",newPosition)
                    .addParameter("departmentId",newDepartmentId)
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }

    @Override
    public void DeleteByUser(int id) {
        String sql = "DELETE FROM users WHERE id = :id";
        try( Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }

    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM users ";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                .executeUpdate();
        }
    }
}
