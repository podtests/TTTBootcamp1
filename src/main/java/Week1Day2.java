public class Week1Day2 {

    public static void main(String[] args) {
        Week1Day2 d1 = new Week1Day2();
        //d1.question1();
      //  d1.question2();
       // d1.question3(3,2,"square");
        d1.question3(3,2,"cube");
    }

    public void question1() {
        int maxColCount = 5;
        for (int i = 0; i<3;i++) {
            for (int j= 0; j<maxColCount-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void question2() {
        for (int i =0; i<4; i++) {
            for(int j=0; j<i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void question3(int a , int b, String type) {
        int res=0;
        if(type == "square"){
            res = a*a +b*b + 2*a*b;
        }
        else if (type == "cube") {
            res = a*a*a +b*b*b + 3*a*a*b + 3*a*b*b;
        }
        System.out.println(res);

    }

}



