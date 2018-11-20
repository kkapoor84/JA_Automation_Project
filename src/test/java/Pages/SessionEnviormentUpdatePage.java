package Pages;
import static Base.DriverSetup.driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SessionEnviormentUpdatePage {
	
	
	public void verifyUpdateEnvDetails (String UpdatedClassName) throws InterruptedException 
	{
		
		System.out.println("******Go to My Course->Not Running> to Verify the updated value****");
	driver.navigate().refresh();
	Thread.sleep(5000);
	//driver.findElement(By.xpath("(.//*[@id='notRunningCourses']//span[starts-with(text(),'JA It')])[2]")).click(); // Explore Drawer
	driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(UpdatedClassName);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(Keys.ENTER);

    Thread.sleep(2000);
    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/div[1]/following-sibling::table//td[text()[contains(.,'Demo')]]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath(".//*[@id='dvEnrolledUser']/div[1]/div[1]/div[1]/span[1]")).click(); //Location section
/*    Thread.sleep(2000);
    String ExpSchoolLocation = "DIOCESE OF BIRMINGHAM ED OFF , 2121 3RD AVE N , BIRMINGHAM , AL - 35203";
    String ActSchoolLocation = driver.findElement(By.xpath(".//*[@id='dvEnrolledUser']/div[1]/div[2]/div/div/div[1]/div[1]")).getText(); 
	Assert.assertEquals(ActSchoolLocation, ExpSchoolLocation);
	System.out.println("SchoolLocartion is updated");*/
	Thread.sleep(2000);
	WebElement Radiobutton = driver.findElement(By.xpath(".//*[@id='dvEnrolledUser']//div[@id='sessionMetadataDiv']//div[6]//span[@id='spanDeliveryModel']//div/label[2]/input"));
    Assert.assertEquals(Radiobutton.isSelected(), true);   
	System.out.println("JAID is selected");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='enrollmentDiv']/div/div[1]/button")).click();

	
	}}
