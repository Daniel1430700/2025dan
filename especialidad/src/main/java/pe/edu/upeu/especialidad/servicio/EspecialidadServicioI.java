package pe.edu.upeu.especialidad.servicio;

import pe.edu.upeu.especialidad.modelo.Especialidad;

import java.util.List;

public interface EspecialidadServicioI {

    void save( Especialidad especialidad); //C

    List<Especialidad> findAll(); // R

    void update(Especialidad especialidad, int index); //U

    void delete(int index); //D

    Especialidad findById(int index); //Buscar

}
