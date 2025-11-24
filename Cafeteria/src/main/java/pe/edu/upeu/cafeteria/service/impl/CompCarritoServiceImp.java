package pe.edu.upeu.cafeteria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.cafeteria.model.CompCarrito;
import pe.edu.upeu.cafeteria.repository.CompCarritoRepository;
import pe.edu.upeu.cafeteria.repository.ICrudGenericoRepository;
import pe.edu.upeu.cafeteria.service.ICompCarritoService;

@RequiredArgsConstructor
@Service
public class CompCarritoServiceImp extends CrudGenericoServiceImp<CompCarrito,Long> implements ICompCarritoService {

private final CompCarritoRepository compCarritoRepository;

    @Override
    protected ICrudGenericoRepository<CompCarrito, Long> getRepo() {
        return compCarritoRepository;
    }
}
