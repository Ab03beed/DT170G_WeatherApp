package Ab03bed.weatherapp;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.JvmOverloads;





import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "weatherdata", strict = false)
public class WeatherData {
    @Element(name = "meta")
    private Meta meta;


    @Element(name = "product")
    private Product product;



    // Getters...
    public Product getProduct() {
        return product;
    }
}

@Root(name = "meta", strict = false)
class Meta {
    @Element(name = "model")
    private Model model;

    // Getters...
}

@Root(name = "model", strict = false)
class Model {
    @Attribute(name = "name")
    private String name;

    @Attribute(name = "termin")
    private String termin;

    @Attribute(name = "runended")
    private String runended;

    @Attribute(name = "nextrun")
    private String nextrun;

    @Attribute(name = "from")
    private String from;

    @Attribute(name = "to")
    private String to;

    // Getters...
}

@Root(name = "product", strict = false)
class Product {
    @Attribute(name = "class")
    private String className;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    /*@Element(name = "time")
    private Time time;*/


    @ElementList(name = "time", inline = true)
    private List<Time> data;


    // Getters...
    public List<Time> getTimeList() {
        return data;
    }
}

@Root(name = "time", strict = false)
class Time {
    @Attribute(name = "datatype")
    private String datatype;

    @Attribute(name = "from")
    private String from;

    @Attribute(name = "to")
    private String to;

    @Element(name = "location")
    private Location location;

    // Getters...
}

@Root(name = "location", strict = false)
class Location {
    @Attribute(name = "altitude")
    private String altitude;

    @Attribute(name = "latitude")
    private String latitude;

    @Attribute(name = "longitude")
    private String longitude;

    @Element(name = "temperature")
    private Temperature temperature;

    @Element(name = "windDirection")
    private WindDirection windDirection;

    @Element(name = "windSpeed")
    private WindSpeed windSpeed;

    @Element(name = "cloudiness")
    private Cloudiness cloudiness;

    // Other elements...

    // Getters...
}

@Root(name = "temperature", strict = false)
class Temperature {
    @Attribute(name = "id")
    private String id;

    @Attribute(name = "unit")
    private String unit;

    @Attribute(name = "value")
    private String value;

    // Getters...
}

@Root(name = "windDirection", strict = false)
class WindDirection {
    @Attribute(name = "id")
    private String id;

    @Attribute(name = "deg")
    private String deg;

    @Attribute(name = "name")
    private String name;

    // Getters...
}

@Root(name = "windSpeed", strict = false)
class WindSpeed {
    @Attribute(name = "id")
    private String id;

    @Attribute(name = "mps")
    private String mps;

    @Attribute(name = "beaufort")
    private String beaufort;

    @Attribute(name = "name")
    private String name;

    // Getters...
}

@Root(name = "cloudiness", strict = false)
class Cloudiness {
    @Attribute(name = "id")
    private String id;

    @Attribute(name = "percent")
    private String percent;

    // Getters...
}

@Root(name = "precipitation", strict = false)
class Precipitation {
    @Attribute(name = "unit")
    private String unit;

    @Attribute(name = "value")
    private String value;

    @Attribute(name = "minvalue")
    private String minvalue;

    @Attribute(name = "maxvalue")
    private String maxvalue;

    // Getters...
}

@Root(name = "symbol", strict = false)
class Symbol {
    @Attribute(name = "id")
    private String id;

    @Attribute(name = "number")
    private String number;

    @Attribute(name = "code")
    private String code;

    // Getters...
}
