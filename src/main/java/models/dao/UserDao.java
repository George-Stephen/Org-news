package models.dao;

import models.User;
import java.util.List;

public interface UserDao {

    // add new user
    void add(User user);
    // list all users
    List<User>all();
    User FindById(int id);
    // update user
    void update(int id,String newName,int newAge,String newPhone,String newEmail,String newPosition,int newDepartmentId);
    // delete user
    void DeleteByUser(int id);
    void clearAll();
}
