package punto1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class WeatherChannelService implements ClimaOnline {

    private static final String API_KEY = "api key";

    @Override
    public String temperatura() {

        try {

            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=Viedma,Argentina" + "&units=metric" + "&appid=" + API_KEY;

            URL url = new URL(urlString);

            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

            conexion.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

            StringBuilder respuesta = new StringBuilder();

            String linea;

            while ((linea = reader.readLine()) != null) {
                respuesta.append(linea);
            }

            reader.close();

            JSONObject json = new JSONObject(respuesta.toString());

            double temp = json.getJSONObject("main")
                    .getDouble("temp");

            System.out.println("OpenWeather devuelve: " + temp);

            return String.valueOf(temp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}