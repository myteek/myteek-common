package com.myteek.common.util;

import org.junit.Test;

public class DateUtilTest {

    @Test
    public void stringToTimestampTest() {
        System.out.println(DateUtil.stringToTimestamp("20220401223435", "yyyyMMddHHmmss"));
    }

    @Test
    public void formatterTest() {
        System.out.println(DateUtil.formatterDate(1648903944000L));
    }

    @Test
    public void dayHourTest() {
        System.out.println(DateUtil.dayHour(System.currentTimeMillis()));
    }

}
