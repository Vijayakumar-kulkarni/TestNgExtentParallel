package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utilities.UtilityClass;

public class IRetryAnalyzerImpl implements IRetryAnalyzer {
	private ThreadLocal<Integer> counter = ThreadLocal.withInitial(()->0);
	private static final int maxTry = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		if(counter.get()<maxTry) {
			System.out.println("Retrying test " + UtilityClass.testName.get() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (counter.get()+1) + " time(s).");
			counter.set(counter.get()+1);
			return true;
		}else {
			counter.set(0);
			return false;
		}
	}
	public String getResultStatusName(int status) {
    	String resultName = null;
    	if(status==1)
    		resultName = "SUCCESS";
    	if(status==2)
    		resultName = "FAILURE";
    	if(status==3)
    		resultName = "SKIP";
		return resultName;
    }
}
