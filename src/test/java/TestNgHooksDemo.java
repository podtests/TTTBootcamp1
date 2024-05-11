import org.testng.annotations.*;

public class TestNgHooksDemo {


    @BeforeSuite
    public void m1() {
        System.out.println("Executing BeforeSuite");
    }

    @BeforeTest
    public void m2() {
        System.out.println("Executing BeforeTest");
    }


    @BeforeClass
    public void m3() {
        System.out.println("Executing BeforeClass");
    }

    @BeforeMethod
    public void m4() {
        System.out.println("Executing BeforeMethod");
    }

    @Test
    public void testcase1() {
        System.out.println(" testcase1 is executing!");
    }


    @Test
    public void testcase2() {
        System.out.println(" testcase2 is executing!");
    }

    @AfterSuite
    public void m5() {
        System.out.println("Executing AfterSuite");
    }

    @AfterTest
    public void m6() {
        System.out.println("Executing AfterTest");
    }


    @AfterClass
    public void m7() {
        System.out.println("Executing AfterClass");
    }

    @AfterMethod
    public void m8() {
        System.out.println("Executing AfterMethod");
    }
}
