package com.json.converter;

import org.json.simple.JSONArray;
import org.junit.Test;

public class JsonArrayTest
{
    @Test
    public void instantiateTest()
    {
        JsonArray jsonArray = new JsonArray();
        if (!(jsonArray instanceof JSONArray)) {
            assert(false);
        }
    }
}
