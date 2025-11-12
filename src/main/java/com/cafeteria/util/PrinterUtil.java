
package com.cafeteria.util;

import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class PrinterUtil {

    public static String buildReceipt(String title, String product, int qty, double price, double total, String client) {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append("\n");
        sb.append("-------------------------------\n");
        sb.append("Producto: ").append(product).append("\n");
        sb.append("Cantidad: ").append(qty).append("\n");
        sb.append(String.format("Precio: S/ %.2f\n", price));
        sb.append("-------------------------------\n");
        sb.append(String.format("Total: S/ %.2f\n", total));
        sb.append("Cliente: ").append(client).append("\n");
        sb.append("-------------------------------\n");
        sb.append("Gracias por su compra!\n");
        return sb.toString();
    }

    // Try to print directly to default printer (no dialog).
    public static boolean printString(String text) {
        try {
            // find default print service
            PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            if (service == null) return false;
            DocPrintJob job = service.createPrintJob();
            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            Doc doc = new SimpleDoc(bytes, flavor, null);
            PrintRequestAttributeSet attrs = new HashPrintRequestAttributeSet();
            attrs.add(new Copies(1));
            job.print(doc, attrs);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
