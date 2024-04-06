package persistencia;

import org.example.ejercicio2.Pedido;
import org.example.ejercicio3.PersistirDatos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class DatosEnDisco implements PersistirDatos {

    public  DatosEnDisco(){
    }


    @Override
    public void guardarRegistro(String registro) {
        try {

            Files.write(Paths.get("C:\\Users\\victo\\OneDrive\\Documents\\UNIVERSIDAD\\2024\\OBJETOS2\\archivo-ejercicio2.txt"), registro.getBytes(),

                    StandardOpenOption.APPEND);

        } catch (IOException e) {

            throw new RuntimeException("No se pudo persistir...", e);

        }
    }


}
