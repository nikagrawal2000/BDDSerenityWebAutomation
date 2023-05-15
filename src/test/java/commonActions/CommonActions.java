package commonActions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.slf4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.PageObject;

public class CommonActions extends PageObject {

	private static final Logger logger = LoggerFactory.getLogger(CommonActions.class);
	private WebElement webElement;

	public Logger getLogger() {
		return logger;
	}

	public WebElement findElement(By locator) {
		try {
			webElement = getDriver().findElement(locator);
		} catch (Exception e) {
			logger.error("Error while fetching element using locator " + locator.toString());
			e.printStackTrace();
		}
		return webElement;

	}

	public List<WebElement> findElements(By locator) {
		List<WebElement> ele;

		ele = getDriver().findElements(locator);
		if (ele.isEmpty())
			logger.error("Error while fetching element using locator " + locator.toString());

		return ele;

	}

	public void click(By locator) {
		webElement = findElement(locator);
		try {

			webElement.click();
			logger.info("Element Present and clicked successfully ");
		}

		catch (Exception e) {
			logger.error("unable to click on element " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void sendText(By locator, String valueToSend) {
		webElement = findElement(locator);
		try {
			webElement.clear();
			webElement.sendKeys(valueToSend);
			logger.info("Element Present and entered value successfully");
		}

		catch (Exception e) {
			logger.error("error while inputting text on locator " + locator);
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public void enterValue(WebElement webElement, String valueToSend) {
		try {

			webElement.clear();
			webElement.sendKeys(valueToSend);
			logger.info("Element Present and entered value successfully");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void scrollIntoCenterViewOfElement(By locator) {
		WebElement element = findElement(locator);
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) getDriver()).executeScript(scrollElementIntoMiddle, element);
	}

	public void hoverOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void javaScriptClick(WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", ele);
	}

	public void verifyText(By locator, String textToVerify) {
		webElement = findElement(locator);
		assertEquals(webElement.getText().toLowerCase().trim(), textToVerify.toLowerCase().trim());
		logger.info("Message present on screen and verified successfully");

	}

	public void verifyTextContains(By locator, String textToVerify) {
		webElement = findElement(locator);
		assertTrue(webElement.getText().toLowerCase().trim().contains(textToVerify.toLowerCase().trim()));
		logger.info("text contains in the element as expected");

	}

	public void verifyVisibilityOfElement(By locator) {
		try {
			webElement = findElement(locator);
			assertTrue(webElement.isDisplayed());
			logger.info("Element present on screen and verified successfully");
		} catch (Exception e) {
			logger.error("element not found " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void waitForVisibilityOfElement(By locator) {
		WebDriver driver = getDriver();
		WebDriverWait wait = new WebDriverWait(driver, getWaitForTimeout());
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Waited for element and its visible now");
	}

	public void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(getDriver(), getWaitForTimeout());
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}
}
