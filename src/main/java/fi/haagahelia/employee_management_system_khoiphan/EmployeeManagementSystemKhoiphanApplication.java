package fi.haagahelia.employee_management_system_khoiphan;

import java.util.Locale.Category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.employee_management_system_khoiphan.domain.Department;
import fi.haagahelia.employee_management_system_khoiphan.domain.DepartmentRepository;
import fi.haagahelia.employee_management_system_khoiphan.domain.Employee;
import fi.haagahelia.employee_management_system_khoiphan.domain.EmployeeRepository;
import fi.haagahelia.employee_management_system_khoiphan.domain.User;
import fi.haagahelia.employee_management_system_khoiphan.domain.UserRepository;

@SpringBootApplication
public class EmployeeManagementSystemKhoiphanApplication {

	public static final Logger log = LoggerFactory.getLogger(EmployeeManagementSystemKhoiphanApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemKhoiphanApplication.class, args);
	}

	@Bean
	public CommandLineRunner employeeDemo(EmployeeRepository repository, DepartmentRepository departmentrepository, UserRepository uRepository){
		return (args) -> {

			log.info("Create some departments.");
			Department dep1 = new Department("Engineering");
			Department dep2 = new Department("Marketing");
			Department dep3 = new Department("Sales");
			Department dep4 = new Department("Finance");

			departmentrepository.save(dep1);
			departmentrepository.save(dep2);
			departmentrepository.save(dep3);
			departmentrepository.save(dep4);


			log.info("Save some employees.");
			repository.save(new Employee("Ethan", "Hunt", "ethan.hunt@gmail.com", "Financial Analyst", 90000.00, dep4));
			repository.save(new Employee("John", "Connor", "john.connor@gmail.com", "Sales Executive", 120000.00, dep3));
			repository.save(new Employee("Bob", "Smith", "bob.smith@gmail.com", "Marketing Director", 150000.00, dep2));
			repository.save(new Employee("Jack", "Neilson", "jack.neilson@gmail.com", "Software Engineer", 200000.00, dep1));
			

			log.info("Fetch all books.");
			for(Employee employee : repository.findAll()){
				log.info(employee.toString());
			}


			log.info("Fetch all books.");
			for(Employee employee : repository.findAll()){
				log.info(employee.toString());
			}

			log.info("Save some users.");
			User user1 = new User("user", "$2a$10$5eota6DvrUlNFvzBwbVgO.a1UF4CCdw9wCgVAB8IfAauxnsVNxxje", "user@email.com", "USER");
			User admin = new User("admin","$2a$10$PN6dyQHTqf8exRftszQvXuzn9JrG4NQp76r5PMAbFnU7sUgvSVQT.", "admin@email.com","ADMIN");
			
			// user1 - username: user password: user
			uRepository.save(user1); 
			// admin - username: admin password: admin
			uRepository.save(admin);
		};
	}
}
