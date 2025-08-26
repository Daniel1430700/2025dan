package pe.edu.upeu.conceptospoo.enums;

enum GENERO {M,F}
enum NACIONALIDAD{PERUANO,RUSO,ITALIANO}

public class persona {
    static String nombre;
   static GENERO genero=GENERO.M;
     static NACIONALIDAD nacionalidad=NACIONALIDAD.ITALIANO;

     public static void main(String[] args) {
         nombre="Daniel";
         System.out.println(nombre+ "es"+nacionalidad+"y tiene el género "+genero);

         for (GENERO xx: GENERO.values()){
             System.out.println(xx);
         }
         for (NACIONALIDAD x: NACIONALIDAD.values()){
             System.out.println(x);
         }
     }
}
