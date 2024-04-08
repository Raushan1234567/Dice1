package com.mausamupdate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mausamupdate.service.WeatherHourlyUpadte;
import com.mausamupdate.service.WeatherHourlyUpdateInterface;

import com.mausamupdate.service.WeatherServiceInterface;
import com.mausamupdate.wmodel.WeatherResponse;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherServiceInterface weatherService;
	
	@Autowired
	private WeatherHourlyUpdateInterface hourlyUpdateInterface;
	
   @GetMapping("/updateByCity/{city}")
	public ResponseEntity<WeatherResponse> getWeatherSummaryByCityName(@PathVariable String city) {
		
		return new ResponseEntity<WeatherResponse>(weatherService.weatherApiByCityName(city), HttpStatus.OK) ;
	
	}
   @GetMapping("/updateByhourly/{city}")
	public ResponseEntity<WeatherResponse> getWeatherHourly(@PathVariable String city) {
		
		return new ResponseEntity<WeatherResponse>(hourlyUpdateInterface.callWeatherApiHourly(city), HttpStatus.OK) ;
	
	}
	

}
