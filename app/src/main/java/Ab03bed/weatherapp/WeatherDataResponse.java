package Ab03bed.weatherapp;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "product", strict = false)
public class WeatherDataResponse {

    @ElementList(inline = true, required = false)
    private List<WeatherData> data = new ArrayList<>();

    public List<WeatherData> getData() {
        return data;
    }

    public void setData(List<WeatherData> data) {
        this.data = data;
    }
}

@Root(name = "cloudiness")
class Cloudiness {
    public void setPercent(float percent) {
        this.percent = percent;
    }

    @Attribute(name = "percent")
    public float percent;

    public float getPercent() {
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
    public void setName(String name) {
        this.name = name;
    }

    @Attribute(name = "name")
    public String name;

    public String getName() {
        return name;
    }

    // Getter method...
}

@Root(name = "windSpeed")
class WindSpeed {
    public void setName(String name) {
        this.name = name;
    }

    @Attribute(name = "name")
    public String name;

    public String getName() {
        return name;
    }
// Getter method...
}