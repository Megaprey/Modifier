/*
 * LoadRunner Java script. (Build: _build_number_)
 * 
 * Script Description: 
 *                     
 */
import lrapi.lr;
import org.testng.*;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Actions
{
	private static int count;
	public int init() throws Throwable {
		return 0;
	}//end of init

	 public static void testngStart(Map<String, String> dataTest){
        
       
        for(Map.Entry<String,String> dataTestNG : dataTest.entrySet()) {
        	count++;
        	String nameTransaction = "TestNGModifier" + count;
        	lr.start_transaction(nameTransaction);
        	XmlSuite suite = new XmlSuite();
        	String nameTest = dataTestNG.getKey();
            String valueChange = dataTestNG.getValue();
        	suite.setName(nameTest);
           
            List<XmlClass> classes = new ArrayList<XmlClass>();
            if (nameTest.equals("TestNGModifierChange")) {
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
            lr.end_transaction(nameTransaction, testNG.getStatus());
        }
        

    }

public int action() throws Throwable {
		
		HashMap<String, String> dataTest = new HashMap<String, String>();
		dataTest.put("TestNGModifierChange", "testFail");
		dataTest.put("TestNGModifierGet","");
		testngStart(dataTest);
		
		return 0;
	}//end of action
	


	public int end() throws Throwable {
		return 0;
	}//end of end
}
