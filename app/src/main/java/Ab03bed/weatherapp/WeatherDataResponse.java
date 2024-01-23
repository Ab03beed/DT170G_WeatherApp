package Ab03bed.weatherapp;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.JvmOverloads;

@Root(name = "product", strict = false)
public class WeatherDataResponse{

    @ElementList(inline = true, required = false)
    private List<WeatherData> data;


    public WeatherDataResponse(){
        this.data = new ArrayList<>();
    }

    public List<WeatherData> getData() {
        return data;
    }

    public void setData(List<WeatherData> data) {
        this.data = data;
    }
}
