package punto1;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ArchivoObserver implements Observer {

    @Override
    public void actualizar(String temperatura) {

        try (FileWriter writer =
                     new FileWriter("temperaturas.txt", true)) {

            writer.write(
                    LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                            + " - "
                            + temperatura
                            + "\n");




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}