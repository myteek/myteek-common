package com.myteek.common.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lists {

    public static <T> List<T> of(T... args) {
        return Stream.of(args).collect(Collectors.toList());
    }

    public static List<Integer> integerOf(String string, String split) {
        return Stream.of(string.split(split)).map(item -> item.trim())
                .filter(item -> item.length() > 0).map(item -> Integer.valueOf(item)).collect(Collectors.toList());
    }

    public static List<Short> shortOf(String string, String split) {
        return Stream.of(string.split(split)).map(item -> item.trim())
                .filter(item -> item.length() > 0).map(item -> Short.valueOf(item)).collect(Collectors.toList());
    }

    public static <T> String listToString(List<T> lists, String joinString) {
        return lists.stream().map(item -> String.valueOf(item)).collect(Collectors.joining(joinString));
    }

}
