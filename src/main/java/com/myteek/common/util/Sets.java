package com.myteek.common.util;

import java.util.HashSet;
import java.util.Set;

public class Sets {

    /**
     * set from of values
     * @param args args
     * @param <T> type
     * @return
     */
    public static <T> Set<T> of(T... args) {
        HashSet<T> ret = new HashSet<>(args.length);
        for (T item : args) {
            ret.add(item);
        }
        return ret;
    }

}
