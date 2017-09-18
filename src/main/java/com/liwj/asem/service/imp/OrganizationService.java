package com.liwj.asem.service.imp;


import com.liwj.asem.bo.SelectionBO;
import com.liwj.asem.bo.UnitBO;
import com.liwj.asem.dao.*;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.UnitTypeEnum;
import com.liwj.asem.model.*;
import com.liwj.asem.service.IOrganizationService;
import com.liwj.asem.service.IUserService;
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

    @Autowired
    private RPrimaryAndSecondaryTeachingInstitutionMapper primaryAndSecondaryTeachingInstitutionMapper;

    @Autowired
    private RGradeAndSecondaryTeachingInstitutionMapper gradeAndSecondaryTeachingInstitutionMapper;

    @Autowired
    private ClassesMapper classesMapper;

    @Autowired
    private IUserService userService;


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

    @Override
    public List<SelectionBO> getMajorsByCollege(Long id) {
        RPrimaryAndSecondaryTeachingInstitutionExample example = new RPrimaryAndSecondaryTeachingInstitutionExample();
        example.createCriteria().andPrimaryTeachingInstitutionIdEqualTo(id);
        List<RPrimaryAndSecondaryTeachingInstitution> list = primaryAndSecondaryTeachingInstitutionMapper.selectByExample(example);
        List<SelectionBO> res = new ArrayList<>();
        for (RPrimaryAndSecondaryTeachingInstitution institution: list){
            SelectionBO bo = new SelectionBO();
            bo.setId(institution.getSecondaryTeachingInstitutionId());
            SecondaryTeachingInstitution secondaryTeachingInstitution = secondaryTeachingInstitutionMapper.selectByPrimaryKey(institution.getSecondaryTeachingInstitutionId());
            bo.setName(secondaryTeachingInstitution.getName());
            res.add(bo);
        }
        return res;
    }

    @Override
    public List<SelectionBO> getGradesByMajor(Long id) {
        RGradeAndSecondaryTeachingInstitutionExample example = new RGradeAndSecondaryTeachingInstitutionExample();
        example.createCriteria().andSecondaryTeachingInstitutionIdEqualTo(id);
        List<RGradeAndSecondaryTeachingInstitution> list = gradeAndSecondaryTeachingInstitutionMapper.selectByExample(example);
        List<SelectionBO> res = new ArrayList<>();
        for (RGradeAndSecondaryTeachingInstitution institution: list){
            SelectionBO bo = new SelectionBO();
            bo.setId(institution.getGradeId());
            Grade grade = gradeMapper.selectByPrimaryKey(institution.getGradeId());
            bo.setName(grade.getName());
            res.add(bo);
        }
        return res;
    }

    @Override
    public List<SelectionBO> getClassByGradeAndMajor(Long majorId, Long gradeId) {
        ClassesExample example = new ClassesExample();
        example.createCriteria().andSecondaryTeachingInstitutionEqualTo(majorId)
                .andGradeIdEqualTo(gradeId);
        List<Classes> list = classesMapper.selectByExample(example);
        List<SelectionBO> res = new ArrayList<>();
        for (Classes classes: list){
            SelectionBO bo = new SelectionBO();
            bo.setId(classes.getId());
            bo.setName(classes.getName());
            res.add(bo);
        }
        return res;
    }

    @Override
    public List<SelectionBO> getManageGrades(UserDTO user) {
        if (userService.isGradeManger(user)){
            List<Grade> grades = user.getManageGrades();
            List<SelectionBO> res = new ArrayList<>();
            for (Grade grade: grades){
                SelectionBO bo = new SelectionBO();
                bo.setId(grade.getId());
                bo.setName(grade.getName());
                res.add(bo);
            }
            return res;
        }
        return null;
    }

    @Override
    public List<SelectionBO> getManageClassByGrade(UserDTO user, Long gradeId) {
        if (userService.isGradeManger(user)){
            if (gradeId!=null&& gradeId>0){
                ClassesExample example = new ClassesExample();
                example.createCriteria().andGradeIdEqualTo(gradeId).andSecondaryTeachingInstitutionEqualTo(user.getSecondaryTeachingInstitution().getId());
                List<Classes> list = classesMapper.selectByExample(example);
                List<SelectionBO> res = new ArrayList<>();
                for (Classes classes: list){
                    SelectionBO bo = new SelectionBO();
                    bo.setId(classes.getId());
                    bo.setName(classes.getName());
                    res.add(bo);
                }
                return res;
            }
        }
        return new ArrayList<>();
    }


}
