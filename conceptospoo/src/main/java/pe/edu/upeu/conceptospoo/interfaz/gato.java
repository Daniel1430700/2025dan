package pe.edu.upeu.conceptospoo.interfaz;

public class gato implements animal{


    @Override
    public void emitirsonido() {
        System.out.println("miauuuuu....miauuu");
    }

    @Override
    public void dormir() {
        System.out.println("zzzzzz.z.z.z.z.zzzzz");
    }

    public String juega(){
        return "le gusta jugar con el gato antes de matarlo";
    }

}

