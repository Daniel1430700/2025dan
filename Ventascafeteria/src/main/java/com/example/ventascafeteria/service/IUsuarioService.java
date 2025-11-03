package com.example.ventascafeteria.service;

import com.example.ventascafeteria.model.Usuario;
import com.example.ventascafeteria.repository.ICrudGenericoRepository;

public interface IUsuarioService extends ICrudGenericoService<Usuario,Long>{
    ICrudGenericoRepository<Usuario, Long> getRepo();

    Usuario loginUsuario(String user, String clave);

}
