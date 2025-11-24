package pe.edu.upeu.cafeteria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.cafeteria.model.Perfil;
import pe.edu.upeu.cafeteria.repository.ICrudGenericoRepository;
import pe.edu.upeu.cafeteria.repository.PerfilRepository;
import pe.edu.upeu.cafeteria.service.IPerfilService;
@RequiredArgsConstructor
@Service
public class PerfilServiceImp extends CrudGenericoServiceImp<Perfil, Long> implements IPerfilService {

    private final PerfilRepository perfilRepository;

    @Override
    protected ICrudGenericoRepository<Perfil, Long> getRepo() {
        return perfilRepository;
    }
}
