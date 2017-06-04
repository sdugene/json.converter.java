package com.json.tester;

import com.json.converter.Json;
import java.util.List;

public class Application
{
    public static void main(String [] args)
    {
        Entity test1 = (Entity) Json.jsonDecode("{\"test\": \"ok simple\"}", new Entity());
        System.out.println(test1.getTest());

        List<Entity> test2 = (List)Json.jsonDecode("[{\"test\": \"ok double\"},{\"test\": \"ok double 2\"}]", new Entity());
        System.out.println(test2.get(1).getTest());
        System.out.println(test2.get(0).getTest());
        System.out.println("test1: "+test1.getTest());
    }
}
