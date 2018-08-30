package TATAAIA.MAVEN;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class CustomerDetailsPage 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Customer Details Page //
		
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Maximizing the window
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		String strurl = "https://sellonlineuat.tataaia.com/wps/PA_TATAAIA_SO/CampaignRedirection?campaign=HB1"; 
		driver.get(strurl);	

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.titleIs("TATAAIA_SO"));
		
		if(driver.getTitle().equals("TATAAIA_SO"))
		{
			System.out.println("Customer Details page is displayed");
		}
		else
		{
			System.out.println("Customer details page is not displayed");
			return;
		}
		
		WebElement ObjFN = driver.findElement(By.name("firstName"));
		WebElement ObjLN = driver.findElement(By.name("lastName"));
		WebElement ObjDOB = driver.findElement(By.name("dob"));
		WebElement ObjEmail = driver.findElement(By.name("email"));
		WebElement ObjMobile = driver.findElement(By.name("mobile"));
		WebElement ObjAddress1 = driver.findElement(By.name("add1"));
		WebElement ObjLandmark = driver.findElement(By.name("landmark"));
		WebElement ObjZip = driver.findElement(By.name("zip"));
	
		if(ObjFN.isDisplayed() && ObjLN.isDisplayed() && ObjDOB.isDisplayed() && ObjEmail.isDisplayed() && ObjMobile.isDisplayed() && ObjAddress1.isDisplayed() && ObjLandmark.isDisplayed() && ObjZip.isDisplayed())
		{
			System.out.println("FirstName / LastName /  DateOfBirth / Email / Mobile / Address / Landmark and zip fields are displayed");
		}
		else
		{
			System.out.println("FirstName / LastName /  DateOfBirth / Email / Mobile / Address / Landmark and zip fields are not displayed");
			return;
		}
		
		String strFN = "sandeep"; 
		String strLN = "gatla"; 
		String strDOB = "31-07-1983";
		String strEmail = "sandeep@monocept.com";
		String strMobile = "9866054327";
		String strAddress1 = "H.No 5-6-81/1";
		String strLandmark = "Alluri Sitarama Raju";
		String strZip = "500040";
		
		ObjFN.sendKeys(strFN);
		ObjLN.sendKeys(strLN);
		
		Select gender = new Select(driver.findElement(By.name("gender")));
		gender.selectByVisibleText("Male");
		
		ObjDOB.sendKeys(strDOB);
		ObjEmail.sendKeys(strEmail);
		ObjMobile.sendKeys(strMobile);
		ObjAddress1.sendKeys(strAddress1);
		ObjLandmark.sendKeys(strLandmark);
		
		Select strState = new Select(driver.findElement(By.name("state")));
		strState.selectByVisibleText("TELANGANA");
		
		Select strCity = new Select(driver.findElement(By.name("city")));
		strCity.selectByVisibleText("HYDERABAD");
		
		ObjZip.sendKeys(strZip);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"cdc.custDetailForm\"]/div[4]/div/input[1]"))));
		wait.until(ExpectedConditions.titleIs("TATAAIA_SO"));
		
		WebElement ObjSubmit = driver.findElement(By.xpath("//*[@id=\"cdc.custDetailForm\"]/div[4]/div/input[1]"));
		if(ObjSubmit.isDisplayed())
		{
			System.out.println("Submit button is displayed");
		}
		else
		{
			System.out.println("Submit button is not displayed");
		}
		
		ObjSubmit.click();		
	
		// Life Insurance Plans Page //
		
		String strLIP = driver.findElement(By.xpath("//*[@id=\"indexmaindiv\"]/div/section/div[3]/div/h1")).getText();
		
		if(strLIP.equals("Life Insurance Plans"))
		{
			System.out.println("We are into Life Insurance Plans page");
		}
		else 
		{
			System.out.println("We are not in Life Insurance Plans page");
			return;
		}
		
		WebElement objQuickQuote = driver.findElement(By.xpath("//*[@id=\"indexmaindiv\"]/div/section/div[3]/div/div/div[1]/ul/li[1]/div[3]/a[1]"));
		if(objQuickQuote.isDisplayed())
		{
			System.out.println("Quick Quote is displayed");
		}
		else
		{
			System.out.println("Quick Quote is not displayed");
		}
		objQuickQuote.click();
		
		// Quick Calculator //
		
		String strQuickCalculator = driver.findElement(By.xpath("//*[@id=\"indexmaindiv\"]/section/div/div/div/h1")).getText();
		
		if(strQuickCalculator.equals("Quick Calculator"))
		{
			System.out.println("We have logged into Quick Calculator page");
		}
		else 
		{
			System.out.println("We did not logged into Quick Calculator page");
		}
		
		//Personal Details Section

		//Proceed button
		WebElement objProceed = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/section/div[3]/div[1]/section/div/div/div/div/div[1]/form/div[5]/input"));
		
		if(objProceed.isDisplayed())
		{
			System.out.println( "Proceed button is displayed");
		}
		else
		{
			System.out.println("Proceed button is not displayed");
		}
		objProceed.click();
		
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"st_accordion\"]/div[2]/form/div[1]/div/div[5]/input"))));
		
		
		
		WebElement objPolicyTerm = driver.findElement(By.name("term"));
	    WebElement objSumAssured = driver.findElement(By.name("sumAssured"));

		 if(objPolicyTerm.isDisplayed() && objSumAssured.isDisplayed())
		 {
			 System.out.println("Policy term / Sum Assured fields are displayed");
		 }
		 else
		 {
			 System.out.println("Policy term / Sum Assured fields are not displayed");
			 return;
		 }

		String strPolicyTerm = "12";
		String strSumAssured = "70000000";
		objPolicyTerm.sendKeys(strPolicyTerm);
		objSumAssured.sendKeys(strSumAssured);
		
		WebElement objBuyNow = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/section/div[3]/div[1]/section/div/div/div/div/div[2]/form/div[2]/div[2]/input"));
		if(objBuyNow.isDisplayed())
		{
			System.out.println("Buy Now button is displayed");
		}
		else
		{
			System.out.println("Buy Now button is not dispalyed");
		}
		
		objBuyNow.click();
		Thread.sleep(5000);
		
		
		if(wait.until(ExpectedConditions.alertIsPresent())==null)
		{
			System.out.println("Alert is not present");
		}
		else
		{
			driver.switchTo().alert();
			String strAlertMessage = driver.switchTo().alert().getText();
			System.out.println(strAlertMessage);
			driver.switchTo().alert().accept();
			objBuyNow.click();
		}
		
		//Personal Details Page//
		
		String strPersonalDetails = driver.findElement(By.xpath("//*[@id=\"indexmaindiv\"]/div/div/section/div/div/div/div/h1")).getText();
		
		if(strPersonalDetails.equals("Personal Details"))
		{
			System.out.println("We have navigated to Personal Details Page");
		}
		else 
		{
			System.out.println("We have not navigated to Personal Details Page");
			return;
		}
		
		//clicking Save and Proceed button in Insurance For section
		WebElement objSaveProceedInsuranceFor = driver.findElement(By.xpath("//*[@id=\"spform.InsuranceFor\"]/div/input"));
		objSaveProceedInsuranceFor.click();
		
		Select strMaritalStatus = new Select(driver.findElement(By.name("maritalStatus")));
		strMaritalStatus.selectByVisibleText("Married");
		
		Select strOccupation = new Select(driver.findElement(By.name("occupation")));
		strOccupation.selectByVisibleText("Agriculturist/Farmer");
		
		WebElement objAnnualIncome = driver.findElement(By.name("insIncome"));
		
		if(objAnnualIncome.isDisplayed())
		{
			System.out.println("Annual Income field is displayed");
		}
		else
		{
			System.out.println("Annual Income field is not displayed");
		}
		
		String strAnnualIncome = "100000";
		objAnnualIncome.sendKeys(strAnnualIncome);
		
		Select strAgeProof = new Select(driver.findElement(By.name("AgeProof")));
		strAgeProof.selectByVisibleText("PAN Card");		
		
		//clicking Save and Proceed button in Insured section
		WebElement objSaveProceedInsured = driver.findElement(By.xpath("//*[@id=\"spform.personalDetails\"]/div[4]/input[2]"));
		objSaveProceedInsured.click();
	
		
		
		
	}
}
