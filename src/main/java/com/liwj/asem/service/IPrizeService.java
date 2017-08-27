package com.liwj.asem.service;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.*;
import com.liwj.asem.enums.ScholarshipTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.User;

import java.util.List;

public interface IPrizeService {
    PageInfo getManagePrizeLists(User user, Integer pageNum, Integer pageSize);

    List<SelectOfPrizeBO> getSelectOfUnAllocationNumberPrizes(User user);

    void allocationNumber(User user, EntireUnitPrizeForm entireUnitPrizeForm);

    PageInfo getAllocatedNumberPrizes(User user, Integer pageNum, Integer pageSize);

    EntireUnitPrizeForm getAwardDetailOfAllocatedNumber(User user, Long prizeId) throws WSPException;

    void updateAllocationNumber(User user, EntireUnitPrizeForm entireUnitPrizeForm);

    List<SelectOfScholarshipBO> getSelectOfUnAllocationTimeScholarships(User user, ScholarshipTypeEnum scholarshipType, Boolean needGrade);

    void allocationTime(User user, List<TimeLimitBO> list) throws WSPException;

    PageInfo getScholarshipsOfAllocatedTime(User user, Integer pageNum, Integer pageSize);

    TimeLimitBO getDetailOfAllocatedTime(User user, Long id);

    void updateAllocationTime(User user,TimeLimitBO timeLimitBO);

    void releaseToCollege(List<Long> prizeList);

    List<SelectOfScholarshipBO> getScholarshipSelectionForQuotaFeedback(User user);
}
