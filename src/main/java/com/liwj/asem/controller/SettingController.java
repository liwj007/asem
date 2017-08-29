package com.liwj.asem.controller;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.FileBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.service.IComprehensiveEvaluationService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/setting")
public class SettingController {

    @Autowired
    private IComprehensiveEvaluationService comprehensiveEvaluationService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/upload_comprehensive_evaluation", method = RequestMethod.POST)
    public ResponseData uploadFiles(@RequestBody List<FileBO> fileBOList) throws WSPException, IOException {
        comprehensiveEvaluationService.uploadFiles(fileBOList);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/comprehensive_evaluation_list", method = RequestMethod.GET)
    public ResponseData getComprehensiveEvaluationList(@RequestParam(value = "token") String token,
                                                       @RequestParam(value = "pageSize") Integer pageSize,
                                                       @RequestParam(value = "pageNum") Integer pageNum) throws WSPException {
        PageInfo pageInfo = comprehensiveEvaluationService
                .getAssessmentRecordList(pageNum, pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }
}
