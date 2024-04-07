package otherpkg;

public class MobileDemo {

    public static void main(String[] args) {


        //otherpkg.Mobile m1 = new otherpkg.Mobile(); //can't create object of interface

        /*


        otherpkg.Apple a1 = new otherpkg.Apple();
        a1.calling();
        a1.gps();
         otherpkg.Mobile a2 = new otherpkg.Apple();
        a2.calling();
        a2.gps();
*/

        Samsung s1 = new Samsung();
        s1.calling();
        s1.gps();
        s1.games();

        Mobile s2 = new Samsung();
        s2.calling();
        s2.gps();
        //s2.games();



    }
}
