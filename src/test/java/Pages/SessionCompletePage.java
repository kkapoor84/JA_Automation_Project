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
		driver.findElement(By.xpath(".//*[@id='notRunningCourses']/div[16]/div[1]/div/span[1]")).click(); // Explore Drawer
		Thread.sleep(5000);
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[3]/div/div[16]/div[2]/div/div/div[1]/div[2]/input")).sendKeys(UpdatedClassName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[3]/div/div[16]/div[2]/div/div/div[1]/div[2]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='notRunningCourses']/div[16]/div[2]//table/tbody/tr[1]/td[1]")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='notRunningCourses']/div[16]/div[2]/div/div/div[1]/div[1]/span/button")).click(); //class start
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='startClass']")).click();
	 
	    System.out.println("*****Go to My Course->Running to Complete the Class ****");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[3]/a")).click(); //RunningCourses
	    driver.findElement(By.xpath("(.//*[@id='runningCourses']//span[starts-with(text(),'JA It')])[4]")).click(); //clicking on ja its my future 16 17
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='runningCourses']/div[98]/div[2]/div/div/div[1]/div[3]/input")).sendKeys(UpdatedClassName);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='runningCourses']/div[98]/div[2]/div/div/div[1]/div[3]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='runningCourses']/div[98]//table/tbody/tr[1]/td[1]/input")).click(); //select the radio button
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='runningCourses']/div[98]/div[2]//div[@class='topButton']/div[1]/span/button")).click(); //class compelte
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//*[@id='btnOk']")).click();
	    Thread.sleep(5000);
	    
	    System.out.println("*****Go to My Course->Complete COurse-> to Incomplete the Class ****");
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[4]/a")).click(); //complete course
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='completedCourses']/div[6]/div[1]/div/span[1]")).click();  //course
		Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='completedCourses']/div[6]/div[2]/div/div/div[1]/div[2]/input")).sendKeys(UpdatedClassName);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='completedCourses']/div[6]/div[2]/div/div/div[1]/div[2]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='completedCourses']/div[6]//table/tbody/tr/td[2]/input")).click(); //select the radio button
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='completedCourses']/div[6]/div[2]//div[@class='topButton']/div[1]/span/button")).click(); // incompelte
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//*[@id='btnOk']")).click();
	    Thread.sleep(5000);
	    
	    System.out.println("*****Go to My Course->Rnning->Tpo verify the incompleted class ****");
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[3]/a")).click(); //RunningCourses
	    driver.findElement(By.xpath("(.//*[@id='runningCourses']//span[starts-with(text(),'JA It')])[4]")).click(); //clicking on ja its my future 16 17
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='runningCourses']/div[98]/div[2]/div/div/div[1]/div[3]/input")).sendKeys(UpdatedClassName);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='runningCourses']/div[98]/div[2]/div/div/div[1]/div[3]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);
	    
	    String ActCLassname= driver.findElement(By.xpath(".//*[@id='runningCourses']/div[98]//table/tbody/tr[1]/td[2]")).getText();
	    String ExpClassname=UpdatedClassName;
	    Assert.assertEquals(ActCLassname, ExpClassname);
	    


	}}
