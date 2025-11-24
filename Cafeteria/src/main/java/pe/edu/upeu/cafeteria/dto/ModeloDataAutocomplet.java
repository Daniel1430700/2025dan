package pe.edu.upeu.cafeteria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//dto sirve para manejo de datos
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModeloDataAutocomplet {
    String idx;
    String nameDysplay;
    String otherData;
    @Override
    public String toString() {
        return nameDysplay+" "+idx+" " + otherData;
    }
}