package pe.edu.upeu.asistencia.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.asistencia.modelo.Estudiante;
import pe.edu.upeu.asistencia.repositorio.EstudianteRepositorio;

import java.util.ArrayList;
import java.util.List;


@Service
public class EstudianteServicioImp extends EstudianteRepositorio implements EstudianteServicioI{

    @Override
    public void saveEntidad(Estudiante estudiante) {
        listaEstudiante.add(estudiante);
    }

    @Override
    public List<Estudiante> findAllEntidades() {
        return listaEstudiante;
    }

    @Override
    public void updateEntidad(Estudiante estudiante, int index) {
listaEstudiante.set(index, estudiante);
    }

    @Override
    public void deleteEntidad(int index) {
listaEstudiante.remove(index);
    }

    @Override
    public Estudiante findEntidad(int index) {
        return listaEstudiante.get(index);
    }
}
