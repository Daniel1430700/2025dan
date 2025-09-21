package pe.edu.upeu.botica.servicio;
import org.springframework.stereotype.Service;
import pe.edu.upeu.Botica.modelo.Cita;
import java.util.ArrayList;
import java.util.List;
@Service
public class CitaService {
    private final List<Cita> citas = new ArrayList<>();
    private Long nextId = 1L;
    public Cita registrar(Cita c) {
        c.setId(nextId++);
        citas.add(c);
        return c;
    }
    public List<Cita> listar() {
        return citas;
    }
    public boolean eliminar(Long id) {
        return citas.removeIf(x -> x.getId().equals(id));
    }
}
