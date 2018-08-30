package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import readExcel.ReadExcelFile;
import utilities.ReusableActions;

public class QuickCalculator 
{
	@FindBy(xpath="//input[@value='Proceed']")
	WebElement Proceed;
	
	@FindBy(name="term")
	WebElement PolicyTerm;
	
	@FindBy(name="sumAssured")
	WebElement SumAssured;
	
	
	WebDriver driver;

	public QuickCalculator(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void setProceed()
	{
		Proceed.click();
	}
	
	//Policy Term
	public void setPolicyTerm(String testCaseSheetName, int testcaseRowId) throws Exception 
	{
		String strPolicyTerm = ReadExcelFile.readDatafromExcel_CI(testCaseSheetName, testcaseRowId, 11);
		ReusableActions.waitTillElementVisible(PolicyTerm, driver);
		PolicyTerm.sendKeys(strPolicyTerm);
	}
	
	//Sum Assured
	public void setSumAssured(String testCaseSheetName, int testcaseRowId) throws Exception 
	{
		String strSumAssured = ReadExcelFile.readDatafromExcel_CI(testCaseSheetName, testcaseRowId, 12);
		ReusableActions.waitTillElementVisible(SumAssured, driver);
		SumAssured.sendKeys(strSumAssured);
	}
	
	public void setData(String testCaseSheetName, int testcaseRowId) throws Exception 
	{
		setPolicyTerm(testCaseSheetName, testcaseRowId);
		setSumAssured(testCaseSheetName, testcaseRowId);
	}
	
	
	
	
}
