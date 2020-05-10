package models.dao;

import models.Department;
import models.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oUserDaoTest {
    private static Connection conn;
    private  static  Sql2oDepartmentDao departmentDao;
    private static Sql2oUserDao userDao;
    private static Sql2oNewsDao newsDao;
    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/org_news_test";
        Sql2o sql2o = new Sql2o(connectionString, "stephen", "stephen2020");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        departmentDao.clearAll();
        userDao.clearAll();
        newsDao.clearAll();
    }
    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }
    @Test
    public void addingUserSetsId() throws Exception {
        User testUser = setupNewUser();
        int originalUserId = testUser.getId();
        userDao.add(testUser);
        assertNotEquals(originalUserId, testUser.getId());
    }

    @Test
    public void addedUsersAreReturnedFromGetAll() throws Exception {
        User testUser = setupNewUser();
        userDao.add(testUser);
        assertEquals(1, userDao.all().size());
    }

    @Test
    public void noUserReturnsEmptyList() throws Exception {
        assertEquals(0, userDao.all().size());
    }

    @Test
    public void deleteByIdDeletesCorrectUser() throws Exception {
        User user = setupNewUser();
        userDao.add(user);
        userDao.DeleteByUser(user.getId());
        assertEquals(0, userDao.all().size());
    }

    @Test
    public void clearAll() throws Exception {
        User testUser = setupNewUser();
        User otherUser = setupNewUser();
        userDao.clearAll();
        assertEquals(0, userDao.all().size());
    }

    public Department setupDepartment() {
        Department department = new Department("accounting", "handles firm budget", 6);
        departmentDao.add(department);
        return department;
    }

    public User setupUserForDepartment(Department department) {
        User user = new User("Annette", "yazz@gmail.com","01234567", "programmer",department.getId());
        userDao.add(user);
        return user;
    }
    public User setupNewUser(){
        return new User("James", "yazz@gmail.com", "01234567","programmer",1);
    }
}