package models.dao;

import models.Department;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {
    private static Connection conn;
    private static Sql2oDepartmentDao departmentDao;
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
    public void addingDepartmentSetsId() throws Exception {
        Department testDepartment = setupNewDepartment();
        int originalDepartmentId = testDepartment.getId();
        departmentDao.add(testDepartment);
        assertNotEquals(originalDepartmentId, testDepartment.getId());
    }

    @Test
    public void getAll() throws Exception{
        Department testDepartment = new Department("accounting", "handles firm budget", 6);
        departmentDao.add(testDepartment);
        assertEquals(1, departmentDao.all().size());
    }

    @Test
    public void addedDepartmentsAreReturnedFromGetAll() throws Exception {
        Department testDepartment = setupNewDepartment();
        assertEquals(1, departmentDao.all().size());
    }
    @Test
    public void noDepartmentsReturnsEmptyList() throws Exception {
        assertEquals(0, departmentDao.all().size());
    }

    @Test
    public void findByIdReturnsCorrectDepartment() throws Exception {
        Department testDepartment = setupNewDepartment();
        Department otherDepartment = setupNewDepartment();
        assertEquals(testDepartment, departmentDao.FindById(testDepartment.getId()));
    }


    @Test
    public void deleteByIdDeletesCorrectDepartment() throws Exception {
        Department testDepartment = setupNewDepartment();
        departmentDao.deleteById(testDepartment.getId());
        assertEquals(0, departmentDao.all().size());
    }

    @Test
    public void clearAll() throws Exception {
        Department testDepartment = setupNewDepartment();
        Department otherDepartment = setupNewDepartment();
        departmentDao.clearAll();
        assertEquals(0, departmentDao.all().size());
    }

    public Department setupNewDepartment(){
        Department department = new Department("accounting", "handles company's finance", 5);
        departmentDao.add(department);
        return department;
    }
}