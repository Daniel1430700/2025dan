package pe.edu.upeu.asistencia.repositorio;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import pe.edu.upeu.asistencia.enums.CARRERA;
import pe.edu.upeu.asistencia.enums.TIPO_PARTICIPANTE;
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
                        new SimpleBooleanProperty(true), CARRERA.Sistemas,
                        TIPO_PARTICIPANTE.Asistente
                )
        );
        listaParticipante.add(
                new Participante(
                        new SimpleStringProperty("84575955"),
                        new SimpleStringProperty("Mayra"),
                        new SimpleStringProperty("valle"),
                        new SimpleBooleanProperty(true), CARRERA.Enfermeria,
                        TIPO_PARTICIPANTE.Asistente
                )
        );
        return listaParticipante;
    }



}
