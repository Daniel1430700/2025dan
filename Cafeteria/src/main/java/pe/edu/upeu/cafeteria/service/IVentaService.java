package pe.edu.upeu.cafeteria.service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.File;
import java.sql.SQLException;

public interface IVentaService {
    File getFile(String filex);
    JasperPrint runReport(Long idv) throws JRException, SQLException;
}
