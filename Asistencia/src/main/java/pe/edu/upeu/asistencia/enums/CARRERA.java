package pe.edu.upeu.asistencia.enums;

import lombok.Getter;

public enum CARRERA {
    Sistemas(FACULTAD.FIA),
    Civil(FACULTAD.FIA),
    Ambiental(FACULTAD.FIA),
    Administracion(FACULTAD.FCE),
    Enfermeria(FACULTAD.FCS),
    Psicologia(FACULTAD.FCS),
    Nutricion(FACULTAD.FCS),
    Educacion(FACULTAD.FACIHED),
    General(FACULTAD.GENERAL);
    private FACULTAD facultad;
    private CARRERA(FACULTAD facultad) {
        this.facultad = facultad;
    }
    public FACULTAD getFacultad() {return facultad;}
    }

