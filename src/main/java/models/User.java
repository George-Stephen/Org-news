package models;

public class User{
  private int id ;
  private String name;
  private int Age;
  private String email;
  private String phone;
  private String Position;
  private String Role;
  private int departmentsId;

    public User(String name, int age, String email, String phone, String position, String role, int departmentsId) {
        this.name = name;
        Age = age;
        this.email = email;
        this.phone = phone;
        Position = position;
        Role = role;
        this.departmentsId = departmentsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public int getDepartmentsId() {
        return departmentsId;
    }

    public void setDepartmentsId(int departmentsId) {
        this.departmentsId = departmentsId;
    }
}