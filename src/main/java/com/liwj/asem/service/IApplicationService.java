package com.liwj.asem.service;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.ApplicationBO;
import com.liwj.asem.bo.EntireApplicationForm;
import com.liwj.asem.bo.MyselfEvaluationBO;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.User;

public interface IApplicationService {
    void createApplication(User user, EntireApplicationForm applicationForm) throws WSPException;

    PageInfo getPrizeWhichCanSubmit(User user, Integer pageNum, Integer pageSize);

    MyselfEvaluationBO getMyselfEvaluation(User user);

    ApplicationBO getApplicationDetail(User user, Long id) throws WSPException;

    PageInfo getPrizeForCheck(User user, Integer pageNum, Integer pageSize);
}
