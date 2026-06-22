package punto1;


public class ConsolaObserver implements Observer {

    @Override
    public void actualizar(String temperatura) {

        System.out.println("Temperatura recibida: " + temperatura);

        double temp = Double.parseDouble(temperatura);

        if (temp < 12) {
            System.out.println("Hace frio, se encenderá la caldera");
        }

        if (temp > 17) {
            System.out.println("Hace calor, se encenderá el aire acondicionado");
        }
    }
}