package net.ChangeWithMe.SpringBootWebApp.service.Impl;

import net.ChangeWithMe.SpringBootWebApp.Dto.AssignTaskDto;
import net.ChangeWithMe.SpringBootWebApp.Dto.ReportDto;
import net.ChangeWithMe.SpringBootWebApp.Entity.AssignTask;
import net.ChangeWithMe.SpringBootWebApp.Entity.Employee;
import net.ChangeWithMe.SpringBootWebApp.Entity.Report;
import net.ChangeWithMe.SpringBootWebApp.Objects.EmployeesPagesObject;
import net.ChangeWithMe.SpringBootWebApp.Repository.AssignTaskRepository;
import net.ChangeWithMe.SpringBootWebApp.Repository.EmployeeRepository;
import net.ChangeWithMe.SpringBootWebApp.Repository.ReportRepository;
import net.ChangeWithMe.SpringBootWebApp.Utils.OfficeUtils;
import net.ChangeWithMe.SpringBootWebApp.service.OfficeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("BoatsManagerImpl")
public class OfficeManagerImpl implements OfficeManager {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AssignTaskRepository assignTaskRepository;

    @Autowired
    ReportRepository reportRepository;

    @Override
    public EmployeesPagesObject getAllEmployees(int page, int size, String sort) {
        Pageable pagingSort = PageRequest.of(page, size, Sort.by(sort));
        EmployeesPagesObject employeesPagesObject = new EmployeesPagesObject(employeeRepository.findAll(pagingSort));
        return employeesPagesObject;
    }

    @Override
    public Employee getDirectManagerById(int myEmployeeId) {
        return employeeRepository.getManagerByEmployeeId(myEmployeeId);
    }

    @Override
    public void createNewReport(ReportDto reportDto) {
        Employee employee = employeeRepository.getEmployeeById(reportDto.getEmployeeId());
        Report report = OfficeUtils.convertDtoToEntity(reportDto, Report.class);
        report.setEmployee(employee);
        reportRepository.save(report);
    }

    @Override
    public void createNewAssignTask(AssignTaskDto assignTaskDto) {
        Employee employee = employeeRepository.getEmployeeById(assignTaskDto.getEmployeeId());
        AssignTask assignTask = OfficeUtils.convertDtoToEntity(assignTaskDto, AssignTask.class);
        assignTask.setEmployee(employee);
        assignTaskRepository.save(assignTask);
    }
}
