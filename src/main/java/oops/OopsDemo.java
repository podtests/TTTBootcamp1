package oops;

public class OopsDemo {

    public static void main(String[] args) {

       // Animal a1 = new Animal(10);
        //a1.walk();
        Dog d1 = new Dog(20);
       // d1.speak();



        //1
       // Animal a1 = new Animal();
       // a1.speak();  //Animal
        //a1.walk();

        //Dog d1 = new Dog();
        //d1.speak(); //Dog
        //d1.eat();
        //d1.walk();

        /*
        Animal a1 = new Dog();
        //a1.speak();  //Dog
        //a1.walk();
        a1.speak(); //dog
        a1.walk();

        Animal a2 = (Animal) new Dog();
        a2.speak(); //dog version
        a2.walk();
         */

        //Dog a2 = new Animal(); //not allowed copile time error

        //Dog a2 = (Dog) new Animal(); //works in compile time, but fails at run time




        // Dog d1 = new Animal(); //You cannot do this as is
        //Dog d1 = (Dog) new Animal();




        /*
        EncapsulationDemo e1 = new EncapsulationDemo();
        e1.setA(5);
        e1.getA();
         */

        /*
        PolymorphsimDemo p1 = new PolymorphsimDemo();
        p1.m1();
        p1.m1(5);
        p1.m1("Akhil");
         */
    }
}
