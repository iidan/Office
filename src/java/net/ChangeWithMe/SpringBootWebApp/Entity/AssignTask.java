package net.ChangeWithMe.SpringBootWebApp.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "assign_task")
public class AssignTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "assign_date")
    private Timestamp assignDate;
    @Column(name = "due_date")
    private Timestamp dueDate;
    private String task;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @JsonBackReference
    private Employee employee;

    public int getId() {
        return id;
    }

    public Timestamp getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Timestamp assignDate) {
        this.assignDate = assignDate;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
