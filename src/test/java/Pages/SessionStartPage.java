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

public class SessionStartPage {
	
	
	public void verifySessionStart (String UpdatedClassName) throws InterruptedException 
	{
		System.out.println("******Go to My Course->Not Running->To Start the Class****");
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/nav/div/div[2]/ul/li[6]/a")).click(); // My Courses
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[2]/a")).click(); //Not Runnign Course
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='notRunningCourses']/div[16]/div[1]/div/span[1]")).click(); // Explore Drawer
	Thread.sleep(5000);
	driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[3]/div/div[16]/div[2]/div/div/div[1]/div[2]/input")).sendKeys(UpdatedClassName);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[3]/div/div[16]/div[2]/div/div/div[1]/div[2]/input")).sendKeys(Keys.ENTER);
    Thread.sleep(5000);
    driver.findElement(By.xpath(".//*[@id='notRunningCourses']/div[16]/div[2]//table/tbody/tr/td[1]")).click();
    WebElement LabelOfClassStart = driver.findElement(By.xpath(".//*[@id='notRunningCourses']/div[16]/div[2]/div/div/div[1]/div[1]/span/button"));
    String actual = LabelOfClassStart.getText();
    String Expected = "Start in CK";
	System.out.println("******Verfied the Start Button Lable****");
    Assert.assertEquals(actual, Expected);
    System.out.println("******Start the Class****");
    LabelOfClassStart.click();
    Thread.sleep(5000);
	
    driver.findElement(By.xpath(".//*[@id='startClass']")).click();
 
	System.out.println("******Go to My Course->Running Courses****");
    Thread.sleep(5000);
    driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[3]/a")).click();
    driver.findElement(By.xpath("(.//*[@id='runningCourses']//span[starts-with(text(),'JA It')])[4]")).click(); //clicking on ja its my future 16 17
    Thread.sleep(5000);
    driver.findElement(By.xpath(".//*[@id='runningCourses']/div[98]/div[2]/div/div/div[1]/div[3]/input")).sendKeys(UpdatedClassName);
    Thread.sleep(5000);
    driver.findElement(By.xpath(".//*[@id='runningCourses']/div[98]/div[2]/div/div/div[1]/div[3]/input")).sendKeys(Keys.ENTER);
    Thread.sleep(5000);
    //Validate the Class Name and Start Date here
	System.out.println("******Verified the updated Class Name****");
    String ExpClassName = UpdatedClassName;
	String ActualClassName = driver.findElement(By.xpath(".//*[@id='runningCourses']/div[98]//table/tbody/tr[1]/td[2]")).getText();
	
	Assert.assertEquals(ActualClassName, ExpClassName);

	System.out.println("******Verifed the start date after class start****");
	String actstartdate = driver.findElement(By.xpath(".//*[@id='runningCourses']/div[98]//table/tbody/tr[1]/td[5]")).getText();
	System.out.println("actual date is :" + actstartdate);
	
	// Create object of SimpleDateFormat class and decide the format
	 DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	 
	 //get current date time with Date()
	 Date date = new Date();
	 
	 // Now format the date
	 String Expstartdate= dateFormat.format(date);

	 Assert.assertEquals(actstartdate, Expstartdate);
	
		System.out.println("******UnStart the Class***");
	//Unstart the Class
	Thread.sleep(2000);
    driver.findElement(By.xpath(".//*[@id='runningCourses']/div[98]//table/tbody/tr[1]/td[1]/input")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath(".//*[@id='runningCourses']/div[98]/div[2]//div[@class='topButton']/div[2]/span/button")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath(".//*[@id='btnOk']")).click();
    Thread.sleep(5000);
    
	System.out.println("******Go to My Course->Not Running****");
    driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[2]/a")).click(); //Not Runnign Course
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='notRunningCourses']/div[16]/div[1]/div/span[1]")).click(); // Explore Drawer
	Thread.sleep(2000);
	driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[3]/div/div[16]/div[2]/div/div/div[1]/div[2]/input")).sendKeys(UpdatedClassName);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[3]/div/div[16]/div[2]/div/div/div[1]/div[2]/input")).sendKeys(Keys.ENTER);
    Thread.sleep(5000);
    
    String ActualCN= driver.findElement(By.xpath(".//*[@id='notRunningCourses']/div[16]/div[2]//table/tbody/tr[1]/td[2]")).getText();
	 String ExpClassName1 = UpdatedClassName;
		System.out.println("******Verfied the updated class name****");
		Assert.assertEquals(ActualCN, ExpClassName1);

	
		
		


	}}
