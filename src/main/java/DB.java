import models.dao.Sql2oNewsDao;
import org.sql2o.*;

public  class DB{
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-34-192-30-15.compute-1.amazonaws.com:5432/dao7d1kv776ob1","kezopccvwbswzd","7a4fb74ddc7a64d6c6539bad720bce69b011a5638b6ace5c08ae0cfe64557e0f");
}