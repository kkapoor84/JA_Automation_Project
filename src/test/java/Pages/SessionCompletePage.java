package Pages;
import static Base.DriverSetup.driver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SessionCompletePage {
	
	
	public void verifySessionComplete (String UpdatedClassName) throws InterruptedException 
	{
		System.out.println("*****Go to My Course->Not Running>to start the Class ****");

		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/nav/div/div[2]/ul/li[6]/a")).click(); // My Courses
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[2]/a")).click(); //Not Runnign Course
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(UpdatedClassName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(Keys.ENTER);

	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/div[1]/following-sibling::table//td/input[@type='radio']")).click();

	    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/div//span/button[text()[contains(.,'Start')]]")).click();
	    Thread.sleep(5000);
		
	    driver.findElement(By.xpath(".//*[@id='startClass']")).click();
	 
 
		System.out.println("******Go to My Course->Running Courses****");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(UpdatedClassName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(Keys.ENTER);

	    Thread.sleep(2000);

	    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/div[1]/following-sibling::table//td/input[@type='radio']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/div//span/button[text()[contains(.,'Complete')]]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//*[@id='btnOk']")).click();
	    Thread.sleep(5000);
	
	    System.out.println("*****Go to My Course->Complete COurse-> to Incomplete the Class ****");
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[4]/a")).click(); //complete course
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(UpdatedClassName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(Keys.ENTER);

	    Thread.sleep(2000);

	    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/div[1]/following-sibling::table//td/input[@type='radio']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/div//span/button[text()[contains(.,'In')]]")).click();
	    Thread.sleep(2000);

	    driver.findElement(By.xpath(".//*[@id='btnOk']")).click();
	    Thread.sleep(5000);
	    
	    System.out.println("*****Go to My Course->Rnning->Tpo verify the incompleted class ****");
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[3]/a")).click(); //RunningCourses
	    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(UpdatedClassName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(Keys.ENTER);

	    Thread.sleep(5000);
	    System.out.println("******Verified the updated Class Name****");
	    String ExpClassName = UpdatedClassName;
		String ActualClassName = driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/div[1]/following-sibling::table//td[text()[contains(.,'Demo')]]")).getText();
		
		Assert.assertEquals(ActualClassName, ExpClassName);
	    


	}}
