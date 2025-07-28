package me.iamcrk.CRUD.service;

import me.iamcrk.CRUD.entity.Employee;
import me.iamcrk.CRUD.repo.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeRepo employeeRepo;


    public List<Employee> getAll() {

        return employeeRepo.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteById(Long id) {
        employeeRepo.deleteById(id);
    }
}
