package Academy;

import java.io.IOException;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPage;
import pageObjects.SignInPage;

import resources.Base;


public class HomePage extends Base{

	public WebDriver driver;
	public static Logger log=org.apache.logging.log4j.LogManager.getLogger(Base.class.getClass());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializedriver();
		
		driver.get(prop.getProperty("url"));
	}
	@Test(dataProvider = "getdata")
	public void basePageNavigation(String email,String password) throws IOException
	{
		
		driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
		LandingPage land=new LandingPage(driver);

		//Assert.assertEquals(land.gettext().getText(), "FEATURED COURSES");
		land.getlogin().click();
		SignInPage signin=new SignInPage(driver);
		signin.getEmail().sendKeys(email);
		signin.getPassword().sendKeys(password);
		signin.getLogin().click();
	
		log.info("user  is logged in");
		
	}
	@DataProvider
	public Object getdata() {
		Object[][] ob= new Object[1][2];
		
		ob[0][0]="email1";
		ob[0][1]="password1";
		//ob[1][0]="email2";
		//ob[1][1]="password2";
		
		return ob;
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
