package com.vkc_s4.utils;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class methodsUtilsService {

	  public static <T, R> R getValueOrDefault(
	            List<T> list,
	            Predicate<T> filterCondition,
	            Function<T, R> mapper,
	            R defaultValue) {
	        return Optional.ofNullable(list)
	                .flatMap(l -> l.stream()
	                        .filter(filterCondition)
	                        .map(mapper)
	                        .findFirst())
	                .orElse(defaultValue);
	    }
	
	
	@Description(value = "Convert XML to Json Format !!")
	public JsonNode XmlToJsonConversion(String data) throws JsonMappingException, JsonProcessingException {
		JSONObject json = XML.toJSONObject(data);
		String jsonString2 = json.toString(4);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(jsonString2);
		JsonNode entryNodeArray = rootNode.path("feed").path("entry"); // .path("feed")
		return entryNodeArray;
	}

	@Description(value = "Convert XML to Json Format !!")
	public JsonNode XmlToJsonConversionTestContent(String data) throws JsonMappingException, JsonProcessingException {
		JSONObject json = XML.toJSONObject(data);
		String jsonString2 = json.toString(4);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(jsonString2);
		JsonNode entryNodeArray = rootNode.path("feed").path("entry"); // .path("feed")
		return entryNodeArray;
	}
	
	public HttpResponse<String> ApiCallForPost(String apiUrl, String username, String password, String csrfToken,
			String body) throws UnirestException {
		HttpResponse<String> response = Unirest.post(apiUrl).basicAuth(username, password).header("Content-Type", "application/json")
				.header("x-csrf-token", csrfToken).body(body).asString();
		return response;
	}
	
	public static String extractErrorMessage (String data) throws JsonMappingException, JsonProcessingException {
		  // Convert XML to JSON
    JSONObject json = XML.toJSONObject(data);
    String jsonString = json.toString(4);

    // Parse JSON string to JsonNode
    ObjectMapper mapper = new ObjectMapper();
    JsonNode rootNode = mapper.readTree(jsonString);

    // Navigate to the error.message node
    JsonNode messageNode = rootNode.path("error").path("message").path("content");

    // Extract the message content
//    System.out.println("messageNode"+messageNode);
    
    String message = messageNode.asText();
//    System.out.println("Message"+message);
//    System.out.println("Message"+message);

  return message;
	}

	public HttpResponse<String> ApiCall(String apiUrl, String username, String password) throws UnirestException {
		HttpResponse<String> response = Unirest.get(apiUrl).basicAuth(username, password).asString();
		return response;
	}
	
}
