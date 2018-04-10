package com.liwj.asem.schedule;

import com.liwj.asem.dao.PrizeCollegeLimitTimeMapper;
import com.liwj.asem.dao.ScholarshipMapper;
import com.liwj.asem.enums.ScholarshipTypeEnum;
import com.liwj.asem.enums.StatusEnum;
import com.liwj.asem.model.PrizeCollegeLimitTime;
import com.liwj.asem.model.PrizeCollegeLimitTimeExample;
import com.liwj.asem.model.Scholarship;
import com.liwj.asem.model.ScholarshipExample;
import com.liwj.asem.service.IApplicationService;
import com.liwj.asem.service.IScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ScheduleTask {

    @Autowired
    private PrizeCollegeLimitTimeMapper prizeCollegeLimitTimeMapper;

    @Autowired
    private ScholarshipMapper scholarshipMapper;

    @Autowired
    private IScholarshipService scholarshipService;

    @Autowired
    private IApplicationService applicationService;


    @Scheduled(cron = "0 0/2 * * * ?")
    public void executeOpenPrizeTask() {
        List<Integer> status = new ArrayList<>();
        status.add(StatusEnum.RELEASE.code);
        status.add(StatusEnum.OPEN.code);
        ScholarshipExample scholarshipExample = new ScholarshipExample();
        scholarshipExample.createCriteria()
                .andScholarshipTypeEqualTo(ScholarshipTypeEnum.SCHOOL.code)
                .andStatusIn(status)
                .andAllocationTimeStatusEqualTo(true);
        List<Scholarship> scholarships = scholarshipMapper.selectByExample(scholarshipExample);
        for (Scholarship scholarship : scholarships) {
            Date now = new Date();
            if (scholarship.getStudentBeginDate() != null && now.getTime() >= scholarship.getStudentBeginDate().getTime()) {
                scholarshipService.openToStudent(null, scholarship.getId());
            }
        }

        scholarshipExample = new ScholarshipExample();
        scholarshipExample.createCriteria()
                .andScholarshipTypeEqualTo(ScholarshipTypeEnum.COLLEGE.code)
                .andStatusEqualTo(StatusEnum.NEW.code)
                .andAllocationTimeStatusEqualTo(true);
        scholarships = scholarshipMapper.selectByExample(scholarshipExample);
        for (Scholarship scholarship : scholarships) {
            Date now = new Date();
            if (scholarship.getStudentBeginDate() != null && now.getTime() >= scholarship.getStudentBeginDate().getTime()) {
                scholarshipService.openToStudent(null, scholarship.getId());
            }
        }
    }

    @Scheduled(cron = "0 0/2 * * * ?")
    public void executeCloseStudentAndGradeSubmitTask() {
        List<Integer> status = new ArrayList<>();
        status.add(StatusEnum.OPEN.code);
        ScholarshipExample scholarshipExample = new ScholarshipExample();
        scholarshipExample.createCriteria()
                .andStatusIn(status)
                .andAllocationTimeStatusEqualTo(true);
        List<Scholarship> scholarships = scholarshipMapper.selectByExample(scholarshipExample);
        for (Scholarship scholarship : scholarships) {
            Date now = new Date();
            PrizeCollegeLimitTimeExample limitTimeExample = new PrizeCollegeLimitTimeExample();
            limitTimeExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId())
                    .andAllocationTimeStatusEqualTo(true);
            List<PrizeCollegeLimitTime> prizeCollegeLimitTimes = prizeCollegeLimitTimeMapper.selectByExample(limitTimeExample);
            for (PrizeCollegeLimitTime limitTime : prizeCollegeLimitTimes) {
                if (limitTime.getStudentEndDate() != null && now.getTime() >= limitTime.getStudentEndDate().getTime()) {
                    applicationService.closeStudentSubmit(scholarship.getId(), limitTime.getCollegeId());
                }

                if (limitTime.getGradeEndDate() != null && now.getTime() >= limitTime.getGradeEndDate().getTime()) {
                    applicationService.closeGradeSubmit(scholarship.getId(), limitTime.getCollegeId());
                }
            }
        }
    }

    @Scheduled(cron = "0 0/2 * * * ?")
    public void executeCloseCollegeSubmitTask() {
        List<Integer> status = new ArrayList<>();
        status.add(StatusEnum.OPEN.code);
        ScholarshipExample scholarshipExample = new ScholarshipExample();
        scholarshipExample.createCriteria()
                .andScholarshipTypeEqualTo(ScholarshipTypeEnum.SCHOOL.code)
                .andStatusIn(status)
                .andAllocationTimeStatusEqualTo(true);
        List<Scholarship> scholarships = scholarshipMapper.selectByExample(scholarshipExample);
        for (Scholarship scholarship : scholarships) {
            Date now = new Date();
            if (scholarship.getCollegeEndDate() != null && now.getTime() >= scholarship.getCollegeEndDate().getTime()) {
                applicationService.closeCollegeSubmit(scholarship.getId());
            }
        }
    }
}
