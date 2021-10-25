package com.mycompany.mywebapp.employee;

import com.mycompany.mywebapp.employee.Employee;
import com.mycompany.mywebapp.employee.EmployeeNotFoundException;
import com.mycompany.mywebapp.user.User;
import com.mycompany.mywebapp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/employees")
    public String showEmployeeList(Model model){
       List<Employee> listEmployees =service.listAll();
        model.addAttribute("listEmployees",listEmployees);

        return "employee";
    }

    @GetMapping("/employees/new")
    public String showNewForm(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("pageTitle","Add New Employee");
        return "employee_form";
    }

    @PostMapping("/employees/save")
    public String saveBranch(Employee employee, RedirectAttributes ra){
        service.save(employee);
        ra.addFlashAttribute("message","The New Employee added");
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{eid}")
    public String showEditForm(@PathVariable("eid")Integer eid, Model model, RedirectAttributes ra){
        try{
            Employee employee=service.get(eid);
            model.addAttribute("employee",employee);
            model.addAttribute("pageTitle","Edit Employee (ID:"+eid+")");

            return "employee_form";
        }catch(EmployeeNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/employees";
        }
    }

    @GetMapping("/employees/delete/{eid}")
    public String deleteBranch(@PathVariable("eid")Integer eid,RedirectAttributes ra){
        try{
            service.delete(eid);
            ra.addFlashAttribute("message","the Employee "+eid+" has been deleted");

        }catch(EmployeeNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());

        }
        return "redirect:/employees";
    }

}
