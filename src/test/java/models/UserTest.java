package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void userInstantiatesCorrectly() {
        User newUser = setupNewUser();
        assertEquals(true, newUser instanceof User);
    }

    @Test
    public void getsUserNameReturnsUserNameCorrectly_String() {
        User newUser = setupNewUser();
        assertEquals("James", newUser.getName());
    }

    @Test
    public void setsUserNameSetsUserNameCorrectly_Annette() {
        User newUser = setupNewUser();
        newUser.setName("Annette");
        assertEquals("Annette", newUser.getName());
    }

    @Test
    public void getsDepartmentIdReturnsDepartmentIdCorrectly(){
        User newUser = setupNewUser();
        assertEquals(1, newUser.getDepartmentsId());
    }

    @Test
    public void setsDepartmentIdSetsDepartmentIdCorrectly() {
        User newUser = setupNewUser();
        newUser.setDepartmentsId(2);
        assertEquals(2, newUser.getDepartmentsId());
    }

    @Test
    public void getsPositionReturnsRoleCorrectly_String() {
        User newUser = setupNewUser();
        assertEquals("programmer", newUser.getPosition());
    }

    @Test
    public void setsRoleSetsRoleCorrectly_String() {
        User newUser = setupNewUser();
        newUser.setPosition("programmer");
        assertEquals("programmer", newUser.getPosition());
    }

    @Test
    public void userReturnsTrueIfUserNameAndDepartmentIdAndRoleAreSame() {
        User newUser = setupNewUser();
        User anotherUser = setupNewUser();
        assertEquals(true, newUser.equals(anotherUser));
    }


    public User setupNewUser(){
        return new User("James", "yazz@gmail.com", "01234567","programmer",1);
    }

}