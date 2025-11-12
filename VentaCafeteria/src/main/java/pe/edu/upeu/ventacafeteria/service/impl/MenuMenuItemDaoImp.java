package pe.edu.upeu.ventacafeteria.service.impl;

import pe.edu.upeu.ventacafeteria.dto.MenuMenuItenTO;
import pe.edu.upeu.ventacafeteria.service.IMenuMenuItemDao;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MenuMenuItemDaoImp implements IMenuMenuItemDao {
    @Override
    public List<MenuMenuItenTO> listaAccesos(String perfil, Properties idioma) {
        return List.of();
    }

    @Override
    public Map<String, String[]> accesosAutorizados(List<MenuMenuItenTO> accesos) {
        return Map.of();
    }
}
