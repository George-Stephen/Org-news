import models.dao.Sql2oNewsDao;
import org.sql2o.*;

public  class DB{
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/org_news","stephen","stephen2020");
}