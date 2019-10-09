package cs2901.utec.edu.pe;
import java.util.List;

public class ForecastDisplay implements Observer, DisplayElement {
    private List<Double> humidities;
    private List<Double> pressures;
    private List<Double> temps;
    private WeatherData wd;

    public ForecastDisplay(){
        wd = WeatherData.getInstance();
    }

    @Override
    public void update() {
        double new_humid = wd.getHumidity();
        double new_pres = wd.getPressure();
        double new_temp = wd.getTemperature();

        temps.add(new_temp);
        humidities.add(new_humid);
        pressures.add(new_pres);
    }

    @Override
    public void display(){
        System.out.println("Predicted Humidity: " + String.valueOf(humidities.get(humidities.size() -1)));
        System.out.println("Predicted Temperature: " + String.valueOf(temps.get(temps.size() -1)));
        System.out.println("Predicted Pressure: " + String.valueOf(pressures.get(pressures.size() -1)));
    }
}
