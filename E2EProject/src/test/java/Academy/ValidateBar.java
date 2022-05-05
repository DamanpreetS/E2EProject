package Academy;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPage;
import resources.Base;



public class ValidateBar extends Base{
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
		
		Assert.assertTrue(land.getbar().isDisplayed());
		//Assert.assertEquals(land.gettext().getText(), "FEATURED COURSES");
	
		log.info("Info Bar is validated");
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
