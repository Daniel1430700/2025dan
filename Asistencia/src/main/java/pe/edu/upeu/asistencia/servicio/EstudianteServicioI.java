package pe.edu.upeu.asistencia.servicio;

import pe.edu.upeu.asistencia.modelo.Estudiante;

import java.util.List;

public interface EstudianteServicioI {

    void saveEntidad(Estudiante estudiante);

    List<Estudiante> findAllEntidades();

    void updateEntidad(Estudiante estudiante, int index);

    void deleteEntidad(int index);

    Estudiante findEntidad(int index);
}
