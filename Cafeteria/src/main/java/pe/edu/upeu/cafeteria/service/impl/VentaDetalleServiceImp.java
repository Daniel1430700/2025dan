package pe.edu.upeu.cafeteria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.cafeteria.model.VentaDetalle;
import pe.edu.upeu.cafeteria.repository.ICrudGenericoRepository;
import pe.edu.upeu.cafeteria.repository.VentaDetalleRepository;
import pe.edu.upeu.cafeteria.service.IVentaDetalleService;
@RequiredArgsConstructor
@Service
public class VentaDetalleServiceImp extends CrudGenericoServiceImp<VentaDetalle, Long>implements IVentaDetalleService {
    private final VentaDetalleRepository ventaDetalleRepository;
    @Override
    protected ICrudGenericoRepository<VentaDetalle, Long> getRepo() {
        return ventaDetalleRepository;
    }
}
