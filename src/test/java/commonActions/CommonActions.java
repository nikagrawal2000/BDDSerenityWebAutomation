package commonActions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.logging.LogManager;

import org.slf4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.PageObject;

public class CommonActions extends PageObject {

	private static final Logger logger =  LoggerFactory.getLogger(CommonActions.class);
	private WebElement webElement;
	
	public Logger getLogger() {
		return logger;
	}
	
	public WebElement findElement(By locator) {
		try {
		webElement = getDriver().findElement(locator);
		}
		catch(Exception e) {
			logger.error("Error while fetching element using locator "+locator.toString());
			throw e;
		}
		return webElement;
		
	}

	public  void click(By locator) {
		webElement = findElement(locator);
		try {

			webElement.click();
			logger.info("Element Present and clicked successfully ");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  void sendText(By locator, String valueToSend) {
		webElement=findElement(locator);
		try {
			webElement.clear();
			webElement.sendKeys(valueToSend);
			logger.info("Element Present and entered value successfully");
		}

		catch (Exception e) {
			logger.error("error while inputting text on locator "+locator);
			logger.error(e.getMessage());
			throw e;
		}
	}

	public  void selectDropdown(WebElement webElement, String valueToSelect) {
		try {
			Select select = new Select(webElement);
			select.selectByVisibleText(valueToSelect);
			logger.info("Element Present and selected vale form dropdown successfully");

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public  void selectDropdownByValue(WebElement webElement, String valueToSelect) {
		try {
			Select select = new Select(webElement);
			select.selectByValue(valueToSelect);
			logger.info("Element Present and selected vale form dropdown successfully");

		}

		catch (Exception e) {
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

	public  void addProductFromList(List<WebElement> elementList, String productName) {
		try {
			for (WebElement ele : elementList) {
				System.out.println(ele.getText());
				if (ele.getText().contains(productName)) {
					JavascriptExecutor jse = (JavascriptExecutor) getDriver();
					jse.executeScript("window.scrollBy(0,501)");
					hoverOnElement(getDriver(), ele);
					break;

				}

			}

			WebElement e = getDriver().findElement(By.xpath("//*[@id='blockbestsellers']//a[contains(text(),'" + productName
					+ "')]/parent::*/following-sibling::*[@class='button-container']/a/span[text()='Add to cart']"));
			e.click();
			logger.info("Element Present and selected matching element successfully");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void addProductFromPopularList(List<WebElement> elementList, String productName) {
		try {
			for (WebElement ele : elementList) {
				System.out.println(ele.getText());
				if (ele.getText().contains(productName)) {
					JavascriptExecutor jse = (JavascriptExecutor) getDriver();
					jse.executeScript("window.scrollBy(0,501)");
					hoverOnElement(getDriver(), ele);
					break;

				}

			}

			WebElement e = getDriver().findElement(By.xpath("//*[@id='homefeatured']//a[contains(text(),'" + productName
					+ "')]/parent::*/following-sibling::*[@class='button-container']/a/span[text()='Add to cart']"));
			e.click();
			logger.info("Element Present and selected matching element successfully");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void waitForInvisibilityOfElement(WebElement ele) { try {
	 * WebDriverWait wait = new WebDriverWait(driver, 10);
	 * wait.until(ExpectedConditions.invisibilityOf(ele)); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

	public void addAndVerifyTotal(List<WebElement> elementList, WebElement totalValue) {
		try {
			double val = 0.0;
			double totalval = 0.0;
			for (WebElement ele : elementList) {
				if (ele.getText().startsWith("$")) {
					val = val + new Double(ele.getText().substring(1));
				} else {
					throw new Exception("not a valid dollar value");
				}
			}
			if (totalValue.getText().startsWith("$")) {
				totalval = new Double(totalValue.getText().substring(1));
			}

			assertEquals(val, totalval, 0);
			logger.info("Total value of product(s) matches successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectMatchedProductFromList(List<WebElement> elementList, String productName) {
		try {
			for (WebElement ele : elementList) {
				if (ele.getText().contains(productName)) {
					javaScriptClick(ele);
					break;
				}

			}
			logger.info("Element Present and selected matching element successfully");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollIntoView(WebElement element) throws InterruptedException {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}

	public  void hoverOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void javaScriptClick(WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", ele);
	}

	public  void verifyText(By locator, String textToVerify) {
		webElement = findElement(locator);
		assertEquals(webElement.getText(), textToVerify);
		logger.info("Message present on screen and verified successfully");

	}

}
