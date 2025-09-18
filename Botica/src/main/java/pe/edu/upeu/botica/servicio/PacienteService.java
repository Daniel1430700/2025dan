package pe.edu.upeu.Botica.servicio;
import org.springframework.stereotype.Service;
import pe.edu.upeu.Botica.modelo.Paciente;
import java.util.ArrayList;
import java.util.List;
//clases y objetos
@Service
public class PacienteService {
    private final List<Paciente> pacientes = new ArrayList<>();
    private Long nextId = 1L;
    public Paciente registrar(Paciente p) {
        p.setId(nextId++);
        pacientes.add(p);
        return p;
    }
    public List<Paciente> listar() {
        return pacientes;
    }
    public boolean eliminar(Long id) {
        return pacientes.removeIf(x -> x.getId().equals(id));
    }
}
