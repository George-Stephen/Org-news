package  models;

import models.General;

public class Departmental extends General {
    private int departmentId;

    public Departmental(String news, String author,int departmentId) {
        super(news, author);
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}