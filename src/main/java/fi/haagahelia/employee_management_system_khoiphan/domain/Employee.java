package fi.haagahelia.employee_management_system_khoiphan.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String position;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "departmentid")
    private Department department;

    public Employee(){

    }

    public Employee(String firstname, String lastname, String email, String position ,double salary, Department department){
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.position = position;
        this.salary = salary;
        this.department = department;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public Department getDepartment(){
        return department;
    }

    public void setDepartment( Department department){
        this.department = department;
    }

    @Override
    public String toString(){
        if(department != null){
            return "Book [id= " + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", position=" + position + ", salary=" + salary + ", department=" + department + "]";
        } else{
            return "Book [id= " + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", position=" + position + ", salary=" + salary + "]";
        }
        
    }

}
