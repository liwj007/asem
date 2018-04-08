package com.liwj.asem.service;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.FeedbackBO;
import com.liwj.asem.bo.SelectOfPrizeBO;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.FeedbackStatusEnum;
import com.liwj.asem.enums.FeedbackTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.remote.RemoteException;

import java.util.List;

public interface IFeedbackService {
    void applyQuota(UserDTO user, List<FeedbackBO> feedbackBOList);


    void applyBack(UserDTO user, List<FeedbackBO> feedbackBOList) throws WSPException;


    PageInfo getQuotaList(UserDTO user, FeedbackTypeEnum feedbackType, Integer pageSize, Integer pageNum);

    PageInfo getAllQuotaList(UserDTO user, FeedbackTypeEnum feedbackType, Integer pageSize, Integer pageNum) throws RemoteException;

    void checkApplyBatch(List<Long> ids, FeedbackStatusEnum result);

}
