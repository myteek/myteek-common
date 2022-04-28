package com.myteek.common;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Pattern;

public class Preconditions {

    private static final Pattern datePattern =
            Pattern.compile("^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})" +
                    "-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)" +
                    "-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|" +
                    "((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)" +
                    "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})" +
                    "-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)" +
                    "-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|" +
                    "((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$");

    /**
     * check arguments
     * @param condition condition
     */
    public static void checkArgument(boolean condition) {
        if (!condition) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * check arguments
     * @param condition condition
     * @param message throw message
     */
    public static void checkArgument(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * check arguments
     * @param condition condition
     * @param throwable throwable
     */
    public static void checkArgument(boolean condition, Throwable throwable) {
        if (!condition) {
            throw new IllegalArgumentException(throwable);
        }
    }

    /**
     * check argument throw httpResponseException
     * @param condition
     * @param httpResponseException
     */
    public static void checkArgument(boolean condition, HttpResponseException httpResponseException) {
        if (!condition) {
            throw httpResponseException;
        }
    }

    /**
     * check argument with response status
     * @param condition
     * @param responseStatus
     */
    public static void checkArgument(boolean condition, ResponseStatus responseStatus) {
        if (!condition) {
            throw new HttpResponseException(responseStatus);
        }
    }

    /**
     * check string non-null and length great-than 0
     * @param item item string
     * @return
     */
    public static boolean checkStringNonNullAndLength(String item) {
        return Objects.nonNull(item) && item.length() > 0;
    }

    public static boolean checkStringNonNullAndDateFormatter(String item) {
        return Objects.nonNull(item) && datePattern.matcher(item).find();
    }

    /**
     * check long non-null and great-than 0
     * @param item item number
     * @return
     */
    public static boolean checkLongNonNullAndGTZero(Long item) {
        return Objects.nonNull(item) && item > 0;
    }

    /**
     * check integer non-null and great-than 0
     * @param item item num
     * @return
     */
    public static boolean checkIntegerNonNullAndGTZero(Integer item) {
        return Objects.nonNull(item) && item > 0;
    }

    public static boolean checkIntegerNonNullAndGTNumber(Integer item, Integer number) {
        return Objects.nonNull(item) && item > number;
    }

    public static boolean checkIntegerNonNullAndGTOrEQZero(Integer item) {
        return Objects.nonNull(item) && item >= 0;
    }

    public static boolean checkIntegerNonNullAndGTOrEQNumber(Integer item, Integer number) {
        return Objects.nonNull(item) && item >= number;
    }

    /**
     * check decimal non-null and grant than 0
     * @param item item num
     * @return
     */
    public static boolean checkBigDecimalNonNullAndGTZero(BigDecimal item) {
        return Objects.nonNull(item) && item.doubleValue() > 0;
    }

    /**
     * check decimal non-null and greater than or equal 0
     * @param item
     * @return
     */
    public static boolean checkBigDecimalNonNullAndGTOrEQZero(BigDecimal item) {
        return Objects.nonNull(item) && item.doubleValue() >= 0;
    }

    /**
     * check integer number between range
     * @param item item number
     * @param min min number
     * @param max max number
     * @return
     */
    public static boolean checkIntegerNonNullAndBetweenRange(Integer item, Integer min, Integer max) {
        return Objects.nonNull(item) && item >= min && item <= max;
    }

    /**
     * check integer non null and min number
     * @param item
     * @param min
     * @return
     */
    public static boolean checkIntegerNonNullAndMinBy(Integer item, Integer min) {
        return Objects.nonNull(item) && item >= min;
    }

    /**
     * check integer non null and max number
     * @param item item number
     * @param max max number
     * @return
     */
    public static boolean checkIntegerNonNullAndMaxBy(Integer item, Integer max) {
        return Objects.nonNull(item) && item <= max;
    }

    /**
     * check arguments
     * @param condition condition
     * @param httpResponseException throw httpResponseException
     */
    public static void checkCondition(boolean condition, HttpResponseException httpResponseException) {
        if (!condition) {
            throw httpResponseException;
        }
    }

    /**
     * check arguments
     * @param condition condition
     * @param responseStatus response status
     */
    public static void checkCondition(boolean condition, ResponseStatus responseStatus) {
        if (!condition) {
            throw new HttpResponseException(responseStatus);
        }
    }

    /**
     * check reference
     * @param reference reference
     * @param <T> type
     * @return
     */
    public static <T> T checkNotNull(T reference) {
        if (Objects.isNull(reference)) {
            throw new NullPointerException();
        }
        return reference;
    }

    /**
     * check arguments
     * @param reference reference
     * @param message throw message
     * @param <T> type
     * @return
     */
    public static <T> T checkNotNull(T reference, String message) {
        if (Objects.isNull(reference)) {
            throw new NullPointerException(message);
        }
        return reference;
    }

    /**
     * check reference
     * @param reference reference
     * @param httpResponseException throw httpResponseException
     * @param <T> type
     * @return
     */
    public static <T> T checkNotNull(T reference, HttpResponseException httpResponseException) {
        if (Objects.isNull(reference)) {
            throw httpResponseException;
        }
        return reference;
    }

    /**
     * check reference
     * @param reference reference
     * @param responseStatus throw response status
     * @param <T> type
     * @return
     */
    public static <T> T checkNotNull(T reference, ResponseStatus responseStatus) {
        if (Objects.isNull(reference)) {
            throw new HttpResponseException(responseStatus);
        }
        return reference;
    }

}
