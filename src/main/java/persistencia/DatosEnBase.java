package persistencia;
import org.example.ejercicio2.Bebida;
import org.example.ejercicio2.Pedido;
import org.example.ejercicio2.Plato;
import org.example.ejercicio3.PersistirDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DatosEnBase implements PersistirDatos {
    private final static String conexion = "jdbc:mysql://localhost:3306/tp-2";
    private final static String usuario = "victor";
    private final static String clave = "nUojg8-u.uc8/a.1";


    @Override
    public void guardarRegistro(String data) {
        String insertarPedido = "INSERT INTO pedido (fecha,costo) VALUES (?,?)";
        try (Connection myConexion = DriverManager.getConnection(conexion, usuario, clave);
             PreparedStatement statementInsertar = myConexion.prepareStatement(insertarPedido)) {

            statementInsertar.setString(1, data);
            statementInsertar.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
