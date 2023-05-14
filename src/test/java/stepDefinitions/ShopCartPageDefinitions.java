package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import pages.ShopCartPage;

public class ShopCartPageDefinitions {

	@Steps
	ShopCartPage shopcartPage;

	@Given("User is on Shop Cart page")
	public void openProductPage() {
		shopcartPage.navigateToCartPage();
	}

	@And("User verifies cart page of name and price {string} {string}")
	public void userVerifiesProductAndValue(String cartdesc, String cartprice) {
		shopcartPage.verifyCartDescription(cartdesc);
		shopcartPage.verifyCartPrice(cartprice);
	}

	@And("User clicks on checkout")
	public void userClicksOnCheckout() {
		shopcartPage.clickCheckoutButton();
	}

}
