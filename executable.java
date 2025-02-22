import java.util.Scanner;

public class executable {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        boolean exit = false;
        showMenu.welcome();
        while (!exit) {

            var option = showMenu.principalMenu(null);

            try {
                option = Integer.parseInt(scanner.nextLine());
                // switch para seleccionar el tipo de emergencia
                switch (option) {
                    case 1:
                        // Seleccionar producto
                        produtos.agregarAlCarrito(scanner);
                        break;
                    case 2:
                        // Ver productos en el carrito
                        produtos.productosEnCarrito(scanner);
                        break;
                    case 3:
                        produtos.eliminarProducto(scanner);
                        break;
                    case 4:
                        produtos.totalCompra();
                        break;
                    case 5:
                        // Salir
                        showMenu.goodbye();
                        exit = true;
                        break;
                    default:
                        throw new NullPointerException();
                }
            } // Se captura la excepción en caso de que la opción no sea un número
            catch (NumberFormatException e) {
                showMenu.serrMenu();
            } // Se captura la excepción en caso de que la opción sea nula
            catch (NullPointerException e) {
                showMenu.serrMenu();
            }
        }
    }
}
