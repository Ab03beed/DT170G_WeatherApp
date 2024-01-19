package Ab03bed.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import Ab03bed.weatherapp.Network.GetWeatherData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private final String WS_HOST = "https://api.met.no";

    TextView text = (TextView) findViewById(R.id.t1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WS_HOST)
                .build();

        GetWeatherData fetch = retrofit.create(GetWeatherData.class);
        //https://api.met.no/weatherapi/locationforecast/2.0/classic?lat=59.93&lon=10.72&altitude=90
        fetch.getWeatherData("59.93", "10.72", "90").enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                text.setText("response.body().getTemp()");
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                text.setText("t.getMessage()");
            }
        });*/

    }
}