package models;

public class User{
  private int id ;
  private String name;
  private String email;
  private String phone;
  private String position;
  private int departmentsId;

    public User(String name, String email, String phone, String position, int departmentsId) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.position = position;
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
        return position;
    }

    public void setPosition(String position) {
        position = position;
    }


    public int getDepartmentsId() {
        return departmentsId;
    }

    public void setDepartmentsId(int departmentsId) {
        this.departmentsId = departmentsId;
    }
}