package com.gao.util;

import org.springframework.util.StringUtils;

public class AJaxModel {
    /**
     * 默认成功的取到了想取的信息
     */
    private String responseCode;

    /**
     * 取到了想取的信息响应得消息
     */
    private String responseMsg;
    /**
     * 是否返回成功
     */
    private boolean success = true;
    /**
     * 相应的返回数据
     */
    private Object data;

    public String getResponseCode() {
        if (StringUtils.isEmpty(responseCode)) {
            responseCode = "1";
        }
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        if (StringUtils.isEmpty(responseCode)) {
            this.responseCode = "1";
        } else {
            this.responseCode = responseCode;
        }
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        if (StringUtils.isEmpty(responseMsg)) {
            this.responseMsg = "-";
        } else {
            this.responseMsg = responseMsg;
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
