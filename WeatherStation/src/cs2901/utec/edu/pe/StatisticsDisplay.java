package cs2901.utec.edu.pe;
import java.util.List;

public class StatisticsDisplay implements Observer,DisplayElement {

    private WeatherData wd;
    private List<Double> humidities;
    private List<Double> pressures;
    private List<Double> temps;
    
    private double max_humid;
    private double max_pressure;
    private double max_temp;

    private double min_humid;
    private double min_pressure;
    private double min_temp;


    public StatisticsDisplay(){

        wd = WeatherData.getInstance();

        double hum = wd.getHumidity();
        max_humid = min_humid = hum;
        humidities.add(hum);
        
        double tmp = wd.getTemperature();
        max_temp = min_temp = tmp;
        temps.add(tmp);

        double pre = wd.getPressure();
        max_pressure = min_pressure = pre;
        pressures.add(pre);
    }

    private double getAvg(int d){
        double avg = 0;
        switch(d){
            case MedType.PRESSURE:
                for(double v : pressures){
                    avg += v;
                }
                return avg / pressures.size();
            case MedType.TEMP:
                for(double v : temps){
                    avg += v;
                }
                return avg / temps.size();
            case MedType.HUMID:
                for(double v : temps){
                    avg += v;
                }
                return avg / humidities.size();
            default:
                return 0;
        }
    }

    @Override
    public void update() {
        double new_humid = wd.getHumidity();
        double new_pres = wd.getPressure();
        double new_temp = wd.getTemperature();

        temps.add(new_temp);
        humidities.add(new_humid);
        pressures.add(new_pres);

        max_pressure = new_pres > max_pressure ? new_pres : max_pressure;
        min_pressure = new_pres < max_pressure ? new_pres : min_pressure;

        max_temp = new_temp > max_temp ? new_temp : max_temp;
        min_temp = new_temp < min_temp ? new_temp : min_temp;

        max_humid = new_humid > max_humid ? new_humid : max_humid;
        min_humid = new_humid < min_humid ? new_humid : min_humid; 

    }

    @Override
    public void display(){
        System.out.println("Humidity: ");
        System.out.println("Max: " + String.valueOf(max_humid));
        System.out.println("Min " + String.valueOf(min_humid));
        System.out.println("Avg: " + String.valueOf(getAvg(MedType.HUMID)));

        System.out.println("Temperature: ");
        System.out.println("Max: " + String.valueOf(max_temp));
        System.out.println("Min " + String.valueOf(min_temp));
        System.out.println("Avg: " + String.valueOf(getAvg(MedType.TEMP)));

        System.out.println("Pressure: ");
        System.out.println("Max: " + String.valueOf(max_pressure));
        System.out.println("Min " + String.valueOf(min_pressure));
        System.out.println("Avg: " + String.valueOf(getAvg(MedType.PRESSURE)));

    }
}
