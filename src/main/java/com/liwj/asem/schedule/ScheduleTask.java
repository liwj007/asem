package com.liwj.asem.schedule;

import com.liwj.asem.dao.PrizeCollegeLimitTimeMapper;
import com.liwj.asem.dao.ScholarshipMapper;
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


    @Scheduled(cron = "0 0/30 * * * ?")
//    @Scheduled(cron = "*/5 * * * * ?")
    public void executeUploadTask() {
        System.out.println("test schedule");
        ScholarshipExample scholarshipExample = new ScholarshipExample();
        scholarshipExample.createCriteria().andStatusEqualTo(StatusEnum.NEW.code);
        List<Scholarship> scholarships = scholarshipMapper.selectByExample(scholarshipExample);

        for (Scholarship scholarship : scholarships) {
            Date now = new Date();
            if (scholarship.getStudentBeginDate()!=null && now.getTime() >= scholarship.getStudentBeginDate().getTime()) {
                scholarshipService.openToStudent(null, scholarship.getId());
            }

            if (scholarship.getCollegeEndDate()!=null && now.getTime()>=scholarship.getCollegeEndDate().getTime()) {
                applicationService.closeCollegeSubmitForSchedule(scholarship.getId());
            }

            PrizeCollegeLimitTimeExample limitTimeExample = new PrizeCollegeLimitTimeExample();
            limitTimeExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId())
                    .andAllocationTimeStatusEqualTo(true);
            List<PrizeCollegeLimitTime> prizeCollegeLimitTimes = prizeCollegeLimitTimeMapper.selectByExample(limitTimeExample);
            for (PrizeCollegeLimitTime limitTime : prizeCollegeLimitTimes) {
                if (limitTime.getGradeEndDate() != null && now.getTime()>=limitTime.getGradeEndDate().getTime()) {
                    applicationService.closeGradeSubmitForSchedule(scholarship.getId(), limitTime.getPrimaryTeachingInstitutionId());
                }

                if (limitTime.getStudentEndDate()!= null && now.getTime()>=limitTime.getStudentEndDate().getTime()){
                    applicationService.closeApplyForSchedule(scholarship.getId(), limitTime.getPrimaryTeachingInstitutionId());
                }
            }
        }
    }
}
