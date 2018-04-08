package com.liwj.asem.controller;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.SelectionBO;
import com.liwj.asem.dao.AssessmentRecordMapper;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.AssessmentRecord;
import com.liwj.asem.model.AssessmentRecordExample;
import com.liwj.asem.remote.RemoteException;
import com.liwj.asem.remote.RemoteService;
import com.liwj.asem.remote.bo.College;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/help")
public class HelpController {
    @Autowired
    private IUserService userService;

    @Autowired
    private AssessmentRecordMapper assessmentRecordMapper;

    @RequestMapping(value = "/year_selection", method = RequestMethod.GET)
    public ResponseData getYears(@RequestParam(value = "token") String token) throws WSPException {
        UserDTO user = userService.getUserByToken(token);

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

        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(list);
        return responseData;
    }

    @RequestMapping(value = "/college_selection", method = RequestMethod.GET)
    public ResponseData getColleges(@RequestParam(value = "token") String token) throws WSPException {
        UserDTO user = userService.getUserByToken(token);

        List<SelectionBO> res = new ArrayList<>();
        RemoteService rs = new RemoteService();
        List<College> list = null;
        try {
            list = rs.getAllColleges();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        for (College institution: list){
            SelectionBO bo = new SelectionBO();
            bo.setId(institution.getId());
            bo.setName(institution.getName());
            res.add(bo);
        }

        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

}
