package cs2901.utec.edu.pe;
import java.util.List;

public class CurrentConditions implements Observer, DisplayElement {

    private WeatherData wd;
    double current_humidity;
    double current_pressure;
    double current_temp;


    public CurrentConditions(){
        wd = WeatherData.getInstance();
        current_humidity = wd.getHumidity();
        current_pressure = wd.getPressure();
        current_temp = wd.getTemperature();
    }
    @Override
    public void update() {
        current_humidity = wd.getHumidity();
        current_humidity = wd.getPressure();
        current_temp = wd.getTemperature();
    }

    @Override
    public void display(){
        System.out.println("Temperature: " + String.valueOf(current_temp));
        System.out.println("Pressure " + String.valueOf(current_pressure));
        System.out.println("Humidity: " + String.valueOf(current_humidity));
    }
}
