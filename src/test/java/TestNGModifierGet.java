
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGModifierGet {
    public static Modifier x;

    @Test
    public void getTest(){
        Assert.assertTrue(x.get().contains("ass"));
    }

    @BeforeClass
    public static void setUpClass() throws Exception{
        x = Modifier.getInstance();
        x.populate();
    }
}
