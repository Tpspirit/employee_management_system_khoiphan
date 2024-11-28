package fi.haagahelia.employee_management_system_khoiphan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.employee_management_system_khoiphan.domain.DepartmentRepository;
import fi.haagahelia.employee_management_system_khoiphan.domain.Employee;
import fi.haagahelia.employee_management_system_khoiphan.domain.EmployeeRepository;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private DepartmentRepository departmentrepository;
    

    // Show employee list
    @GetMapping({"/","/employeelist"})
    public String employeelist(Model model){
        model.addAttribute("employees", repository.findAll());
        return "employeelist";
    }

    // Add employee
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentrepository.findAll());
        return "addemployee";
    }

    @PostMapping("/add")
    public String add(Employee employee){
        repository.save(employee);
        return "redirect:/employeelist";
    }


    // Edit employee
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("employee", repository.findById(id));
        model.addAttribute("departments", departmentrepository.findAll());
        return "editemployee";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        repository.deleteById(id);
        return "redirect:../employeelist";
    }
}
