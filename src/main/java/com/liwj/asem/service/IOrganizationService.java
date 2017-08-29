package com.liwj.asem.service;

import com.liwj.asem.bo.UnitBO;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.model.*;

import java.util.HashMap;
import java.util.List;

public interface IOrganizationService {

    Integer getNumberOfPrimaryTeachingInstitution(Long id);

    Integer getNumberOfGrade(Long id);

    List<UnitBO> getUnitsForAllocation(UserDTO user, String type);
}
