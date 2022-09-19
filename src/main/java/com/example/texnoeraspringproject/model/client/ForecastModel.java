package com.example.texnoeraspringproject.model.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ForecastModel {
    @JsonProperty(namespace = "weather")
    List<WeatherDto> weather;
}
