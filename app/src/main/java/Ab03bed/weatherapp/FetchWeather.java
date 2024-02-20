package Ab03bed.weatherapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FetchWeather {
    //why you leave alone my darling, dont you have a heart in you? i feel so lonly when you go to your famliy and donot care about the bread and the salt between us? signed by #doyouwantacarAbro
    //@GET("/weatherapi/locationforecast/2.0/classic?")
    //Call<Weather> getWeatherData(@Query("lat") String lat, @Query("lon") String lon);

    //@GET("/weatherapi/locationforecast/2.0/classic")
    //Call<List<WeatherData>> getWeatherData(@Query("lat") String lat, @Query("lon") String lon);

    @GET("/weatherapi/locationforecast/2.0/classic?")
    Call<WeatherData> getWeatherData(@Query("lat") String lat, @Query("lon") String lon);

}

