import org.testng.annotations.*;

public class TestNgHooksDemo2 {




    @BeforeClass
    public void m3() {
        System.out.println("TestNgHooksDemo2: Executing BeforeClass");
    }

    @BeforeMethod
    public void m4() {
        System.out.println("TestNgHooksDemo2: Executing BeforeMethod");
    }

    @Test
    public void testcase3() {
        System.out.println("TestNgHooksDemo2: testcase3 is executing!");
    }







    @AfterClass
    public void m7() {
        System.out.println("TestNgHooksDemo2: Executing AfterClass");
    }

    @AfterMethod
    public void m8() {
        System.out.println("TestNgHooksDemo2: Executing AfterMethod");
    }
}
