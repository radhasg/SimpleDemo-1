package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterTest {
	@Test
	public void myCredentials() {
		String browser = System.getProperty("browser");
		String url = System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		System.out.println("browser"+ browser);
		System.out.println("url"+ url);
		System.out.println("username"+ username);
		System.out.println("password"+ password);
		WebDriver driver=null;
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 System.out.println("launch the chrome");
			}else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				System.out.println("launch the firefox");
			}else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				System.out.println("launch the edge");
				
			}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
	    driver.findElement(By.name("user_password")).sendKeys(password);
	    driver.findElement(By.id("submitButton")).click();	
	    WebElement move = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions actions=new Actions(driver);
	    actions.moveToElement(move).perform();
	    driver.findElement(By.linkText("Sign Out")).click();
	    
				
	}

}
