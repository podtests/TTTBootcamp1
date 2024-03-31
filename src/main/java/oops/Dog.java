package oops;

public class Dog extends Animal{

    public Dog(int b) {
        super(b);
    }


    public void speak() {
        System.out.println("Dogs Bark");
    }

    public void eat() {
        System.out.println("Dog is eating");
    }

}
