
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.*;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class TestNGModifierChange {
    public static Modifier x;
    private static String valueChange;

    public void setValueChange(String valueChange) {
        this.valueChange = valueChange;
    }

    @DataProvider(name = "changeTest")
    public Object[][] createData(){

        if(valueChange == null){
            valueChange = "test";
        }
        return new Object[][]{{valueChange}};
    }

    @Test(dataProvider = "changeTest")
    public void changeTest(String valueChange) {
        ArrayList<String> mass = x.getMass();
        int index = 2;
        System.out.println(valueChange);
        x.change(2, valueChange);
        Assert.assertEquals(valueChange,mass.get(2));
    }





    @BeforeClass
    public static void setUpClass() throws Exception{
        x = Modifier.getInstance();
        x.populate();
    }

}
