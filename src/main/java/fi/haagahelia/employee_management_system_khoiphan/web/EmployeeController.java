package fi.haagahelia.employee_management_system_khoiphan.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class EmployeeController {

    @GetMapping("/")
    public String index(){
        return "This is main page. Progress on going...";
    }
}
