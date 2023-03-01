package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import POMPages.ContactUsPage;
import POMPages.CoreJavaForSeleniumPage;
import POMPages.CoreJavaVideoPage;
import POMPages.HomePage;
import POMPages.SeleniumTrainingPage;
import POMPages.SkillRaryDemoAppPage;
import POMPages.TestingPage;

public class BaseClass {
	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected HomePage home;
	
	protected SkillRaryDemoAppPage demoapp;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected CoreJavaForSeleniumPage corejava;
	protected CoreJavaVideoPage javavideo;
	protected ContactUsPage contact;

	//@BeforeSuite
	//@BeforeTest  ---B/C  NO pARALLEL EXECUTION
	//@BeforeClass
	public void classConfiguration()
	{
		 property= new PropertiesUtility();
		 excel = new ExcelUtility();
		 web = new WebDriverUtility();
		 
		 property.propertiesInitialization(IConstantPath.PROPERTIES_FILE_PATH);
		 excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
	}
	//@BeforeMethod
	public void methodConfiguration()
	{
		long time =100;//Long.parseLong(property.fetchProperty("timeouts"));
		driver=web.openApplication(property.fetchProperty("browser"), property.fetchProperty("url"), time);
		
		home = new HomePage(driver);
		Assert.assertTrue(home.getLogo().isDisplayed());
		demoapp = new SkillRaryDemoAppPage(driver);
		selenium = new SeleniumTrainingPage(driver);
		testing = new TestingPage(driver);
		corejava = new CoreJavaForSeleniumPage(driver);
		javavideo = new CoreJavaVideoPage(driver);
		contact = new ContactUsPage(driver);
		
	}
	
	//@AfterMethod
	public void methodTeardown()
	{
		web.quitBrowser();
	}
	//@AfterClass
	public void classTeardown()
	{
		excel.closeExcel();
	}
	//@AfterTest
	//@AfterSuite

}
