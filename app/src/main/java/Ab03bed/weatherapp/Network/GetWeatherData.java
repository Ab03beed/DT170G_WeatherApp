package Ab03bed.weatherapp.Network;

import java.util.List;

import Ab03bed.weatherapp.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetWeatherData {
    @GET("/weatherapi/locationforecast/2.0/complete?lat={lat}&lon={lon}")
    Call<Weather> getWeatherData(@Query("lat") double lat, @Query("lon") double lon);

    //@GET("/users/{username}")
    //public Call<User> getUser(@Path("username") String username);
}
