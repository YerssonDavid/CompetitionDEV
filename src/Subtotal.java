import java.util.List;

public class Subtotal {

    public static double calcularSubtotal(List<Double> precios){
        double subTotal = 0;
        for (double precio : precios){
            subTotal += precio;
        }
        return subTotal;
    }
}
