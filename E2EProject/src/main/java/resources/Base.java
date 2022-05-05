package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class Base {
	public WebDriver driver;
	
	public Properties prop;

	public WebDriver initializedriver() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		//mvn test -Dtest=Regression -- means you are sending in command name of TC
		//mvn test -Dbrowser=chrome - means sending name pf browser in command
		
		String browser=System.getProperty("browser"); //mvn sets them in system properties
		//String browser=prop.getProperty("browser");
		if(browser.contains("chrome"))
			
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
		
			if(browser.contains("headless"))
			options.addArguments("headless");
			driver=new ChromeDriver(options);
			
		}
		else if(browser.contains("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Eclipse\\geckodriver.exe");
			FirefoxOptions options=new FirefoxOptions();
			if(browser.contains("headless"))
			options.addArguments("headless");
			driver=new FirefoxDriver(options);
			
			Actions a=new Actions(driver);
			
		
		}
		else
		{
			System.setProperty("webdriver.edge.driver", "D:\\Eclipse\\msedgedriver.exe");
			EdgeOptions options=new EdgeOptions();
			if(browser.contains("headless"))
			options.addArguments("headless");
			driver=new EdgeDriver(options);
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	return driver;	
	}
	
	public String getScreenshotPath(WebDriver driver2, String name) throws IOException
	{
		this.driver=driver2;
		File file= ((TakesScreenshot )driver).getScreenshotAs(OutputType.FILE);
		String file2=System.getProperty("user.dir")+"\\reports\\"+name+".png";
		org.apache.commons.io.FileUtils.copyFile(file, new File(file2));
		return file2;
	}
}
