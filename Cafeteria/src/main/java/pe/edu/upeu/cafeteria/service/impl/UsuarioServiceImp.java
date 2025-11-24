package pe.edu.upeu.cafeteria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.cafeteria.model.Usuario;
import pe.edu.upeu.cafeteria.repository.ICrudGenericoRepository;
import pe.edu.upeu.cafeteria.repository.UsuarioRepository;
import pe.edu.upeu.cafeteria.service.IUsuarioService;
@RequiredArgsConstructor
@Service
public class UsuarioServiceImp extends CrudGenericoServiceImp<Usuario, Long> implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Override
    protected ICrudGenericoRepository<Usuario, Long> getRepo() {
        return usuarioRepository;
    }
    @Override
    public Usuario loginUsuario(String user, String clave) {
        return usuarioRepository.loginUsuario(user, clave);
    }

}
