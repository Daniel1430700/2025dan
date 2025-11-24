package pe.edu.upeu.cafeteria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.cafeteria.dto.ComboBoxOption;
import pe.edu.upeu.cafeteria.model.Marca;
import pe.edu.upeu.cafeteria.repository.ICrudGenericoRepository;
import pe.edu.upeu.cafeteria.repository.MarcaRepository;
import pe.edu.upeu.cafeteria.service.IMarcaService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MarcaServiceImp extends CrudGenericoServiceImp<Marca, Long> implements IMarcaService {
private final MarcaRepository marcaRepository;

    @Override
    protected ICrudGenericoRepository<Marca, Long> getRepo() {
        return marcaRepository;
    }
    @Override
    public List<ComboBoxOption> listarCombobox() {
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(Marca cate : marcaRepository.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdMarca()));
            cb.setValue(cate.getNombre());
            listar.add(cb);
        }
        return listar;
    }
}
