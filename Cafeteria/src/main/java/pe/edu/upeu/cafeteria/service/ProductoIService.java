package pe.edu.upeu.cafeteria.service;

import pe.edu.upeu.cafeteria.dto.ModeloDataAutocomplet;
import pe.edu.upeu.cafeteria.model.Producto;

import java.util.List;

public interface ProductoIService {
    Producto save(Producto producto);
    List<Producto> findAll();
    Producto update(Producto producto);
    void delete(Long id);
    Producto findById(Long id);
    List<ModeloDataAutocomplet> listAutoCompletProducto(String nombre);
    public List<ModeloDataAutocomplet> listAutoCompletProducto();
}
