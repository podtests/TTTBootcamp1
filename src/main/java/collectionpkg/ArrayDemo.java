package collectionpkg;

import otherpkg.Apple;

import java.util.*;

public class ArrayDemo {

    public static void main(String[] args) {
        ArrayDemo d1 = new ArrayDemo();
        d1.setDemo();

        /*
        //1 Variable
        String name = "Akhil";

        //Array
        String[] names = new String[100];
        names[0] = "Akhil";
        names[1] = "Adithiyan";

        //Arrays: primitive, objects
        int[] rollno = new int[5];
        rollno[0] = 1;

        Apple[] appleMobiles = new Apple[6];

        String[] names1 = new String[10];


        //Collection: objects
        //how to work with primitive data types?
        //Boxing, Unboxing , AutoBoxing

        //convert your primitive data type into objects
        List<Integer> rollNo = new ArrayList<Integer>();
        // Integer i1 = new Integer(5);

        rollNo.add( 5);

        Set<String> guestList2 = new HashSet<String>();

        Map<String, String> studentNames = new HashMap<String, String>();
*/

    }

    public void listDemo() {
        List<String> guestList = new ArrayList<String>();


        //add
        guestList.add("Akhil");
        guestList.add("Sai");
        guestList.add("Shobha");
        guestList.add("Akhil");

        //remove
        guestList.remove("Shobha");

        System.out.println(guestList.size());

        //iteration
        for( String n  : guestList ) {
            System.out.println(n);
        }





    }


    public void setDemo() {
        Set<String> guestList = new HashSet<String>();

        //add
        guestList.add("Akhil");
        guestList.add("Sai");
        guestList.add("Shobha");
        guestList.add("Akhil");

        System.out.println(guestList.size());  //3

        //iteration  //3
        for( String n  : guestList ) {
            System.out.println(n);
        }

        //remove
        guestList.remove("Shobha");

        System.out.println(guestList.size());  //2

        //iteration  //2
        for( String n  : guestList ) {
            System.out.println(n);
        }





    }
}
