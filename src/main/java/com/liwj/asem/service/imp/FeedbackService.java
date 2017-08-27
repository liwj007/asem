package com.liwj.asem.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.FeedbackBO;
import com.liwj.asem.dao.CollegeMapper;
import com.liwj.asem.dao.PrizeMapper;
import com.liwj.asem.dao.QuotaFeedbackMapper;
import com.liwj.asem.dao.ScholarshipMapper;
import com.liwj.asem.data.ErrorInfo;
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
    private PrizeMapper prizeMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    @Transactional
    public void applyQuota(User user, List<FeedbackBO> feedbackBOList) {
        for (FeedbackBO bo : feedbackBOList) {
            QuotaFeedback quotaFeedback = new QuotaFeedback();
            quotaFeedback.setApplyNumber(bo.getApplyNumber());
            quotaFeedback.setScholarshipId(bo.getScholarshipId());
            quotaFeedback.setPrizeId(bo.getPrizeId());
            quotaFeedback.setUnitId(user.getManageCollegeId());
            quotaFeedback.setUserId(user.getId());
            quotaFeedback.setApplyDate(new Date());
            quotaFeedback.setApplyType(FeedbackTypeEnum.APPLY.code);
            quotaFeedback.setStatus(FeedbackStatusEnum.NEW.code);
            Prize prize = prizeMapper.selectByPrimaryKey(bo.getPrizeId());
            quotaFeedback.setAllocationNumber(prize.getNumber());

            quotaFeedbackMapper.insertSelective(quotaFeedback);
        }
    }

    @Override
    public void applyBack(User user, List<FeedbackBO> feedbackBOList) throws WSPException {
        for (FeedbackBO bo : feedbackBOList) {
            QuotaFeedback quotaFeedback = new QuotaFeedback();
            quotaFeedback.setApplyNumber(bo.getApplyNumber());
            quotaFeedback.setScholarshipId(bo.getScholarshipId());
            quotaFeedback.setPrizeId(bo.getPrizeId());
            quotaFeedback.setUnitId(user.getManageCollegeId());
            quotaFeedback.setUserId(user.getId());
            quotaFeedback.setApplyDate(new Date());
            quotaFeedback.setApplyType(FeedbackTypeEnum.BACK.code);
            quotaFeedback.setStatus(FeedbackStatusEnum.PASS.code);
            Prize prize = prizeMapper.selectByPrimaryKey(bo.getPrizeId());
            quotaFeedback.setAllocationNumber(prize.getNumber());

            quotaFeedbackMapper.insertSelective(quotaFeedback);

            int newNumber = prize.getNumber() - bo.getApplyNumber();
            if (newNumber >= 0) {
                prize.setNumber(newNumber);
            } else {
                throw new WSPException(ErrorInfo.PARAMS_ERROR);
            }
            prizeMapper.updateByPrimaryKeySelective(prize);

        }
    }


    @Override
    public PageInfo getQuotaList(User user, FeedbackTypeEnum feedbackType, Integer pageSize, Integer pageNum) {
        List<FeedbackBO> res = new ArrayList<>();
        QuotaFeedbackExample quotaFeedbackExample = new QuotaFeedbackExample();
        quotaFeedbackExample.createCriteria().andUnitIdEqualTo(user.getManageCollegeId())
                .andApplyTypeEqualTo(feedbackType.code);
        PageHelper.startPage(pageNum,pageSize);
        List<QuotaFeedback> list = quotaFeedbackMapper.selectByExample(quotaFeedbackExample);
        PageInfo pageInfo = new PageInfo(list);
        for (QuotaFeedback quotaFeedback : list) {
            FeedbackBO bo = new FeedbackBO();
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(quotaFeedback.getScholarshipId());
            bo.setScholarshipName(scholarship.getName());
            Prize prize = prizeMapper.selectByPrimaryKey(quotaFeedback.getPrizeId());
            bo.setPrizeName(prize.getPrizeName());
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
    public PageInfo getAllQuotaList(User user, FeedbackTypeEnum feedbackType, Integer pageSize, Integer pageNum) {
        List<FeedbackBO> res = new ArrayList<>();
        QuotaFeedbackExample quotaFeedbackExample = new QuotaFeedbackExample();
        quotaFeedbackExample.createCriteria().andApplyTypeEqualTo(feedbackType.code);
        PageHelper.startPage(pageNum,pageSize);
        List<QuotaFeedback> list = quotaFeedbackMapper.selectByExample(quotaFeedbackExample);
        PageInfo pageInfo = new PageInfo(list);
        for (QuotaFeedback quotaFeedback : list) {
            FeedbackBO bo = new FeedbackBO();
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(quotaFeedback.getScholarshipId());
            bo.setScholarshipName(scholarship.getName());
            Prize prize = prizeMapper.selectByPrimaryKey(quotaFeedback.getPrizeId());
            bo.setPrizeName(prize.getPrizeName());
            bo.setAllocationNumber(quotaFeedback.getAllocationNumber());
            bo.setApplyNumber(quotaFeedback.getApplyNumber());
            bo.setStatus(FeedbackStatusEnum.getNameByCode(quotaFeedback.getStatus()));
            College college = collegeMapper.selectByPrimaryKey(quotaFeedback.getUnitId());
            bo.setUnitName(college.getName());
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
                Prize prize = prizeMapper.selectByPrimaryKey(quotaFeedback.getPrizeId());
                prize.setNumber(prize.getNumber() + quotaFeedback.getApplyNumber());
                prizeMapper.updateByPrimaryKeySelective(prize);
            }
        }
    }
}
