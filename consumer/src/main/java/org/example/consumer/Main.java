package org.example.consumer;

import org.example.provider.GothenburgWeather;
import org.example.provider.MalmoWeather;
import org.example.provider.StockholmWeather;
import org.example.service.Weather;

import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {

        ServiceLoader<Weather> loader = ServiceLoader.load(Weather.class);

        Scanner scanner = new Scanner(System.in);
        String city = "";

        while (true) {
            System.out.println("Enter the name of the city: ");
            city = scanner.nextLine();

            if (city.equalsIgnoreCase("Gothenburg") || city.equalsIgnoreCase("Stockholm") || city.equalsIgnoreCase("Malmö")) {
                break;
            } else {
                System.out.println("Invalid city name. Please try again.");
            }
        }

        for (Weather weatherService : loader) {
            if (weatherService instanceof GothenburgWeather && city.equalsIgnoreCase("Gothenburg")) {
                System.out.println(weatherService.weather(city));
            } else if (weatherService instanceof StockholmWeather && city.equalsIgnoreCase("Stockholm")) {
                System.out.println(weatherService.weather(city));
            } else if (weatherService instanceof MalmoWeather && city.equalsIgnoreCase("Malmö")) {
                System.out.println(weatherService.weather(city));
            }
        }
    }
}
