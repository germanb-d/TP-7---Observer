package punto1;


import java.util.ArrayList;
import java.util.List;

public class Medidor {

    private String temperatura;
    private ClimaOnline clima;

    private List<Observer> observers;

    public Medidor(ClimaOnline clima) {
        this.clima = clima;
        this.observers = new ArrayList<>();
    }

    public void agregarObserver(Observer observer) {
        observers.add(observer);
    }

    public void eliminarObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notificarObservers() {
        for (Observer observer : observers) {
            observer.actualizar(temperatura);
        }
    }

    public String leerTemperatura() {

        this.temperatura = clima.temperatura();

        notificarObservers();

        return temperatura;
    }
}