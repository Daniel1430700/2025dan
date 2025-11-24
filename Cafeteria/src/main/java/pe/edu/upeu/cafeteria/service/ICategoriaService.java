package pe.edu.upeu.cafeteria.service;

import pe.edu.upeu.cafeteria.dto.ComboBoxOption;
import pe.edu.upeu.cafeteria.model.Categoria;

import java.util.List;

public interface ICategoriaService extends ICrudGenericoService <Categoria,Long>{
    List<ComboBoxOption> listarCombobox();
}
