package com.brightpaths.pma.controllers;

import com.brightpaths.pma.dao.EmployeeRepository;
import com.brightpaths.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = employeeRepo.findAll();
        model.addAttribute("employeesList", employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee singleEmployee = new Employee();
        model.addAttribute("employee", singleEmployee);
        return "employees/new-employees";
    }

    @PostMapping("/save")
    public String createEmployeeForm(Employee employee, Model model) {
        employeeRepo.save(employee);
        return "redirect:/employees";
    }

}
