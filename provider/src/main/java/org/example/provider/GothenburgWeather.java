package org.example.provider;

import org.example.service.Weather;

public class GothenburgWeather implements Weather {
    @Override
    public String weather(String city) {
        return "The weather in " + city + " is windy.";
    }
}
