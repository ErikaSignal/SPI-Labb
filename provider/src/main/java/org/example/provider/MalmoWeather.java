package org.example.provider;

import org.example.service.Weather;

public class MalmoWeather implements Weather {
    @Override
    public String weather(String city) {
        return "The weather in " + city + " is rainy.";
    }
}
