package com.gao.controller;

import com.gao.util.AJaxModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {
    private Logger log = LoggerFactory.getLogger(FileUploadController.class);

    /**
     * 單文件上傳
     *
     * @param file1
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadSingle")
    @ResponseBody
    public AJaxModel uploadSingle(@RequestParam("file1") MultipartFile file1, HttpServletResponse response, HttpServletRequest request) {
        AJaxModel aJaxModel = new AJaxModel();
        String realPath = request.getServletContext().getRealPath("/upload");
        try {
            file1.transferTo(new File(realPath + "/" + file1.getOriginalFilename()));
            aJaxModel.setData("/upload/".concat(file1.getOriginalFilename()));
            aJaxModel.setResponseMsg("上傳成功！");
            log.info("上傳成功！");
        } catch (IOException e) {
            log.error("文件上傳出現異常：", e);
            aJaxModel.setResponseMsg("文件上傳出現異常");
            aJaxModel.setResponseCode("2");
        }
        return aJaxModel;
    }

    /**
     * 單文件上傳
     *
     * @param files
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadMutiFile")
    @ResponseBody
    public AJaxModel uploadMutiFile(@RequestParam("file") MultipartFile[] files, HttpServletResponse response, HttpServletRequest request) {
        AJaxModel aJaxModel = new AJaxModel();
        List<String> fileList = new ArrayList<String>();
        String realPath = request.getServletContext().getRealPath("/upload");
        try {
            for (MultipartFile file : files) {
                file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
                fileList.add("/upload/" + file.getOriginalFilename());
            }
            aJaxModel.setResponseMsg("上傳成功！");
            aJaxModel.setData(fileList);
            log.info("上傳成功！");
        } catch (IOException e) {
            log.error("文件上傳出現異常：", e);
            aJaxModel.setResponseMsg("文件上傳出現異常");
            aJaxModel.setResponseCode("2");
        }
        return aJaxModel;
    }

}
