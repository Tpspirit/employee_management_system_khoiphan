package fi.haagahelia.employee_management_system_khoiphan;

import java.util.List;
import java.util.Locale.Category;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import fi.haagahelia.employee_management_system_khoiphan.domain.Department;
import fi.haagahelia.employee_management_system_khoiphan.domain.DepartmentRepository;
import fi.haagahelia.employee_management_system_khoiphan.domain.Employee;
import fi.haagahelia.employee_management_system_khoiphan.domain.EmployeeRepository;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void createNewEmployeeTest() throws Exception{

        Department dep1 = new Department("Security");
        departmentRepository.save(dep1);


        Employee employee = new Employee("Kevin", "Wilson", "john.wilson@gmail.com", "Lead Security", 90000, dep1);


        employeeRepository.save(employee);
        assertThat(employee.getId()).isNotNull();
    }

    @Test
    public void deleteEmployeeTest() throws Exception{

        Department dep1 = new Department("Security");
        departmentRepository.save(dep1);

        Employee employee = new Employee("Kevin", "Wilson", "john.wilson@gmail.com", "Lead Security", 90000, dep1);

        employeeRepository.save(employee);
        assertThat(employee.getId()).isNotNull();

        Long id = employee.getId();

        employeeRepository.deleteById(id);

        List<Employee> employees = (List<Employee>) employeeRepository.findAll();

        assertThat(employees).hasSize(4);
     
    }

    @Test
    public void searchEmployeeTest() throws Exception{
        Department dep1 = new Department("Security");
        departmentRepository.save(dep1);

        Employee employee = new Employee("Kevin", "Wilson", "john.wilson@gmail.com", "Lead Security", 90000, dep1);

        employeeRepository.save(employee);
        
        Employee employees = employeeRepository.findByFirstname("Kevin");

        assertThat(employees).isNotNull();
        assertThat(employees.getFirstname()).isEqualTo("Kevin");

    }
}
