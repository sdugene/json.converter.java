package com.json.converter;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

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

        Object map = Json.jsonDecode(json);
        if (!(map instanceof HashMap)) {
            assert(false);
        }
        assertEquals("ok simple", ((Map) map).get("test"));
    }

    @Test
    public void jsonEncodeTest()
    {
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("test", "ok simple");

        String jsonTest = Json.jsonEncode(jsonObject);
        assertEquals(json, jsonTest);
    }
}
