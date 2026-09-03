package Basics;
// Importing necessary classes for Selenium WebDriver and TestNG annotations.
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;


public class loginToNdosiWebsite {

    WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        Thread.sleep(5000);
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
    }

    //Clicking the login button to open the login form.
    @Test
    public void clickLoginButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")).click();
    }

    //Entering the username in the username field.
    @Test(dependsOnMethods = {"clickLoginButton"})
    public void enterUserName() throws InterruptedException {
        driver.findElement(By.id("login-email")).sendKeys("MzwDhlamini@gmail.com");
    }

    //Entering the password in the password field.
    @Test(dependsOnMethods = {"enterUserName"})
    public void enterPassword() throws InterruptedException {
        driver.findElement(By.id("login-password")).sendKeys("Mzeeto.716");
    }

    //Clicking the login submit button to attempt to log in.
    @Test(dependsOnMethods = {"enterPassword"})
    public void clickLoginSubmitButton() throws InterruptedException {
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(5000);
    }

    //*Content to be added on LandingPage*
    //Verifying that the login was successful by checking if the user profile button is displayed.
    @Test(dependsOnMethods = {"clickLoginSubmitButton"})
    public void verifyLoginSuccess() {
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[3]/button/span[2]")).isDisplayed();
    }

    //Navigating to and Select Web Automation Advance tab (clickLearn, clickLearningMaterials, clickWebAutomationBasicForm)
    @Test(dependsOnMethods = {"verifyLoginSuccess"})
    public void clickLearn() {
        driver.findElement(By.xpath("//span[contains(.,'Learn')]")).click();
    }

    @Test(dependsOnMethods = {"clickLearn"})
    public void clickLearningMaterials() {
        driver.findElement(By.xpath("//span[contains(.,'Learning Materials')]")).click();
    }

    @Test(dependsOnMethods = {"clickLearningMaterials"})
    public void clickWebAutomationBasicForm() {
        driver.findElement(By.xpath("//span[contains(.,'Web Automation Advance')]")).click();
    }

    //Inventory Form shown:
    @Test(dependsOnMethods = {"clickWebAutomationBasicForm"})
    public void fillInventoryForm() {
        driver.findElement(By.xpath("//span[contains(.,'Web Automation Advance')]")).click();

//    Select Device Type: Phone → Brand dropdown enabled.
        driver.findElement(By.xpath("//select[@id='deviceType']/option[@value='phone']")).click();
//    Select Brand: Apple → Device preview shown.
        driver.findElement(By.xpath("//select[@id='brand']/option[@value='apple']")).click();
//    Select Storage: 128GB → Unit price R480.00 displayed.
        driver.findElement(By.id("storage-128GB")).click();
      //    Select Color: Blue → Color selection applied.
        driver.findElement(By.xpath("//select[@id='color']/option[@value='blue']")).click();
//    Enter Quantity: 2 → Subtotal R960.00.
        driver.findElement(By.id("quantity")).sendKeys("2");
//    Enter Address: &quot;123 Test Street&quot; → Address field filled.
        driver.findElement(By.id("address")).sendKeys("123 Test Street");
//    Click Next → Order preview displayed.
        driver.findElement(By.id("inventory-next-btn")).click();
//    Select Express Shipping → R25.00 added.
        driver.findElement(By.id("shipping-express")).click();
//    Select 1yr Warranty → R49.00 added.
        driver.findElement(By.id("warranty-1yr")).click();
//    Apply discount code SAVE10 → 10% off applied.
        driver.findElement(By.id("discount-code")).sendKeys("Save10");
        driver.findElement(By.id("apply-discount-btn")).click();
//    Click Confirm Purchase → Success toast with order details.
        driver.findElement(By.id("purchase-device-btn")).click();
//    ========================================================================
//    Click View Invoice → Invoice history panel shown.

        // 1. Switch driver focus into the iframe (use the iframe's ID, Name, or index)
        driver.switchTo().frame("purchase-success-toast");

        // 2. Click the button inside the iframe
        driver.findElement(By.id("view-history-btn")).click();

        // 3. Crucial: Switch back to the main webpage when done with the popup
        driver.switchTo().defaultContent();
//    ========================================================================

//    Click View on invoice → Invoice opens with all order details.
        driver.findElement(By.xpath("//*[contains(@id, 'view-invoice')]")).click();
    }

    //terminating the entire browser session.
//    @AfterTest
//    public void quit() {
//        driver.quit();
//    }
}

