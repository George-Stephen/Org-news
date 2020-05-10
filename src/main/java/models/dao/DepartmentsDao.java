package models.dao;

import models.Department;
import models.Departmental;
import models.User;

import java.util.List;

public interface DepartmentsDao {
    // add departments
    void add (Department department);
    // list all departments
    List<Department>all();
    Department FindById(int id);
    List<Departmental>allNewsbyId(int id);
    List<User>allUsersbyId(int id);
    // delete
    void deleteById(int id);
    void clearAll();

}
