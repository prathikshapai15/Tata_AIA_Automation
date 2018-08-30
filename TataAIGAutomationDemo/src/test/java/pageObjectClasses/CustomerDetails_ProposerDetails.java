package pageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import readExcel.ReadExcelFile;
import utilities.ReusableActions;

public class CustomerDetails_ProposerDetails 
{
	@FindBy(name="firstName")
	WebElement FirstName;

	@FindBy(name="lastName")
	WebElement LastName;

	@FindBy(name="gender")
	WebElement Gender;

	@FindBy(name="dob")
	WebElement DateOfBirth;

	@FindBy(name="email")
	WebElement Email;

	@FindBy(name="mobile")
	WebElement Mobile;

	@FindBy(name="add1")
	WebElement Address1;

	@FindBy(name="landmark")
	WebElement Landmark;

	@FindBy(name="state")
	WebElement State;

	@FindBy(name="city")
	WebElement City;

	@FindBy(name="zip")
	WebElement Zip;

	@FindBy(xpath="//input[@value='Submit']")
	WebElement Submit;

	WebDriver driver;

	public CustomerDetails_ProposerDetails(WebDriver driver) 
	{
		this.driver=driver;
	}

	//FirstName
	public void setFirstname(String testCaseSheetName, int testcaseRowId) throws Exception 
	{
		String strFirstName = ReadExcelFile.readDatafromExcel_CI(testCaseSheetName, testcaseRowId, 0);
		ReusableActions.waitTillElementVisible(FirstName, driver);
		FirstName.sendKeys(strFirstName);
	}

	//LastName
	public void setLastname(String testCaseSheetName, int testcaseRowId) throws Exception 
	{
		String strLastName = ReadExcelFile.readDatafromExcel_CI(testCaseSheetName, testcaseRowId, 1);
		ReusableActions.waitTillElementVisible(LastName, driver);
		LastName.sendKeys(strLastName);
	}

	//Gender
	public void setGender(String testCaseSheetName, int testcaseRowId) throws Exception
	{
		String strGender = ReadExcelFile.readDatafromExcel_CI(testCaseSheetName, testcaseRowId, 2);
		Select genderdropdown = new Select(Gender);
		List<WebElement> select2Options = genderdropdown.getOptions();
		for (WebElement options:  select2Options)
		{
			if(strGender.equals(options.getText()))
			{
				options.click();
				break;
			}
		}

	}

	//DateOfBirth
	public void setDateOfBirth(String testCaseSheetName, int testcaseRowId) throws Exception
	{
		String strDateOfBirth = ReadExcelFile.readDatafromExcel_CI(testCaseSheetName, testcaseRowId, 3);
		ReusableActions.waitTillElementVisible(DateOfBirth, driver);
		DateOfBirth.sendKeys(strDateOfBirth);
		System.out.println(strDateOfBirth);
	}

	//Email
	public void setEmail(String testCaseSheetName, int testcaseRowId) throws Exception 
	{
		String strEmail = ReadExcelFile.readDatafromExcel_CI(testCaseSheetName, testcaseRowId, 4);
		ReusableActions.waitTillElementVisible(Email, driver);
		Email.sendKeys(strEmail);
	}

	//Mobile
	public void setMobile(String testCaseSheetName, int testcaseRowId) throws Exception
	{
		String strMobile = ReadExcelFile.readDatafromExcel_CI(testCaseSheetName, testcaseRowId, 5);
		ReusableActions.waitTillElementVisible(Mobile, driver);
		Mobile.sendKeys(strMobile);
	}

	//Address1
	public void setAddress1(String testCaseSheetName, int testcaseRowId) throws Exception
	{
		String strAddress1 = ReadExcelFile.readDatafromExcel_CI(testCaseSheetName, testcaseRowId, 6);
		ReusableActions.waitTillElementVisible(Address1, driver);
		Address1.sendKeys(strAddress1);
	}

	//Landmark
	public void setLandmark(String testCaseSheetName, int testcaseRowId) throws Exception
	{
		String strLandmark = ReadExcelFile.readDatafromExcel_CI(testCaseSheetName, testcaseRowId, 7);
		ReusableActions.waitTillElementVisible(Landmark, driver);
		Landmark.sendKeys(strLandmark);
		System.out.println(strLandmark);

	}

	//State
	public void setState(String testCaseSheetName, int testcaseRowId) throws Exception
	{
		String strState = ReadExcelFile.readDatafromExcel_CI(testCaseSheetName, testcaseRowId, 8);
		Select statedropdown = new Select(State);
		List<WebElement> select12Options = statedropdown.getOptions();
		for (WebElement options:  select12Options)
		{
			if(strState.equals(options.getText()))
			{
				options.click();
				break;
			}
		}

	}

	//City
	public void setCity(String testCaseSheetName, int testcaseRowId) throws Exception
	{
		String strCity = ReadExcelFile.readDatafromExcel_CI(testCaseSheetName, testcaseRowId, 9);
		Select citydropdown = new Select(City);
		List<WebElement> select12Options = citydropdown.getOptions();
		for (WebElement options:  select12Options)
		{
			if(strCity.equals(options.getText()))
			{
				options.click();
				break;
			}
		}

	}

	//Zip
	public void setZip(String testCaseSheetName, int testcaseRowId) throws Exception
	{
		String strZip = ReadExcelFile.readDatafromExcel_CI(testCaseSheetName, testcaseRowId, 10);
		ReusableActions.waitTillElementVisible(Zip, driver);
		Zip.sendKeys(strZip);;
	}

	//Submit Button
	public void setSubmit()
	{
		ReusableActions.waitTillElementToBeClickable(Submit, driver);
		Submit.click();
	}

	public void setData_CustomerDetails(String testCaseSheetName, int testcaseRowId) throws Exception
	{
		setFirstname(testCaseSheetName, testcaseRowId);
		setLastname(testCaseSheetName, testcaseRowId);
		setGender(testCaseSheetName, testcaseRowId);
		setDateOfBirth(testCaseSheetName, testcaseRowId);
		setEmail(testCaseSheetName, testcaseRowId);
		setMobile(testCaseSheetName, testcaseRowId);
		setAddress1(testCaseSheetName, testcaseRowId);
		setLandmark(testCaseSheetName, testcaseRowId);
		setState(testCaseSheetName, testcaseRowId);
		setCity(testCaseSheetName, testcaseRowId);
		setZip(testCaseSheetName, testcaseRowId);
		setSubmit();
	}


}
