package com.myteek.common.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class Common {

    /**
     * thread sleep millis
     * @param millis 休眠时间 单位毫秒
     */
    public static void sleep(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (Throwable e) {
            log.warn("thread sleep error", e);
        }
    }

    public static String mapToString(Map<String, String> map) {
        return map.entrySet().stream().map(item -> item.getKey() + ":" + item.getValue())
                .collect(Collectors.joining(","));
    }

}
