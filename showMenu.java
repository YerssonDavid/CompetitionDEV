public class showMenu {

    public static void welcome() {
        System.out.println(
                ConsoleColor.cyanText("|===========================================================|"));
        System.out.println(ConsoleColor.cyanText("|==-")
                + ConsoleColor.blueText("BIENVENIDO AL SISTEMA DE FACTURACION DEL SUPERMERCADO")
                + ConsoleColor.cyanText("-==|"));
        System.out.println(
                ConsoleColor.cyanText("|===========================================================|"));
    };

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
        System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("3. Eliminar producto del carrito")
                + ConsoleColor.cyanText("                          |"));
        System.out.println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("4. Ver total a pagar")
                + ConsoleColor.cyanText("                                      |"));
        System.out
                .println(ConsoleColor.cyanText("|-") + ConsoleColor.blueText("5. Salir") + ConsoleColor.cyanText("                                                  |"));
        System.out.println(
                ConsoleColor.cyanText("|===========================================================|"));
        System.out.print(ConsoleColor.orangeText("|- Seleccione una opcion: "));
        option = 0;
        return option;
    }

    public static void serrMenu() {
        System.out.println(ConsoleColor.redText("""
                |===========================================================|
                |==========-Opción invalida, intentelo nuevamente.-=========|
                |===========================================================|"""));
    }
}
