package pe.edu.upeu.asistencia.repositorio;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import pe.edu.upeu.asistencia.modelo.Participante;

import java.util.ArrayList;
import java.util.List;

public class ParticipanteRepositorio {
    public List<Participante> listaParticipante =new ArrayList<>();
    public List<Participante> findAll(){
        listaParticipante.add(
                new Participante(
                        new SimpleStringProperty("Daniel"),
                        new SimpleBooleanProperty(true)
                )
        );
        listaParticipante.add(
                new Participante(
                        new SimpleStringProperty("Samuel"),
                        new SimpleBooleanProperty(true)));
        return listaParticipante;
    }



}
