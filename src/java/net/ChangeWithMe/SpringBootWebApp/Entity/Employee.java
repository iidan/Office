package net.ChangeWithMe.SpringBootWebApp.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String position;
    private int directManager;

    @OneToMany(mappedBy="employee")
    private List<AssignTask> assignTaskList;

    @OneToMany(mappedBy="employee")
    private List<Report> reportList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<AssignTask> getAssignTaskList() {
        return assignTaskList;
    }

    public void setAssignTaskList(List<AssignTask> assignTaskList) {
        this.assignTaskList = assignTaskList;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    public int getDirectManager() {
        return directManager;
    }

    public void setDirectManager(int directManager) {
        this.directManager = directManager;
    }
}
