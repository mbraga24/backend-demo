package demo.backend.service;

import backend.demo.inbound.EmployeeProfileInbound;
import backend.demo.outbound.SaveProfileOutbound;
import demo.backend.Entity.Employee;
import demo.backend.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
//@RequiredArgsConstructor
public class EmployeeProfileService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Mono<SaveProfileOutbound> addEmployeeProfile(EmployeeProfileInbound employeeProfile) {

        Employee newEntity = new Employee();

        setEmployeeProfile(employeeProfile, newEntity);

        newEntity = employeeRepository.save(newEntity);

        SaveProfileOutbound saveProfileOutbound = new SaveProfileOutbound();
        saveProfileOutbound.setEmployeeId(newEntity.getId());
        saveProfileOutbound.setMessage("Employee saved successfully.");
        return Mono.just(saveProfileOutbound);
    }

    public void setEmployeeProfile(EmployeeProfileInbound employeeProfile, Employee employeeEntity) {
        employeeEntity.setFirstName(employeeProfile.getFirstName());
        employeeEntity.setLastName(employeeProfile.getLastName());
        employeeEntity.setRole(employeeProfile.getRole());
        employeeEntity.setColors(String.valueOf(employeeProfile.getColors()));
    }

}
