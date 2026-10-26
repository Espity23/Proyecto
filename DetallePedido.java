public class DetallePedido {

    // Definición de los atributos 
    private Producto producto;
    private int cantidad;
    
    // Método constructor
    public DetallePedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    // Getters
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }

    // Calcular subtotal para cada producto según cantidad
    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() { return cantidad + " x " + producto.getNombre(); }
}
