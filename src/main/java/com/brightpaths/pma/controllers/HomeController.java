package com.brightpaths.pma.controllers;

import com.brightpaths.pma.dao.EmployeeRepository;
import com.brightpaths.pma.dao.ProjectRepository;
import com.brightpaths.pma.dto.ChartData;
import com.brightpaths.pma.dto.EmployeeProject;
import com.brightpaths.pma.entities.Employee;
import com.brightpaths.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        Map<String, Object> map = new HashMap<>();

        // querying the DB for projects
        List<Project> projects = projectRepo.findAll();
        model.addAttribute("projects", projects);

        List<ChartData> projectData = projectRepo.getProjectStatus();

        // convert projectData object into a JSON structure for use in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
//        {["NOTSTARTED], 1], ["INPROGRESS", 2], ["COMPLETED", 1]}

        model.addAttribute("projectStatusCount", jsonString);

        // querying the DB for employees
//        List<Employee> employees = employeeRepo.findAll();
//        model.addAttribute("employeesList", employees);

//        Querying the DB for the Employee Project Count
        List<EmployeeProject> employeesProjectCount = employeeRepo.employeeProjects();
        model.addAttribute("employeesListProjectsCount", employeesProjectCount);

        return "main/home";
    }
}
