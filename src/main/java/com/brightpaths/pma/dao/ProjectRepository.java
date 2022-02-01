package com.brightpaths.pma.dao;

import com.brightpaths.pma.dto.ChartData;
import com.brightpaths.pma.dto.EmployeeProject;
import com.brightpaths.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();


    @Query(nativeQuery=true, value = "SELECT stage AS label, COUNT(*) AS value " +
            "FROM project " +
            "GROUP BY stage")
    public List<ChartData> getProjectStatus();

}
