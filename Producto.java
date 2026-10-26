import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Producto {

    // Formato de moneda 
    private static final DecimalFormat FORMATO =
        new DecimalFormat("$#,##0", DecimalFormatSymbols.getInstance(Locale.forLanguageTag("es-CO")));

    // Atributos para cada producto
    final private String nombre;
    final private double precio;

    // Método constructor
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    // Convertir el valor del precio a string
    public static String moneda(double valor) { return FORMATO.format(valor); }

    // Lo usa el JComboBox para mostrar cada producto
    @Override
    public String toString() { return nombre + " - " + moneda(precio); }
}
