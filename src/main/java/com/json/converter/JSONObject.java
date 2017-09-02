package com.json.converter;

import java.util.Map;

public class JSONObject extends org.json.simple.JSONObject
{
    public JSONObject ()
    {
        super();
    }

    public JSONObject (Map<String, String> map)
    {
        super(map);
    }
}
