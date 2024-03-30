public class Jungle {

    public static void main(String[] args) {

        Animal lion = new Animal();

        Animal monkey = new Animal();
        monkey.name = "Monkey";

        lion.printDetails();

        //Animal name is:
        //Animal name is: null
        //Animal name is: monkey
        //no output

        monkey.printDetails();
    }
}
