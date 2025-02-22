
import java.util.*;

public class produtos {
// Se crean los productos y sus precios
    public static String[] productos = { "Leche", "Panela", "Chocolate", "Arroz", "Huevos", "Caramelos", "Frutas",
            "Legumbres" };
    public static Integer[] precios = { 3400, 2400, 12000, 6000, 18000, 3500, 8000, 5000 };
// Se crean las listas para almacenar los productos seleccionados
    static List<String> productoSeleccionado = new ArrayList<>();
    static List<Integer> precioSeleccionado = new ArrayList<>();
    static List<Integer> cantidadSeleccionada = new ArrayList<>();
    static List<Integer> totalcantSeleccionado = new ArrayList<>();
    static List<Integer> total = new ArrayList<>();
// Método para agregar productos al carrito
    public static void agregarAlCarrito(Scanner scanner) throws InterruptedException {
        boolean exit = false;
        while (!exit) {

            System.out.println(ConsoleColor.cyanText("|===========================================================|"));
            System.out
                    .println(ConsoleColor.cyanText("|====================-") + ConsoleColor.blueText("AGREGAR PRODUCTO")
                            + ConsoleColor.cyanText("-=====================|"));
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
                totalcantSeleccionado.add(0);
                var operator = totalcantSeleccionado.get(0);
                try {
                    cantidad = scanner.nextInt();
                    if (cantidad < 1) {
                        throw new NullPointerException();
                    }
                    cantidadSeleccionada.add(cantidad);
                    var resultado = operator + cantidad;
                    totalcantSeleccionado.clear();
                    totalcantSeleccionado.add(resultado);
                    total.add(precios[option - 1] * cantidad);
                    System.out.println(
                            ConsoleColor.cyanText("|===========================================================|"));
                } catch (NumberFormatException e) {
                    showMenu.serrMenu();
                }
                System.out.println(
                        ConsoleColor.greenText("|===========================================================|"));
                System.out.println(
                        ConsoleColor.greenText("|- Producto agregado correctamente                          |"));
                System.out.println(
                        ConsoleColor.greenText("|===========================================================|"));
                System.out.println(
                        ConsoleColor.cyanText("|===========================================================|"));
                System.out
                        .println(ConsoleColor.cyanText("|-")
                                + ConsoleColor.blueText("1. Agregar otro producto al carrito")
                                + ConsoleColor.cyanText("                       |"));
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("2. pasar a facturacion")
                        + ConsoleColor.cyanText("                                    |"));
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("3. Voler al menu principal")
                        + ConsoleColor.cyanText("                                |"));
                System.out.println(
                        ConsoleColor.cyanText("|===========================================================|"));
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
                        showMenu.pressAnyKeyToContinue();
                        executable.showMenu();
                        exit = true;
                    }
                } catch (Exception e) {
                    showMenu.serrMenu();
                }
            } catch (NumberFormatException e) {
                System.out
                        .println(ConsoleColor.redText("|===========================================================|"));
                System.out
                        .println(ConsoleColor.redText("|- Debe seleccionar un número                               |"));
                System.out
                        .println(ConsoleColor.redText("|===========================================================|"));
            } catch (NullPointerException e) {
                System.out
                        .println(ConsoleColor.redText("|===========================================================|"));
                System.out
                        .println(ConsoleColor.redText("|- Debe seleccionar una opción válida                       |"));
                System.out
                        .println(ConsoleColor.redText("|===========================================================|"));
            }
        }
    }
// Método para ver los productos en el carrito
    public static void productosEnCarrito(Scanner scanner) throws InterruptedException {
        boolean exit = false;
        while (!exit) {
            System.out.println(ConsoleColor.cyanText("|===========================================================|"));
            System.out.println(ConsoleColor.cyanText("|================-")
                    + ConsoleColor.blueText("PRODUCTOS EN EL CARRITO") + ConsoleColor.cyanText("-==================|"));
            System.out.println(ConsoleColor.cyanText("|===========================================================|"));
            if (productoSeleccionado.size() <= 0) {
                System.out
                        .println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText(" No hay productos en el carrito")
                                + ConsoleColor.cyanText("                          -|"));
                break;
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
            System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("1. Pasar a pagar")
                    + ConsoleColor.cyanText("                                          |"));
            System.out
                    .println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("2. Agregar otro producto del carrito")
                            + ConsoleColor.cyanText("                      |"));
            System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("3. Volver al menu principal")
                    + ConsoleColor.cyanText("                               |"));
                    System.out.println(ConsoleColor.cyanText("|===========================================================|"));
            System.out.print(ConsoleColor.orangeText("|- Seleccione una opcion: "));
            var option03 = scanner.nextInt();
            scanner.nextLine();
            try {
                if (option03 == 1) {
                    totalCompra();
                    scanner.nextLine();
                } else if (option03 == 2) {
                    agregarAlCarrito(scanner);
                    scanner.nextLine();
                } else {
                    showMenu.printLoadingBar();
                    showMenu.pressAnyKeyToContinue();
                    executable.showMenu();
                    exit = true;
                }
            } catch (Exception e) {
                showMenu.serrMenu();
            }
        }
    }
// Método para eliminar productos del carrito
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
                                .blueText("El producto: '" + productoEliminado + "' ha sido eliminado del carrito")));
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
// Método para mostrar el total de la compra
    public static void totalCompra() throws InterruptedException {
        int totales = 0;
        for (Integer precio : total) {
            totales += precio;
        }
        var disTotal = descuentos(totalcantSeleccionado, total);
        var valTotal = totales - (int) disTotal;
        showMenu.printLoadingBar();
        // Imprimir el ticket de compra
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out
                .println(ConsoleColor.cyanText("|====================-") + ConsoleColor.blueText("TICKET DE COMPRA")
                        + ConsoleColor.cyanText("-=====================|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("-10% de descuento por la compra de 4 a 5 productos")
                + ConsoleColor.cyanText("        |"));
        System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("-15% de descuento por la compra de 6 a 10 productos")+ ConsoleColor.cyanText("       |"));
        System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("-20% de descuento por la compra de mas de 10 productos")+ ConsoleColor.cyanText("    |"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        for (int i = 0; i < productoSeleccionado.size(); i++) {
            System.out.printf("|-%s: Val U= $%d |Cant %d Val T=$%d %n", productoSeleccionado.get(i),
                    precioSeleccionado.get(i), cantidadSeleccionada.get(i), total.get(i));
        }
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|=")
                + ConsoleColor.blueText("Total de productos: " + totalcantSeleccionado.get(0)));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Total de la compra: $" + totales));
        System.out.println(
                ConsoleColor.cyanText("|-"+ConsoleColor.blueText("Subtotal con descuentos: $" + descuentos(totalcantSeleccionado, total))));
        System.out.println(ConsoleColor.cyanText("|-")+ConsoleColor.blueText("Total:") + valTotal);
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("Gracias por su compra")
                + ConsoleColor.cyanText("                                     |"));
        System.out.println(ConsoleColor.cyanText("|===========================================================|"));
        showMenu.goodbye();
        showMenu.pressAnyKeyToContinue();
        executable.main(null);

    }
// Método para calcular los descuentos
    public static double descuentos(List<Integer> totalcantSeleccionado, List<Integer> total) {
        int cantidadProductos = totalcantSeleccionado.get(0);
        int totales = (int) calcularSubtotal(total);
        double descuento;

        if (cantidadProductos >= 4 && cantidadProductos <= 5) {
            // 10% de descuento
            descuento = totales * 0.10;
            return descuento; // Retorna el descuento aplicado
        } else if (cantidadProductos > 5 && cantidadProductos <= 10) {
            // 15% de descuento
            descuento = totales * 0.15;
            return descuento; // Retorna el descuento aplicado
        } else if (cantidadProductos > 10) {
            // 20% de descuento
            descuento = totales * 0.20;
            return descuento; // Retorna el descuento aplicado
        }
        // En caso de no aplicar ningún descuento
        return totales;
    }
// Método para calcular el subtotal
    public static double calcularSubtotal(List<Integer> total) {
        int subTotal = 0;
        for (double precio : total) {
            subTotal += precio;
        }
        return subTotal;
    }

}
