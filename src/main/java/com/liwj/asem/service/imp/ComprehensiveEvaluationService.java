package com.liwj.asem.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.FileBO;
import com.liwj.asem.dao.ComprehensiveEvaluationMapper;
import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.ComprehensiveEvaluation;
import com.liwj.asem.model.ComprehensiveEvaluationExample;
import com.liwj.asem.service.IComprehensiveEvaluationService;
import com.liwj.asem.utils.Common;
import com.liwj.asem.utils.Util;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ComprehensiveEvaluationService implements IComprehensiveEvaluationService {

    @Autowired
    private ComprehensiveEvaluationMapper comprehensiveEvaluationMapper;

    @Override
    @Transactional
    public void uploadFiles(List<FileBO> fileBOList) throws IOException, WSPException {
        for (FileBO bo : fileBOList) {
            String fileName = bo.getName();
            String path = ".//uploadFiles//" + fileName;
            readFile(path);
        }
    }

    @Override
    public PageInfo getComprehensiveEvaluationList(Integer pageNum, Integer pageSize) {
        ComprehensiveEvaluationExample example = new ComprehensiveEvaluationExample();
        PageHelper.startPage(pageNum, pageSize);
        List<ComprehensiveEvaluation> list = comprehensiveEvaluationMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
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

            String academicYear = xssfRow.getCell(0).toString();
            String collegeName = xssfRow.getCell(1).toString();
            String majorName = xssfRow.getCell(2).toString();
            String gradeName = xssfRow.getCell(3).toString();
            String name = xssfRow.getCell(4).toString();
            String no = xssfRow.getCell(5).toString();
            Integer majorNumber = new Double(xssfRow.getCell(6).getNumericCellValue()).intValue();
            Double compositeScore = xssfRow.getCell(7).getNumericCellValue();
            Integer compositeRank = new Double(xssfRow.getCell(8).getNumericCellValue()).intValue();
            Double intellectualScore = xssfRow.getCell(9).getNumericCellValue();
            Integer intellectualRank = new Double(xssfRow.getCell(10).getNumericCellValue()).intValue();

            ComprehensiveEvaluation comprehensiveEvaluation = new ComprehensiveEvaluation(null,name,no,majorNumber,
                    compositeScore,compositeRank,intellectualScore,intellectualRank,academicYear,collegeName,
                    majorName,gradeName);
            comprehensiveEvaluationMapper.insertSelective(comprehensiveEvaluation);
        }
    }

    private void readXls(String path) throws IOException, WSPException {
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
        for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            HSSFRow hssfRow = hssfSheet.getRow(rowNum);

            String academicYear = hssfRow.getCell(0).toString();
            String collegeName = hssfRow.getCell(1).toString();
            String majorName = hssfRow.getCell(2).toString();
            String gradeName = hssfRow.getCell(3).toString();
            String name = hssfRow.getCell(4).toString();
            String no = hssfRow.getCell(5).toString();
            Integer majorNumber = new Double(hssfRow.getCell(6).getNumericCellValue()).intValue();
            Double compositeScore = hssfRow.getCell(7).getNumericCellValue();
            Integer compositeRank = new Double(hssfRow.getCell(8).getNumericCellValue()).intValue();
            Double intellectualScore = hssfRow.getCell(9).getNumericCellValue();
            Integer intellectualRank = new Double(hssfRow.getCell(10).getNumericCellValue()).intValue();

            ComprehensiveEvaluation comprehensiveEvaluation = new ComprehensiveEvaluation(null,name,no,majorNumber,
                    compositeScore,compositeRank,intellectualScore,intellectualRank,academicYear,collegeName,
                    majorName,gradeName);
            comprehensiveEvaluationMapper.insertSelective(comprehensiveEvaluation);
        }
    }
}
