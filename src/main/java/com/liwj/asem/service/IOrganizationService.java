package com.liwj.asem.service;

import com.liwj.asem.bo.SelectionBO;
import com.liwj.asem.bo.UnitBO;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.model.*;

import java.util.HashMap;
import java.util.List;

public interface IOrganizationService {

    Integer getNumberOfPrimaryTeachingInstitution(Long id);

    Integer getNumberOfGrade(Long id);

    List<UnitBO> getUnitsForAllocation(UserDTO user, String type);

    List<SelectionBO> getYears(UserDTO user);

    List<SelectionBO> getColleges(UserDTO user);

    List<SelectionBO> getMajors(UserDTO user);

    List<SelectionBO> getGrades(UserDTO user);

    List<SelectionBO> getMajorsByCollege(Long id);

    List<SelectionBO> getGradesByMajor(Long id);

    List<SelectionBO> getClassByGradeAndMajor(Long majorId, Long gradeId);

    List<SelectionBO> getManageGrades(UserDTO user);

    List<SelectionBO> getManageClassByGrade(UserDTO user, Long gradeId);
}
