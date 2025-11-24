package pe.edu.upeu.cafeteria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.cafeteria.dto.ComboBoxOption;
import pe.edu.upeu.cafeteria.model.Categoria;
import pe.edu.upeu.cafeteria.repository.CategoriaRepository;
import pe.edu.upeu.cafeteria.repository.ICrudGenericoRepository;
import pe.edu.upeu.cafeteria.service.ICategoriaService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaServiceImp extends CrudGenericoServiceImp<Categoria,Long> implements ICategoriaService {
    private final CategoriaRepository categoriaRepository;
    @Override
    protected ICrudGenericoRepository<Categoria, Long> getRepo() {
        return categoriaRepository;
    }
    @Override
    public List<ComboBoxOption> listarCombobox() {
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(Categoria cate : categoriaRepository.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdCategoria()));
            cb.setValue(cate.getNombre());
            listar.add(cb);
        }
        return listar;
    }
}
