package Ab03bed.weatherapp;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "product", strict = true)
public class WeatherDataResponse{

    /*@ElementList(inline = true, required = true)
    private List<WeatherData> data;


    public WeatherDataResponse(){
        this.data = new ArrayList<>();
    }

    public List<WeatherData> getData() {
        return data;
    }

    public void setData(List<WeatherData> data) {
        this.data = data;
    }*/
}