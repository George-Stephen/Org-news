package models;

import java.util.Objects;

public class Department {
    private int id ;
    private String name ;
    private String story ;
    private  int NoOfEmployees;

    public Department(String name, String story, int noOfEmployees) {
        this.name = name;
        this.story = story;
        NoOfEmployees = noOfEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                NoOfEmployees == that.NoOfEmployees &&
                Objects.equals(name, that.name) &&
                Objects.equals(story, that.story);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, story, NoOfEmployees);
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

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public int getNoOfEmployees() {
        return NoOfEmployees;
    }

    public void setNoOfEmployees(int noOfEmployees) {
        NoOfEmployees = noOfEmployees;
    }
}
