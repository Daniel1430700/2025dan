package pe.edu.upeu.Botica.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upeu.Botica.servicio.EspecialidadService;

import java.net.URL;
import java.util.ResourceBundle;

@Controller  // 👈 Importante
public class CitaController implements Initializable {

    @Autowired
    private EspecialidadService especialidadService; // 👈 Ahora sí lo inyecta Spring

    @FXML
    private TextField txtNombrePaciente;
    @FXML
    private TextField txtDni;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox<String> cbEspecialidad;
    @FXML
    private DatePicker dpFecha;
    @FXML
    private TextField txtHora;
    @FXML
    private TableView<?> tablaCitas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Aquí especialidadService ya no será null
        System.out.println("EspecialidadService inyectado: " + especialidadService);
    }

    @FXML
    private void registrarCita() {
        System.out.println("Registrar cita");
    }
}
