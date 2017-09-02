package com.json.converter;

import org.junit.Test;

public class JSONArrayTest
{
    @Test
    public void instantiateTest()
    {
        JSONArray jsonArray = new JSONArray();
        if (!(jsonArray instanceof org.json.simple.JSONArray)) {
            assert(false);
        }
    }
}
