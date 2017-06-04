import com.json.converter.Json;

import java.util.HashMap;

public class JsonTests {

	public static void main(String [] args)
    {


		System.out.println(Json.jsonDecode("{\"test\":\"blaj\"}", new HashMap<>()));
	}

}
