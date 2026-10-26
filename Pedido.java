import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {
    // Declaración de atributos 
    private int numero;
    private ArrayList<DetallePedido> detalles;

    // Constructor
    public Pedido(int numero) {
        this.numero = numero;
        this.detalles = new ArrayList<>(); // Arreglo vacío
    }

    // Getters 
    public int getNumero() { return numero; }
    
    public List<DetallePedido> getDetalles() {
        return Collections.unmodifiableList(detalles);
    }

    // Agrega un producto al final del arreglo
    public void agregarProducto(Producto producto, int cantidad) {
        detalles.add(new DetallePedido(producto, cantidad));
    }

    // Borra el ultimo elemento del arreglo
    public void quitarDetalle(int indice) {
        detalles.remove(indice);
    }

    // Calcula el total del pedido sumando subtotales de cada producto
    public double calcularTotal() {
        double total = 0;
        for (DetallePedido detalle : detalles) {
            total += detalle.calcularSubtotal();
        }
        return total;
    }

    // Ej: "2 x Hamburguesa, 1 x Pizza"     
    public String resumen() {
        StringBuilder sb = new StringBuilder();
        for (DetallePedido d : detalles) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(d);
        }
        return sb.toString();
    }
}
