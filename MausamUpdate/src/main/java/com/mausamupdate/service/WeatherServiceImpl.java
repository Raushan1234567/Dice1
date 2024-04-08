package com.mausamupdate.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mausamupdate.exception.RestTemplateNotFoundException;
import com.mausamupdate.wmodel.WeatherResponse;

@Service
public class WeatherServiceImpl implements WeatherServiceInterface{
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/{cityName}/summary/" ;
	
	private static final String apiKey = "7ae0f3f50cmshadb0da0d38b7db8p1319a3jsnc5348de96f6b";

	private static final String apiHost = "forecast9.p.rapidapi.com";
	
	
	
	@Override
	public WeatherResponse weatherApiByCityName(String city) {
		String URL = url.replace("{cityName}", city);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Key", apiKey);
		headers.set("X-RapidAPI-Host", apiHost);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		try {
			
			
			ResponseEntity<WeatherResponse> response = restTemplate.exchange(URL,HttpMethod.GET,entity,WeatherResponse.class);
			System.out.println("response{} "+response.getBody());
			return response.getBody();
			
		}
		catch (Exception e) {
			
			throw new RestTemplateNotFoundException("RestTemplate not fount");
			
		}
		
	}
	
	
	
	

}
        
        
//OkHttpClient client = new OkHttpClient();
//
//Request request = new Request.Builder()
//	.url("https://forecast9.p.rapidapi.com/rapidapi/forecast/Patna/summary/")
//	.get()
//	.addHeader("X-RapidAPI-Key", "7ae0f3f50cmshadb0da0d38b7db8p1319a3jsnc5348de96f6b")
//	.addHeader("X-RapidAPI-Host", "forecast9.p.rapidapi.com")
//	.build();
//
//Response response = client.newCall(request).execute();

