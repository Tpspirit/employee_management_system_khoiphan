package fi.haagahelia.employee_management_system_khoiphan;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Locale.Category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.haagahelia.employee_management_system_khoiphan.domain.Department;
import fi.haagahelia.employee_management_system_khoiphan.domain.DepartmentRepository;

@DataJpaTest
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

     @Test
    public void createNewDepartmnetTest() throws Exception{
        
        Department dep1 = new Department("Security");

        departmentRepository.save(dep1);

        assertThat(dep1.getDepartmentid()).isNotNull();
    }

    @Test
    public void deleteDepartmnetTest() throws Exception {
        Department dep1 = new Department("Security");

        departmentRepository.save(dep1);

        assertThat(dep1.getDepartmentid()).isNotNull();

        Long id = dep1.getDepartmentid();

        departmentRepository.deleteById(id);

        List<Department> cates = (List<Department>) departmentRepository.findAll();

        assertThat(cates).hasSize(4);
    }

    @Test
    public void searchCategoryTest() throws Exception{
        Department dep1 = new Department("Security");

        departmentRepository.save(dep1);

        assertThat(dep1.getDepartmentid()).isNotNull();

        Department dep = departmentRepository.findByName("Security");

        assertThat(dep).isNotNull();
        assertThat(dep.getName()).isEqualTo("Security");

    }
}
