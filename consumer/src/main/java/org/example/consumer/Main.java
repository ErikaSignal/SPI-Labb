package org.example.consumer;

import org.example.service.Weather;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ServiceLoader<Weather> loader = ServiceLoader.load(Weather.class);

        System.out.println("Today's weather: ");

        List<String> cities = Arrays.asList("Gothenburg", "Malmo", "Stockholm");

        Map<String, Weather> weatherServices = new HashMap<>();
        for (Weather weatherService : loader) {
            for (String city : cities) {
                if (weatherService.getClass().getSimpleName().startsWith(city)) {
                    weatherServices.put(city, weatherService);
                }
            }
        }

        for (String city : cities) {
            Weather weatherService = weatherServices.get(city);
            if (weatherService != null) {
                System.out.println(weatherService.weather(city));
            } else {
                System.out.println("No weather service found for " + city);
            }
        }
    }
}