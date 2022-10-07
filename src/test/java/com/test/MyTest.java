package com.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Rrow
 * @date: 2022/10/7 18:14
 */
public class MyTest {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    public void test01() {
        String time = format.format(new Date());
        System.out.println(time);
    }
}
