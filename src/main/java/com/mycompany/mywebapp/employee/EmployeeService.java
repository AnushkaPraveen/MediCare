package com.mycompany.mywebapp.employee;

import com.mycompany.mywebapp.employee.Employee;
import com.mycompany.mywebapp.employee.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repo;

    public List<Employee> listAll() {
        return (List<Employee>) repo.findAll();
    }

    public void save(Employee employee) {
        repo.save(employee);
    }

    public Employee get(Integer eid) throws EmployeeNotFoundException {
        Optional<Employee> result = repo.findById(eid);
        if (result.isPresent()) {
            return result.get();
        }
        throw new EmployeeNotFoundException("Could not find any users with ID " + eid);
    }

    public void delete(Integer eid) throws EmployeeNotFoundException {
        Optional<Employee> count = repo.findById(eid);
        if (count.isEmpty()) throw new EmployeeNotFoundException("Could not find any users with ID " + eid);
        repo.deleteById(eid);
    }


}
