package models;

public class Admin extends User{

    public Admin(String name, int age, String email, String phone, String position, int departmentsId) {
        super(name, age, email, phone, position, departmentsId);
    }
}