package pe.edu.upeu.conceptospoo.encapsulamiento;

public class clasegeneral {
    public static void main(String[] args) {
        persona persona = new persona();//persona es un objeto
        // persona.nombre="Daniel";
        //persona.edad=18;
        persona.setNombre("Daniel");
        persona.setEdad(25);


        System.out.println("nombre: " + persona.getNombre());
        System.out.println("edad: " + persona.getEdad());

        persona.saludar();
    }
}
