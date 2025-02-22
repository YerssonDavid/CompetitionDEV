
import java.util.*;

public class produtos {

    public static String[] productos = { "Leche", "Panela", "Chocolate", "Arroz", "Huevos", "Caramelos", "Frutas","Legumbres" };
    public static Integer[] precios = { 3400, 2400, 12000, 6000, 18000, 3500, 8000, 5000};

    static List<String> productoSeleccionado = new ArrayList<>();
    static List<Integer> precioSeleccionado = new ArrayList<>();

    public static  void agregarAlCarrito(Scanner scanner) {
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|====================-") + ConsoleColor.blueText("AGREGAR PRODUCTO") + ConsoleColor.cyanText("-=====================|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Seleccione un producto") + ConsoleColor.cyanText("                                   -|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        for (int i = 0; i < productos.length; i++) {
            System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText(" " + (i + 1) + ". " + productos[i] + " - $" + precios[i]));
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
            System.out.println(ConsoleColor.greenText("|===========================================================|"));
            System.out.println(ConsoleColor.greenText("|- Producto agregado correctamente                          |"));
            System.out.println(ConsoleColor.greenText("|===========================================================|"));
        } catch (NumberFormatException e) {
            System.out.println(ConsoleColor.redText("|===========================================================|"));
            System.out.println(ConsoleColor.redText("|- Debe seleccionar un número                               |"));
            System.out.println(ConsoleColor.redText("|===========================================================|"));

        } catch (NullPointerException e) {
            System.out.println(ConsoleColor.redText("|===========================================================|"));
            System.out.println(ConsoleColor.redText("|- Debe seleccionar una opción válida                       |"));
            System.out.println(ConsoleColor.redText("|===========================================================|"));

        }
    }

    public static void productosEnCarrito(Scanner scanner) {
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|================-") + ConsoleColor.blueText("PRODUCTOS EN EL CARRITO") + ConsoleColor.cyanText("-==================|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        if (productoSeleccionado.size() == 0) {
            System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText(" No hay productos en el carrito") + ConsoleColor.cyanText("                           -|"));
        } else {
            for (int i = 0; i < productoSeleccionado.size(); i++) {
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText(" " + (i + 1) + ". " + productoSeleccionado.get(i) + " - $" + precioSeleccionado.get(i)));
            }
        }
        System.out.println(ConsoleColor.orangeText("|===========================================================|"));
        System.out.println(ConsoleColor.orangeText("|- 1. Pasar a pagar "));
        System.out.println(ConsoleColor.orangeText("|- 2. agregar otro producto al carrito "));
        scanner.nextLine();
    }
}
