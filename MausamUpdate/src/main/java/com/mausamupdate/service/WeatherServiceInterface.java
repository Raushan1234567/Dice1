package com.mausamupdate.service;

import com.mausamupdate.wmodel.WeatherResponse;

public interface WeatherServiceInterface {
	WeatherResponse weatherApiByCityName(String city);
}
