package Ab03bed.weatherapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FetchWeather {

    //@GET("/weatherapi/locationforecast/2.0/classic?")
    //Call<Weather> getWeatherData(@Query("lat") String lat, @Query("lon") String lon);

    //@GET("/weatherapi/locationforecast/2.0/classic")
    //Call<List<WeatherData>> getWeatherData(@Query("lat") String lat, @Query("lon") String lon);

    @GET("/weatherapi/locationforecast/2.0/classic?")
    Call<WeatherDataResponse> getWeatherData(@Query("lat") String lat, @Query("lon") String lon);

}

