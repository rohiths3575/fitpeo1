package fitpeo;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.pages.HomePageFactory;
import com.pages.RevenuePageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssesmentSteps {
	
	WebDriver driver=new FirefoxDriver();
	HomePageFactory hp=new HomePageFactory(driver);
	RevenuePageFactory rv=new RevenuePageFactory(driver);
	@Given("user should be in website")
	public void user_should_be_in_website() {
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("user clicks on Revenue Calculator")
	public void user_clicks_on_revenue_calculator() {
		hp.revenuePage();
	}

	@When("user moves to scroller and sets number Total Individual Patient\\/Month")
	public void user_moves_to_scroller_and_sets_number_total_individual_patient_month() {
		try {
			String actvalue=	rv.SlideSlider();
			String realvalue="820";
			Assert.assertEquals(actvalue,realvalue);
		}
		catch (StaleElementReferenceException e) {
		String actvalue=	rv.SlideSlider();
			String realvalue="820";
			Assert.assertEquals(actvalue,realvalue);
		}
	}

	@When("user checks the scroller by manually entering the value {string}")
	public void user_checks_the_scroller_by_manually_entering_the_value(String string) {
		rv.EnterValue(string);
	}
	
	@When("user refreshes the page")
	public void user_refreshes_the_page() {
		driver.navigate().refresh();
	}
	
	@When("user sets value again to eight twenty")
	public void user_sets_value_again_to_eight_twenty() {
		try {
			rv.SlideSlider();
			
		}
		catch (StaleElementReferenceException e) {
				rv.SlideSlider();
			
		}
	}
	
	@When("user checks the boxes with CPT values of his choice")
	public void user_checks_the_boxes_with_cpt_values_of_his_choice() {
	    rv.CheckBox();
	}

	@Then("user verifies the value of Total Recurring Reimbursement")
	public void user_verifies_the_value_of_total_recurring_reimbursement() {
		String t=rv.VerifyTRR();
		String act_t="$110700";
		Assert.assertEquals(t, act_t);
	}

	@Then("closes the window")
	public void closes_the_window() {
		driver.close();
		}

}
