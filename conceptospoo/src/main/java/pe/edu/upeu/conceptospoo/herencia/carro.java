package pe.edu.upeu.conceptospoo.herencia;

public class carro extends vehiculo{
    String color="blanco";
    String modelo="tipe35";

    void caracteristicas(){
        marca="bugatti";
        System.out.println("el vehiculo tiene las siguientes caracteristicas ");
        System.out.println("la marca de este vehiculo es: " + marca);
        System.out.println("modelo: "+modelo);
        System.out.println("color: "+color);
        System.out.println("y emite el siguiente sonido"+sonido());
    }
    public void main(String[] args){

    }
}
