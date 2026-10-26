import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Restaurante {
    private final List<Producto> menu = new ArrayList<>();  // Crea un arreglo que contendrá cada producto del menú
    private Queue<Pedido> pedidosPendientes = new LinkedList<>(); // Cola con los pedidos creados: principio FIFO
    private Stack<Pedido> historialAgregados = new Stack<>();     // Pila para deshacer pedidos (si es necesario): principio LIFO
    private int numeroPedido = 1;

    // Productos a mostrar y su precio
    public Restaurante() {
        menu.add(new Producto("Hamburguesa", 15000));
        menu.add(new Producto("Pizza", 20000));
        menu.add(new Producto("Limonada", 5000));
        menu.add(new Producto("Malteada", 10000));
    }

    public List<Producto> getMenu() { return Collections.unmodifiableList(menu); }

    public int getSiguienteNumero() { return numeroPedido; }
    
    
    public void agregarPedido(Pedido pedido) {
        pedidosPendientes.offer(pedido);    // Agrega el pedido a la cola de espera
        historialAgregados.push(pedido);    // Almacena el pedido en la pila del historial
        numeroPedido++;     // El número del siguente pedido para la siguiente iteración
    }

    // Copia de la cola, en orden de atención
    public List<Pedido> getPedidosPendientes() { return new ArrayList<>(pedidosPendientes); }

    // peek: mira el siguiente sin sacarlo (null si no hay)
    public Pedido verSiguientePedido() { return pedidosPendientes.peek(); }

    // poll: saca el siguiente de la cola (null si no hay)
    public Pedido atenderSiguientePedido() { return pedidosPendientes.poll(); }

    // Muestra el ultimo pedido agregado a la pila
    public Pedido getUltimoAgregado() {
        return historialAgregados.empty() ? null : historialAgregados.peek();
    }

    // Solo se puede deshacer si el último agregado todavía no fue atendido
    public boolean puedeDeshacerUltimo() {
        Pedido ultimo = getUltimoAgregado();
        return ultimo != null && pedidosPendientes.contains(ultimo);
    }

    // Si el pedido no está en pendientes, se puede eliminar de la cola
    public boolean deshacerUltimoPedidoAgregado() {
        if (!puedeDeshacerUltimo()) return false;
        pedidosPendientes.remove(historialAgregados.pop());
        return true;
    }
}
