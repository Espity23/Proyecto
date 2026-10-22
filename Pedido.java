import java.util.ArrayList;

public class Pedido {

    //Agregamos la clase pedido y le asignamigos un numero y un arreglo en el cual vna a ver dato de DetallePedido.java
    private int numero;
    private ArrayList<DetallePedido> detalles;


    public Pedido(int numero) {
        this.numero = numero;
        this.detalles = new ArrayList<>();
    }

    //Agregamos le contenido que va tener nuestro arreglo
    public void agregarProducto(Producto producto, int cantidad){
        DetallePedido detalle = new DetallePedido(producto, cantidad);
        detalles.add(detalle);
    }


    //Calculamos el total de todos los productos que haya en el pedido.
    public double calcularTotal() {
        double total = 0;
    
        //utilizamos este for-each para recorrer el arreglo y que suma el valor de todos
        for (DetallePedido detalle : detalles){
            total += detalle.calcularSubtotal();
        }
        return total;
    }


    //Realizamos todos lo que va a aparecer en la terminal
    public void mostrarPedido() {
        System.out.println("Pedido #" + numero);
        System.out.println("-----Productos-----");

        //Realizamos un for-each para recorrer todo el arreglo y que imprima todos los productos dentro del pedido
        for (DetallePedido detalle: detalles){
            detalle.mostrarDetalle();
        }
        System.out.println("Total: $" + calcularTotal());
        System.out.println();
    }
}
