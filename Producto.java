public class Producto {

    //Presentamos la clase producto la cual cada una tiene tiene su nombre y precio

    private String nombre;
    private double precio;

    //Declaramos su nombre y precio
    public Producto(String nombre, double precio){
        this.nombre=nombre;
        this.precio=precio;
    }
    
    public String getNombre(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    //Muestr el nombre y precio del producto ya terminado en la terminal
    public void mostrarInformacion(){
        System.out.println(nombre + " - $" + precio);
    }
}
