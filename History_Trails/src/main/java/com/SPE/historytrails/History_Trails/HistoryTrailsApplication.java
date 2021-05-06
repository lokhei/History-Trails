package com.SPE.historytrails.History_Trails;

import com.SPE.historytrails.History_Trails.domain.Objects;
import com.SPE.historytrails.History_Trails.service.ObjectService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;




@SpringBootApplication
public class HistoryTrailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistoryTrailsApplication.class, args);
	}


	public JSONArray initialiseLikes() throws IOException {

		JSONArray likesList = new JSONArray();

		JSONObject galleryList = requestJSON("https://opendata.bristol.gov.uk/api/records/1.0/search/?dataset=open-data-gallery-3-european-old-masters&q=&rows=115&sort=-order_of_appearance&facet=medium&facet=object_type","","");

		Iterable<JSONObject> objects = (Iterable<JSONObject>) galleryList.get("records");

		//Iterate over gallery array
		objects.forEach(object -> {

			Object recordid = object.get("recordid");
			JSONObject objectLikes = new JSONObject();
			objectLikes.put("recordid", recordid);
			objectLikes.put("likes", 0);
			likesList.add(objectLikes);

		});


//		write to file
		try (FileWriter file = new FileWriter("src/main/resources/json/likes.json")) {
			//We can write any JSONArray or JSONObject instance to the file
			file.write(likesList.toString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return likesList;

	}

	private static JSONObject requestJSON(String urlString, String username, String key)
	{
		try {
			URL url = new URL(urlString);
			byte[] keyBytes = (username + ":" + key).getBytes(StandardCharsets.UTF_8);
			String encodedKey = Base64.getEncoder().encodeToString(keyBytes);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setRequestProperty ("Authorization", "Basic " + encodedKey);
			InputStream stream = (InputStream) connection.getInputStream();
			JSONParser parser = new JSONParser();
			return (JSONObject)parser.parse(new InputStreamReader(stream, StandardCharsets.UTF_8));
		} catch(IOException | ParseException uee) { return null; }
	}

//	@GetMapping(value = "/updateLikes")
//	public void updateLikes(Iterable<JSONObject> likesList, String recordUpdate, int sign) throws IOException {
//
//
//		JSONArray updatedlikesList = new JSONArray();
//
//		likesList.forEach(object -> {
//			Object recordid = object.get("recordid");
//			int numLikes = (recordid.equals(recordUpdate))  ?  (int) object.get("likes") + sign : 0;
//			JSONObject objectLikes = new JSONObject();
//			objectLikes.put("recordid", recordid);
//			objectLikes.put("likes", numLikes);
//			updatedlikesList.add(objectLikes);
//
//		});
//
//		try (FileWriter file = new FileWriter("src/main/resources/json/likes.json")) {
//			//We can write any JSONArray or JSONObject instance to the file
//			file.write(updatedlikesList.toString());
//			file.flush();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
////		return updatedlikesList;
//
//	}


	@Bean
	CommandLineRunner runner(ObjectService objectService){
		return args -> {

			JSONArray likesList = initialiseLikes();


			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Objects>> typeReference = new TypeReference<List<Objects>>(){};
			InputStream targetStream = TypeReference.class.getResourceAsStream("/json/likes.json");

			try {
				List<Objects> objects = mapper.readValue(targetStream,typeReference);
				objectService.save(objects);

				System.out.println("Objects Saved!");
			} catch (IOException e){
				System.out.println("Unable to save objects: " + e.getMessage());
			}
		};
	}
}
