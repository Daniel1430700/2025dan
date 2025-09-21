package pe.edu.upeu.especialidad.modelo;

import lombok.Data;

@Data
public class Paciente {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
}
