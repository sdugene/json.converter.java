package com.json.converter;

import java.util.HashMap;

public class Tests {

	public static void main(String [] args)
    {
		System.out.println(Json.jsonDecode("{\"test\":\"blaj\"}", new HashMap()));
	}

}
