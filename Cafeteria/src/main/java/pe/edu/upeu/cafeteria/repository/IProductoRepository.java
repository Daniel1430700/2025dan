package pe.edu.upeu.cafeteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upeu.cafeteria.model.Producto;

import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
    // Aquí puedes agregar métodos personalizados si necesitas realizarconsultas específicas
    @Query(value = "SELECT p.* FROM upeu_producto p WHERE p.nombre like:filter", nativeQuery = true)
    List<Producto> listAutoCompletProducto(@Param("filter") String filter);

    @Query(value = "SELECT p.* FROM upeu_producto p WHERE -p.id_marca=:filter", nativeQuery = true)
    List<Producto> listProductoMarca(@Param("filter") Integer filter);
    @Query("SELECT p FROM Producto p WHERE  p.marca.idMarca= :filter")
    List<Producto> listProductoMarcaJ(@Param("filter") Integer filter);
}
