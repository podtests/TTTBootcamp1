package demo;
public class ArrayDemo {

    //Have list of Students of the batch

    String name = "Akhil";
    String name2 = "Derrick";

    String name3 = "Abhishek";

    String name4 = "Nutesh";

    String[] studentName = new String[5];

    public static void main(String[] args) {
        ArrayDemo d1 = new ArrayDemo();
        d1.addNames();
        //System.out.println(d1.getNames(3));
        d1.printAllNames();
    }

    public void addNames() {
        studentName[0] = "Akhil";
        studentName[1] = "Derrick";
        studentName[2] = "Abhishek";
        studentName[3] = "Nutesh";
        studentName[4] = "Kayan";


    }

    public String getNames(int indexpos) {
        return studentName[indexpos];
    }

    public void printAllNames() {
        for(int i =0; i<studentName.length; i++){
            System.out.println(studentName[i]);
        }
    }


}
