package demo.org;

public class JavaDemo {

    public static void main(String[] Args) {

        int age = -100;

        //Find the Age Stage based on given age
        if (age <0) {
            System.out.println("Please provide the age of a living person");
        }
        else if(age >=0 && age <18) {
            System.out.println("User is a Child!");
        }
        else if (age >=18 && age <60) {
            System.out.println("User is a Adult");
        }
        else {
            System.out.println("User is a Senior Citizen");
        }

        System.out.println("If else block got completed");

        /*
       int a = 9;
        System.out.println("a value is:"+a);

        float num1 = 6.65f;
        double num2 = 8.95;

        System.out.println("num1 is :"+num1);
        System.out.println("num2 is :"+num2);

        char nameStart = 'a';
        System.out.println("nameStart is: "+nameStart);

        String name = "Akhil";

        System.out.println("name is: "+name);
*/

    }




}
