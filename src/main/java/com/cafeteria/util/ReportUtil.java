package com.cafeteria.util;

import com.cafeteria.util.DBUtil;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class ReportUtil {

    public static File exportSalesPDF(LocalDate date, String outPath) throws Exception {
        // Simple PDF with Apache PDFBox, listing ventas for the given date
        File out = new File(outPath);
        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.LETTER);
            doc.addPage(page);
            PDPageContentStream cs = new PDPageContentStream(doc, page);
            cs.beginText();
            cs.setFont(PDType1Font.HELVETICA_BOLD, 14);
            cs.newLineAtOffset(50, 700);
            cs.showText("Reporte de Ventas - " + date.toString());
            cs.newLineAtOffset(0, -20);
            cs.setFont(PDType1Font.HELVETICA, 12);

            try (Connection c = DBUtil.getConnection()) {
                PreparedStatement ps = c.prepareStatement("SELECT * FROM ventas WHERE date(fecha) = ?");
                ps.setString(1, date.toString());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String line = "ID:" + rs.getInt("id") + " - Cliente:" + rs.getString("cliente") + " - Total:" + rs.getDouble("total");
                    cs.showText(line);
                    cs.newLineAtOffset(0, -15);
                }
            }

            cs.endText();
            cs.close();
            doc.save(out);
        }
        return out;
    }

}
