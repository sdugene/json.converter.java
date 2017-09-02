package com.json.converter;

import org.json.simple.JSONObject;

import java.util.Map;

public class JsonObject extends JSONObject
{
    public JsonObject()
    {
        super();
    }

    public JsonObject(Map<String, String> map)
    {
        super(map);
    }
}
