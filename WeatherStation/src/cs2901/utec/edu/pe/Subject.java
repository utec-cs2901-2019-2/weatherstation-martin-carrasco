package cs2901.utec.edu.pe;

public interface Subject {
    void registerObserver(Observer ob);
    void removeObserver(Observer ob);
    void notifyObservers();
}
