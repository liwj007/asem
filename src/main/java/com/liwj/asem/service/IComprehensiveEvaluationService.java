package com.liwj.asem.service;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.FileBO;
import com.liwj.asem.exception.WSPException;

import java.io.IOException;
import java.util.List;

public interface IComprehensiveEvaluationService {
    void uploadFiles(List<FileBO> fileBOList) throws IOException, WSPException;

    PageInfo getComprehensiveEvaluationList(Integer pageNum, Integer pageSize);
}
