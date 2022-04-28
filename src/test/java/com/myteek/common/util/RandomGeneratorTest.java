package com.myteek.common.util;

import org.junit.Assert;
import org.junit.Test;

public class RandomGeneratorTest {

    @Test
    public void generateIntStringTest() {
        int length = 10000;
        Assert.assertEquals(length, RandomGenerator.generateIntString(length).length());
    }

}
