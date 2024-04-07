package collectionpkg;

import otherpkg.Apple;

import java.util.*;

public class ArrayDemo {

    public static void main(String[] args) {
        ArrayDemo d1 = new ArrayDemo();
        d1.complexMapDemo();

    }


    public void complexMapDemo() {

        List<String> row1 = new ArrayList<String>();
        row1.add("Akhil");
        row1.add("Male");
        row1.add("6");
        row1.add("Delhi");

        //row1.iterator();

        List<String> row2 = new ArrayList<String>();
        row2.add("Rahil");
        row2.add("Male");
        row2.add("16");
        row2.add("UP");

        Map<Integer, List<String>> webData = new HashMap<Integer, List<String>>();
        webData.put(1, row1);
        webData.put(2, row2);

        Iterator<String> rowData = webData.get(2).iterator(); //List<String>
        while(rowData.hasNext()) {
            System.out.println(rowData.next());
        }
    }


    public void mapDemo() {
        Map<Integer, String> studentNames = new HashMap<Integer, String>();

        //Additions
        studentNames.put(1, "Nutesh");
        studentNames.put(2, "Anvesh");
        studentNames.put(3, "Srinivas");
        studentNames.put(4, "Anvesh");


        //get the values: based on keys
        String name = studentNames.get(3);//Anvesh //Srinivas
        System.out.println(name);

        //size
        System.out.println(studentNames.size());  //3 4

        //iterate thru entire value
        Iterator<String>   studentNameList = studentNames.values().iterator();
        while(studentNameList.hasNext()) {
            System.out.println(studentNameList.next());
        }

        //remove
        studentNames.remove(1);

        //iterate thru the keys
        Iterator<Integer> studentKeys =  studentNames.keySet().iterator();
        Integer key;
        while(studentKeys.hasNext()) {
            key = studentKeys.next();
            System.out.println("RollNo is: "+key+ ", StudentName is: "+studentNames.get(key));
        }









    }


    public void collectionDemo() {

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
        //for( String n  : guestList ) {
          //  System.out.println(n);
        //}

        Iterator<String> guestListIterator = guestList.iterator();

        while(guestListIterator.hasNext()) {
            System.out.println(guestListIterator.next());
        }





        /*
        //remove
        guestList.remove("Shobha");

        System.out.println(guestList.size());  //2

        //iteration  //2
        for( String n  : guestList ) {
            System.out.println(n);
        }

         */





    }
}
