package com.json.tester;

import com.json.converter.Json;

import java.util.HashMap;
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

        String json1 = Json.jsonEncode(test1);
        System.out.println(json1);

        String json2 = Json.jsonEncode(test2);
        System.out.println(json2);


        String api = "{\"mails\":[{\"id\":28,\"fromAddress\":\"inscription@siteoffice.fr\",\"fromName\":\"SITEOFFICE - Inscription\",\"recipient\":\"test@siteoffice.fr\",\"subject\":\"SiteOffice | Validation de compte\",\"body\":\"<html></html>\",\"attachment\":null,\"errorCount\":null,\"errorMessage\":null,\"date\":\"2015-04-12 16:28:54.0\",\"className\":\"Mail\"}],\"templateName\":\"mails\",\"jsScript\":false,\"icon\":\"fa-file\",\"title\":\"Gestion des messages\"}";
        System.out.println("api: "+ Json.jsonDecode(api, new HashMap<String, Object>()));

    }
}
