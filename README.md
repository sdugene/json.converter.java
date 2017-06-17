# json.converter.java

Convert Json string into object

#Requirements

* Java 1.8

#Example
```
* jsonDecode :
String json = "{\"sample\": \"smaple text\"}";
Entity entity = jsonDecode(json, new Entity());


* jsonEncode :
Entity entity = new Entity();
String json = jsonEncode(entity);
```