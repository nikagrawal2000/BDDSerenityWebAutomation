package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.ProductPage;

public class ProductPageDefinitions {
	
	 @Steps
	 ProductPage productPage;
	
	
	@Given("User is on Product page")
    public void openProductPage() {
		productPage.navigateToProductPage();
    }
	
	@When("User enters search as {string}")
	public void enterTextInSearchAndClickSearch(String search) {
		productPage.enterSearchTerm(search);
		productPage.clickOnSearchButton();
	}
	
	@And("User selects product of value {string}")
	public void userSelectsProductWithValue(String value ) {
		productPage.selecProductByValue(value);
		productPage.waitTillPopupVisible();
		productPage.clickOnViewCart();
	}

}
