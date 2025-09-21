package pe.edu.upeu.especialidad.modelo;

import javafx.beans.property.IntegerProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Especialidad {
    private IntegerProperty id;
    private String nombre;
}
