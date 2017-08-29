package com.liwj.asem.service;

import com.liwj.asem.bo.EntireScholarshipForm;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.exception.WSPException;
import org.springframework.stereotype.Service;

@Service
public interface IScholarshipService {
    void createNewScholarship(UserDTO user, EntireScholarshipForm scholarshipBO);

    EntireScholarshipForm getScholarshipDetailInfo(UserDTO user, Long scholarshipId, Long unitId) throws WSPException;

    void deleteScholarship(Long id) throws WSPException;

    void updateScholarship(UserDTO user,EntireScholarshipForm scholarshipBO) throws WSPException;

    void openToStudent(UserDTO user, Long scholarshipId);
}
