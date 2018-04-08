package com.liwj.asem.controller;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.SelectionBO;
import com.liwj.asem.bo.Unit;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.remote.RemoteException;
import com.liwj.asem.remote.RemoteService;
import com.liwj.asem.remote.bo.College;
import com.liwj.asem.remote.bo.Item;
import com.liwj.asem.remote.bo.Major;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/rs")
public class RSController {


    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getColleges", method = RequestMethod.GET)
    public ResponseData getColleges(@RequestParam(value = "token") String token) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        RemoteService rs = new RemoteService();
        List<College> units = rs.getAllColleges();
        List<SelectionBO> res = new ArrayList<>();
        for (College unit: units){
            SelectionBO bo = new SelectionBO();
            bo.setId(unit.getId());
            bo.setName(unit.getName());
            res.add(bo);
        }
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }


    @RequestMapping(value = "/getMajorsByCollege", method = RequestMethod.GET)
    public ResponseData getMajorsByCollege(@RequestParam(value = "token") String token,
                                    @RequestParam(value = "id") Long id) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        RemoteService rs = new RemoteService();

        List<SelectionBO> res = new ArrayList<>();
        if (id!=0){
            List<Major> units = rs.getMajorsByCollege(id);
            for (Major unit: units){
                SelectionBO bo = new SelectionBO();
                bo.setId(unit.getId());
                bo.setName(unit.getName());
                res.add(bo);
            }
        }
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/getGradesByMajor", method = RequestMethod.GET)
    public ResponseData getGradesByMajor(@RequestParam(value = "token") String token,
                                    @RequestParam(value = "id") Long id) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        RemoteService rs = new RemoteService();
        List<SelectionBO> res = new ArrayList<>();
        if (id!=0){
            List<String> units = rs.getGradesByMajor(id);
            for (String unit: units){
                SelectionBO bo = new SelectionBO();
                bo.setId(Long.parseLong(unit));
                bo.setName(unit);
                res.add(bo);
            }
        }

        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/getManageGrades", method = RequestMethod.GET)
    public ResponseData getManageGrades(@RequestParam(value = "token") String token) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectionBO> res = new ArrayList<>();
        for (String grade: user.getManageGrades()){
            SelectionBO bo = new SelectionBO();
            bo.setId(Long.parseLong(grade));
            bo.setName(grade);
            res.add(bo);
        }
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/getManageClassByGrade", method = RequestMethod.GET)
    public ResponseData getManageClassByGrade(@RequestParam(value = "token") String token,
                                              @RequestParam(value = "gradeId") String grade,
                                              @RequestParam(value = "collegeId") Long collegeId) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectionBO> res = new ArrayList<>();
        if (grade!=null && !"0".equals(grade)){
            RemoteService rs = new RemoteService();
            List<Item> list = rs.findClassByUnitAndGrade(grade,collegeId.intValue());

            for (Item item:list){
                SelectionBO bo = new SelectionBO();
                bo.setId((long) item.getId());
                bo.setName(item.getName());
                res.add(bo);
            }
        }
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/getClassByGradeAndMajor", method = RequestMethod.GET)
    public ResponseData getClassByGradeAndMajor(@RequestParam(value = "token") String token,
                                                @RequestParam(value = "majorId") Long majorId,
                                                @RequestParam(value = "gradeId") String grade) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectionBO> res = new ArrayList<>();
        if (grade!=null && !"0".equals(grade)){
            RemoteService rs = new RemoteService();
            List<Item> list = rs.findClassByUnitAndGrade(grade,majorId.intValue());
            for (Item item:list){
                SelectionBO bo = new SelectionBO();
                bo.setId((long) item.getId());
                bo.setName(item.getName());
                res.add(bo);
            }
        }
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }
}
