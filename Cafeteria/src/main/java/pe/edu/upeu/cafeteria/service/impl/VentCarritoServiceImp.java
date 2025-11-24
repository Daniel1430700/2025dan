package pe.edu.upeu.cafeteria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.cafeteria.model.VentCarrito;
import pe.edu.upeu.cafeteria.repository.ICrudGenericoRepository;
import pe.edu.upeu.cafeteria.repository.VentCarritoRepository;
import pe.edu.upeu.cafeteria.service.IVentCarritoService;


import java.util.List;

@RequiredArgsConstructor
@Service
public class VentCarritoServiceImp extends CrudGenericoServiceImp<VentCarrito, Long> implements IVentCarritoService {

    private final VentCarritoRepository carritoRepository;

    @Override
    protected ICrudGenericoRepository<VentCarrito, Long> getRepo() {
        return carritoRepository;
    }

    @Override
    public List<VentCarrito> listaCarritoCliente(String dni) {
        return carritoRepository.listaCarritoCliente(dni);
    }
    @Transactional
    @Override
    public void deleteCarAll(String dniruc) {
        carritoRepository.deleteByDniruc(dniruc);
    }
}
