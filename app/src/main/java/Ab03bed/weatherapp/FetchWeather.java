package Ab03bed.weatherapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FetchWeather {
    //Abbe: i have atucly to.
    //Abbe: I have no heart in me.
    //Abbe: Not my matter.
    //@GET("/weatherapi/locationforecast/2.0/classic?")
    //Call<Weather> getWeatherData(@Query("lat") String lat, @Query("lon") String lon);

    //@GET("/weatherapi/locationforecast/2.0/classic")
    //Call<List<WeatherData>> getWeatherData(@Query("lat") String lat, @Query("lon") String lon);

    @GET("/weatherapi/locationforecast/2.0/classic?")
    Call<WeatherData> getWeatherData(@Query("lat") String lat, @Query("lon") String lon);

}

