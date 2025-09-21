package pe.edu.upeu.especialidad.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cita {
    private Long id;
    private LocalDate fecha;
    private LocalTime hora;
    private Paciente paciente;
    private Especialidad especialidad;
}
