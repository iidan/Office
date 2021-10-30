package net.ChangeWithMe.SpringBootWebApp.Objects;

import net.ChangeWithMe.SpringBootWebApp.Entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public class EmployeesPagesObject {
    private int pageSize;
    private List<Employee> employees;

    public EmployeesPagesObject(Page<Employee> page) {
        this.pageSize = page.getTotalPages();
        this.employees = page.getContent();
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}