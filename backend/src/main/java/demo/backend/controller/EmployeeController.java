package demo.backend.controller;

import backend.demo.inbound.EmployeeProfileInbound;
import backend.demo.outbound.SaveProfileOutbound;
import demo.backend.constants.Constants;
import demo.backend.repository.EmployeeRepository;
import demo.backend.service.EmployeeProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RequestMapping("${demo-app-profile-root}")
@RestController
public class EmployeeController {

//    @RequestBody EmployeeProfileInbound employee

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeProfileService employeeProfileService;

    /*
        Mono<ResponseEntity<T>> -- this provides all three -- response status, headers, and body,
        asynchronously at a later point. IT allows the response status and headers to vary depending
        on the outcome of asynchronous request handling.
     */
    @PostMapping(value = Constants.EMPLOYEE_PROFILE, consumes = Constants.APPLICATION_VND_V1_JSON)
    public Mono<ResponseEntity<SaveProfileOutbound>> addEmployee(
            @RequestHeader(value = Constants.CLIENT_ID, required = true) String client_id,
            @RequestBody EmployeeProfileInbound employeeProfile) {
        log.info("Employee :: {}", employeeProfile);
        return employeeProfileService.addEmployeeProfile(employeeProfile).map(ResponseEntity::ok);
    }

    @GetMapping("/employees")
    @ResponseBody
    public String getAllEmployees() {
        log.info("Running Employees Method - Controller");
        return employeeRepository.findAll().toString();
    }

}

