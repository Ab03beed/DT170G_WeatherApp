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


@Root(name = "temperature")
class Temperature {
    @Attribute(name = "value")
    public float value;

    public float getValue() {
        return value;
    }

    // Getter method...
}

@Root(name = "windDirection")
class WindDirection {
    @Attribute(name = "name")
    public String name;

    public String getName() {
        return name;
    }

    // Getter method...
}

@Root(name = "windSpeed")
class WindSpeed {
    @Attribute(name = "name")
    public String name;

    public String getName() {
        return name;
    }
// Getter method...
}

@Root(name = "cloudiness")
class Cloudiness {
    @Attribute(name = "percent")
    public float percent;

    public float getPercent() {
        return percent;
    }
// Getter method...
}

@Root(name = "precipitation")
class Precipitation {
    @Attribute(name = "value")
    public float value;

    public float getValue() {
        return value;
    }
// Getter method...
}
