package pe.edu.upeu.cafeteria.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.cafeteria.model.Compra;
import pe.edu.upeu.cafeteria.repository.CompraRepository;
import pe.edu.upeu.cafeteria.repository.ICrudGenericoRepository;
import pe.edu.upeu.cafeteria.service.ICompraService;

@RequiredArgsConstructor
@Service
public class CompraServiceImp extends CrudGenericoServiceImp<Compra,Long> implements ICompraService {

private final CompraRepository compraRepository;


    @Override
    protected ICrudGenericoRepository<Compra, Long> getRepo() {
        return compraRepository;
    }
}
