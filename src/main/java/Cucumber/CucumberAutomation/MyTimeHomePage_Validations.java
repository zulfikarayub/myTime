package Cucumber.CucumberAutomation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyTimeHomePage_Validations extends BaseTest {

    int searchCount;
    String staffName, serviceTypeName, serviceDuration, servicePrice;


    @FindBy(xpath = "//div[@class='main-container ']//form//*[@id='search-query']")
    WebElement homePgBusinessName;

    @FindBy(xpath = "//div[@class='main-container ']//form//*[@id='search-location']")
    WebElement homePgLocation;

    @FindBy(xpath = "//div[@class='main-container ']//form//button[text()='Search']")
    WebElement homePgLSearchBtn;

    @FindBy(xpath = "//ul[@id='results']//li")
    List<WebElement> searchItemResult;

    @FindBy(xpath = "//section[@class='staff-member']//label")
    List<WebElement> staffMemberCount;

    @FindBy(xpath = "//h4[text()='Haircut']/..//span[contains(text(),'Men')]")
    WebElement menHairCutSelection;

    @FindBy(xpath = "//h4[text()='Haircut']/..//span[contains(text(),'Men')]/../..//span[contains(@class,'variation-duration')]")
    WebElement menHairCutSelectionTime;

    @FindBy(xpath = "//h4[text()='Haircut']/..//span[contains(text(),'Men')]/../..//span[contains(@class,'variation-price')]")
    WebElement menHairCutSelectionRate;

    @FindBy(xpath = "//h4[text()='Haircut']/..//span[contains(text(),'Men')]/../../..//button[text()='book']")
    WebElement menHairCutSelectionBookButton;

    @FindBy(xpath = "//div[contains(@class,'panel modal-container')]//button[text()='Select Time']")
    WebElement selectTimeButton;

    @FindBy(xpath = "//div[contains(@class,'open-times-list')]/div")
    List<WebElement> timeSlotsCheck;

    @FindBy(xpath = "//p[text()='Sorry, there are no appointments for this date.']")
    WebElement noTimeSlot;

    @FindBy(xpath = "//p/button[text()='Go to the next available date']")
    WebElement selectNxtAvailDate;

    @FindBy(xpath = "//div[@class='appointment-preview-wrapper']//span[contains(@class,'variation-name')]")
    WebElement appointmentServiceName;

    @FindBy(xpath = "//div[@class='appointment-preview-wrapper']//span[contains(@class,'normal-price')]")
    WebElement appointmentServicePrice;

    @FindBy(xpath = "//div[@class='appointment-preview-wrapper']//div[@class='Select-value']/span")
    WebElement selectedStaffName;


    public MyTimeHomePage_Validations(String strURL) {
        driver.get(strURL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void validateHOmePage() {
        String pageTitle, expectedPgTitle = "Open Appointments for Massages, Haircuts, Dentists, Yoga and more - MyTime";
        try {

            pageTitle = driver.getTitle();
            System.out.println(pageTitle);
            Assert.assertEquals(expectedPgTitle, pageTitle);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void searchServiceAndLocation(String typeService, String location) {

        try {
            homePgBusinessName.clear();
            homePgBusinessName.sendKeys(typeService);
            homePgLocation.clear();
            homePgLocation.sendKeys(location);
            homePgLSearchBtn.click();

            System.out.println(typeService + "    " + location);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public int searchResultCount(int count) {

        try {
            searchCount = searchItemResult.size();
            if (searchCount >= count) {
                System.out.println("more or equal to " + count + " result has been displayed");
            } else {
                System.out.println("less than " + count + " result has been displayed");
                Assert.fail();
            }
            return searchCount;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
        return count;
    }

    public void ValidateBusinessName(String ExpectedBusinessName) {

        try {
            WebElement hairShop = driver.findElement(By.xpath("//ul[@id='results']//li//a[contains(text(),'" + ExpectedBusinessName + "')]"));
            Assert.assertTrue(hairShop.isDisplayed());
            System.out.println("Expected Shop is Displayed");
            hairShop.click();


        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void selectServiceType(String ExpectedServiceType) {

        try {
            WebElement serviceTyp = driver.findElement(By.xpath("//span[contains(text(),'" + ExpectedServiceType + "')]"));
            Assert.assertTrue(serviceTyp.isDisplayed());
            System.out.println("Service Type is Displayed");
            serviceTyp.click();


        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public String selectSecondStaff() {

        try {

            staffMemberCount.get(2).click();
            staffName = driver.findElement(By.xpath("(//section[@class='staff-member']//label/span)[3]")).getText().toString();
            System.out.println(staffName);


        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
        return staffName;
    }

    public String clickHairCutBookButton() {

        try {
            serviceTypeName = menHairCutSelection.getText().toString();
            serviceDuration = menHairCutSelectionTime.getText().toString();
            servicePrice = menHairCutSelectionRate.getText().toString();

            System.out.println("service name is " + serviceTypeName + " with duration of " + serviceDuration + " and with price " + servicePrice);
            menHairCutSelectionBookButton.click();
            System.out.println("Book button has been clicked");


        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
        return staffName;
    }

    public String clickSelectTimeButton() {

        try {
            selectTimeButton.click();
            System.out.println("Select Time button has been clicked");


        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
        return staffName;
    }

    public int timeSlotAvailableCheck(int count) {
        int timeCountCheck;

        try {

            if (noTimeSlot.isDisplayed()) {
                System.out.println("NO time availability for the date");
                selectNxtAvailDate.click();
                System.out.println("Next available date is selected");

            }
            Thread.sleep(2000);

            timeCountCheck = timeSlotsCheck.size();
            if (timeCountCheck >= count) {
                System.out.println("more or equal to " + count + " result has been displayed");
            } else {
                System.out.println("less than " + count + " result has been displayed");

            }
            return searchCount;


        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
        return count;
    }

    public String appointmentConfirmationCheck() {
        String actualServiceName, actualServicePrice, actualStaffName;

        try {
            actualServiceName = appointmentServiceName.getText();
            actualServicePrice = appointmentServicePrice.getText();
            actualStaffName = selectedStaffName.getText();
            Assert.assertTrue(actualServiceName.equalsIgnoreCase(serviceTypeName));
            Assert.assertTrue(actualServicePrice.equalsIgnoreCase(servicePrice));
            Assert.assertTrue(actualStaffName.equalsIgnoreCase(staffName));


        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
        return staffName;
    }


}
