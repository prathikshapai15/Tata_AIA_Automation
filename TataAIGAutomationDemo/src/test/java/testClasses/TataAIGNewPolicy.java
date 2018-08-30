package testClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjectClasses.CustomerDetails_ProposerDetails;
import pageObjectClasses.LifeInsurancePlans;
import pageObjectClasses.QuickCalculator;

public class TataAIGNewPolicy 
{
	WebDriver driver;
	
	CustomerDetails_ProposerDetails customerdetails;
	LifeInsurancePlans lifeinsuranceplan;
	QuickCalculator quickcalculator;
	
	@BeforeMethod
	public void beforeMethod() 
	{
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://sellonlineuat.tataaia.com/wps/PA_TATAAIA_SO/CampaignRedirection?campaign=HB1");
		
		customerdetails = PageFactory.initElements(driver, CustomerDetails_ProposerDetails.class);
		lifeinsuranceplan = PageFactory.initElements(driver, LifeInsurancePlans.class);
		quickcalculator = PageFactory.initElements(driver, QuickCalculator.class);
	}
	
	@Test
	public void tc_E2E_NewPolicyFunctionality() throws Exception 
	{
		customerdetails.setData_CustomerDetails("CustomerDetailsSheet", 1);
		lifeinsuranceplan.setQuickQuote();
		quickcalculator.setProceed();
		quickcalculator.setData("CustomerDetailsSheet", 1);
	}
	
	@AfterMethod
	public void afterMethod() 
	{
		
		
	}
}
