
public class DetallePedido {

    //Creamos las especificaciones de cada producto, esto incluyendo lo de un producto normal mas la cantidad de ello
    private Producto producto;
    private int cantidad;

    //Por esa razon utilizamos Producto producto, para asi ya no utilizar las variables nombre y precio que se
    //declararon anteriormente en Producto.java
    public DetallePedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    //Calculamos el total de cada producto
    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    //Enseñamos lo que se va a mostrar en la terminal
    public void mostrarDetalle() {
        System.out.println(producto.getNombre() + " x " + cantidad + " = $" + calcularSubtotal()
        );
    }
}
