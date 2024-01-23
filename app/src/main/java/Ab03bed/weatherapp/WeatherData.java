package Ab03bed.weatherapp;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "location")
public class WeatherData {
    @Element(name = "temperature")
    private Temperature temperature;

    @Element(name = "windDirection")
    private WindDirection windDirection;

    @Element(name = "windSpeed")
    private WindSpeed windSpeed;

    @Element(name = "cloudiness")
    private Cloudiness cloudiness;

    @Element(name = "precipitation", required = false)
    private Precipitation precipitation;

    // Other fields and methods...

    public Temperature getTemperature() {
        return temperature;
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public WindSpeed getWindSpeed() {
        return windSpeed;
    }

    public Cloudiness getCloudiness() {
        return cloudiness;
    }

    public Precipitation getPrecipitation() {
        return precipitation;
    }
}


