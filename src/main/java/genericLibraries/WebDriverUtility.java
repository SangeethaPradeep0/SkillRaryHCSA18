package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all reusable methods of WebDriver
 * @author sange
 *
 */

public class WebDriverUtility {

	 WebDriver driver;
	 
	 /**
	  * This method is used to launch browser and maximize the browser
	  * @param browser
	  * @param url
	  * @param time
	  * @return
	  */
	
	public WebDriver openApplication(String browser, String url, long time)
	{
		switch(browser) {
		case "chrome": driver = new ChromeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		default: System.out.println("Invalid browser data");
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		return driver;
	}
	
	public void mouseHover(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	public void doubleClickOnElement(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	public void dragAndDropElement(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source,target).perform();
	}
	public void dropdown(String value, WebElement element)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	public void dropdown(WebElement element,int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	public void switchToFrame()
	{
		driver.switchTo().frame(0);
	}
	public void switchBacktoFrame()
	{
		driver.switchTo().defaultContent();
	}
	public void handleAlert()
	{
		driver.switchTo().alert().accept();
	}
	public void alertCancel()
	{
		driver.switchTo().alert().dismiss();
	}
	public void handleChildBrowser()
	{
		Set<String> windowIDs = driver.getWindowHandles();
		for(String string:windowIDs)
		{
			driver.switchTo().window(string);
		}
	}
	
	public void switchToParentWindow()
	{
		driver.switchTo().window(driver.getWindowHandle());
	}
	public void scrollElement(Object element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	public void takeScreenshot()
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./elementpic.png");
		try {
			FileUtils.copyFile(src,dest);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
		
		
	public WebElement explicitWait(WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
	   return wait.until(ExpectedConditions.visibilityOf(element));	
		
	}
	public void closeCurrentWindow()
	{
		driver.close();
	}
	public void quitBrowser()
	{
		driver.quit();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

