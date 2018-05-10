package Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.json.JSONException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.DriverSetup;
import Pages.AP2SessionEnv;
import Pages.AP3SessionUpdate;
import Pages.API1PostMethodStringVerification;
import Pages.AccountLogin;
import Pages.ApproveRequestPage;
import Pages.CarryForwardPage;
import Pages.DatabasePage;
import Pages.SessionCompletePage;
import Pages.SessionEnviormentAddPage;
import Pages.SessionEnviormentUpdatePage;
import Pages.SessionStartPage;

public class APITest {
	public API1PostMethodStringVerification PMObject;
	public ApproveRequestPage  ARObject1;
	public DriverSetup  DSObject ;
	public  AccountLogin ALObject;
	public DatabasePage  dbobject;
	public AP2SessionEnv SEobject;
	public AP3SessionUpdate SUobject;
	public SessionEnviormentAddPage SEPObject;
	public SessionEnviormentUpdatePage SEUObject;
	public SessionStartPage SSPObject;
	public SessionCompletePage SCPObject;
	public CarryForwardPage CFPObject;
	String classId;
	int random;
	
	
	@BeforeClass
	public void initDriver(){
		PMObject = new API1PostMethodStringVerification();
		DSObject =  new DriverSetup();
		 ALObject = new AccountLogin();
		 ARObject1 = new ApproveRequestPage();
		 dbobject =  new DatabasePage();
	 SEobject = new AP2SessionEnv();
	 SUobject = new AP3SessionUpdate();
	 SEPObject =new SessionEnviormentAddPage();
	 SEUObject = new SessionEnviormentUpdatePage();
	 SSPObject= new SessionStartPage();
	 SCPObject = new SessionCompletePage();
	 CFPObject= new CarryForwardPage();
	 
	 
	 classId = dbobject.getClassID();
	 random = dbobject.generateRandomNumber();
	}
	
	@AfterClass(alwaysRun = true)
	public void deleteRecord()
	{	
	dbobject.DeleteRecord(classId);
	DSObject.driver.quit();
	}

		
 @Test (priority=1)
	 
	public void courseRequestAPI() throws InterruptedException
	{

	 PMObject.httpPost(classId);
		
	} 


	@Test (priority=2)
	
	public void openURL() throws IOException, InterruptedException
	{
		ALObject.LoginSetup();
	}
	
	 @Test (priority=3)
	
	public void requestApprovalpage() throws InterruptedException, IOException
	{
		ARObject1.CourseApprove();
	}
	
	 @Test (priority=4)
	
	public void dbQuery() throws SQLException
	{
	
		dbobject.dbConnection(random);
	}
	
	 @Test (priority=5)
	public void runApiUerEnv() throws JSONException, InterruptedException
	{
		
		SEobject.httpPost2(classId);
	}
	
	@Test (priority=6)
	public void verifyAddEnv() throws JSONException, InterruptedException
	{
		
		List<String> ExpectedResultEducator = Arrays.asList("super","admin","tom.landsness@ja.org","super.admin");
		List<String> ExpectedResultVolunteer = Arrays.asList("k","Volunteer","k.Volunteer@3pillarglobal.com","k.volunteer");
		SEPObject.verifyAddEnvDetails(ExpectedResultEducator,ExpectedResultVolunteer,random);

	}
	
	
	@Test (priority=7)
	public void runApiSessionUpdate() throws JSONException, InterruptedException
	{
		
		SUobject.httpPost3(classId);
	}
	
	
	@Test (priority=8)
	public void verifyUpdateEnv() throws JSONException, InterruptedException
	{
		SEUObject.verifyUpdateEnvDetails("DemoAutomationClass");
	}
	
	
	

	

	@Test (priority=9)
	public void verifySessionStartUnStart() throws Exception
	{
		SSPObject.verifySessionStart ("DemoAutomationClass");
	}
	
	@Test (priority=10)
	public void verifyStartDateInDB() throws Exception
	{
		dbobject.VerifyStartDate(classId);
	}
	
	@Test (priority=11)
	public void verifyCompleteDate() throws Exception
	{
		SCPObject.verifySessionComplete("DemoAutomationClass");
	}
	
	@Test (priority=12)
	public void verifyCarryForward() throws Exception
	{
		CFPObject.verifyCarryForwardFucntionality("DemoAutomationClass");
	}

}
