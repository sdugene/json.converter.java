package com.json.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rits.cloning.Cloner;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.beanutils.BeanUtils.populate;

public class Json
{
    public static Object jsonDecode(String json, Object object)
    {
        List<Object> list;
        Cloner cloner=new Cloner();

        String pattern = "^\\[.*\\]$";
        if (json.matches(pattern)) {
            list = new Gson().fromJson(
                    json, new TypeToken<List<JSONObject>>() {}.getType()
            );

            for (Object line: list) {
                int key = list.indexOf(line);
                list.set(key, Json.jsonDecode(line.toString(), cloner.deepClone(object)));
            }

            return list;
        } else {
            Map<String, String> map = new Gson().fromJson(
                    json, new TypeToken<HashMap<String,String>>() {}.getType()
            );

            try {
                populate(object, map);
            } catch (Exception e) {
                System.out.println(e);
            }

            return object;
        }
    }
}
