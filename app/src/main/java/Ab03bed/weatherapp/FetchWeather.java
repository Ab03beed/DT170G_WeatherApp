package Ab03bed.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FetchWeather {
    @GET("/weatherapi/locationforecast/2.0/compact?")
    Call<WeatherData> getWeatherData(@Query("lat") String lat, @Query("lon") String lon);

}

