package com.example.ventascafeteria.repository;

import com.example.ventascafeteria.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ICrudGenericoRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM cafteria_usuario u WHERE u.user = :user AND u.clave = :clave", nativeQuery = true)
    Usuario loginUsuario(@Param("user") String user, @Param("clave") String clave);
}