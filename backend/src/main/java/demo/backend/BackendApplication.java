package demo.backend;

import demo.backend.Entity.Employee;
import demo.backend.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan("demo.backend")
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(EmployeeRepository repository) {
		return (args -> {
			insertJavaEmployees(repository);
			log.info("Employees :: {}", repository.findAll());
		});
	}

	public void insertJavaEmployees(EmployeeRepository repository) {
		repository.save(new Employee("Alex", "Koslo", "UX Designer", "[blue, yellow]"));
		repository.save(new Employee("Josh", "Smith", "Scrum Master", "[blue, yellow]"));
		repository.save(new Employee("Seagal", "Magal", "Developer - Front End", "[blue, yellow]"));
		repository.save(new Employee("Juan", "Diaz", "Developer - Back End", "[blue, yellow]"));
		repository.save(new Employee("Raneeb", "Patel", "Developer - Back End", "[blue, yellow]"));
		repository.save(new Employee("John", "MacKeen", "Data Scientist", "[blue, yellow]"));
	}

}
