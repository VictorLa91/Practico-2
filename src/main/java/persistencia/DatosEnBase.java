package persistencia;
import org.example.ejercicio2.Bebida;
import org.example.ejercicio2.Pedido;
import org.example.ejercicio2.Plato;
import org.example.ejercicio3.PersistirDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatosEnBase implements PersistirDatos {
    private final static String conexion = "jdbc:mysql://localhost:3306/restaurant";
    private final static String usuario= "victor";
    private final static String clave = "nUojg8-u.uc8/a.1";


    @Override
    public void guardarPedido(Pedido unPedido) {
        var listadoPlatos = new ArrayList<Plato>(); listadoPlatos= unPedido.getListadoPlatos();
        var listadoBebidas = new ArrayList<Bebida>(); listadoBebidas=unPedido.getListadoBebidas();
        String insertarPedido = "INSERT INTO pedido (id,costo) VALUES (?,?)";
        String insertarPlato= "INSERT INTO pedido_plato (id_pedido,id_plato) VALUES (?,?)";
        String insertarBebida= "INSERT INTO pedido_bebida (id_pedido,id_bebida) VALUES (?,?)";
        try (Connection myConexion = DriverManager.getConnection(conexion,usuario,clave);
             PreparedStatement statementInsertar = myConexion.prepareStatement(insertarPedido);
             PreparedStatement statementTablaIntermedia = myConexion.prepareStatement(insertarPlato);
             PreparedStatement statementTablaIntermedia2 = myConexion.prepareStatement(insertarBebida))

        {
            statementInsertar.setInt(1, unPedido.getId());
            statementInsertar.setInt(2, unPedido.cuantoSaleTodo());
            statementInsertar.executeUpdate();
            for (Plato plato : listadoPlatos)
            {
                statementTablaIntermedia.setInt(1,unPedido.getId());
                statementTablaIntermedia.setInt(2, plato.id());
                statementTablaIntermedia.executeUpdate();
            }
            for (Bebida bebida : listadoBebidas)
            {
                statementTablaIntermedia2.setInt(1,unPedido.getId());
                statementTablaIntermedia2.setInt(2, bebida.id());
                statementTablaIntermedia2.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void guardarPlato(Plato unPlato) {

        String insertarPedido = "INSERT INTO platos (id,costo) VALUES (?,?)";
        try (Connection myConexion = DriverManager.getConnection(conexion,usuario,clave);
             PreparedStatement statementInsertar = myConexion.prepareStatement(insertarPedido))

        {
            statementInsertar.setInt(1, unPlato.id());
            statementInsertar.setDouble(2, unPlato.precio());
            statementInsertar.executeUpdate();
            for (Plato plato : listadoPlatos)
            {
                statementTablaIntermedia.setInt(1,unPedido.getId());
                statementTablaIntermedia.setInt(2, plato.id());
                statementTablaIntermedia.executeUpdate();
            }
            for (Bebida bebida : listadoBebidas)
            {
                statementTablaIntermedia2.setInt(1,unPedido.getId());
                statementTablaIntermedia2.setInt(2, bebida.id());
                statementTablaIntermedia2.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
