package fi.haagahelia.employee_management_system_khoiphan.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentid;
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> employees;
    
    public Department(){

    }

    public Department(String name){
        super();
        this.name = name;
    }

    public Long getDepartmentid(){
        return departmentid;
    }

    public void setDepartmentid(Long departmentid){
        this.departmentid = departmentid;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    public void setEmployees(List<Employee> employees){
        this.employees = employees;
    }

    @Override
    public String toString(){
        return "Department [id=" + departmentid + ", name=" + name + "]";
    }

}
    


