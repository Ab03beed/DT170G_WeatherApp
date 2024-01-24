package Ab03bed.weatherapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class WeatherData {
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }
}


class Properties {
    private List<TimeSeries> timeseries;

    public List<TimeSeries> getTimeseries() {
        return timeseries;
    }
}

class TimeSeries {
    private String time;
    private TimeSeriesData data;

    public TimeSeriesData getData() {
        return data;
    }

    public String getTime() {
        return time;
    }
}


class TimeSeriesData {
    private InstantData instant;
    private Next1Hour next_1_hours;
    public InstantData getInstant() {
        return instant;
    }

    public Next1Hour getNext_1_hours() {
        return next_1_hours;
    }
}

class InstantData {
    private Details details;

    public Details getDetails() {
        return details;
    }
}

class Details {
    private double air_temperature;
    private double wind_speed;
    private double wind_from_direction;
    private double cloud_area_fraction;

    public double getAir_temperature() {
        return air_temperature;
    }
    public double getWind_speed() { return wind_speed; }
    public double getWind_from_direction() { return wind_from_direction; }
    public double getCloud_area_fraction() { return cloud_area_fraction; }


}

class Next1Hour {
    private Summary summary;
    private Precipitation precipitation;

    public Summary getSummary() { return summary; }

    public Precipitation getPrecipitation() { return precipitation; }
}

class Summary {
    private String symbol_code;
    public String getSymbol_code() { return symbol_code; }
}
class Precipitation {
    private double precipitation_amount;
    public double getPrecipitation_amount() { return precipitation_amount; }
}



interface FetchWeather {
    @GET("/weatherapi/locationforecast/2.0/compact?")
    Call<WeatherData> getWeatherData(@Query("lat") String lat, @Query("lon") String lon);
}
