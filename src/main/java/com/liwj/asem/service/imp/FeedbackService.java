package com.liwj.asem.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.FeedbackBO;
import com.liwj.asem.dao.*;
import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.FeedbackStatusEnum;
import com.liwj.asem.enums.FeedbackTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.*;
import com.liwj.asem.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private QuotaFeedbackMapper quotaFeedbackMapper;

    @Autowired
    private ScholarshipMapper scholarshipMapper;

    @Autowired
    private CollegePrizeMapper collegePrizeMapper;

    @Autowired
    private PrimaryTeachingInstitutionMapper primaryTeachingInstitutionMapper;

    @Autowired
    private PrizeInfoMapper prizeInfoMapper;

    @Override
    @Transactional
    public void applyQuota(UserDTO user, List<FeedbackBO> feedbackBOList) {
        for (FeedbackBO bo : feedbackBOList) {
            QuotaFeedback quotaFeedback = new QuotaFeedback();
            quotaFeedback.setApplyNumber(bo.getApplyNumber());
            quotaFeedback.setScholarshipId(bo.getScholarshipId());
            quotaFeedback.setPrizeId(bo.getPrizeId());

            CollegePrize prize = collegePrizeMapper.selectByPrimaryKey(bo.getPrizeId());
            quotaFeedback.setPrimaryTeachingInstitutionId(prize.getPrimaryTeachingInstitutionId());
            quotaFeedback.setApplyUserId(user.getId());
            quotaFeedback.setApplyDate(new Date());
            quotaFeedback.setApplyType(FeedbackTypeEnum.APPLY.code);
            quotaFeedback.setStatus(FeedbackStatusEnum.NEW.code);

            quotaFeedback.setAllocationNumber(prize.getNumber());

            quotaFeedbackMapper.insertSelective(quotaFeedback);
        }
    }

    @Override
    public void applyBack(UserDTO user, List<FeedbackBO> feedbackBOList) throws WSPException {
        for (FeedbackBO bo : feedbackBOList) {
            QuotaFeedback quotaFeedback = new QuotaFeedback();
            quotaFeedback.setApplyNumber(bo.getApplyNumber());
            quotaFeedback.setScholarshipId(bo.getScholarshipId());
            quotaFeedback.setPrizeId(bo.getPrizeId());

            CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(bo.getPrizeId());
            quotaFeedback.setPrimaryTeachingInstitutionId(collegePrize.getPrimaryTeachingInstitutionId());
            quotaFeedback.setApplyUserId(user.getId());
            quotaFeedback.setApplyDate(new Date());
            quotaFeedback.setApplyType(FeedbackTypeEnum.BACK.code);
            quotaFeedback.setStatus(FeedbackStatusEnum.PASS.code);

            quotaFeedback.setAllocationNumber(collegePrize.getNumber());

            quotaFeedbackMapper.insertSelective(quotaFeedback);

            int newNumber = collegePrize.getNumber() - bo.getApplyNumber();
            if (newNumber >= 0) {
                collegePrize.setNumber(newNumber);
            } else {
                throw new WSPException(ErrorInfo.PARAMS_ERROR);
            }
            collegePrizeMapper.updateByPrimaryKeySelective(collegePrize);

        }
    }


    @Override
    public PageInfo getQuotaList(UserDTO user, FeedbackTypeEnum feedbackType, Integer pageSize, Integer pageNum) {
        List<FeedbackBO> res = new ArrayList<>();
        QuotaFeedbackExample quotaFeedbackExample = new QuotaFeedbackExample();
        quotaFeedbackExample.createCriteria().andPrimaryTeachingInstitutionIdIn(user.getManageCollegeId())
                .andApplyTypeEqualTo(feedbackType.code);
        PageHelper.startPage(pageNum, pageSize);
        List<QuotaFeedback> list = quotaFeedbackMapper.selectByExample(quotaFeedbackExample);
        PageInfo pageInfo = new PageInfo(list);
        for (QuotaFeedback quotaFeedback : list) {
            FeedbackBO bo = new FeedbackBO();
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(quotaFeedback.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());
            CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(quotaFeedback.getPrizeId());
            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
            bo.setPrizeName(prizeInfo.getPrizeName());
            bo.setAllocationNumber(quotaFeedback.getAllocationNumber());
            bo.setApplyNumber(quotaFeedback.getApplyNumber());
            bo.setStatus(FeedbackStatusEnum.getNameByCode(quotaFeedback.getStatus()));
            bo.setId(quotaFeedback.getId());
            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    public PageInfo getAllQuotaList(UserDTO user, FeedbackTypeEnum feedbackType, Integer pageSize, Integer pageNum) {
        List<FeedbackBO> res = new ArrayList<>();
        QuotaFeedbackExample quotaFeedbackExample = new QuotaFeedbackExample();
        quotaFeedbackExample.createCriteria().andApplyTypeEqualTo(feedbackType.code);
        PageHelper.startPage(pageNum, pageSize);
        List<QuotaFeedback> list = quotaFeedbackMapper.selectByExample(quotaFeedbackExample);
        PageInfo pageInfo = new PageInfo(list);
        for (QuotaFeedback quotaFeedback : list) {
            FeedbackBO bo = new FeedbackBO();
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(quotaFeedback.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());
            CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(quotaFeedback.getPrizeId());
            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
            bo.setPrizeName(prizeInfo.getPrizeName());
            bo.setAllocationNumber(quotaFeedback.getAllocationNumber());
            bo.setApplyNumber(quotaFeedback.getApplyNumber());
            bo.setStatus(FeedbackStatusEnum.getNameByCode(quotaFeedback.getStatus()));
            PrimaryTeachingInstitution institution = primaryTeachingInstitutionMapper.selectByPrimaryKey(quotaFeedback.getPrimaryTeachingInstitutionId());
            bo.setUnitName(institution.getName());
            bo.setId(quotaFeedback.getId());

            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    @Transactional
    public void checkApplyBatch(List<Long> ids, FeedbackStatusEnum result) {
        for (Long id : ids) {
            QuotaFeedback quotaFeedback = quotaFeedbackMapper.selectByPrimaryKey(id);
            quotaFeedback.setStatus(result.code);
            quotaFeedbackMapper.updateByPrimaryKeySelective(quotaFeedback);

            if (result == FeedbackStatusEnum.PASS) {
                CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(quotaFeedback.getPrizeId());
                collegePrize.setNumber(collegePrize.getNumber() + quotaFeedback.getApplyNumber());
                collegePrizeMapper.updateByPrimaryKeySelective(collegePrize);
            }
        }
    }
}
