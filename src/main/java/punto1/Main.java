package punto1;

public class Main {

    public static void main(String[] args) {

        ClimaOnline clima =
                new WeatherChannelService();

        Medidor medidor =
                new Medidor(clima);

        medidor.agregarObserver(
                new ArchivoObserver());

        medidor.agregarObserver(
                new ConsolaObserver());

        medidor.leerTemperatura();
        medidor.leerTemperatura();
        medidor.leerTemperatura();
    }
}