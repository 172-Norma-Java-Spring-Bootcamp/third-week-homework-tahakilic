package com.example.weatherapihomework.controller;
import com.example.weatherapihomework.model.CustomWeatherDto;
import com.example.weatherapihomework.model.WeatherDto;
import com.example.weatherapihomework.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/", produces = "application/json")
public class WeatherController {

    private WeatherService weatherService;

    //@PathVariable annotation example
    //localhost:8080/api/WeatherByCity/bursa
    @GetMapping(path = "WeatherByCity/{cityName}")
    public ResponseEntity<WeatherDto> getWeatherByCity(@PathVariable String cityName){
        return weatherService.getWeatherByCity(cityName);
    }


    //@RequestParam annotation example
    //localhost:8080/api/WeatherByCity?countryName=Bursa
    @GetMapping(path = "WeatherByCity")
    public ResponseEntity<CustomWeatherDto> getPathWeatherByCity(@RequestParam(value = "countryName")String countryName){
        return weatherService.getPathWeatherByCity(countryName);
    }

    //@RequestBody annotation example
    /*
     * localhost:8080/api/CustomWeatherByCity
     * body= {"cityName":"bursa"}
     */
    @PostMapping(path = "CustomWeatherByCity")
    public ResponseEntity<CustomWeatherDto> getCustomWeatherByCity(@RequestBody CustomWeatherDto customWeatherDto){
        return weatherService.getCustomWeatherByCity(customWeatherDto);
    }



    @Autowired
    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
}
