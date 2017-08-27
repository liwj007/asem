package com.liwj.asem.service;

import com.liwj.asem.bo.UnitBO;
import com.liwj.asem.model.*;

import java.util.HashMap;
import java.util.List;

public interface IOrganizationService {
    void createNewOrganization(String name, String type, Long collegeId, Long gradeId, Long majorId);

    void deleteOrganization(Long id, String type);

    HashMap<String,List> getAllOrganization();

    List<College> getAllColleges();

    List<Grade> getAllGrades();

    List<Major> getAllMajors();

    List<Classes> getAllClasses();

    List<Major> getMajorsByCollegeAndGrade(long collegeId, long gradeId);

    List<UnitBO> getUnitsForAllocation(User user, String type);
}
