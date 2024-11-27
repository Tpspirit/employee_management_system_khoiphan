package fi.haagahelia.employee_management_system_khoiphan.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    Employee findByFirstname(String firstname);
}
