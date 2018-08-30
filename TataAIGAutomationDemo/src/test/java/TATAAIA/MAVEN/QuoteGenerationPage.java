package TATAAIA.MAVEN;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuoteGenerationPage 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		String strurl = "https://sellonlineuat.tataaia.com/wps/portal/TATAAIA/TATAAIA_SO#!/sis-generation/quote-generation"; 
		driver.get(strurl);	
		
		//clicking Save and Proceed button in Plan Details section
		WebElement objSaveProceedPlanDetails = driver.findElement(By.xpath("//*[@id=\"st_accordion\"]/div[1]/div[3]/input"));
		objSaveProceedPlanDetails.click();
		
		//clicking Save and Proceed button in Riders Details section
		WebElement objSaveProceedRidersDetails = driver.findElement(By.xpath("//*[@id=\"st_accordion\"]/div[2]/form/div[3]/input[1]"));
		objSaveProceedRidersDetails.click();
		
		//clicking Save and Proceed button in Other Details section
		WebElement objSaveProceedOtherDetails = driver.findElement(By.xpath("//*[@id=\"st_accordion\"]/div[3]/form/div[2]/input"));
		objSaveProceedOtherDetails.click();
		
		//clicking InsuredOTP button 
		WebElement objInsuredOTP = driver.findElement(By.xpath("//*[@id=\"st_accordion\"]/div[4]/div[2]/input[1]"));
		objInsuredOTP.click();
		
		//switching to alert message and entering the OTP
		driver.switchTo().alert().sendKeys("2468");
		
		//clicking on Validate button on the alert message.
		WebElement objValidate = driver.findElement(By.xpath("//*[@id=\"insuredPopUp\"]/div/div/form/div/div/input"));
		objValidate.click();
		
		
		

	}

}
