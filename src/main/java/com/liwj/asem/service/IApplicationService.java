package com.liwj.asem.service;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.ApplicationBO;
import com.liwj.asem.bo.EntireApplicationForm;
import com.liwj.asem.bo.MyselfEvaluationBO;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.ApplicationFileStatusEnum;
import com.liwj.asem.exception.WSPException;

import java.util.List;

public interface IApplicationService {
    void createApplication(UserDTO user, EntireApplicationForm applicationForm) throws WSPException;

    PageInfo getPrizeWhichCanSubmit(UserDTO user, Integer pageNum, Integer pageSize);

    MyselfEvaluationBO getMyselfEvaluation(UserDTO user);

    ApplicationBO getApplicationDetail(UserDTO user, Long id) throws WSPException;

    PageInfo getPrizeForFileCheck(UserDTO user, Long unitId, Integer pageNum, Integer pageSize);

    PageInfo getPrizeDetailForFileCheck(UserDTO user, Long prizeId, Integer pageNum, Integer pageSize);

    void checkApplicationFile(UserDTO user, List<Long> ids, ApplicationFileStatusEnum result);

    void updateApplication(UserDTO user, EntireApplicationForm applicationForm);

    PageInfo getPrizeForAwardCheck(UserDTO user, Long unitId, Integer pageNum, Integer pageSize);
}
