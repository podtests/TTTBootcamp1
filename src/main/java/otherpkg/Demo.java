package otherpkg;

public class Demo {

    public static int a = 9;

    public int b = 10;

    public static void main(String[] args) {  //static

        System.out.println(a);  //static
       // System.out.println(b);  //non-static

        //otherpkg.Demo d1 = new otherpkg.Demo();
        //d1.m1();

        m2();



    }


    public static void m2() {
        System.out.println("m2 methods");
    }

    public void m1() { //non-static
        System.out.println(a);  //static
        System.out.println(b);  //non-static

        m2();


    }

    public void m3() { //non-static
        System.out.println(a);  //static
        System.out.println(b);  //non-static



    }
}
