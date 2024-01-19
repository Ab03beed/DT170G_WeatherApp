package Ab03bed.weatherapp.Network;

import Ab03bed.weatherapp.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetWeatherData {
    @GET("/weatherapi/locationforecast/2.0/classic?lat={lat}&lon={lon}&altitude={altitude}")
    Call<Weather> getWeatherData(@Path("lat") String lat, @Path("lon") String lon, @Path("altitude") String altitude);

}
