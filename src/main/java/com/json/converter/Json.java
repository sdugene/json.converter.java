package com.json.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rits.cloning.Cloner;

import java.lang.reflect.InvocationTargetException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.apache.commons.beanutils.BeanUtils.populate;

public class Json
{
    private Json() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Convert Json String into defined Object
     *
     * @param json text to convert
     * @param object object to hydrate
     */
    public static Object jsonDecode(String json, Object object) throws Exception
    {
        if(object instanceof JsonObject) {
            return toJSONObject(json);
        }

        List<Object> list;
        Cloner cloner=new Cloner();

        String pattern = "^\\[.*\\]$";
        if (json.matches(pattern)) {
            list = new Gson().fromJson(
                    json, new TypeToken<List<JsonObject>>() {}.getType()
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

            populate(object, map);

            return object;
        }
    }

    /**
     * Convert Json String into JSONObject
     *
     * @param json text to convert
     */
    private static JsonObject toJSONObject(String json) throws Exception
    {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);
        if (obj instanceof JsonArray) {
            return null;
        } else {
            return (JsonObject) obj;
        }
    }

    /**
     * Convert Json String into Map
     *
     * @param json text to convert
     */
    public static Object jsonDecode(String json) throws Exception
    {
        return Json.jsonDecode(json, new HashMap<String, Object>());
    }

    /**
     * Convert Json String into specific class
     *
     * @param json text to convert
     * @param className class to hydrate
     */
    public static Object fromJson(String json, Class className)
    {
        return new Gson().fromJson(json, className);
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

    /**
     * Convert Json String into specific class
     *
     * @param object Object to convert
     */
    public static String toJson(Object object)
    {
        return new Gson().toJson(object);
    }
}
