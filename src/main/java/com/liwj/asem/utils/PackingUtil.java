package com.liwj.asem.utils;

import com.liwj.asem.bo.FileBO;
import com.liwj.asem.model.ScholarshipFile;

import java.util.ArrayList;
import java.util.List;

public class PackingUtil {
    public static List<FileBO> packingFileBO(List<ScholarshipFile> scholarshipFiles) {
        List<FileBO> files = new ArrayList<>();
        for (ScholarshipFile file : scholarshipFiles) {
            FileBO fileBO = new FileBO();
            fileBO.setName(file.getName());
            fileBO.setId(file.getId());
            fileBO.setOriginalName(file.getOriginalName());
            files.add(fileBO);
        }
        return files;
    }

}
