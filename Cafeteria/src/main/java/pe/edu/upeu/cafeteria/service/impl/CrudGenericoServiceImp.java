package pe.edu.upeu.cafeteria.service.impl;

import pe.edu.upeu.cafeteria.exception.ModelNotFoundException;
import pe.edu.upeu.cafeteria.repository.ICrudGenericoRepository;
import pe.edu.upeu.cafeteria.service.ICrudGenericoService;

import java.util.List;

public abstract class CrudGenericoServiceImp <T,ID> implements ICrudGenericoService<T,ID> {
    protected abstract ICrudGenericoRepository<T,ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }
    @Override
    public T update(ID id,T t) {
        getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND:" + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) {
    return getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND:" + id));
    }

    @Override
    public void delete(ID id) {
        if(!getRepo().existsById(id)){
            throw new ModelNotFoundException("ID NOT EXIST:" + id);
        }
        getRepo().deleteById(id);

    }
}
