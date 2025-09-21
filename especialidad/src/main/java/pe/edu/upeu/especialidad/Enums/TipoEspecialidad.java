package pe.edu.upeu.especialidad.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum TipoEspecialidad {
    CARDIOLOGIA( "Cardiología"),
    NEUROLOGIA(  "Neurología"),
    DERMATOLOGIA(  "Dermatología"),
    TRAUMATOOGIA("Traumatología");


    private String descripcion;
}
