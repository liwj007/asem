package com.liwj.asem.service;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.*;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.ScholarshipTypeEnum;
import com.liwj.asem.exception.WSPException;


import java.util.List;

public interface IPrizeService {
    PageInfo getManagePrizeLists(UserDTO user, Integer pageNum, Integer pageSize, Long unitId) throws WSPException;

    List<SelectOfPrizeBO> getSelectOfUnAllocationNumberPrizes(UserDTO user, Long unitId);

    void allocationNumber(UserDTO user, EntireUnitPrizeForm entireUnitPrizeForm);

    PageInfo getAllocatedNumberPrizes(UserDTO user, Integer pageNum, Integer pageSize, Long unitId);

    EntireUnitPrizeForm getAwardDetailOfAllocatedNumber(UserDTO user, Long prizeId) throws WSPException;

    void updateAllocationNumber(UserDTO user, EntireUnitPrizeForm entireUnitPrizeForm);

    List<SelectOfScholarshipBO> getSelectOfUnAllocationTimeScholarships(UserDTO user, ScholarshipTypeEnum scholarshipType, Boolean needGrade, Long unitId);

    void allocationTime(UserDTO user, List<TimeLimitBO> list) throws WSPException;

    PageInfo getScholarshipsOfAllocatedTime(UserDTO user, Integer pageNum, Integer pageSize, Long unitId);

    TimeLimitBO getDetailOfAllocatedTime(UserDTO user, Long scholarship,Long unitId);

    void updateAllocationTime(UserDTO user,TimeLimitBO timeLimitBO);

    void releaseToCollege(List<Long> prizeList);

    List<SelectOfScholarshipBO> getScholarshipSelectionForQuotaFeedback(UserDTO user, Long unitId);

    List<SelectOfPrizeBO> getPrizesByScholarship(UserDTO user, Long scholarshipId);
}
