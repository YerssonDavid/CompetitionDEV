import java.util.Scanner;

public class showMenu {

        static Scanner scanner = new Scanner(System.in);
// Se muestra el mensaje de bienvenida
        public static void welcome() {
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|==-")
                                + ConsoleColor.blueText("BIENVENIDO AL SISTEMA DE FACTURACION DEL SUPERMERCADO")
                                + ConsoleColor.cyanText("-==|"));
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
        };
// Se muestra el menú principal
        public static Integer principalMenu(Integer option) {
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|=========-")
                                + ConsoleColor.blueText("SISTEMA DE FACTURACIÓN DEL SUPERMERCADO")
                                + ConsoleColor.cyanText("-=========|"));
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("1. Agregar producto al carrito")
                                + ConsoleColor.cyanText("                            |"));
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("2. Ver productos en el carrito")
                                + ConsoleColor.cyanText("                            |"));
                System.out.println(
                                ConsoleColor.cyanText("|-") + ConsoleColor.blueText("3. Eliminar producto del carrito")
                                                + ConsoleColor.cyanText("                          |"));
                System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("4. Ver total a pagar")
                                + ConsoleColor.cyanText("                                      |"));
                System.out
                                .println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("5. Salir") + ConsoleColor
                                                .cyanText("                                                  |"));
                System.out.println(
                                ConsoleColor.cyanText("|===========================================================|"));
                System.out.print(ConsoleColor.orangeText("|- Seleccione una opcion: "));
                option = 0;
                return option;
        }
// Se muestra el menú de productos
        public static void serrMenu() {
                System.out.println(ConsoleColor.redText("""
                                |===========================================================|
                                |==========-Opción invalida, intentelo nuevamente.-=========|
                                |===========================================================|"""));
        }
// Se imprime la barra de carga
        public static void printLoadingBar() throws InterruptedException {
                int total = 53;
                for (int i = 0; i <= total; i++) {
                        // Calcula el porcentaje
                        int porcentaje = (i * 100) / total;
                        // Genera la barra de carga
                        StringBuilder barra = new StringBuilder("[");
                        for (int j = 0; j < total; j++) {
                                if (j < i) {
                                        barra.append("=");
                                } else {
                                        barra.append(" ");
                                }
                        }
                        barra.append("] ").append(porcentaje).append("%");
                        // Imprime la barra de carga
                        System.out.print("\r" + barra.toString());
                        // Simula un trabajo en progreso
                        Thread.sleep(50);
                }
                System.out.println(" ");
        }
// Se muestra el mensaje de despedida
        public static void goodbye() {
                System.out.println(ConsoleColor.cyanText("""
                                |===========================================================|
                                |          Muchas gracias por comprar con nosotros          |
                                |===========================================================|
                                |                                                           |
                                |-----------------------Produced by: -----------------------|
                                |--------Ingeniero Elkin Humberto Chaparro Franklin---------|
                                |--------Ingeniero Elkin Humberto Chaparro Franklin---------|
                                |--------Ingeniero Elkin Humberto Chaparro Franklin---------|
                                |                                                           |
                                |===========================================================|"""));
        }
// Se muestra el mensaje de error
        public static void pressAnyKeyToContinue() {
                System.out.print(ConsoleColor.orangeText("""
                                |===========================================================|
                                |==============-Presione Enter para Continuar-==============|
                                |===========================================================|"""));
                scanner.nextLine();
        }
}
