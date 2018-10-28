package com.gao.controller;

import com.alibaba.fastjson.JSONObject;
import com.gao.model.TStudent;
import com.gao.service.TStudentService;
import com.gao.util.AJaxModel;
import com.gao.util.JudgeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("student")
public class TStudentController {
    private static final Logger log = LoggerFactory.getLogger(TStudentController.class);
    @Autowired
    private TStudentService tStudentService;

    /**
     * @param tStudent
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "insert")
    @ResponseBody
    public AJaxModel insert(TStudent tStudent, HttpServletRequest request, HttpServletResponse response) {
        log.info("新增学生开始");
        AJaxModel aJaxModel = new AJaxModel();
        try {
            int insert = tStudentService.insert(tStudent);
            Assert.isTrue(insert < 0, "新增失败！");
            log.info("新增成功！");
            aJaxModel.setResponseMsg("新增成功");
        } catch (IllegalArgumentException e) {
            log.error("异常为：", e.getMessage());
            aJaxModel.setResponseCode("2");
            aJaxModel.setResponseMsg(e.getMessage());
        }
        log.info("新增学生结束");
        return aJaxModel;
    }

    /**
     * @param tStudent
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "insertSelective")
    @ResponseBody
    public AJaxModel insertSelective(TStudent tStudent, HttpServletRequest request, HttpServletResponse response) {
        log.info("新增学生开始");
        AJaxModel aJaxModel = new AJaxModel();
        try {
            int insert = tStudentService.insertSelective(tStudent);
            Assert.isTrue(insert < 0, "新增失败！");
            log.info("新增成功！");
            aJaxModel.setResponseMsg("新增成功");
        } catch (IllegalArgumentException e) {
            log.error("异常为：", e.getMessage());
            aJaxModel.setResponseCode("2");
            aJaxModel.setResponseMsg(e.getMessage());
        }
        log.info("新增学生结束");
        return aJaxModel;
    }

    /**
     * @param tStudent
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "updateByPrimaryKeySelective")
    @ResponseBody
    public AJaxModel updateByPrimaryKeySelective(TStudent tStudent, HttpServletRequest request, HttpServletResponse response) {
        log.info("修改学生开始");
        AJaxModel aJaxModel = new AJaxModel();
        try {
            int insert = tStudentService.updateByPrimaryKeySelective(tStudent);
            Assert.isTrue(insert < 0, "修改学生失败！");
            log.info("修改成功成功！");
            aJaxModel.setResponseMsg("修改成功");
        } catch (IllegalArgumentException e) {
            log.error("异常为：", e.getMessage());
            aJaxModel.setResponseCode("2");
            aJaxModel.setResponseMsg(e.getMessage());
        }
        log.info("修改学生结束");
        return aJaxModel;
    }

    /**
     * @param tStudent
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "updateByPrimaryKey")
    @ResponseBody
    public AJaxModel updateByPrimaryKey(TStudent tStudent, HttpServletRequest request, HttpServletResponse response) {
        log.info("修改学生开始");
        AJaxModel aJaxModel = new AJaxModel();
        try {
            int insert = tStudentService.updateByPrimaryKey(tStudent);
            Assert.isTrue(insert < 0, "修改学生失败！");
            log.info("修改成功成功！");
            aJaxModel.setResponseMsg("修改成功");
        } catch (IllegalArgumentException e) {
            log.error("异常为：", e.getMessage());
            aJaxModel.setResponseCode("2");
            aJaxModel.setResponseMsg(e.getMessage());
        }
        log.info("修改学生结束");
        return aJaxModel;
    }

    /**
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "selectByPrimaryKey")
    @ResponseBody
    public AJaxModel selectByPrimaryKey(HttpServletRequest request, HttpServletResponse response) {
        log.info("查詢学生开始");
        AJaxModel aJaxModel = new AJaxModel();
        try {
            Assert.isTrue(JudgeUtil.isNumber(request.getParameter("id")), "輸入的參數非法");
            int id = Integer.parseInt(request.getParameter("id"));
            TStudent tStudent = tStudentService.selectByPrimaryKey(id);
            Assert.notNull(tStudent, "查无此学生");
            Object o = (JSONObject) JSONObject.toJSON(tStudent);
            String s = ((JSONObject) o).toJSONString();
            log.info(s.toString());
            log.info("查詢成功！");
            aJaxModel.setResponseMsg("查詢成功");
            aJaxModel.setData(tStudent);
        } catch (IllegalArgumentException e) {
            log.error("异常为：" + e.getMessage());
            aJaxModel.setResponseCode("2");
            aJaxModel.setResponseMsg(e.getMessage());
        }
        log.info("查找学生结束");
        return aJaxModel;
    }

    /**
     * @param tStudent
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "deleteByPrimaryKey")
    @ResponseBody
    public AJaxModel deleteByPrimaryKey(TStudent tStudent, HttpServletRequest request, HttpServletResponse response) {
        log.info("修改学生开始");
        AJaxModel aJaxModel = new AJaxModel();

        try {
            Assert.isInstanceOf(Integer.TYPE, request.getParameter("id"), "参数不能转换成int类型");
            int insert = tStudentService.deleteByPrimaryKey(Integer.parseInt(request.getParameter("id")));
            Assert.isTrue(insert < 0, "删除学生失败！");
            log.info("删除成功成功！");
            aJaxModel.setResponseMsg("删除成功");
        } catch (IllegalArgumentException e) {
            log.error("异常为：", e.getMessage());
            aJaxModel.setResponseCode("2");
            aJaxModel.setResponseMsg(e.getMessage());
        }
        log.info("删除学生结束");
        return aJaxModel;
    }


}