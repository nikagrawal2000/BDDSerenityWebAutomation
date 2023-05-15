package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import commonActions.CommonActions;
import net.thucydides.core.annotations.Step;

public class ProductPage extends CommonActions {

	public static By link_ProductPage = By.cssSelector("a[href='/products']");
	public static By txt_ProductPage = By.xpath("//*[@class='features_items']/h2");
	public static By txt_SearchedProducts = By.xpath("//*[@class='features_items']/h2");
	public static By txt_SearchProduct = By.id("search_product");
	public static By btn_Search = By.id("submit_search");
	public static By btn_popupWindow = By.xpath("//*[text()='Close']");
	public static By btn_addToCart = By.xpath("//*[@class='product-overlay']/descendant::*[text()='Add to cart']");
	public static By iframeWindow = By.id("aswift_1");
	public static By modalWindow = By.className("modal-content");

	@Step("Click Products Link")
	public void navigateToProductPage() {
		getDriver().navigate().to(getDriver().getCurrentUrl() + "/products");
		verifyText(txt_ProductPage, "All PRODUCTS");
	}

	@Step("Input Search term")
	public void enterSearchTerm(String search) {
		click(txt_SearchProduct);
		sendText(txt_SearchProduct, search);
	}

	@Step("Click on Search")
	public void clickOnSearchButton() {
		click(btn_Search);
		waitForPageLoad();
	}

	@Step("Verify Searched Products")
	public void verifySearchResultDisplayed() {
		verifyText(txt_SearchedProducts, "SEARCHED PRODUCTS");
	}

	@Step("Select Product By Value")
	public void selecProductByValue(String value) {
		scrollIntoCenterViewOfElement(By.xpath("//h2[contains(text(),'" + value + "')]"));
		hoverOnElement(getDriver(), getDriver().findElement(By.xpath("//h2[contains(text(),'" + value + "')]")));
		waitForVisibilityOfElement(btn_addToCart);
		click(btn_addToCart);
	}

	@Step("Wait Till Continue Shopping Popup is visible")
	public void waitTillPopupVisible() {
		waitForVisibilityOfElement(modalWindow);
	}

	@Step("Click on Continue Shopping")
	public void clickOnContinueShopping() {
		WebElement modalContainer = findElement(modalWindow);
		WebElement modalAcceptButton = modalContainer
				.findElement(By.xpath(".//button[contains(text(),'Continue Shopping')]"));
		modalAcceptButton.click();
		waitForPageLoad();
	}

	@Step("Click on View Cart")
	public void clickOnViewCart() {
		WebElement modalContainer = findElement(modalWindow);
		WebElement modalViewCart = modalContainer.findElement(By.xpath(".//*[contains(text(),'View Cart')]"));
		scrollIntoView(modalViewCart);
		modalViewCart.click();
		waitForPageLoad();
	}

}
