package pe.edu.upeu.asistencia.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
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
    private TableColumn<Participante, Void>opcColum;

@Autowired
    ParticipanteServicioI ps;
int indexE=-1;

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
            if(indexE==-1){
                ps.save(p);
            }else {
                ps.update(p, indexE);
                indexE = -1;

            }
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
        opcColum=new TableColumn("Opciones");
        opcColum.setPrefWidth(200);
        tableView.getColumns().addAll(dniColum, nombreColum, apellidosColum, carreraColum, tipoPartColum,opcColum);
    }
    public void agregarAccionBotones() {
        Callback<TableColumn<Participante, Void>, TableCell<Participante, Void>> cellFactory =
                param -> new TableCell<>() {
                    private final Button editarBtn = new Button("Editar");
                    private final Button eliminarBtn = new Button("Eliminar");

                    {
                        editarBtn.setOnAction(event -> {
                            Participante p=getTableView().getItems().get(getIndex());
                            editarDatos(p, getIndex());
                        });
                        eliminarBtn.setOnAction(event -> {
                            eliminarParticipante(getIndex());

                        });

                    }


                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);

                            }else{
                                HBox hBox = new HBox(editarBtn, eliminarBtn);
                                hBox.setSpacing(10);
                                setGraphic(hBox);
                            }
                        }
                };
        opcColum.setCellFactory(cellFactory);
    }


    public void listarParticipantes(){
        dniColum.setCellValueFactory( cellData -> cellData.getValue().getDni() );
        nombreColum.setCellValueFactory(cellData -> cellData.getValue().getNombre() );
        apellidosColum.setCellValueFactory(cellData -> cellData.getValue().getApellidos());
        carreraColum.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getCarrera().toString()));
        agregarAccionBotones();
        listaparticipantes=FXCollections.observableArrayList(ps.findAll());
        tableView.setItems(listaparticipantes);

    }
    public void eliminarParticipante(int index){
        ps.delete(index);
        listarParticipantes();
    }
public void editarDatos(Participante p, int index){
        txtDni.setText(p.getDni().getValue());
        txtNombre.setText(p.getNombre().getValue());
        txtApellidos.setText(p.getApellidos().getValue());
        cbxCarrera.setValue(p.getCarrera());
        cbxTipoParticipante.setValue(p.getTipoParticipante());
    indexE=index;
}

}
