package com.liwj.asem.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.AssessmentRecordBO;
import com.liwj.asem.bo.FileBO;
import com.liwj.asem.dao.AssessmentRecordMapper;
import com.liwj.asem.dao.UserMapper;
import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.enums.RoleTypeEnum;
import com.liwj.asem.enums.UserTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.AssessmentRecord;
import com.liwj.asem.model.AssessmentRecordExample;
import com.liwj.asem.model.User;
import com.liwj.asem.model.UserExample;
import com.liwj.asem.remote.RemoteException;
import com.liwj.asem.remote.RemoteService;
import com.liwj.asem.service.IComprehensiveEvaluationService;
import com.liwj.asem.service.IUserService;
import com.liwj.asem.utils.Common;
import com.liwj.asem.utils.PropertiesUtil;
import com.liwj.asem.utils.Util;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComprehensiveEvaluationService implements IComprehensiveEvaluationService {

    @Autowired
    private AssessmentRecordMapper assessmentRecordMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    public final static String fileMenu = PropertiesUtil.getStringByKey("uploadFiles");

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void uploadFiles(List<FileBO> fileBOList) throws IOException, WSPException {
        for (FileBO bo : fileBOList) {
            String fileName = bo.getName();
            String path = fileMenu + "//" + fileName;
            readFile(path);
        }
    }

    @Override
    public PageInfo getAssessmentRecordList(Long year, Long college, Long major, String grade,
                                            Integer pageNum, Integer pageSize) throws RemoteException {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        boolean flag = false;
        if (college != null && college != 0) {
            criteria.andCollegeIdEqualTo(college);
            flag = true;
        }
        if (major != null && major != 0) {
            criteria.andMajorIdEqualTo(major);
            flag = true;
        }
        if (grade != null && !"0".equals(grade) && !"".equals(grade)) {
            criteria.andGradeEqualTo(grade);
            flag = true;
        }

        List<String> userSns = new ArrayList<>();
        if (flag) {
            criteria.andUserRoleEqualTo(RoleTypeEnum.STUDENT.code);
            List<User> users = userMapper.selectByExample(userExample);
            if (users.size() == 0) {
                return new PageInfo();
            }
            for (User user : users) {
                if (user.getSn() != null && !"".equals(user.getSn()))
                    userSns.add(user.getSn());
            }
        }

        AssessmentRecordExample example = new AssessmentRecordExample();
        AssessmentRecordExample.Criteria criteria1 = example.createCriteria();
        if (year != null && year != 0)
            criteria1.andYearEqualTo(year.intValue());
        if (userSns.size() > 0) {
            criteria1.andSnIn(userSns);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<AssessmentRecord> list = assessmentRecordMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        List<AssessmentRecordBO> res = new ArrayList<>();
        RemoteService rs = new RemoteService();
        for (AssessmentRecord record : list) {
            AssessmentRecordBO bo = new AssessmentRecordBO();
            bo.setSn(record.getSn());
            bo.setIntellectualRank(record.getIntellectualRank());
            bo.setIntellectualScore(record.getIntellectualScore());
            bo.setOverallRank(record.getOverallRank());
            bo.setOverallScore(record.getOverallScore());
            bo.setMajorTotal(record.getMajorTotal());
            User user = userService.getUserBySN(record.getSn());
            if (user != null)
                bo.setName(user.getName());
            else {
                String name = rs.findUserNameBySn(bo.getSn());
                bo.setName(name);
            }
            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }


    private void readFile(String path) throws IOException, WSPException {
        if (path == null || Common.EMPTY.equals(path)) {
            return;
        } else {
            String postfix = Util.getPostfix(path);
            if (!Common.EMPTY.equals(postfix)) {
                if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                    readXls(path);
                } else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
                    readXlsx(path);
                }
            } else {
                throw new WSPException(ErrorInfo.PARAMS_ERROR);
            }
        }
    }

    private void readXlsx(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
            XSSFRow xssfRow = xssfSheet.getRow(rowNum);

            Integer academicYear = new Double(xssfRow.getCell(0).getNumericCellValue()).intValue();
            String Sn = xssfRow.getCell(1).toString();
            Integer majorNumber = new Double(xssfRow.getCell(2).getNumericCellValue()).intValue();
            Double compositeScore = xssfRow.getCell(3).getNumericCellValue();
            Integer compositeRank = new Double(xssfRow.getCell(4).getNumericCellValue()).intValue();
            Double intellectualScore = xssfRow.getCell(5).getNumericCellValue();
            Integer intellectualRank = new Double(xssfRow.getCell(6).getNumericCellValue()).intValue();

            AssessmentRecord record = new AssessmentRecord();
            record.setYear(academicYear);
            record.setSn(Sn);
            record.setOverallScore(compositeScore);
            record.setOverallRank(compositeRank);
            record.setIntellectualScore(intellectualScore);
            record.setIntellectualRank(intellectualRank);
            record.setMajorTotal(majorNumber);
            assessmentRecordMapper.insertSelective(record);
        }
    }

    private void readXls(String path) throws IOException, WSPException {
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
        for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            HSSFRow hssfRow = hssfSheet.getRow(rowNum);

            Integer academicYear = new Double(hssfRow.getCell(0).getNumericCellValue()).intValue();
            String Sn = hssfRow.getCell(1).toString();

            Integer majorNumber = new Double(hssfRow.getCell(2).getNumericCellValue()).intValue();
            Double compositeScore = hssfRow.getCell(3).getNumericCellValue();
            Integer compositeRank = new Double(hssfRow.getCell(4).getNumericCellValue()).intValue();
            Double intellectualScore = hssfRow.getCell(5).getNumericCellValue();
            Integer intellectualRank = new Double(hssfRow.getCell(6).getNumericCellValue()).intValue();

            AssessmentRecord record = new AssessmentRecord();
            record.setYear(academicYear);
            record.setSn(Sn);
            record.setOverallScore(compositeScore);
            record.setOverallRank(compositeRank);
            record.setIntellectualScore(intellectualScore);
            record.setIntellectualRank(intellectualRank);
            record.setMajorTotal(majorNumber);
            assessmentRecordMapper.insertSelective(record);
        }
    }
}
