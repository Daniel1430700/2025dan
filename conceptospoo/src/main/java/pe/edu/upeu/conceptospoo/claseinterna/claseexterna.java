package pe.edu.upeu.conceptospoo.claseinterna;

public class claseexterna {
    int a,b;


    int operacion(){
        return a+b;
    }
    class claseinterna1{
        int r;
        void mensaje(){
            r=a+b;
            System.out.println("la suma es:"+r);
        }
    }
    class claseinterna2{
        void otraoperacion(){
            System.out.println("la operacionde resta es:"+(a-b));
        }
    }

    public static void main(String[] args) {
        claseexterna ce = new claseexterna();
        ce.a=9;
        ce.b=10;
        System.out.println("la operacion es:"+ce.operacion());

        claseinterna1 ci1=ce.new claseinterna1();
        ci1.mensaje();
        claseinterna2 ci2=ce.new claseinterna2();
        ci2.otraoperacion();
    }



}
class claseexternax{

}
class claseexternay{
}