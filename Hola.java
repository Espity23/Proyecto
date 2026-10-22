
import java.util.Scanner;

public class Hola {
    public static void main(String[] args) {

        //Declaramos los difentes productos que van a ver
        Restaurante restaurante = new Restaurante();
        Producto hamburguesa = new Producto("Hamburguesa", 15000);
        Producto pizza = new Producto("Pizza", 20000);
        Producto malteada = new Producto("Malteada", 10000);
        Producto limonada = new Producto("limonada", 5000);

        //Declaramos el numero del primer pedido
        int numeroPedido = 1;

        //Ponemos la opcion de elegir un numero para llevar al usuario a un determinado proceso
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do { 
            //Mostramos la interfaz que el usuario va a ver
            System.out.println("\n----------------------");
            System.out.println("Bienvenido a FoodFlow");
            System.out.println("---------------------");
            System.out.println("1.Crear pedido");
            System.out.println("2.Ver pedidos pendientes");
            System.out.println("3.Eliminar ultimo pedido agregado");
            System.out.println("4.Atender el siguiente pedido");
            System.out.println("5.Salir");
            System.out.print("Selecciona una opcion: ");

            //Verificamos si lo escrito por el usuario es un numero
            if(sc.hasNextInt()){
                opcion = sc.nextInt();

                //Dependiendo el caso elegido nos lleva a un determinado proceso
                switch (opcion) {

                //Creacion de un pedido hecho por el usuarion
                case 1:
                    System.out.println("\n--- Crear pedido ---");

                    //Declaramos el nuevo pedido
                    Pedido nuevoPedido = new Pedido(numeroPedido);
                    //Como estandar ponemos continuar en S
                    String continuar = "S";

                    //Realizamos un bucle hasta que que continuar cambie
                    while(continuar.equalsIgnoreCase("S")){
                        System.out.println("1.Hamburguesa - $15000");
                        System.out.println("2.Pizza - $20000");
                        System.out.println("3.Limonada - $5000");
                        System.out.println("4.Malteada - $10000");
                        System.out.print("Selecciona un producto: ");

                        //Verificamos que sea un numero
                        if (!sc.hasNextInt()){
                            System.out.println("Debe escribir un numero");
                            sc.next();
                            continue;
                        }

                        int productoElegido = sc.nextInt();

                        //Verificamos el intervalo elegido
                        if (productoElegido <1 || productoElegido >4){
                            System.out.println("Seleccione un producto del 1 al 4");
                            continue;
                        }

                        System.out.println("Ingrese la cantidad del producto: ");  
                        int cantidad = sc.nextInt();

                        //Verificamos una cantidad logica
                        if(cantidad <= 0){
                            System.out.println("La cantidad debe ser mayor que 0");
                            continue;
                        }

                        //Correspondemos cada numero con su producto
                        if (productoElegido == 1){
                            nuevoPedido.agregarProducto(hamburguesa, cantidad);
                        }
                        if (productoElegido == 2){
                            nuevoPedido.agregarProducto(pizza, cantidad);
                        }
                        if (productoElegido == 3){
                            nuevoPedido.agregarProducto(limonada, cantidad);
                        }
                        if (productoElegido == 4){
                            nuevoPedido.agregarProducto(malteada, cantidad);
                        }

                        System.out.println("¿Desea agregar otro producto? (S/N): ");
                        continuar = sc.next();
                    }
                    //Añadimos el pedido realizado a la lista y añadimos +1 para el siguiente pedido
                    restaurante.agregarPedido(nuevoPedido);
                    numeroPedido++;
                    break;

                    //Verificamos los pedidos pendidientes desde Restaurante.java
                case 2:
                    restaurante.verPedidosPendientes(); 
                    break;

                    //Eliminamos el ultimo pedido en la pila desde Restaurante.java
                case 3:
                    restaurante.deshacerUltimoPedidoAgregado(sc);
                    break;

                    //Mostramos el ultimo pedido en la cola y lo quitamos
                case 4:
                    restaurante.atenderSiguientePedido();
                    break;

                    //Cerramos el programa y damos por concluido tood
                case 5:
                    System.out.println("Gracias por usar Foodflow");
                    break;

                    //Verficamos que el valor dado este dentro del rango de las opciones
                default:
                    System.out.println("Entrada no valida. Escriba un numero del 1 al 5");
                }

                //Verficamos que el valor dado este dentro del rango de las opciones
            }else{
                System.out.println("Entrada no valida. Escriba un numero del 1 al 5"); 
                sc.next();
                opcion = 0;
            }
        //Cierre del bucle
        }while(opcion != 5);
        //Cierre del programa
        sc.close();

    }
}