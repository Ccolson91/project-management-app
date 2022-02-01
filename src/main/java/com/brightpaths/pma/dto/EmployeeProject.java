package com.brightpaths.pma.dto;

public interface EmployeeProject {
    // property names begin with get so spring knows to get properties from dao file using the customer sql query

    public String getFirstName();
    public String getLastName();
    public int getProjectCount();

}
