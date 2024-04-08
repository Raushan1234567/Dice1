package com.mausamupdate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.mausamupdate.exception.RestTemplateNotFoundException;
import com.mausamupdate.wmodel.WeatherResponse;

@Service
public class WeatherHourlyUpadte implements WeatherHourlyUpdateInterface{
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/{cityName}/hourly/" ;
	
	private static final String apiKey = "a124951665mshbd82256088f542cp1c9f3ejsncc809bdf6357";

	private static final String apiHost = "forecast9.p.rapidapi.com";
	

	@Override
	public WeatherResponse callWeatherApiHourly(String city) {
		
       String URL = url.replace("{cityName}", city);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Key", apiKey);
		headers.set("X-RapidAPI-Host", apiHost);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		try {
			
			ResponseEntity<WeatherResponse> response = restTemplate.exchange(URL,HttpMethod.GET,entity,WeatherResponse.class);
			if(response == null) {
				throw new RestTemplateNotFoundException("RestTemplate is not Exchange");
			}
			
			System.out.println("response{} "+response.getBody());
			return response.getBody();
			
		}
		catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			
		} 
	}

}


//OkHttpClient client = new OkHttpClient();
//
//Request request = new Request.Builder()
//	.url("https://forecast9.p.rapidapi.com/rapidapi/forecast/Berlin/hourly/")
//	.get()
//	.addHeader("X-RapidAPI-Key", "a124951665mshbd82256088f542cp1c9f3ejsncc809bdf6357")
//	.addHeader("X-RapidAPI-Host", "forecast9.p.rapidapi.com")
//	.build();
//
//Response response = client.newCall(request).execute();
