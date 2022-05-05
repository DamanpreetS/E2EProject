package Academy;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPage;
import pageObjects.SignInPage;

import resources.Base;



public class ValidateTitle extends Base{

	public WebDriver driver;
	public static Logger log=org.apache.logging.log4j.LogManager.getLogger(Base.class.getClass());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializedriver();
		
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void basePageNavigation() throws IOException
	{
	
		driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
		LandingPage land=new LandingPage(driver);
		
		Assert.assertEquals(land.gettext().getText(), "feat COURSES");
		
		log.error("title is validated");
	
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
