package hellocucumber;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class StepDefinitions {
    private WebDriver driver;
    private WebDriver adminDriver;
    private String webDriver = "webdriver.chrome.driver";
    private String webAdminDriver = "webdriver.chrome.driver";
    private String path = "..//Selenium//chromedriver.exe";
    private WebDriverWait AdminWait;


    private void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void scrollAndClick(String xpath, String scrollStr, String message, WebDriver driver){
        // Locate the element link using its XPath
        WebElement element = driver.findElement(By.xpath(xpath));

        // Scroll to the element link
        ((JavascriptExecutor) driver).executeScript(scrollStr, element);

        sleep(1000);

        // Wait for the element link to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        // Click the element link
        element.click();
        System.out.println(message);
    }

    private void clickAndWait(String xpath, String message){
        // Locate and click on element
        WebElement button = adminDriver.findElement(By.xpath(xpath));

        // Wait for element to be visible and clickable
        WebDriverWait wait = new WebDriverWait(adminDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(button));

        // Click the element button
        button.click();
        System.out.println(message);
    }


    @Given("user opens the OpenCart main page")
    public void UserOpensTheOpenCartMainPage() {
        System.setProperty(webDriver, path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/opencart/upload");     // Check if upload is necessary
        System.out.println("Opened OpenCart main page!");
    }

    @When("user presses on MacBook")
    public void userPressesOnMacBook() {
        scrollAndClick("//div[1]/div[1]/div[2]/div[1]/h4[1]/a[1]", "arguments[0].scrollIntoView(true); window.scrollBy(0, 500);", "Clicked on the MacBook link!" ,driver);
    }


    @And("user adds macBook to the cart")
    public void userAddToCartMacBook() {
        scrollAndClick("//*[@id='button-cart']", "arguments[0].scrollIntoView(true); window.scrollBy(0, 500);", "Clicked on the MacBook add to cart link!",driver);
    }

    @And("user navigates to the shopping cart")
    public void UserNavigatesToTheCheckOut() {
        scrollAndClick("//li[5]/a[1]/span[1]", "window.scrollTo(0, 0);", "Clicked on checkout link!",driver);
    }


    @Then("user should see the checkout page")
    public void UserShouldSeeTheCheckoutPage() {
        // Verify you are on the Checkout page
        WebElement checkoutHeader = driver.findElement(By.xpath("//h1[text()='Checkout']"));
        boolean checkoutVisible = checkoutHeader.isDisplayed();
        assert checkoutVisible : "Checkout page is not visible!";
        System.out.println("Checkout page is visible!");

    }


    @And("user verifies that MacBook is in the order summary")
    public void userVerifiesMacBookInOrderSummary() {
        // Locate the cell containing the MacBook details using the provided XPath
        WebElement macBookCell = driver.findElement(By.xpath("//div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]"));

        // Verify if the cell text contains "MacBook"
        String cellText = macBookCell.getText();
        if (cellText.contains("1x MacBook")) {
            System.out.println("Verification Passed: MacBook is present in the order summary.");
        } else {
            System.out.println("Verification Failed: MacBook is not present in the order summary.");
        }

        // Optionally, use an assertion to fail the test if MacBook is not found
        assert cellText.contains("MacBook") : "MacBook is not present in the order summary!";
        sleep(5000);
        // Close the browser
        driver.quit();
    }

    @Given("admin opens admin login page")
    public void adminOpensAdminLoginPage() {
        System.setProperty(webAdminDriver, path);
        adminDriver = new ChromeDriver();
        AdminWait = new WebDriverWait(adminDriver, Duration.ofSeconds(40L));
        adminDriver.manage().window().maximize();
        adminDriver.get("http://localhost/opencart/upload/myadmin");     // Check if upload is necessary
        System.out.println("Opened OpenCart Admin login page!");
    }

    @When("Admin logs in using {string} and {string}")
    public void adminIsLoggedInWithUsernameAndPassword(String username, String password) {
        ((WebElement)this.AdminWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-username']")))).sendKeys(new CharSequence[]{username});
        ((WebElement)this.AdminWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-password']")))).sendKeys(new CharSequence[]{password});
        WebElement login = (WebElement)this.AdminWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/button[1]")));
        login.click();
        sleep(1000);
    }


    @And("admin navigates to product catalog")
    public void adminNavigatesToProductCatalog() {
        clickAndWait("//nav[1]/ul[1]/li[2]/a[1]", "Clicked on 'Catalog'!");
        clickAndWait("//nav[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]", "Navigated to 'Product' catalog!");
    }

    @And("admin searches for product {string} and adds variant")
    public void adminSearchesForProduct(String product) {
        ((WebElement)this.AdminWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-name']")))).sendKeys(new CharSequence[]{product});
        scrollAndClick("//*[@id='button-filter']", "arguments[0].scrollIntoView(true); window.scrollBy(0, 500);","Clicked on 'Filter' button!", adminDriver);
        sleep(1000);
        scrollAndClick("/html/body/div[@id='container']/div[@id='content']/div[@class='container-fluid']/div[@class='row']/div[@class='col col-lg-9 col-md-12']/div[@class='card']/div[@id='product']/form[@id='form-product']/div[@class='table-responsive']/table[@class='table table-bordered table-hover']/tbody/tr/td[@class='text-end'][3]/div[@class='btn-group']/a[@class='btn btn-primary']","window.scrollTo(0, 0);", "Clicked on 'Edit' button!", adminDriver);
    }

    @And("admin presses Data button")
    public void adminPressesDataButton() {
        clickAndWait("//form[1]/ul[1]/li[2]/a[1]", "Clicked on 'Data' button!");
    }

    @And("admin scrolls down and edits the price to {string}")
    public void adminScrollsDownAndEditsThePriceTo(String price) {
        scrollAndClick("//*[@id='input-price']", "arguments[0].scrollIntoView(true); window.scrollBy(0, 1000);", "Clicked on 'Price' field!", adminDriver);

        sleep(1000);
        // Locate the "Price" field and wait for visibility
        WebElement priceField = (WebElement) this.AdminWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-price']")));

        // Clear the existing price value
        priceField.clear();

        // Enter the new price
        priceField.sendKeys(price);

    }

    @And ("admin saves the changes")
    public void adminSavesTheChanges() {
        scrollAndClick("/html/body/div[@id='container']/div[@id='content']/div[@class='page-header']/div[@class='container-fluid']/div[@class='float-end']/button[@class='btn btn-primary']", "window.scrollTo(0, 0)", "Clicked on 'Save' button!", adminDriver);
    }
    @Then("verify changes in product: {string}, changed to price: {string}")
    public void verifyChanges(String product, String price) {
        scrollAndClick("//nav[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]", "window.scrollTo(0, 0)", "Clicked on 'Save' button!", adminDriver);
        adminSearchesForProduct(product);
        adminPressesDataButton();
        scrollAndClick("//*[@id='input-price']", "arguments[0].scrollIntoView(true); window.scrollBy(0, 1000);", "Clicked on 'Price' field!", adminDriver);
        // Locate the cell containing the MacBook details using the provided XPath
        WebElement priceCell = adminDriver.findElement(By.xpath("//nav[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        // Verify if the cell text contains "MacBook"
        String cellText = priceCell.getText();
        if (cellText.contains(price)) {
            System.out.println("Verification Passed: price has been changed");
        } else {
            System.out.println("Verification Failed: price has not been changed");
        }

        // Optionally, use an assertion to fail the test if MacBook is not found
        assert cellText.contains(price) : "price has not been changed!";

    }
    @And("close the browser")
    public void closeTheBrowser() {
        // Close the browser
        sleep(5000);
        adminDriver.quit();
    }

}
