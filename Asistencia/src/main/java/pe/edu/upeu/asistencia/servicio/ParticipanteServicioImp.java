package pe.edu.upeu.asistencia.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.asistencia.modelo.Participante;
import pe.edu.upeu.asistencia.repositorio.ParticipanteRepositorio;

import java.util.List;


@Service
public class ParticipanteServicioImp extends ParticipanteRepositorio implements ParticipanteServicioI {

    @Override
    public void save(Participante participante) {
        listaParticipante.add(participante);
    }

    @Override
    public List<Participante> findAll() {
        return listaParticipante;
    }

    @Override
    public void update(Participante participante, int index) {
listaParticipante.set(index, participante);
    }

    @Override
    public void delete(int index) {
listaParticipante.remove(index);
    }

    @Override
    public Participante findById(int index) {
        return listaParticipante.get(index);
    }
}
