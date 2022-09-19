package com.example.texnoeraspringproject.model.client;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class WeatherDto {
    @JsonProperty(namespace = "id")
    Long id;
    @JsonProperty(namespace = "main")
    String main;
    @JsonProperty(namespace = "description")
    String description;
    @JsonProperty(namespace = "icon")
    String icon;
}
