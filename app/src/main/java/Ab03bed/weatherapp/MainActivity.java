package Ab03bed.weatherapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //precipitation_amount_max		mm	maximum likely precipitation for period
    //precipitation_amount_min	    mm	minimum likely precipitation for period

    //wind_from_direction	        degrees	direction the wind is coming from (0° is north, 90° east, etc.)
    //wind_speed		            m/s	wind speed at 10m above the ground (10 min average)

    //air_temperature		        celsius	air temperature at 2m above the ground

    //cloud_area_fraction		    %	total cloud cover for all heights

    private final String WS_HOST = "https://api.met.no/";
    //private final String WS_HOST2 = "https://api.met.no/weatherapi/locationforecast/2.0/classic?lat=60.10&lon=9.58";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WS_HOST)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        FetchWeather fetchWeather = retrofit.create(FetchWeather.class);

        Call<List<WeatherData>> call = fetchWeather.getWeatherData("60.10","9.58");

        call.enqueue(new Callback<List<WeatherData>>() {
            @Override
            public void onResponse(Call<List<WeatherData>> call, Response<List<WeatherData>> response) {
                if (response.isSuccessful()) {
                    List<WeatherData> weatherDataList = response.body();
                    if (weatherDataList != null && !weatherDataList.isEmpty()) {
                        WeatherData firstWeatherData = weatherDataList.get(0);
                        Temperature temperature = firstWeatherData.getTemperature();
                        WindDirection windDirection = firstWeatherData.getWindDirection();
                        WindSpeed windSpeed = firstWeatherData.getWindSpeed();
                        Cloudiness cloudiness = firstWeatherData.getCloudiness();
                        Precipitation precipitation = firstWeatherData.getPrecipitation();

                        // Handle the extracted data
                        System.out.println("Temperature: " + temperature.getValue());
                        System.out.println("Wind Direction: " + windDirection.getName());
                        System.out.println("Wind Speed: " + windSpeed.getName());
                        System.out.println("Cloudiness: " + cloudiness.getPercent());
                        if (precipitation != null) {
                            System.out.println("Precipitation: " + precipitation.getValue());
                        }
                    }
                } else {
                    // Handle error
                    System.out.println("Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<WeatherData>> call, Throwable t) {
                // Handle failure
                System.out.println("Network request failed: " + t.getMessage());
            }
        });
    }
}