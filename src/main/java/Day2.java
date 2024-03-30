public class Day2 {

    public static void main(String[] args) {

        int c = sum(9,10);
        System.out.println("Sum is :"+c);
        System.out.println("Sum is :"+sum(5,6));
        System.out.println("Sum is :"+sum(100,200));
        System.out.println("Sum is :"+sum(10,200));
        System.out.println("Sum is :"+sum(-10,200));


    }

    public static int sum(int a , int b) {
        int c = a+b;
        return c;
    }

    public void looping() {
        boolean isValid= true;

        for(int i =2; ((i<=100) && (isValid == true)); i=i+2) {
            System.out.println(i);
            if (i== 70) {
                isValid = false;
            }
        }

        /*
        int i=2;
        while(i<=100) {
            System.out.println(i);
            i=i+2;
        }
        */





        //for loop
        //System.out.println("I will do my homework on Time!");

/*
        for(int i =1; i<=3; i++) {     //1st iteration: i=1, 1<=3,  2nd iteration: i++ ==> i= i+1 = 1+1 = 2, 2<=3, 3rd iteration: 3<=3, 4th iteration: 4, 4<=3
            System.out.println("i: "+i+" and I will do my homework on Time!");
        }
*/



/*
        int i =0;
        while(i<3) {
            System.out.println("i: "+i+" and I will do my homework on Time!");
            i++;
        }
*/
    }

    public void switchCase() {
        char gender = 'M';

        switch (gender) {  //gender=A
            case 'M': {
                int a = 10;
                for (int i = 0; i < a; i++) {
                    System.out.println(i);
                }
                System.out.println("You are a male");
                break;
            }
            default :
                System.out.println("Wrong input provided");
                break;

            case 'F':
                System.out.println("You are a Female");
                break;

            case 'T':
                System.out.println("You are a Transgender");
                break;


        }
    }





}
