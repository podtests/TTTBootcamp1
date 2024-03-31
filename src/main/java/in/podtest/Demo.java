package in.podtest;

public class Demo {

    public static void main(String[] args) {

        Human akhil  = new Human(35, "Akhil");
        Human rahul  = new Human(25, "Rahul");
        /*
        h1.age = 56;
        h1.name = "Akhil";
        */
        //System.out.println(akhil.getAge());

        akhil.getDetails(2);
        rahul.getDetails(10);
    }
}
