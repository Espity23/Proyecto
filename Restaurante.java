import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
//Antes que nada añadimos las librerias que vamos a utilizar en la mayor parte del restaurante
//LinkedList para los Array
//Queue implementa lo necesario para el desarollo de la cola
//Scanner paraque pueda leer lo que el usuario escriba
//Stack implementa lo necesario para el desarollo de la pila
public class Restaurante {

    //Declaramos las variables para la cola y la pila
    private Queue<Pedido> pedidosPendientes;
    private Stack<Pedido> historialAgregados;

    public Restaurante() {

        //Designamos las variables
        pedidosPendientes = new LinkedList<>();
        historialAgregados = new Stack<>();
    }

    //Añadimos el contenido de las variables
    public void agregarPedido(Pedido pedido) {
        pedidosPendientes.offer(pedido);
        historialAgregados.push(pedido);

        System.out.println("Pedido agregado a la cola.");
    }


    //Uilizamos .peek() para mirar el ultimo elemento agregado sin sacarlo
    public void verSiguientePedido() {
        Pedido pedido = pedidosPendientes.peek();

        //Dependendiendo del contenido del pedido se realizan ciertas acciones
        if (pedido == null) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            System.out.println("Siguiente pedido pendiente:");
            pedido.mostrarPedido();
        }
    }

    //Mostramos todos los pedidos que tenemos en la lista
    public void verPedidosPendientes(){
        if(pedidosPendientes.isEmpty()){
            System.out.println("No hay pedidos pendientes");
            return;
        }
        System.out.println("\n---Pedidos pendientes ---");

        for(Pedido pedido : pedidosPendientes){
            pedido.mostrarPedido();
        }
        System.out.println("----------------");
    }

    //Uilizamos .poll() para atrapar el ultimo pedido y a su vez eliminarlo
    public void atenderSiguientePedido() {
        Pedido pedido = pedidosPendientes.poll();

        //Dependiendo de lo conseguido por .poll realizamos las acciones
        if (pedido == null) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            System.out.println("Atendiendo el siguiente pedido:");
            pedido.mostrarPedido();
        }

    }
    
    //Creamos el metodo para quitar el ultimo pedido agregado
    public void deshacerUltimoPedidoAgregado(Scanner sc) {

        //Verificamos si la lista esta vacia
        if (historialAgregados.empty()) {
            System.out.println("No hay pedidos en el historial.");
            return;
        }


        //Mostramos el ultimo pedido agregado sin quitarlo
        Pedido ultimo = historialAgregados.peek();
        System.out.println("\n ---- Ultimo pedido agregado:");
        ultimo.mostrarPedido();

        //Verificamos el contenido de la lista
        if(!pedidosPendientes.contains(ultimo)){
            System.out.println("Este pedido ya fue atendido, por ende no se puede eliminar.");
            return;
        }

        //Confirmamos la autorizacion
        System.out.println("Seguro que desea eliminar el este pedido? (S/N)");
        String respuesta = sc.next();

        //Realizamos la operacion correspondiente de lo escrito anterior
        if(respuesta.equalsIgnoreCase("S")){
            pedidosPendientes.remove(ultimo);
            historialAgregados.pop();
            System.out.println("Pedido eliminado correctamente.");
        }else{
            System.err.println("Se cancelo la operacion.");
        }
    }
}