package com.liwj.asem.controller;

import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.utils.PropertiesUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@RestController
@RequestMapping(value = "/files")
public class FileController {
    public final static String fileMenu = PropertiesUtil.getStringByKey("uploadFiles");

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResponseData testUploadFile(HttpServletRequest req,
                                       MultipartHttpServletRequest multiReq) {
        // 获取上传文件的路径
        String uploadFilePath = multiReq.getFile("file").getOriginalFilename();

        // 截取上传文件的文件名
        String uploadFileName = uploadFilePath.substring(
                uploadFilePath.lastIndexOf('\\') + 1, uploadFilePath.indexOf('.'));

        // 截取上传文件的后缀
        String uploadFileSuffix = uploadFilePath.substring(
                uploadFilePath.indexOf('.') + 1, uploadFilePath.length());
        if (!uploadFileSuffix.equals("doc") && !uploadFileSuffix.equals("docx") && !uploadFileSuffix.equals("pdf")
                && !uploadFileSuffix.equals("xls") && !uploadFileSuffix.equals("xlsx")){
            ResponseData responseData = new ResponseData();
            responseData.setFail(ErrorInfo.ERROR_FILE_TYPE);
            return responseData;
        }

        String  newFileName = UUID.randomUUID().toString();

        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fis = (FileInputStream) multiReq.getFile("file").getInputStream();
            fos = new FileOutputStream(new File(fileMenu + "//" + newFileName
                    + ".")
                    + uploadFileSuffix);
            byte[] temp = new byte[1024];
            int i = fis.read(temp);
            while (i != -1){
                fos.write(temp,0,temp.length);
                fos.flush();
                i = fis.read(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(newFileName+"."+uploadFileSuffix);
        return responseData;
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void testDownload(HttpServletResponse res,@RequestParam(value = "file") String fileName) {
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(fileMenu + "//"
                    + fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
