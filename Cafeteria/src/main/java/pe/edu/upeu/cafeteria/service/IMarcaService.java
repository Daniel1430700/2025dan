package pe.edu.upeu.cafeteria.service;

import pe.edu.upeu.cafeteria.dto.ComboBoxOption;
import pe.edu.upeu.cafeteria.model.Marca;

import java.util.List;

public interface IMarcaService extends  ICrudGenericoService<Marca,Long>{
    List<ComboBoxOption> listarCombobox();
}
