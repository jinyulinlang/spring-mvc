package com.gao.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;


import static java.util.regex.Pattern.compile;

public class JudgeUtil {
    private static final Logger log = LoggerFactory.getLogger(JudgeUtil.class);

    public static boolean isNum(String numStr) throws IllegalArgumentException {
        try {
            Assert.notNull(numStr, "參數爲null");
            Assert.hasLength(numStr, "參數為空字符串");
            Assert.isTrue(compile("[0-9]*").matcher(numStr).matches(), "字符串不能等轉成數字");
            return true;
        } catch (IllegalArgumentException e) {
            log.error("判斷是否可以轉化為數字的異常為 ：" + e.getMessage());
            return false;
        }
    }

    public static boolean isNumber(String numStr) throws IllegalArgumentException {
        try {
            Assert.notNull(numStr);
            Assert.hasLength(numStr);
            Assert.isTrue(compile("[0-9]*").matcher(numStr).matches());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
