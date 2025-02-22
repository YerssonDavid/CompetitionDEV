
import java.util.*;

public class produtos {

    public static String[] productos = { "Leche", "Panela", "Chocolate", "Arroz", "Huevos", "Caramelos", "Frutas",
            "Legumbres" };
    public static Integer[] precios = { 3400, 2400, 12000, 6000, 18000, 3500, 8000, 5000 };

    static List<String> productoSeleccionado = new ArrayList<>();
    static List<Integer> precioSeleccionado = new ArrayList<>();
    static List<Integer> cantidadSeleccionada = new ArrayList<>();
    static List<Integer> total = new ArrayList<>();

    public static void agregarAlCarrito(Scanner scanner) {
        boolean exit = false;
        while (!exit) {

        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|====================-") + ConsoleColor.blueText("AGREGAR PRODUCTO")
                + ConsoleColor.cyanText("-=====================|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Seleccione un producto")
                + ConsoleColor.cyanText("                                   -|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        for (int i = 0; i < productos.length; i++) {
            System.out.println(ConsoleColor.cyanText("|-")
                    + ConsoleColor.blueText(" " + (i + 1) + ". " + productos[i] + " - $" + precios[i]));
        }
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.print(ConsoleColor.orangeText("|- Seleccione un producto: "));
        int option = 0;
        try {
            option = Integer.parseInt(scanner.nextLine());
            if (option < 1 || option > productos.length) {
                throw new NullPointerException();
            }
            productoSeleccionado.add(productos[option - 1]);
            precioSeleccionado.add(precios[option - 1]);

            System.out.print(ConsoleColor.orangeText("|- Seleccione la cantidad del producto:"));
            int cantidad = 0;

            try {
                cantidad = scanner.nextInt();
                if (cantidad < 1) {
                    throw new NullPointerException();
                }
                cantidadSeleccionada.add(cantidad);
                total.add(precios[option - 1] * cantidad);
                System.out.println(
                        ConsoleColor.cyanText("|===========================================================|"));
            } catch (NumberFormatException e) {
                showMenu.serrMenu();
            }
            System.out.println(ConsoleColor.greenText("|===========================================================|"));
            System.out.println(ConsoleColor.greenText("|- Producto agregado correctamente                          |"));
            System.out.println(ConsoleColor.greenText("|===========================================================|"));
            System.out.println(ConsoleColor.cyanText("|===========================================================|"));
            System.out
                    .println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("1. Agregar otro producto al carrito")
                            + ConsoleColor.cyanText("                       |"));
            System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("2. pasar a facturacion")
                    + ConsoleColor.cyanText("                                    |"));
            System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("3. Voler al menu principal"));
            System.out.println(ConsoleColor.cyanText("|===========================================================|"));
            System.out.print(ConsoleColor.orangeText("|- Seleccione una opcion: "));
            try {
                int option2 = scanner.nextInt();
                scanner.nextLine();
                if (option2 == 1) {
                    agregarAlCarrito(scanner);
                    scanner.nextLine();
                } else if (option2 == 2) {
                    productosEnCarrito(scanner);
                    scanner.nextLine();
                } else if (option2 == 3) {
                    showMenu.printLoadingBar();
                    exit = true;
                }
            } catch (Exception e) {
                showMenu.serrMenu();
            }
        } catch (NumberFormatException e) {
            System.out.println(ConsoleColor.redText("|===========================================================|"));
            System.out.println(ConsoleColor.redText("|- Debe seleccionar un número                               |"));
            System.out.println(ConsoleColor.redText("|===========================================================|"));
        } catch (NullPointerException e) {
            System.out.println(ConsoleColor.redText("|===========================================================|"));
            System.out.println(ConsoleColor.redText("|- Debe seleccionar una opción válida                       |"));
            System.out.println(ConsoleColor.redText("|===========================================================|"));
        }}
    }

    public static void productosEnCarrito(Scanner scanner) throws InterruptedException {
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|================-")
                + ConsoleColor.blueText("PRODUCTOS EN EL CARRITO") + ConsoleColor.cyanText("-==================|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        if (productoSeleccionado.size() == 0) {
            System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText(" No hay productos en el carrito")
                    + ConsoleColor.cyanText("                           -|"));
        } else {
            for (int i = 0; i < productoSeleccionado.size(); i++) {
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText(
                        " " + (i + 1) + ". " + productoSeleccionado.get(i) + " - Unit $"
                                + precioSeleccionado.get(i))
                        + ConsoleColor.cyanText(
                                " - Cantidad: " + cantidadSeleccionada.get(i) + " - Total: $" + total.get(i)));
            }
        }
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.orangeText("|- 1. Pasar a pagar "));
        System.out.println(ConsoleColor.orangeText("|- 2. agregar otro producto al carrito "));
        System.out.println(ConsoleColor.orangeText("|- 3. volver al menu principal "));
        System.out.print(ConsoleColor.orangeText("|- Seleccione una opcion: "));
        var option = scanner.nextInt();
        if (option == 1) {
            totalCompra();
        } else if (option == 2) {
            agregarAlCarrito(scanner);
            scanner.nextLine();
        } else if (option == 3) {
            showMenu.printLoadingBar();
        }

        scanner.nextLine();
    }

    public static void eliminarProducto(Scanner scanner) {
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|===================-") + ConsoleColor.blueText("ELIMINAR PRODUCTO")
                + ConsoleColor.cyanText("-=====================|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        for (int i = 0; i < productoSeleccionado.size(); i++) {
            System.out.println(
                    ConsoleColor.cyanText("|") + ConsoleColor.blueText((i + 1) + ". " + productoSeleccionado.get(i)));
        }

        System.out.println(ConsoleColor.orangeText("|-Escoja el producto a eliminar:"));
        var opcion = scanner.nextLine();
        try {
            int indice = Integer.parseInt(opcion) - 1;
            if (indice >= 0 && indice < productoSeleccionado.size()) {
                String productoEliminado = productoSeleccionado.get(indice);
                productoSeleccionado.remove(indice);
                precioSeleccionado.remove(indice);
                System.out.println(
                        ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-"
                        + ConsoleColor
                                .blueText("El producto: '" + productoEliminado + "' ha sido eliminado del carrito")
                        + ConsoleColor.cyanText("          |")));
            } else {
                System.out
                        .println(ConsoleColor.redText("|===========================================================|"));
                System.out.println(ConsoleColor.redText("|-Opción inválida, inténtelo nuevamente."));
                System.out
                        .println(ConsoleColor.redText("|===========================================================|"));
            }
        } catch (NumberFormatException e) {
            System.out.println(ConsoleColor.redText("|===========================================================|"));
            System.out.println(ConsoleColor.redText("|-ERROR: Ingresa solo un valor numérico                     |"));
            System.out.println(ConsoleColor.redText("|===========================================================|"));
        } catch (NullPointerException e) {
            System.out.println(ConsoleColor.redText("|===========================================================|"));
            System.out.println(ConsoleColor.redText("|-ERROR: Ingresa solo un valor numérico                     |"));
            System.out.println(ConsoleColor.redText("|===========================================================|"));
        }
    }

    public static void verCarrito() {
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|====================-") + ConsoleColor.blueText("CARRITO DE COMPRAS")
                + ConsoleColor.cyanText("-=====================|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        for (int i = 0; i < productoSeleccionado.size(); i++) {
            System.out.println((i + 1) + ". " + productoSeleccionado.get(i) + " - $" + precioSeleccionado.get(i));
        }
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
    }

    public static void totalCompra() {
        int total = 0;
        for (double precio : precioSeleccionado) {
            total += precio;
        }
        // Imprimir el ticket de compra
        System.out.println("Tikete de compra");
        System.out.println("-----------------");
        for (int i = 0; i < productoSeleccionado.size(); i++) {
            System.out.printf("%s: $%d%n", productoSeleccionado.get(i), precioSeleccionado.get(i));
        }
        System.out.println("-----------------");
        System.out.printf("Total: $%d%n", total);
    }
}
