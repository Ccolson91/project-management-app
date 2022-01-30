package com.brightpaths.pma.controllers;

import com.brightpaths.pma.dao.EmployeeRepository;
import com.brightpaths.pma.dao.ProjectRepository;
import com.brightpaths.pma.entities.Employee;
import com.brightpaths.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("/")
    public String displayHome(Model model) {

        // querying the DB for projects
        List<Project> projects = projectRepo.findAll();
        model.addAttribute("projects", projects);

        // querying he DB for employees
        List<Employee> employees = employeeRepo.findAll();
        model.addAttribute("employeesList", employees);

        return "main/home";
    }
}
