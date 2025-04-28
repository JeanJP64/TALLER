import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppStore appStore = new AppStore();

        // Agregar juegos iniciales
        appStore.agregarJuego(new Juego("FIFA 23", "Deporte", 59.99, 12));
        appStore.agregarJuego(new Juego("Need for Speed", "Velocidad", 49.99, 20));
        appStore.agregarJuego(new Juego("Assassin's Creed", "Aventura", 69.99, 8));
        appStore.agregarJuego(new Juego("Call of Duty", "Accion", 79.99, 18));

        int opcion;
        do {
            System.out.println("\n--- Menú AppStore ---");
            System.out.println("1. Ver juegos");
            System.out.println("2. Comprar licencias");
            System.out.println("3. Vender licencias");
            System.out.println("4. Juego más vendido");
            System.out.println("5. Consultar descuentos");
            System.out.println("6. Consultar compras por porcentaje");
            System.out.println("7. Consultar compras por categoría");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println(appStore.mostrarTodosLosJuegos());
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del juego: ");
                    String nombreCompra = sc.nextLine();
                    System.out.print("Ingrese la cantidad de licencias a comprar: ");
                    int cantidadCompra = sc.nextInt();
                    if (appStore.comprarLicencias(nombreCompra, cantidadCompra)) {
                        System.out.println("Compra realizada.");
                    } else {
                        System.out.println("Juego no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del juego: ");
                    String nombreVenta = sc.nextLine();
                    if (appStore.venderLicencia(nombreVenta)) {
                        System.out.println("Venta realizada.");
                    } else {
                        System.out.println("No se pudo realizar la venta.");
                    }
                    break;
                case 4:
                    System.out.println("Juego más vendido: " + appStore.juegoMasVendido());
                    break;
                case 5:
                    System.out.print("Ingrese la cantidad de licencias: ");
                    int cantidadDescuento = sc.nextInt();
                    System.out.println("Descuento: " + appStore.consultarDescuento(cantidadDescuento));
                    break;
                case 6:
                    System.out.println(appStore.metodo1());
                    break;
                case 7:
                    System.out.println("Juegos que deberían comprarse por categoría: " + appStore.metodo2());
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
}
