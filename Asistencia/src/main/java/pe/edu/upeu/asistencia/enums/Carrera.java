package pe.edu.upeu.asistencia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Carrera {
    RADIOGRAFIA(Facultad.FIA,"Radiografia"),
    PEDIATRIA(Facultad.FIA,"Pediatría"),
    CARDIOLOGIA(Facultad.FIA,"Cardiología"),
    GENERAL(Facultad.GENERAL,"General"),;
    private Facultad facultad;

    private String descripcion;
    }

