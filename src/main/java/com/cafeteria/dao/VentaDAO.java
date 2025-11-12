package com.cafeteria.dao;

import com.cafeteria.model.Venta;
import com.cafeteria.model.DetalleVenta;
import com.cafeteria.util.DBUtil;

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class VentaDAO {
    public static int saveVenta(Venta v) throws SQLException {
        try (Connection c = DBUtil.getConnection()) {
            c.setAutoCommit(false);
            PreparedStatement ps = c.prepareStatement(
                "INSERT INTO ventas(cliente,fecha,vendedor,total,impreso,impresora) VALUES(?,?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, v.getCliente());
            ps.setString(2, v.getFecha().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            ps.setString(3, v.getVendedor());
            ps.setDouble(4, v.getTotal());
            ps.setInt(5, v.isImpreso() ? 1 : 0);
            ps.setString(6, v.getImpresora());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            int ventaId = -1;
            if (keys.next()) ventaId = keys.getInt(1);

            PreparedStatement psDet = c.prepareStatement(
                "INSERT INTO detalle_ventas(venta_id,product_id,cantidad,precio_unit,subtotal) VALUES(?,?,?,?,?)");
            for (DetalleVenta d : v.getDetalles()) {
                psDet.setInt(1, ventaId);
                psDet.setInt(2, d.getProductId());
                psDet.setInt(3, d.getCantidad());
                psDet.setDouble(4, d.getPrecioUnit());
                psDet.setDouble(5, d.getSubtotal());
                psDet.executeUpdate();

                // update stock
                PreparedStatement psUpd = c.prepareStatement("UPDATE products SET stock = stock - ? WHERE id = ?");
                psUpd.setInt(1, d.getCantidad());
                psUpd.setInt(2, d.getProductId());
                psUpd.executeUpdate();
            }
            c.commit();
            return ventaId;
        }
    }
}
