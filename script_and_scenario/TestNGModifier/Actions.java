/*
 * LoadRunner Java script. (Build: _build_number_)
 * 
 * Script Description: 
 *                     
 */
import lrapi.lr;

public class Actions
{

	public int init() throws Throwable {
		return 0;
	}//end of init


	public int action() throws Throwable {
		lr.start_transaction("TestNGModifier");
		int testStatus;
		int changeStatus = TestngStart.testngStart("TestNGModifierChange", "testFail");
		int getStatus = TestngStart.testngStart("TestNGModifierGet", "");
		testStatus = changeStatus == 1 || getStatus == 1 ? 1 : 0;
		lr.end_transaction("TestNGModifier", testStatus);
		
		return 0;
	}//end of action


	public int end() throws Throwable {
		return 0;
	}//end of end
}
