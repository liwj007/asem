package com.liwj.asem.service;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.PublicityApplyBO;
import com.liwj.asem.bo.PublicityScholarshipBO;
import com.liwj.asem.bo.SelectOfScholarshipBO;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.remote.RemoteException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPublicityService {

    PageInfo getCollegePublicityList(UserDTO user, Long unitId, List<Long> studentIds, Long scholarshipId, Long prizeId, Integer pageNum, Integer pageSize) throws RemoteException;

    List<SelectOfScholarshipBO> getCollegePublicityScholarshipList(UserDTO user, Long unitId);

    void collegePublicity(UserDTO user, PublicityApplyBO publicityApplyBO);

    PageInfo getCollegeMangePublicityList(UserDTO user, Long unitId, Integer pageSize, Integer pageNum) throws RemoteException;

    PageInfo getMangePublicityDetailList(UserDTO user, Long publicityId, Integer pageSize, Integer pageNum) throws RemoteException;

    PageInfo getStudentMangePublicityList(UserDTO user, Integer pageSize, Integer pageNum) throws RemoteException;

    void addObjection(UserDTO user, Long publicityId, String content);

    List<PublicityScholarshipBO> getAllStudentMangePublicityList(UserDTO user) throws RemoteException;

    PageInfo getStudentObjections(UserDTO user, Integer pageSize, Integer pageNum) throws RemoteException;

    void feedbackObjection(UserDTO user, Long publicityId, String content);

    PageInfo getCollegeObjections(UserDTO user, Long unitId, Integer pageSize, Integer pageNum) throws RemoteException;

    PageInfo getSchoolPublicityList(UserDTO user, List<Long> studentIds, Long scholarshipId, Long prizeId, Integer pageNum, Integer pageSize) throws RemoteException;

    List<SelectOfScholarshipBO> getSchoolPublicityScholarshipList(UserDTO user);

    void schoolPublicity(UserDTO user, PublicityApplyBO publicityApplyBO);

    PageInfo getSchoolMangePublicityList(UserDTO user, Integer pageSize, Integer pageNum);

    PageInfo getSchoolObjections(UserDTO user, Integer pageSize, Integer pageNum) throws RemoteException;
}
