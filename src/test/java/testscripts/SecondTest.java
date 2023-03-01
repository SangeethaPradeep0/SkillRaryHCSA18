package testscripts;

import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class SecondTest  extends BaseClass{
	
	//@Test
	public void secondTest()
	{
		SoftAssert soft = new SoftAssert();
		
		home.clickGears();
		home.clickSkillraryDemoApp();
		web.handleChildBrowser();
		
		
		soft.assertEquals(demoapp.getPageHeader(), "SkillRary-ECommerce");
		demoapp.selectCategory(web, 1);
		
		soft.assertEquals(testing.getPageHeader(), "Testing");
		//checking page is appearing or not
		web.dragAndDropElement(testing.getJavaImage(),testing.getMyCartArea());
		web.scrollElement(testing.getFaceBookIcon());
		testing.clickFaceBookIcon();
		soft.assertAll();
		
		
		
		
	}

}
