package pe.edu.upeu.cafeteria.service;

import pe.edu.upeu.cafeteria.model.Usuario;

public interface IUsuarioService extends ICrudGenericoService<Usuario,Long>{
    Usuario loginUsuario(String user, String clave);
}
