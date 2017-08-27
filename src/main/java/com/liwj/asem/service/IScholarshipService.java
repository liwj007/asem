package com.liwj.asem.service;

import com.liwj.asem.bo.EntireScholarshipForm;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IScholarshipService {
    void createNewScholarship(User user, EntireScholarshipForm scholarshipBO);

    EntireScholarshipForm getScholarshipDetailInfo(User user, Long id) throws WSPException;

    void deleteScholarship(Long id) throws WSPException;

    void updateScholarship(User user,EntireScholarshipForm scholarshipBO) throws WSPException;

    void openToStudent(User user, Long scholarshipId);
}
