package pe.edu.upeu.cafeteria.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.cafeteria.model.Emisor;
import pe.edu.upeu.cafeteria.repository.EmisorRepository;
import pe.edu.upeu.cafeteria.repository.ICrudGenericoRepository;
import pe.edu.upeu.cafeteria.service.IEmisorService;
@RequiredArgsConstructor
@Service
public class EmisorServiceImp extends CrudGenericoServiceImp<Emisor, Long> implements IEmisorService {

private final EmisorRepository emisorRepository;

    @Override
    protected ICrudGenericoRepository<Emisor, Long> getRepo() {
        return null;
    }
}
