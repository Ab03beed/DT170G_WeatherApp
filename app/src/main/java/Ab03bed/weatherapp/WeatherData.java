package Ab03bed.weatherapp;

import java.util.List;

public class WeatherData {
    public Properties properties;

    public Properties getProperties() {
        return properties;
    }
}



class Properties {

    public List<Timeseries> timeseries;

    public List<Timeseries> getTimeseries() {
        return timeseries;
    }
}

class Timeseries {
    public String time;
    public TimeseriesData data;
}


class TimeseriesData {
    public InstantData instant;
    public Next1Hour next_1_hours;
    public InstantData getInstant() {
        return instant;
    }

    public Next1Hour getNext_1_hours() {
        return next_1_hours;
    }
}

class InstantData {
    public Details details;

    public Details getDetails() {
        return details;
    }
}

class Details {
    public double air_pressure_at_sea_level;
    public double air_temperature;
    public double cloud_area_fraction;
    public double wind_from_direction;
    public double wind_speed;

    public double getAir_pressure_at_sea_level() {
        return air_pressure_at_sea_level;
    }

    public double getAir_temperature() {
        return air_temperature;
    }

    public double getCloud_area_fraction() {
        return cloud_area_fraction;
    }

    public double getWind_from_direction() {
        return wind_from_direction;
    }

    public double getWind_speed() {
        return wind_speed;
    }


}



class Next1Hour {
    public Summary summary;
    public Details details;
}


class Summary {
    public String symbol_code;
}
