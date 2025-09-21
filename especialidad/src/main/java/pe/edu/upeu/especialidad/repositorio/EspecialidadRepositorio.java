package pe.edu.upeu.especialidad.repositorio;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import pe.edu.upeu.especialidad.Enums.TipoEspecialidad;
import pe.edu.upeu.especialidad.modelo.Especialidad;

import java.util.ArrayList;
import java.util.List;

public abstract class EspecialidadRepositorio {
    public List<Especialidad> listaEspecialidades = new ArrayList<>();

    public List<Especialidad> findAll() {
        listaEspecialidades.add(
                new Especialidad(
                        new SimpleIntegerProperty(1),
                        TipoEspecialidad.NEUROLOGIA

                )
        );
        listaEspecialidades.add(
                new Especialidad(

                )
        );
        return listaEspecialidades;
    }
}
