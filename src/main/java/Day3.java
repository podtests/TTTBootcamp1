public class Day3 {

    public static void main(String[] args) {
        Day3 d3 = new Day3();
        String res = d3.printName("Ashish");
        System.out.println(res);

        d3.getName();
        d3.printName();
    }
    public String printName(String name) {
        System.out.println(name);
        return "Akhil";
    }

    public String getName() {
        return "Akhil Jain";
    }

    public void printName() {
        System.out.println("Akhil Jain");
    }




    //Create a method: accept 2 inputs : age, name
    //print the number of years we have outlived in our Adulthood stage

    // print : Name + Adult age
    //return adult age

}

