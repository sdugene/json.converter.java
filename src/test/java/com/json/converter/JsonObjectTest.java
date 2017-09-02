package com.json.converter;

import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.HashMap;

public class JsonObjectTest
{
    @Test
    public void instantiateTest()
    {
        JsonObject jsonObject = new JsonObject();
        if (!(jsonObject instanceof JSONObject)) {
            assert(false);
        }

        JsonObject jsonObject2 = new JsonObject(new HashMap<String, String>());
        if (!(jsonObject instanceof JSONObject)) {
            assert(false);
        }
    }
}
