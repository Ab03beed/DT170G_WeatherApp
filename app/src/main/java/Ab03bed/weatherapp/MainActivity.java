package Ab03bed.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import Ab03bed.weatherapp.Network.GetWeatherData;
import Ab03bed.weatherapp.Network.User;
import okhttp3.OkHttpClient;
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

        /*
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        GetWeatherData service = retrofit.create(GetWeatherData.class);
        Call<User> callSync = service.getUser("Ab03beed");

        callSync.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    Log.d("gg", user.id);
                } else {
                    Log.d("gg", "Request failed");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("gg", "Request failed", t);
            }
        });*/

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WS_HOST).addConverterFactory(GsonConverterFactory.create())
                .build();

        GetWeatherData service = retrofit.create(GetWeatherData.class);
        //https://api.met.no/weatherapi/locationforecast/2.0/classic?lat=59.93&lon=10.72&altitude=90    XML
        //https://api.met.no/weatherapi/locationforecast/2.0/complete?lat=60.10&lon=10                  JSON
        Call<Weather> callSync = service.getWeatherData(60.10, 10.0);
        callSync.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if (response.isSuccessful()) {
                    Weather w = response.body();
                    /*Log.d("gg-air_temperature", w.air_temperature);
                    Log.d("gg-cloud_area_fraction", w.cloud_area_fraction);
                    Log.d("gg-probability_of_precipitation", w.probability_of_precipitation);
                    Log.d("gg-wind_speed", w.wind_speed);*/
                    System.out.println("gg-air_temperature " + w.air_temperature);
                    System.out.println("gg-cloud_area_fraction" + w.cloud_area_fraction);
                    System.out.println("gg-probability_of_precipitation" + w.probability_of_precipitation);
                    System.out.println("gg-wind_speed" + w.wind_speed);

                } else {
                    Log.d("gg", "Request failed");
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.d("gg", "Request failed", t);
            }
        });



    }
}