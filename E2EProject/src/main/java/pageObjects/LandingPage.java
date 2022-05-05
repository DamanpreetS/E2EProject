package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By login=By.xpath("//a[contains(@href,\"sign_in\")]");
	By text=By.xpath("//h2[text()='Featured Courses']");
	public By bar=By.xpath("//ul[contains(@class,'navbar-right')]");
	
	public WebElement getlogin()
	{
		return driver.findElement(login);
	}
	public WebElement getbar()
	{
		return driver.findElement(bar);
	}
	public WebElement gettext()
	{
		return driver.findElement(text);
	}
	
}
