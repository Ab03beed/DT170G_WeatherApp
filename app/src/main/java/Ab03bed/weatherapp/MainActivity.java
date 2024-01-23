package Ab03bed.weatherapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    //precipitation_amount_max		mm	maximum likely precipitation for period
    //precipitation_amount_min	    mm	minimum likely precipitation for period

    //wind_from_direction	        degrees	direction the wind is coming from (0° is north, 90° east, etc.)
    //wind_speed		            m/s	wind speed at 10m above the ground (10 min average)
    //air_temperature		        celsius	air temperature at 2m above the ground
    //cloud_area_fraction		    %	total cloud cover for all heights

    private final String WS_HOST = "https://api.met.no/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WS_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FetchWeather fetchWeather = retrofit.create(FetchWeather.class);


        Call<WeatherData> call = fetchWeather.getWeatherData("60.10","9.58");

        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if (response.isSuccessful()) {
                    WeatherData weatherData = response.body();

                    if (weatherData != null) {
                        Log.d("GG", "GGGGGGGs");
                        List<Timeseries> timeList = weatherData.getProperties().getTimeseries();
                        for(int i=0; i<timeList.size(); i++){
                            System.out.println("Time: " + timeList.get(i).time + " | Data: "
                                    + timeList.get(i).data.instant.getDetails().air_pressure_at_sea_level + " "
                                    + timeList.get(i).data.instant.getDetails().air_temperature + " "
                                    + timeList.get(i).data.instant.getDetails().cloud_area_fraction + " "
                                    + timeList.get(i).data.instant.getDetails().wind_from_direction + " "
                                    + timeList.get(i).data.instant.getDetails().wind_speed);
                        }

                    }
                } else {
                    // Handle error
                    Log.d("GG", "Error msg: " + response.message());
                    Log.d("GG", "Error bdy: " + response.errorBody());
                    Log.d("GG", "Error code: " + response.code());
                    Log.d("GG", "Error toStr: " + response.toString());
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                // Handle failure
                Log.d("GG",  "Network request failed: " + t.getMessage());
            }
        });


    }
}