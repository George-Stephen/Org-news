package models.dao;

import models.Department;

import java.util.List;

public interface DepartmentsDao {
    // add departments
    void add (Department department);
    // list all departments
    List<Department>all();
    Department FindById(int id);
    // delete
    void deleteById(int id);
    void clearAll();

}
