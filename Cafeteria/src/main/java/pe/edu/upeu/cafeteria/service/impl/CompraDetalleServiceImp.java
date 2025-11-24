package pe.edu.upeu.cafeteria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.cafeteria.model.CompraDetalle;
import pe.edu.upeu.cafeteria.repository.CompraDetalleRepository;
import pe.edu.upeu.cafeteria.repository.ICrudGenericoRepository;
import pe.edu.upeu.cafeteria.service.ICompraDetalleService;

@RequiredArgsConstructor
@Service
public class CompraDetalleServiceImp extends CrudGenericoServiceImp<CompraDetalle, Long>implements ICompraDetalleService {
    private final CompraDetalleRepository CompraDetalleRepository;

    @Override
    protected ICrudGenericoRepository<CompraDetalle, Long> getRepo() {
        return CompraDetalleRepository;
    }
}