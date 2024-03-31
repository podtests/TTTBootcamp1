package in.podtest;

public class Human {
    private int age ;

    private String name;

    private float height;

    //default constructor
    public Human(int a, String n) {
        age= a;
        name = n;
    }

    public int getAge() {
        return age;
    }

    public void getDetails(int c) {

        int id = c;

        System.out.println("Name is: "+name+ ", Age is: "+age+ ", height is:"+height+ ", id is: "+id);
    }


}
