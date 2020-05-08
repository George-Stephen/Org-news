package models;

public class Admin extends User{

    public Admin(String name,  String email, String phone, String position, int departmentsId) {
        super(name, email, phone, position, departmentsId);
    }
}