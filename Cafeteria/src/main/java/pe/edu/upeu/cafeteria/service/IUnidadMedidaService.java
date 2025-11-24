package pe.edu.upeu.cafeteria.service;


import pe.edu.upeu.cafeteria.dto.ComboBoxOption;
import pe.edu.upeu.cafeteria.model.UnidadMedida;

import java.util.List;

public interface IUnidadMedidaService extends  ICrudGenericoService<UnidadMedida,Long>{
    List<ComboBoxOption> listarCombobox();
}
