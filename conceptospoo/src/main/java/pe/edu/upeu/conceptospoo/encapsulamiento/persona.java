package pe.edu.upeu.conceptospoo.encapsulamiento;

public class persona {
    private String  nombre;
    private int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void saludar(){
        System.out.println("hola, soy "+nombre+" y mi edad es "+edad);
    }

}
