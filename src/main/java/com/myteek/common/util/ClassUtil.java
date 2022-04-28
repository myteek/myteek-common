package com.myteek.common.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Slf4j
public class ClassUtil {

    /**
     * field copy
     * @param source
     * @param target
     */
    public static void fieldCopy(Object source, Object target) {
        Class superClass = source.getClass();
        while (superClass != null) {
            for (Field field : superClass.getDeclaredFields()) {
                if (!Modifier.isFinal(field.getModifiers())) {
                    try {
                        field.setAccessible(true);
                        setFiled(target, field.getName(), field.get(source));
                    } catch (IllegalAccessException e) {
                        log.info("field copy error, instance: {}, field: {}", source, field, e);
                    }
                }
            }
            superClass = superClass.getSuperclass();
        }
    }

    public static void removeListProperties(List<?> itemArr, Set<String> properties) {
        itemArr.forEach(item -> removeProperties(item, properties));
    }

    public static void removeProperties(Object instance, Set<String> properties) {
        properties.forEach(item -> setFiled(instance, item, null));
    }

    /**
     * set reserve object instance fields
     * @param instance
     * @param properties
     */
    public static void reserveProperties(Object instance, Set<String> properties) {
        if (Objects.nonNull(instance)) {
            try {
                for (Field field : instance.getClass().getDeclaredFields()) {
                    if (!properties.contains(field.getName())) {
                        setField(instance, field, null);
                    }
                }
            } catch (Exception e) {
                log.info("reserve properties error", e);
            }
        }
    }

    /**
     * set instance field
     * @param instance
     * @param field
     * @param value
     */
    public static void setField(Object instance, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(instance, value);
        } catch (IllegalAccessException e) {
            log.warn("field set failure", e);
        }
    }

    /**
     * set field name value
     * @param instance instance
     * @param name field name
     * @param value field value
     * @return
     */
    public static boolean setFiled(Object instance, String name, Object value) {
        if (Objects.isNull(instance) || Objects.isNull(name)) {
            throw new IllegalArgumentException("instance should not be null");
        }
        Field field;
        try {
            field = instance.getClass().getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            field = null;
        }
        Class superClass = instance.getClass().getSuperclass();
        while (field == null && superClass != null) {
            try {
                field = superClass.getDeclaredField(name);
            } catch (NoSuchFieldException e) {
                superClass = superClass.getSuperclass();
            }
        }
        if (field == null) {
            return false;
        }
        field.setAccessible(true);
        try {
            field.set(instance, value);
        } catch (IllegalAccessException e) {
            log.info("set field error, instance: {}, field: {}, value: {}", instance, field, value, e);
        }
        return false;
    }

}
