package com.brightpaths.pma.services;

import com.brightpaths.pma.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    // field injection (also a use case of @Qualifier)
    // @Qualifier("staffRepositoryImpl1")
    @Autowired
    EmployeeRepository employeeRepo;

    // constructor injection with @Qualifier as an example
//    public EmployeeService(@Qualifier("staffRepositoryImpl1") EmployeeRepository employeeRepo) {
//        super();
//        this.employeeRepo = employeeRepo;
//    }

    // Setter injection with @Qualifier as an example (EmployeeRepository would also have to change to StaffRepositoryImpl1)
//    @Autowired
    //@Qualifier("staffRepositoryImpl1")
//    public void setEmployeeRepo(EmployeeRepository employeeRepo) {
//        this.employeeRepo = employeeRepo;
//    }

}
