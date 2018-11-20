package Pages;
import static Base.DriverSetup.driver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CarryForwardPage {
	
	
	public void verifyCarryForwardFucntionality (String UpdatedClassName) throws InterruptedException 
	{
		System.out.println("*****Go to My Course->CaryForward ****");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/nav/div/div[2]/ul/li[6]/a")).click(); // My Courses
		 Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[6]/a")).click(); //CarryForward
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(UpdatedClassName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(Keys.ENTER);

	    Thread.sleep(8000);
	    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/div[1]/following-sibling::table//td/input[@type='checkbox']")).click();  //select the radio button
	    Thread.sleep(5000);
	    System.out.println("*****Go to My Course->CaryForward ->Add element to repositroy****");
	    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/parent::div/div/div[3]/button[@id='btnAddToRepository']")).click(); //Add To Repository
	    Thread.sleep(5000);

	   List<WebElement> listofcolumn= driver.findElements(By.xpath(".//*[@id='CarryForwardCourses']/div[1]/div[2]/div[2]/table/thead/tr/th"));
	   int actualnoofcolumn = listofcolumn.size();
	    int expnoofcolumn=11;
	    System.out.println("*****Go to My Course->CaryForward->Verfied the number of column in repository ****");
	    Assert.assertEquals(actualnoofcolumn, expnoofcolumn); //Verified the number of column
	    		
	   String actualcolumn1 = listofcolumn.get(9).getText();
	   String columnname1="Status";
	   System.out.println("*****Go to My Course->CaryForward->Verifed the status column added ****");  		
	    Assert.assertEquals(actualcolumn1, columnname1); //Verified the status column added
	    
	    List<WebElement> ValueofColumn= driver.findElements(By.xpath(".//*[@id='CarryForwardCourses']/div[1]/div[2]/div[2]/table/tbody/tr/td"));
	    String ActualClassName= ValueofColumn.get(1).getText();
	    String ExpectedClassName=UpdatedClassName;
	    System.out.println("*****Go to My Course->CaryForward Verified the same class added into respository****");
	    Assert.assertEquals(ActualClassName, ExpectedClassName); //Verified the same class is added into the reporsitory
	     
	    Thread.sleep(5000);
	    System.out.println("*****Go to My Course->CaryForward >remove the class****");
	    driver.findElement(By.xpath(".//a[text()='Remove']")).click(); //remove 
	    Thread.sleep(2000);
	    driver.navigate().refresh();
	    Thread.sleep(2000);
	    System.out.println("*****Go to My Course->CaryForward->Add the class to repository ****");
	    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(UpdatedClassName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(Keys.ENTER);


	    Thread.sleep(5000);
	    System.out.println("******Verified the updated Class Name****");
	    String ExpClassName = UpdatedClassName;
		String ActualClassName2 = driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/div[1]/following-sibling::table//td[text()[contains(.,'Demo')]]")).getText();
		
		Assert.assertEquals(ActualClassName2, ExpClassName);
	    
	    Thread.sleep(5000);

	    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/div[1]/following-sibling::table//td/input[@type='checkbox']")).click();  //select the radio button
	    Thread.sleep(5000);
	    System.out.println("*****Go to My Course->CaryForward ->Add element to repositroy****");
	    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/parent::div/div/div[3]/button[@id='btnAddToRepository']")).click(); //Add To Repository
	    Thread.sleep(5000);

	    
	    WebDriverWait wd = new WebDriverWait(driver,10);
	    wd.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath(".//button[text()='Carry Forward']"))));
	    
	    System.out.println("*****Go to My Course->CaryForward ->Carry forward the class****");
	    driver.findElement(By.xpath(".//button[text()='Carry Forward']")).click(); //carryforward button
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//*[@id='successBox']/div/div/div[1]/button")).click(); //close popup
	    Thread.sleep(5000);
    
	    System.out.println("*****Go to My Course->CaryForward->Verify the carry forwarded class is not present ****");
	/*    
	   Thread.sleep(5000);
	    System.out.println("*****Go to My Course->CaryForward ->Verified that class is not present in carry forward screen****");
	    driver.findElement(By.xpath("//*[@id='archivedCourseList']/div[1]//div[text()='No record found']")).isDisplayed();

	    WebElement w= driver.findElement(By.xpath("//*[@id='archivedCourseList']/div[1]//div[text()='No record found']"));
	    */
	   
	    /* Verifying the EEnd Date in  Running Courses */
	   System.out.println("*****Go to My Course-->Running->Verified the end date after carryforward ****");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[3]/a")).click(); //RunningCourses
	    driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(UpdatedClassName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//input[@placeholder='Search Class']")).sendKeys(Keys.ENTER);

	    Thread.sleep(5000);
	    System.out.println("******Verified the Carryforwardenddate****");
	    String ExpectedEndDate ="08-15-2020";
		String CarryforwardEdnDate = driver.findElement(By.xpath("//span[text()[contains(.,'My Future 16-17')]]/parent::div/parent::div/following-sibling::div//div[@id='dvtable']/div[1]/following-sibling::table//td[6]")).getText();

	    Assert.assertEquals(CarryforwardEdnDate, ExpectedEndDate);
	    


	}}
