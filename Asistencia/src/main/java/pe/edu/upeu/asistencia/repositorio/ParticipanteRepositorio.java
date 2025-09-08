package pe.edu.upeu.asistencia.repositorio;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.Participante;

import java.util.ArrayList;
import java.util.List;

public abstract class ParticipanteRepositorio {
    public List<Participante> listaParticipante =new ArrayList<>();
    public List<Participante> findAll(){
        listaParticipante.add(
                new Participante(
                        new SimpleStringProperty("25456845"),
                        new SimpleStringProperty("Daniel"),
                        new SimpleStringProperty("CONDORI"),
                        new SimpleBooleanProperty(true), Carrera.SISTEMAS,
                        TipoParticipante.ASISTENTE
                )
        );
        listaParticipante.add(
                new Participante(
                        new SimpleStringProperty("84575955"),
                        new SimpleStringProperty("Sam<3"),
                        new SimpleStringProperty("valle"),
                        new SimpleBooleanProperty(true), Carrera.ENFERMERIA,
                        TipoParticipante.ASISTENTE
                )
        );
        return listaParticipante;
    }



}
