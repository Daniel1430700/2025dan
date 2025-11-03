package com.example.ventascafeteria.service.impl;

import com.example.ventascafeteria.model.Usuario;
import com.example.ventascafeteria.service.ICrudGenericoService;
import com.example.ventascafeteria.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.ventascafeteria.repository.ICrudGenericoRepository;
import com.example.ventascafeteria.repository.UsuarioRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImp implements IUsuarioService, ICrudGenericoService<Usuario, Long> {
    private final UsuarioRepository usuarioRepository;
    @Override
    public ICrudGenericoRepository<Usuario, Long> getRepo() {
        return usuarioRepository;
    }

    @Override
    public Usuario loginUsuario(String user, String clave) {
        return usuarioRepository.loginUsuario(user, clave);
    }

    @Override
    public Usuario save(Usuario entity) {
        return null;
    }

    @Override
    public Usuario update(Long aLong, Usuario entity) {
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return List.of();
    }

    @Override
    public Usuario findById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
