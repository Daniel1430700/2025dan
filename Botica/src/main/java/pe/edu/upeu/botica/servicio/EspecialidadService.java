package pe.edu.upeu.Botica.servicio;
import org.springframework.stereotype.Service;
import pe.edu.upeu.Botica.modelo.Especialidad;
import java.util.ArrayList;
import java.util.List;
@Service
public class EspecialidadService {
    private final List<Especialidad> list = new ArrayList<>();
    private Long nextId = 1L;
    public Especialidad registrar(Especialidad e) {
        e.setId(nextId++);

        list.add(e);
        return e;
    }
    public List<Especialidad> listar() {
        return list;
    }
    public boolean eliminar(Long id) {
        return list.removeIf(x -> x.getId().equals(id));
    }
}