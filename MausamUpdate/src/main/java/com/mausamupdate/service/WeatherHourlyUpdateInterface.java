package com.mausamupdate.service;

import com.mausamupdate.wmodel.WeatherResponse;

public interface WeatherHourlyUpdateInterface {
	 WeatherResponse callWeatherApiHourly(String city);
}
