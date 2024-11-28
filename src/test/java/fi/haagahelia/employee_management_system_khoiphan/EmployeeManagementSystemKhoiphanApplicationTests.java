package fi.haagahelia.employee_management_system_khoiphan;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.haagahelia.employee_management_system_khoiphan.web.EmployeeController;

@SpringBootTest
class EmployeeManagementSystemKhoiphanApplicationTests {

	@Autowired
	private EmployeeController employeeController;

	@Test
	void contextLoads() throws Exception{
		assertThat(employeeController).isNotNull();
	}

}
