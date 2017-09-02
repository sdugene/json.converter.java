package com.json.tester;

import com.json.converter.Json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application
{
    /**
     * Run json.converter tests
     *
     * @param args default args
     */
    public static void main(String [] args)
    {
        Entity test1 = null;
        try {
            test1 = (Entity) Json.jsonDecode("{\"test\": \"ok simple\"}", new Entity());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("test1: "+test1.getTest());

        List<Entity> test2 = null;
        try {
            test2 = (List)Json.jsonDecode("[{\"test\": \"ok double\"},{\"test\": \"ok double 2\"}]", new Entity());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("test2[1]: "+test2.get(1).getTest());
        System.out.println("test2[0]: "+test2.get(0).getTest());
        System.out.println("test1: "+test1.getTest());

        Map<String, Object> test3 = null;
        try {
            test3 = (Map) Json.jsonDecode("{\"test\": \"ok simple 3\"}");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("test3: "+test3.get("test"));

        String json1 = Json.jsonEncode(test1);
        System.out.println("json1: "+json1);

        String json2 = Json.jsonEncode(test2);
        System.out.println("json2: "+json2);

        String api = "{\"mails\":[{\"id\":28,\"fromAddress\":\"test@siteoffice.fr\",\"fromName\":\"SITEOFFICE - Test\",\"recipient\":\"test@siteoffice.fr\",\"subject\":\"SiteOffice | Validation de test\",\"body\":\"<html></html>\",\"attachment\":null,\"errorCount\":null,\"errorMessage\":null,\"date\":\"2015-04-12 16:28:54.0\",\"className\":\"Mail\"}],\"templateName\":\"mails\",\"jsScript\":false,\"icon\":\"fa-file\",\"title\":\"Gestion des messages\"}";
        try {
            System.out.println("api: "+ Json.jsonDecode(api));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
