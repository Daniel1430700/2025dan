package pe.edu.upeu.asistencia.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.Participante;
import pe.edu.upeu.asistencia.servicio.ParticipanteServicioI;

@Controller
public class ParticipanteController {

    @FXML
    private TextField txtNombre,txtDni,txtApellidos;
    @FXML
    private ComboBox<Carrera> cbxCarrera;
    @FXML
    private ComboBox<TipoParticipante> cbxTipoParticipante;

    @FXML
    private TableView<Participante> tableView;
    ObservableList<Participante> listaparticipantes;

    @FXML
    private TableColumn<Participante,String> dniColum,nombreColum, apellidosColum,carreraColum, tipoPartColum;
@Autowired
    ParticipanteServicioI ps;
    @FXML
    public void initialize(){
        cbxCarrera.getItems().setAll(Carrera.values());
        cbxTipoParticipante.getItems().setAll(TipoParticipante.values());
        definirColumnas();
        listarParticipantes();
    }


    public void limpiarFormulario(){
        txtNombre.setText("");
        txtDni.setText("");
        txtApellidos.setText("");
        cbxCarrera.setValue(null);
        cbxTipoParticipante.setValue(null);
    }

    @FXML
        public void registrarParticipante(){
            Participante p = new Participante();
            p.setDni(new SimpleStringProperty(txtDni.getText()));
            p.setNombre(new SimpleStringProperty(txtNombre.getText()));
            p.setApellidos(new SimpleStringProperty(txtApellidos.getText()));
            p.setCarrera(cbxCarrera.getSelectionModel().getSelectedItem());
            p.setTipoParticipante(cbxTipoParticipante.getSelectionModel().getSelectedItem());
            ps.save(p);
        limpiarFormulario();
            listaparticipantes.add(p);
        }

    public void definirColumnas(){
        //dniColum,nombreColum, apellidosColum,carreraColum, tipoPArtColum
        dniColum=new TableColumn("DNI");
        nombreColum=new TableColumn("Nombre");
        apellidosColum=new TableColumn("Apellidos");
        carreraColum=new TableColumn("Carrera");
        tipoPartColum=new TableColumn("Tipo Participante");
        tableView.getColumns().addAll(dniColum, nombreColum, apellidosColum, carreraColum, tipoPartColum);
    }
    public void listarParticipantes(){
        dniColum.setCellValueFactory( cellData -> cellData.getValue().getDni() );
        nombreColum.setCellValueFactory(cellData -> cellData.getValue().getNombre() );
        apellidosColum.setCellValueFactory(cellData -> cellData.getValue().getApellidos());
        carreraColum.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getCarrera().toString()));
        listaparticipantes=FXCollections.observableArrayList(ps.findAll());
        tableView.setItems(listaparticipantes);

    }


}
