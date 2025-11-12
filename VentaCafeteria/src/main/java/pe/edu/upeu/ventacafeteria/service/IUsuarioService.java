package pe.edu.upeu.ventacafeteria.service;

import pe.edu.upeu.ventacafeteria.model.Usuario;

public interface IUsuarioService extends ICrudGenericoService<Usuario,Long>{
    Usuario loginUsuario(String user, String clave);

}