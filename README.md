# json.converter.java

Convert Json string into object

#Requirements

* Java 1.8
* java commons-beanutils compatibility

#Example
```
* jsonDecode :
String json = "{\"sample\": \"sample text\"}";
Entity entity = jsonDecode(json, new Entity());


* jsonEncode :
Entity entity = new Entity();
String json = jsonEncode(entity);
```