package pe.edu.upeu.cafeteria.service;


import pe.edu.upeu.cafeteria.model.VentCarrito;

import java.util.List;

public interface    IVentCarritoService extends  ICrudGenericoService<VentCarrito,Long>{
    List<VentCarrito> listaCarritoCliente(String dni);
    void deleteCarAll(String dniruc);


}
