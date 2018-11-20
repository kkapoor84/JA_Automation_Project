package Pages;
import static Base.DriverSetup.driver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SessionEnviormentAddPage {
	
	
	public void verifyAddEnvDetails(List<String> e,List<String> f,int random) throws InterruptedException
	{
		
		System.out.println("******Go to My Course->Not Running->To verify the entroll user details****");
	driver.navigate().refresh();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/nav/div/div[2]/ul/li[6]/a")).click(); // My Courses
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[2]/a")).click(); //Not Runnign Course
	Thread.sleep(2000);
	
	
	//driver.findElement(By.xpath("(.//*[@id='notRunningCourses']//span[starts-with(text(),'JA It')])[2]")).click(); // Explore Drawer
	driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]")).click();
	
	Thread.sleep(10000);
	System.out.println("before hiting search class button");
	//driver.findElement(By.xpath("(//*[@id='dvtable']/div[1]/div[2]/input)[2]")).click();
	driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).click();
	
	//driver.findElement(By.cssSelector("input[class*=form-control]")).sendKeys("Class_BCRM_KK_"+random);
	//driver.findElement(By.xpath("(//*[@id='dvtable']/div[1]/div[2]/input)[2]")).sendKeys("Class_BCRM_KK_"+random);
	driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys("Class_BCRM_KK_"+random);
	
	Thread.sleep(5000);
	//driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[3]/div/div[18]/div[2]/div/div/div[1]/div[2]/span/button")).click();
   // driver.findElement(By.xpath("(//*[@id='dvtable']/div[1]/div[2]/input)[2]")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(Keys.ENTER);
    Thread.sleep(8000);
    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/div[1]/following-sibling::table//td[text()[contains(.,'Class_BCRM')]]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[@class='dw-name' and text()[contains(.,'Educator')]]")).click(); // Click educator
	Thread.sleep(5000);
	
	List<WebElement> teacher = driver.findElements(By.xpath("//div[@id='teacher']//table[@class='table table-bordered table-custom']//tr/td/span"));
	Thread.sleep(2000);
	
	
	for (int i= 0 ; i<teacher.size() ; i++)
 {
	System.out.println(teacher.get(i).getText());
	System.out.println(e.get(i));
	Assert.assertEquals(teacher.get(i).getText(),e.get(i));
	
 }
	driver.findElement(By.xpath("//span[@class='dw-name' and text()[contains(.,'Educator')]]")).click(); // Click educator
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//span[@class='dw-name' and text()[contains(.,'Volunteer')]]")).click(); // Volunteer section arrow
	Thread.sleep(2000);
	List<WebElement> Volunteer = driver.findElements(By.xpath("//div[@id='volunteer']//table[@class='table table-bordered table-custom']//tr/td/span"));
	
	for (int j= 0 ; j<Volunteer.size() ;j++)
	
	{
	System.out.println(Volunteer.get(j).getText());	
	System.out.println(f.get(j));
	Assert.assertEquals(Volunteer.get(j).getText(),f.get(j));

	}
		
	driver.findElement(By.xpath("//*[@id='enrollmentDiv']/div/div[1]/button")).click(); //close button
	}}
