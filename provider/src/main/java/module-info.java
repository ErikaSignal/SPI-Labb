import org.example.provider.GothenburgWeather;
import org.example.provider.MalmoWeather;
import org.example.provider.StockholmWeather;
import org.example.service.Weather;

module org.example.provider {
    exports org.example.provider;
    requires org.example.service;
    provides Weather with GothenburgWeather, StockholmWeather, MalmoWeather;

}