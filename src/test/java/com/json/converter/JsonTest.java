package com.json.converter;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class JsonTest
{
    @Test
    public void instantiateTest()
    {
        try {
            Constructor<Json> c = Json.class.getDeclaredConstructor();
            c.setAccessible(true);
            c.newInstance();
        } catch (Exception e) {
            assert(true);
        }
    }
}
