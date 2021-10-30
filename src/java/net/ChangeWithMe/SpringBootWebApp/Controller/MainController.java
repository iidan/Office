package net.ChangeWithMe.SpringBootWebApp.Controller;

import net.ChangeWithMe.SpringBootWebApp.Dto.AssignTaskDto;
import net.ChangeWithMe.SpringBootWebApp.Dto.ReportDto;
import net.ChangeWithMe.SpringBootWebApp.Entity.Employee;
import net.ChangeWithMe.SpringBootWebApp.Objects.EmployeesPagesObject;
import net.ChangeWithMe.SpringBootWebApp.service.OfficeManager;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class MainController {
    private Logger log = LogManager.getLogger(MainController.class.getName());

    @Autowired
    OfficeManager officeManager;

    @GetMapping("/Employees")
    public EmployeesPagesObject loadBoats(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "1") int size,
                                          @RequestParam(defaultValue = "position") String sort) {
        EmployeesPagesObject employeesPagesObject = null;
        try {
            employeesPagesObject = officeManager.getAllEmployees(page, size, sort);
        } catch (Exception e) {
            log.error(String.format("Unable to get employees list error message : %s", e.getMessage()));
        }
        return employeesPagesObject;
    }

    @GetMapping("/get-my-direct-manager")
    public Employee getMyDirectManager(Request req, Response res, int myEmployeeId) {
        Employee manager = null;
        try {
            manager = officeManager.getDirectManagerById(myEmployeeId);
        } catch (Exception e) {
            log.error(String.format("Unable to get manager id : %d , error message : %s"
                    , myEmployeeId, e.getMessage()));
        }
        return manager;
    }

    @RequestMapping("/create-new-report")
    public void createNewReport(Request req, Response res, @RequestBody ReportDto reportDto) {
        try {
            officeManager.createNewReport(reportDto);
        } catch (Exception e) {
            log.error(String.format("Unable to create new report for employee id : %s , error message : %s"
                    , reportDto.getEmployeeId(), e.getMessage()));
        }
    }

    @RequestMapping("/create-new-assign-task")
    public void createNewAssignTask(Request req, Response res, @RequestBody AssignTaskDto assignTaskDto) {
        try {
            officeManager.createNewAssignTask(assignTaskDto);
        } catch (Exception e) {
            log.error(String.format("Unable to create assign task for employee : %s , error message : %s"
                    , assignTaskDto, e.getMessage()));
        }
    }
}
