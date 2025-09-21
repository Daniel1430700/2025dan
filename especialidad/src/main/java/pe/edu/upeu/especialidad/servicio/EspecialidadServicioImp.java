package pe.edu.upeu.especialidad.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.especialidad.modelo.Especialidad;
import pe.edu.upeu.especialidad.repositorio.EspecialidadRepositorio;

import java.util.List;

@Service
public class EspecialidadServicioImp extends EspecialidadRepositorio implements EspecialidadServicioI {


    @Override
    public void save(Especialidad especialidad) {
        listaEspecialidades.add(especialidad);

    }

    @Override
    public List<Especialidad> findAll() {
        if (listaEspecialidades.isEmpty()) {
            return super.findAll();
        }
        return listaEspecialidades;
    } // R

    @Override
    public void update(Especialidad especialidad, int index) {

    }

    @Override
    public void delete(int index) {

    }

    @Override
    public Especialidad findById(int index) {
        return null;
    }
}
