
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class TestNGModifierChange {
    public static Modifier x;

    @DataProvider(name = "changeTest")
    public Object[][] createData(){
        String value = System.getProperty("valueChange");
        if(value == null){
            value = "test";
        }
        return new Object[][]{{value}};
    }

    @Test(dataProvider = "changeTest")
    public void changeTest(String valueChange) {
        ArrayList<String> mass = x.getMass();
        int index = 2;
        x.change(2, valueChange);
        Assert.assertEquals(valueChange,mass.get(2));
    }



    @BeforeClass
    public static void setUpClass() throws Exception{
        x = Modifier.getInstance();
        x.populate();
    }

}
