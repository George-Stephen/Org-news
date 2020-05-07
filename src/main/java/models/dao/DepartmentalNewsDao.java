package models.dao;

import models.Departmental;

import java.util.List;

public interface DepartmentalNewsDao {
    // add new news
    void add(Departmental departmental);
    //list all news
    List<Departmental>all();
    void FindById(int id);
    // delete
    void DeleteById(int id);
    void clearAll();
}
