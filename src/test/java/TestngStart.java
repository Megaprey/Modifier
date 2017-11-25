import com.beust.jcommander.JCommander;
import org.testng.*;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class TestngStart {
    public static void main(String[] args) {
        testngStart("TestNGModifierGet","");
    }
    public static int testngStart(String nameTest, String valueChange){
        XmlSuite suite = new XmlSuite();
        suite.setName("TestNGModifier");

        List<XmlClass> classes = new ArrayList<XmlClass>();
        if(nameTest.equals("TestNGModifierChange")){
            new TestNGModifierChange().setValueChange(valueChange);
        } else {
            new TestNGModifierChange().setValueChange(null);
        }
        classes.add(new XmlClass(nameTest));

        XmlTest test = new XmlTest(suite);
        test.setName("MyTests");
        test.setXmlClasses(classes);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);

        TestNG testNG = new TestNG();
        testNG.setXmlSuites(suites);
        testNG.run();
        return testNG.getStatus();

    }
}
