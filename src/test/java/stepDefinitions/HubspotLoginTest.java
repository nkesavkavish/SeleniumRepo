package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.app.hubspot.factory.DriverFactory;
import com.app.hubspot.pages.HubspotLoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HubspotLoginTest {
	
	private static String title;
	private HubspotLoginPage loginPage = new HubspotLoginPage(DriverFactory.getDriver());
	
	@Given("user is in hubspot application login page")
	public void user_is_in_hubspot_application_login_page() {
	    DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@When("user gets the page title")
	public void user_gets_the_page_title() {
		title = loginPage.getPageTitle();    
	}

	@Then("page title should be {string}")
	public void login_page_title_should_be(String expectedTitle) {
		Assert.assertEquals(expectedTitle, title);
	}
	
	@Then("verify forgot my password link is displayed")
	public void verify_forgot_my_password_link_is_displayed() {
		Assert.assertTrue(loginPage.isForgotPasswordDisplayed());    
	}

	@When("user enter email and password")
	public void user_enter_email_and_password(DataTable credentials) {
	   List<Map<String, String>> data = credentials.asMaps(String.class, String.class);
	   for(Map<String, String> value : data) {
		   loginPage.enterUsername(value.get("email"));
		   loginPage.enterPassword(value.get("password"));
	   }
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
	    loginPage.clickLoginBtn();
	}

}
