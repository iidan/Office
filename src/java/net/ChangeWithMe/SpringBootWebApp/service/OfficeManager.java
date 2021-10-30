package net.ChangeWithMe.SpringBootWebApp.service;

import net.ChangeWithMe.SpringBootWebApp.Dto.AssignTaskDto;
import net.ChangeWithMe.SpringBootWebApp.Dto.ReportDto;
import net.ChangeWithMe.SpringBootWebApp.Entity.Employee;
import net.ChangeWithMe.SpringBootWebApp.Objects.EmployeesPagesObject;
import org.springframework.stereotype.Service;

@Service
public interface OfficeManager {

    EmployeesPagesObject getAllEmployees(int page, int size, String sort);

    void createNewReport(ReportDto reportDto);

    void createNewAssignTask(AssignTaskDto assignTaskDto);

    Employee getDirectManagerById(int myEmployeeId);
}
