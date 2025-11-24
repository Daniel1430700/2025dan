package pe.edu.upeu.cafeteria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.cafeteria.model.Marca;
import pe.edu.upeu.cafeteria.model.Proveedor;
import pe.edu.upeu.cafeteria.repository.ICrudGenericoRepository;
import pe.edu.upeu.cafeteria.repository.ProveedorRepository;
import pe.edu.upeu.cafeteria.service.IProveedorService;
@RequiredArgsConstructor
@Service
public class ProveedorServiceImp extends CrudGenericoServiceImp<Proveedor, Long> implements IProveedorService {
    private final ProveedorRepository proveedorRepository;
    @Override
    protected ICrudGenericoRepository<Proveedor, Long> getRepo() {
        return proveedorRepository;
    }
}
