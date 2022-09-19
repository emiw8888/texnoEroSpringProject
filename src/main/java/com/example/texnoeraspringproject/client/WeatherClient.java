package com.example.texnoeraspringproject.client;

import com.example.texnoeraspringproject.model.client.ForecastModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(
        name = "weather-client",
        url = "http://api.openweathermap.org"
)
public interface WeatherClient {
    @GetMapping(value = "/data/2.5/weather?lat=44.34&lon=10.99&appid=${api-key}", produces = "application/json")
    ForecastModel getForecast();
}
