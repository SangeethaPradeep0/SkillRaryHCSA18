package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
	//Declaration
	@FindBy(xpath="//img[contains(@src,'contactus')]")
	private WebElement pageHeader; //page header 'ContactUs'
	
	@FindBy(name = "name")
	private WebElement fullNameTF;
	
	@FindBy(name="sender")
	private WebElement emailTF;
	
	@FindBy(name="subject")
	private WebElement subjectTF;
	
	@FindBy(name="message")
	private WebElement messageArea;
	
	@FindBy(xpath="//button[text()='Send us mail']")
	private WebElement sendUsMailButton;
	
	//initialization
	
	public ContactUsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	public void sendContactDetails(String name,String email,String subject,String message)
	{
		fullNameTF.sendKeys(name);
		emailTF.sendKeys(email);
		subjectTF.sendKeys(subject);
		messageArea.sendKeys(message);
		sendUsMailButton.click();
		
	}

}
