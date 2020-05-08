package models.dao;

import models.General;
import org.sql2o.Connection;

import java.util.List;

public interface newsDao {

    // add new news
    void add (General general);
    // list all news
    List<General>all();
    General FindById(int id);
    // delete news
    void DeleteById(int id);
    void clearAll();
}
