package com.liwj.asem.service.imp;


import com.liwj.asem.bo.ClassesBO;
import com.liwj.asem.bo.MajorBO;
import com.liwj.asem.bo.UnitBO;
import com.liwj.asem.dao.ClassesMapper;
import com.liwj.asem.dao.CollegeMapper;
import com.liwj.asem.dao.GradeMapper;
import com.liwj.asem.dao.MajorMapper;
import com.liwj.asem.enums.UnitTypeEnum;
import com.liwj.asem.model.*;
import com.liwj.asem.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OrganizationService implements IOrganizationService {

    @Autowired
    private ClassesMapper classesMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public void createNewOrganization(String name, String type, Long collegeId, Long gradeId, Long majorId) {
        HashMap<String, Object> tmp = new HashMap<>();
        switch (type) {
            case "grade":
                Grade grade = new Grade();
                grade.setName(name);
                gradeMapper.insertSelective(grade);
                break;
            case "college":
                College college = new College();
                college.setName(name);
                collegeMapper.insertSelective(college);
                break;
            case "major":
                Major major = new Major();
                major.setName(name);
                major.setCollegeId(collegeId);
                major.setGradeId(gradeId);
                majorMapper.insertSelective(major);
                break;
            case "class":
                Classes classes = new Classes(null, name, collegeId, gradeId, majorId);
                classesMapper.insertSelective(classes);
                break;
        }
    }

    @Override
    public void deleteOrganization(Long id, String type) {
        switch (type) {
            case "grade":
                gradeMapper.deleteByPrimaryKey(id);
                break;
            case "college":
                collegeMapper.deleteByPrimaryKey(id);
                break;
            case "major":
                majorMapper.deleteByPrimaryKey(id);
                break;
            case "class":
                classesMapper.deleteByPrimaryKey(id);
                break;
        }
    }

    @Override
    public HashMap<String, List> getAllOrganization() {
        HashMap<String, List> res = new HashMap<>();
        res.put("colleges", collegeMapper.selectByExample(new CollegeExample()));
        res.put("grades", gradeMapper.selectByExample(new GradeExample()));
        List<Major> majors = majorMapper.selectByExample(new MajorExample());
        List<MajorBO> majorBOS = new ArrayList<>();
        for (Major major:majors){
            MajorBO bo = new MajorBO();
            bo.setId(major.getId());
            bo.setMajorName(major.getName());

            College college = collegeMapper.selectByPrimaryKey(major.getCollegeId());
            bo.setCollegeName(college.getName());

            Grade grade = gradeMapper.selectByPrimaryKey(major.getGradeId());
            bo.setGradeName(grade.getName());

            majorBOS.add(bo);
        }
        res.put("majors",majorBOS );

        List<Classes> classes =classesMapper.selectByExample(new ClassesExample());
        List<ClassesBO> classesBOS = new ArrayList<>();
        for (Classes item: classes){
            ClassesBO bo = new ClassesBO();
            bo.setId(item.getId());
            bo.setClassName(item.getName());

            College college = collegeMapper.selectByPrimaryKey(item.getCollegeId());
            bo.setCollegeName(college.getName());

            Grade grade = gradeMapper.selectByPrimaryKey(item.getGradeId());
            bo.setGradeName(grade.getName());

            Major major = majorMapper.selectByPrimaryKey(item.getGradeId());
            bo.setMajorName(major.getName());

            classesBOS.add(bo);
        }
        res.put("classes", classesBOS);
        return res;
    }

    @Override
    public List<College> getAllColleges() {
        return collegeMapper.selectByExample(new CollegeExample());
    }

    @Override
    public List<Grade> getAllGrades() {
        return gradeMapper.selectByExample(new GradeExample());
    }

    @Override
    public List<Major> getAllMajors() {
        return majorMapper.selectByExample(new MajorExample());
    }

    @Override
    public List<Classes> getAllClasses() {
        return classesMapper.selectByExample(new ClassesExample());
    }

    @Override
    public List<Major> getMajorsByCollegeAndGrade(long collegeId, long gradeId) {
        MajorExample example = new MajorExample();
        example.createCriteria().andCollegeIdEqualTo(collegeId).andGradeIdEqualTo(gradeId);
        return majorMapper.selectByExample(example);
    }

    @Override
    public List<UnitBO> getUnitsForAllocation(User user,String type) {
        List<UnitBO> lst = new ArrayList<>();
        if (type.equals(UnitTypeEnum.SCHOOL.name())) {
            List<College> tmp = getAllColleges();
            for (College college: tmp){
                UnitBO bo = new UnitBO(college.getId(),college.getName(),college.getNumber() );
                lst.add(bo);
            }
        }else if (type.equals(UnitTypeEnum.COLLEGE.name())){
            List<Grade> tmp = getAllGrades();
            for (Grade grade: tmp){
                UnitBO bo = new UnitBO(grade.getId(),grade.getName(),grade.getNumber());
                lst.add(bo);
            }
        }
        return lst;
    }
}
