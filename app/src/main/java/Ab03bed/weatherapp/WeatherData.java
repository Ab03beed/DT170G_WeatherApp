package Ab03bed.weatherapp;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import kotlin.jvm.JvmOverloads;

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

    public WeatherData(Temperature temperature, WindDirection windDirection, WindSpeed windSpeed, Cloudiness cloudiness, Precipitation precipitation){
        this.temperature = temperature;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.cloudiness = cloudiness;
        this.precipitation = precipitation;
    }


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


@Root(name = "cloudiness")
class Cloudiness {
    @Attribute(name = "percent")
    public String percent;

    public Cloudiness(String percent){
        this.percent = percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
    public String getPercent() {
        return percent;
    }
// Getter method...
}


@Root(name = "precipitation", strict = false)
class Precipitation {
    @Attribute(name = "unit")
    private String unit;

    @Attribute(name = "value")
    private String value;

    @Attribute(name = "minvalue")
    private String minValue;

    @Attribute(name = "maxvalue")
    private String maxValue;

    public Precipitation(String unit, String value, String minValue, String maxValue){
        this.unit = unit;
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }


    public String getUnit() {
        return unit;
    }

    public String getValue() {
        return value;
    }

    public String getMinValue() {
        return minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }
}

@Root(name = "temperature")
class Temperature {

    @Attribute(name = "value")
    public float value;


    Temperature(float value){
        this.value = value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    // Getter method...
}

@Root(name = "windDirection")
class WindDirection {
    @Attribute(name = "name")
    public String name;

    public WindDirection(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    // Getter method...
}

@Root(name = "windSpeed")
class WindSpeed {
    @Attribute(name = "name")
    public String name;

    public WindSpeed(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
// Getter method...
}

