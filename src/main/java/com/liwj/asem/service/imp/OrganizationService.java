package com.liwj.asem.service.imp;


import com.liwj.asem.bo.SelectionBO;
import com.liwj.asem.bo.UnitBO;
import com.liwj.asem.dao.*;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.UnitTypeEnum;
import com.liwj.asem.model.*;
import com.liwj.asem.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrganizationService implements IOrganizationService {


    @Autowired
    private PrimaryTeachingInstitutionMapper primaryTeachingInstitutionMapper;


    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private AssessmentRecordMapper assessmentRecordMapper;

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

    @Override
    public List<SelectionBO> getYears(UserDTO user) {
        AssessmentRecordExample example = new AssessmentRecordExample();
        List<AssessmentRecord> res = assessmentRecordMapper.selectByExample(example);
        Set<Integer> tmp = new HashSet<>();
        for (AssessmentRecord record : res){
            tmp.add(record.getYear());
        }
        List<SelectionBO> list = new ArrayList<>();
        for (Integer year: tmp){
            SelectionBO bo = new SelectionBO();
            bo.setId(year.longValue());
            bo.setName(String.format("%d-%d学年",year,year+1));
            list.add(bo);
        }
        return list;
    }

    @Override
    public List<SelectionBO> getColleges(UserDTO user) {
        PrimaryTeachingInstitutionExample example = new PrimaryTeachingInstitutionExample();
        List<PrimaryTeachingInstitution> list = primaryTeachingInstitutionMapper.selectByExample(example);
        List<SelectionBO> res = new ArrayList<>();
        for (PrimaryTeachingInstitution institution: list){
            SelectionBO bo = new SelectionBO();
            bo.setId(institution.getId());
            bo.setName(institution.getName());
            res.add(bo);
        }
        return res;
    }

    @Override
    public List<SelectionBO> getMajors(UserDTO user) {
        SecondaryTeachingInstitutionExample example = new SecondaryTeachingInstitutionExample();
        List<SecondaryTeachingInstitution> list = secondaryTeachingInstitutionMapper.selectByExample(example);
        List<SelectionBO> res = new ArrayList<>();
        for (SecondaryTeachingInstitution institution: list){
            SelectionBO bo = new SelectionBO();
            bo.setId(institution.getId());
            bo.setName(institution.getName());
            res.add(bo);
        }
        return res;
    }

    @Override
    public List<SelectionBO> getGrades(UserDTO user) {
        GradeExample example = new GradeExample();
        List<Grade> list = gradeMapper.selectByExample(example);
        List<SelectionBO> res = new ArrayList<>();
        for (Grade institution: list){
            SelectionBO bo = new SelectionBO();
            bo.setId(institution.getId());
            bo.setName(institution.getName());
            res.add(bo);
        }
        return res;
    }
}
