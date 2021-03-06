package com.liwj.asem.service;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.*;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.ApplicationFileStatusEnum;
import com.liwj.asem.enums.ApplicationPrizeStatusEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.remote.RemoteException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IApplicationService {
    void createApplication(UserDTO user, EntireApplicationForm applicationForm) throws WSPException;

    PageInfo getPrizeWhichCanSubmit(UserDTO user, Integer pageNum, Integer pageSize);

    MyselfEvaluationBO getMyselfEvaluation(UserDTO user);

    ApplicationBO getApplicationDetail(UserDTO user, Long id) throws WSPException;

    PageInfo getPrizeForFileCheck(UserDTO user, Long unitId, Integer pageNum, Integer pageSize) throws WSPException;

    PageInfo getPrizeDetailForFileCheck(UserDTO user, Long prizeId, List<Long> studentIds, List<Integer> status, Integer pageNum, Integer pageSize) throws RemoteException;

    void checkApplicationFile(UserDTO user, List<Long> ids, ApplicationFileStatusEnum result);

    void updateApplication(UserDTO user, EntireApplicationForm applicationForm);

    PageInfo getPrizeForAwardCheck(UserDTO user, Long unitId, Integer pageNum, Integer pageSize) throws WSPException;

    PageInfo getPrizeDetailForAwardCheck(UserDTO user, Long prizeId, List<Long> ids, List<Integer> fileStatus, List<Integer> prizeStatus, Integer pageNum, Integer pageSize) throws RemoteException;

    void checkApplicationPrize(UserDTO user, List<Long> ids, ApplicationPrizeStatusEnum result) throws WSPException;

    PageInfo getCollegePrizeForAwardCheck(UserDTO user, Long prizeId, Integer pageNum, Integer pageSize) throws RemoteException;


    PageInfo getStudentWinningRecord(UserDTO user, Integer pageNum, Integer pageSize);

    void closeSubmit(UserDTO user, Long id, Long unitId) throws WSPException;

    @Transactional
    void closeCollegeSubmit(Long scholarshipId);

    @Transactional
    void closeGradeSubmit(Long scholarshipId, Long unitId);


    @Transactional(rollbackFor = Exception.class)
    void closeStudentSubmit(Long scholarshipId, Long unitId);

    PageInfo getAwardApplicationsByScholarship(UserDTO user, Long scholarshipId, List<Long> studentIds, Integer pageNum, Integer pageSize) throws RemoteException;
}
