package cs2901.utec.edu.pe;
import java.util.List;
import java.util.Random;

public class WeatherData implements Subject {
    private static WeatherData instance = null;
    private List<Observer> obs;

    private WeatherData(){}

    public static WeatherData getInstance(){
        if(instance != null) return instance;
        synchronized(instance){
            if(instance == null)
                instance = new WeatherData();
            return instance;
        }

    }

    @Override
    public void registerObserver(Observer ob){
        obs.add(ob);
    }
    @Override 
    public void removeObserver(Observer ob){
        obs.remove(ob);
    }
    @Override 
    public void notifyObservers(){
        for(Observer o : obs){
            o.update();
        }
    }


    public double getTemperature(){
        return (Math.random() * 40) + 10;
    }
    public double getHumidity(){
        return (Math.random() * 100) + 1;
    }
    public double getPressure(){
        return (Math.random() * 20) + 1;
    }

    public void meassurementsChanged(){
        notifyObservers();
    }
}
