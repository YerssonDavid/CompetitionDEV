import java.util.List;
    public class Descuento {

        public static double descuentos(List<Double> precios) {
            int cantidadProductos = precios.size();
            double total = Subtotal.calcularSubtotal(precios);
            double descuento = 0, totalDescuento;

            if (cantidadProductos > 3 && cantidadProductos <= 5) {
                // 10% de descuento
                descuento = total * 0.10;
            } else if (cantidadProductos > 5 && cantidadProductos <= 10) {
                // 15% de descuento
                descuento = total * 0.15;
            } else if (cantidadProductos > 10) {
                // 20% de descuento
                descuento = total * 0.20;
            }
            totalDescuento = total - descuento;
            return totalDescuento;
        }
    }
