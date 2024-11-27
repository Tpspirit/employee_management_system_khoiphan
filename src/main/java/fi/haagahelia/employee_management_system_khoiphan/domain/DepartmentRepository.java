package fi.haagahelia.employee_management_system_khoiphan.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Department findByName(String name);
}