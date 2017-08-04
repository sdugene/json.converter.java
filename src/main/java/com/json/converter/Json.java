package com.json.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rits.cloning.Cloner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.apache.commons.beanutils.BeanUtils.populate;

/**
 * Created by Sebastien Dugene on 04/06/2017.
 */
public class Json
{
    /**
     * Convert Json String into defined Object
     *
     * @param json text to convert
     * @param object object to hydrate
     */
    public static Object jsonDecode(String json, Object object)
    {
        if(object instanceof JSONObject) {
            return toJSONObject(json);
        }

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
            Map<String, Object> map = new Gson().fromJson(
                    json, new TypeToken<HashMap<String,Object>>() {}.getType()
            );

            try {
                populate(object, map);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return object;
        }
    }

    /**
     * Convert Json String into JSONObject
     *
     * @param json text to convert
     */
    private static JSONObject toJSONObject(String json)
    {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(json);
            if (obj instanceof JSONArray) {
                return null;
            } else {
                return (JSONObject) obj;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Convert Json String into Map
     *
     * @param json text to convert
     */
    public static Object jsonDecode(String json)
    {
        return Json.jsonDecode(json, new HashMap<String, Object>());
    }

    /**
     * Convert object into Json String
     *
     * @param object object to convert
     */
    public static String jsonEncode(Object object)
    {
        return new Gson().toJson(object);
    }
}
