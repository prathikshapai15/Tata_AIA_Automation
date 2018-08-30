package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LifeInsurancePlans 
{
	@FindBy(xpath="//*[@id=\"indexmaindiv\"]/div/section/div[3]/div/div/div[1]/ul/li[1]/div[3]/a[1]")
	WebElement QuickQuote;
	
	WebDriver driver;

	public LifeInsurancePlans(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void setQuickQuote()
	{
		QuickQuote.click();
	}
	
}
