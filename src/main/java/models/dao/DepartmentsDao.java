package models.dao;

import models.Departments;

import java.util.List;

public interface DepartmentsDao {
    // add departments
    void add (Departments departments);
    // list all departments
    List<Departments>all();
    Departments FindById(int id);
    // update departments
    void update(int id, String newName,String newDescription,int newEmployees);
    // delete
    void deleteById(int id);
    void clearAll();

}
