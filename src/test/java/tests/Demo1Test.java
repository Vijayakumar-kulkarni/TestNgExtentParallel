package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.DriverManager;

public class Demo1Test extends BaseTest{
	public static int count = 0;
	
	@Test(dataProvider = "demoDataProvider")
	public void navigateToTrelloPage(String name) {
		DriverManager.getDriver().navigate().to("https://trello.com/");
		if(name.equalsIgnoreCase("first_name1")) {
			if(count<1) {
				count++;
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
	}
	@Test(enabled = false)
	public void navigateCucumberWebSite() {
		DriverManager.getDriver().navigate().to("https://cucumber.io/");
		Assert.assertTrue(true);
	}
	@Test(enabled = true)
	public void navigateToGitHubPage() {
		DriverManager.getDriver().navigate().to("https://github.com/Vijayakumar-kulkarni/Cucumber_Extent_Demo");
		throw new SkipException("SKIPPED DEMO");
	}
	
	@DataProvider(name = "demoDataProvider")
	public static String[] credentials() {
	      return new String[] {"first_name1", "Second_name"};
	   }
	
//	@Test(dataProvider = "dpReturningIterator")
//	  public void ddFromIteratorObject(HashMap<String, String> hm) {
//		  hm.forEach((key,value)->{
//				System.out.print(key +" : "+value+"  ");
//				System.out.println();
//			});
//		  
//		  Iterator<String> itr = hm.keySet().iterator();
//		  while(itr.hasNext()) {
//			  String key = itr.next();
//			  System.out.print(key+" : "+hm.get(key));
//			  System.out.println();
//		  }
//	  }
	
//	@DataProvider(name="dpReturningIterator")
//	public Object[] getData(){
//		HashMap<String, String> hm = new HashMap<String, String>();
//		hm.put("name", "Vijay");
//		hm.put("address", "addr1");
//		
//		HashMap<String, String> hm1 = new HashMap<String, String>();
//		hm1.put("name", "Test_name2");
//		hm1.put("address", "addr2");
//		
//		Object[] obj = new Object[] {hm, hm1};
//		return obj;
//	}
	
}
