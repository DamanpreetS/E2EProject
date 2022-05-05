package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPage {

	WebDriver driver;
	
	public SignInPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="user_email")
	WebElement email;
	
	@FindBy(name=" password")
	WebElement password;
	
	
	@FindBy(name="commit")
	WebElement login;
	public WebElement getEmail()
	{
		return email;
	}
	public WebElement getPassword()
	{
		return password;
	}
	
	public WebElement getLogin()
	{
		return login;
	}
	
}
