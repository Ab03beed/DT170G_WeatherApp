package Ab03bed.weatherapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.logging.HttpLoggingInterceptor;

public class MainActivity extends AppCompatActivity {
    //precipitation_amount_max		mm	maximum likely precipitation for period
    //precipitation_amount_min	    mm	minimum likely precipitation for period

    //wind_from_direction	        degrees	direction the wind is coming from (0° is north, 90° east, etc.)
    //wind_speed		            m/s	wind speed at 10m above the ground (10 min average)

    //air_temperature		        celsius	air temperature at 2m above the ground

    //cloud_area_fraction		    %	total cloud cover for all heights

    private final String WS_HOST = "https://api.met.no/";
    //private final String WS_HOST2 = "https://api.met.no/weatherapi/locationforecast/2.0/classic?lat=60.10&lon=9.58";

    private static final String USER_AGENT = "weather app";

    public List<WeatherData> weatherDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Create OkHttpClient with the logging interceptor
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .header("User-Agent", USER_AGENT)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .addInterceptor(loggingInterceptor)  // Add the logging interceptor here
                .build();


        /*OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .header("User-Agent", USER_AGENT)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();*/


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WS_HOST)
                .client(okHttpClient)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        FetchWeather fetchWeather = retrofit.create(FetchWeather.class);


        Call<WeatherDataResponse> call = fetchWeather.getWeatherData("60.10","9.58");

        call.enqueue(new Callback<WeatherDataResponse>() {
            @Override
            public void onResponse(Call<WeatherDataResponse> call, Response<WeatherDataResponse> response) {
                if (response.isSuccessful()) {
                    WeatherDataResponse weatherDataResponse = response.body();
                    if (weatherDataResponse != null) {
                        weatherDataList = weatherDataResponse.getData();
                        Log.d("GG", "GGGGGGGs");


                        /*for(int i=0; i<weatherDataList.size(); i++){
                            System.out.println(weatherDataList.get(i).);
                        }
*/
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
            public void onFailure(Call<WeatherDataResponse> call, Throwable t) {
                // Handle failure
                Log.d("GG",  "Network request failed: " + t.getMessage());
            }
        });


    }
}