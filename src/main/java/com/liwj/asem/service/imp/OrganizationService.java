package com.liwj.asem.service.imp;


import com.liwj.asem.bo.UnitBO;
import com.liwj.asem.dao.ClassesMapper;
import com.liwj.asem.dao.GradeMapper;
import com.liwj.asem.dao.PrimaryTeachingInstitutionMapper;
import com.liwj.asem.dao.SecondaryTeachingInstitutionMapper;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.UnitTypeEnum;
import com.liwj.asem.model.*;
import com.liwj.asem.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationService implements IOrganizationService {


    @Autowired
    private PrimaryTeachingInstitutionMapper primaryTeachingInstitutionMapper;


    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private ClassesMapper classesMapper;

    @Autowired
    private SecondaryTeachingInstitutionMapper secondaryTeachingInstitutionMapper;


    @Override
    public Integer getNumberOfPrimaryTeachingInstitution(Long id){
        return 100;
    }

    @Override
    public Integer getNumberOfGrade(Long id){
        return 100;
    }

    private List<PrimaryTeachingInstitution> getAllPrimaryTeachingInstitution(){
        PrimaryTeachingInstitutionExample example = new PrimaryTeachingInstitutionExample();
        List<PrimaryTeachingInstitution> list = primaryTeachingInstitutionMapper.selectByExample(example);
        return list;
    }

    private List<Grade> getAllGrades(){
        GradeExample example = new GradeExample();
        List<Grade> grades = gradeMapper.selectByExample(example);
        return grades;
    }

    @Override
    public List<UnitBO> getUnitsForAllocation(UserDTO user, String type) {
        Integer tempNumber = 100;
        List<UnitBO> lst = new ArrayList<>();
        if (type.equals(UnitTypeEnum.SCHOOL.name())) {
            List<PrimaryTeachingInstitution> tmp = getAllPrimaryTeachingInstitution();
            for (PrimaryTeachingInstitution item: tmp){
                UnitBO bo = new UnitBO(item.getId(),item.getName(), tempNumber);
                lst.add(bo);
            }
        }else if (type.equals(UnitTypeEnum.COLLEGE.name())){
            List<Grade> tmp = getAllGrades();
            for (Grade grade: tmp){
                UnitBO bo = new UnitBO(grade.getId(),grade.getName(),tempNumber);
                lst.add(bo);
            }
        }
        return lst;
    }
}
