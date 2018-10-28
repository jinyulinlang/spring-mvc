package com.gao.test;

import com.gao.util.JudgeUtil;
import org.junit.Test;
import org.springframework.util.StringUtils;

public class MainTest {


    @Test
    public void testInteger() {
        String id = "0";
//        Integer integer = Integer.valueOf(id);
//        System.out.println(integer);
        boolean num = JudgeUtil.isNum(id);
        System.out.println(num);

    }
}
