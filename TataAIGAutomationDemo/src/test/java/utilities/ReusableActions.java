package utilities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class ReusableActions {
	WebDriver driver;
   
	//Function for Print the steps in allure report
	@Step("{0}")
	 public static void logStep(String stepName ){
	
	 }
	
	//Function for take the screen shot in allure report
	@Attachment("Screenshot")
    public static byte[] attachScreen(WebDriver driver ) {
        logStep("Taking screenshot");
        return (((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
	
	@Attachment("Error_Screenshot")
    public static byte[] attachScreen_TestCaseError(WebDriver driver ) {
        logStep("Taking screenshot");
        return (((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
	
	//Function for provide wait for loader image
	public static void waitforloadingDisable(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("theImg")));
	}
	
	public static void waitforloadingDisableinsuredDetailsPg(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("Img1")));
	}
	
	
	public static void waitforloadingDisableTW(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 600);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("theImg")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("typing_loader")));
	}	
	
	public static void waitforloadingDisablePaymentPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 750);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("theImg")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
	}	
	
	//Wait functions
	public static WebElement waitTillElementVisible(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = wait.until(ExpectedConditions.visibilityOf(element));
		return elementloaded;
	}
	
	public static WebElement waitTillElementTobeLocated(By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return elementloaded;
	}
	
	public static WebElement waitTillElementToBeClickable(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = wait.until(ExpectedConditions.elementToBeClickable(element));
		return elementloaded;
	}
	public static void waitForVisible(WebElement locator) throws Exception {
		Thread.sleep(1000);
		for (int i = 0; i <= 40; i++) {
			try {
				locator.isDisplayed();
				break;

			} catch (Exception e) {
				if (i == 40) {
					throw e;

				} else {
					Thread.sleep(1000);
				}
			}
		}
	}

	public static void waitForVisibleDropdown(List<WebElement> elements) throws Exception {
		Thread.sleep(1000);
		for (int i = 0; i <= 25; i++) {
			try {
				if (elements.size() != 0) {
					break;
				} else {
					throw new Exception("list size is 0");
				}

			} catch (Exception e) {
				if (i == 25) {
					throw e;

				} else {
					Thread.sleep(1000);
					
				}
			}

		}
	}

	//Wait for Page Load
	public static void waitTillPageLoaded(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
		} catch (Throwable error) {

		}
	}
	
	//Click functionality by Java Script
		public static void clickByJS(WebElement el, WebDriver driver) {
			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", el);

			} catch (Exception e) {
				e.getMessage();
			}
		}
		
		//Move to Element Function 
		public static void moveToElement(WebElement element, WebDriver driver) {
	       try{
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
	       }
	       catch(Exception e){
	    	   e.getMessage();
	       }
		}
		
		// Point To Element
		public static void pointToElement(WebElement e1, WebDriver driver){
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", e1);
		}
		
		// Function for provide wait for VerifyPage Title
		public static void verifypageTitle(String str, WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.titleContains(str));
		}
		
		
}
