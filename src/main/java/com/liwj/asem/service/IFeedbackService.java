package com.liwj.asem.service;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.FeedbackBO;
import com.liwj.asem.enums.FeedbackStatusEnum;
import com.liwj.asem.enums.FeedbackTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.User;

import java.util.List;

public interface IFeedbackService {
    void applyQuota(User user, List<FeedbackBO> feedbackBOList);


    void applyBack(User user, List<FeedbackBO> feedbackBOList) throws WSPException;


    PageInfo getQuotaList(User user, FeedbackTypeEnum feedbackType, Integer pageSize, Integer pageNum);

    PageInfo getAllQuotaList(User user, FeedbackTypeEnum feedbackType, Integer pageSize, Integer pageNum);

    void checkApplyBatch(List<Long> ids, FeedbackStatusEnum result);
}
