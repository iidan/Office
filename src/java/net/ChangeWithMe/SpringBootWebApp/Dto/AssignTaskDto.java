package net.ChangeWithMe.SpringBootWebApp.Dto;

import java.sql.Timestamp;

public class AssignTaskDto {

    private Timestamp assignDate;
    private Timestamp dueDate;
    private int employeeId;
    private String task;

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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
