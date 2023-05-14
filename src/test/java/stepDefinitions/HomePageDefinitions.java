package stepDefinitions;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import pages.HomePage;

public class HomePageDefinitions {

	@Steps
	HomePage homePage;

	@Given("User Launches Application")
	public void openApplication() {
		homePage.open();
	}

	@Given("Home Page is displayed")
	public void verifyHomePageIsDisplayed() {
		homePage.homePageVerify();
	}

}
