package pe.edu.upeu.especialidad.control;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.especialidad.Enums.TipoEspecialidad;
import pe.edu.upeu.especialidad.modelo.Especialidad;


@Controller
public class MainController {
// Si en el futuro agregas un maingui con menú, aquí irá la lógica
@FXML
private ComboBox<TipoEspecialidad>cbxEspecialidad;
    @FXML
    public void initialize(){
        cbxEspecialidad.getItems().setAll(TipoEspecialidad.values());
    }
    @FXML
    public void registrarEspecialidad(){
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre(cbxEspecialidad.getSelectionModel().getSelectedItem().toString());
        System.out.println("Especialidad: "+especialidad.getNombre());
    }
}
