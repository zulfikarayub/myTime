package stepDefinitions;

import Cucumber.CucumberAutomation.BaseTest;
import Cucumber.CucumberAutomation.MyTimeHomePage_Validations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class MyTimeHomePage_StepDefinition extends BaseTest {

    // WebDriver driver = getDriver();
    String strURL = getProperty("URL");
    MyTimeHomePage_Validations fb = new MyTimeHomePage_Validations(strURL);


    @Given("^User is on the Mytime HomePage$")
    public void userIsOnTheMytimeHomePage() {

        fb.validateHOmePage();
    }

    @Given("user Search for {string} in {string}")
    public void user_search_for_in(String TypeService, String Location) {
        fb.searchServiceAndLocation(TypeService, Location);
    }


    @And("Verify that multiple results are shown {int}")
    public void verify_that_multiple_results_are_shown(Integer int1) {
        fb.searchResultCount(int1);
    }

    @Given("Open business with name {string}")
    public void open_business_with_name(String Busniness) {
        fb.ValidateBusinessName(Busniness);
    }

    @When("user Select {string} in the services filter from the left panel")
    public void user_select_in_the_services_filter_from_the_left_panel(String servType) {
        fb.selectServiceType(servType);
    }

    @When("user Select second staff from the staff filter in the left side panel")
    public void user_select_second_staff_from_the_staff_filter_in_the_left_side_panel() {
        fb.selectSecondStaff();
    }

    @When("user Click the Book button for the 'Men's Haircut' service")
    public void user_click_the_book_button_for_the_men_s_haircut_service() {
        fb.clickHairCutBookButton();
    }

    @When("user Press Select Time in the add-on modal opened")
    public void user_press_Select_Time_in_the_add_on_modal_opened() {
        fb.clickSelectTimeButton();
    }

    @Then("Verify that the user is presented with a list of available time slots with at least {int} entries")
    public void verify_that_the_user_is_presented_with_a_list_of_available_time_slots_with_at_least_entries(Integer int1) {
        fb.timeSlotAvailableCheck(int1);
    }

    @Then("verify 'Men's Haircut' is displayed with service price and staff name")
    public void verify_men_s_haircut_is_displayed_with_service_price_and_staff_name() {
        fb.appointmentConfirmationCheck();
    }
}
