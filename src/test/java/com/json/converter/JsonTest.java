package com.json.converter;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertEquals;

public class JsonTest
{
    private String json = "{\"test\":\"ok simple\"}";


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

    @Test
    public void jsonDecodeTest()
    {
        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject = (JsonObject) Json.jsonDecode(json, jsonObject);
        } catch (Exception e) {
            assert(false);
        }

        assertEquals(json, jsonObject.toString());
        jsonObject.put("testEntry", "cool");
        assertEquals("{\"test\":\"ok simple\",\"testEntry\":\"cool\"}", jsonObject.toString());
    }
}
