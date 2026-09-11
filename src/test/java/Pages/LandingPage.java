package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LandingPage {

    WebDriver driver;

// Web Element section

    @FindBy(xpath = "//span[normalize-space()='My Learning']")
    WebElement myLearningTab;

    @FindBy(xpath= "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[3]/button/span[2]")
    WebElement verify_Login_Success;

    @FindBy(xpath= "//span[contains(.,'Learn')]")
    WebElement click_Learn;

    @FindBy(xpath= "//span[contains(.,'Learning Materials')]")
    WebElement click_Learning_Materials;

    @FindBy(xpath= "//span[contains(.,'Web Automation Advance')]")
    WebElement click_Web_Automation_Advance;

    @FindBy(xpath= "//select[@id='deviceType']/option[@value='phone']")
    WebElement device_Type;

    @FindBy(xpath= "//select[@id='brand']/option[@value='apple']")
    WebElement brand_option;

    @FindBy(xpath= "//select[@id='storage']/option[@value='128GB']")
    WebElement storage_option;

    @FindBy(xpath= "//select[@id='color']/option[@value='blue']")
    WebElement color_option;

    @FindBy(id="quantity")
     WebElement quantity_option;

    @FindBy(id="address")
    WebElement address_details;

    @FindBy(id = "inventory-next-btn")
    WebElement Order_preview;

    @FindBy(id = "shipping-express")
    WebElement shipping_express;

    @FindBy(id = "warranty-1yr")
    WebElement warranty_option;

    @FindBy(id = "discount-code")
    WebElement discount_code;

    @FindBy(id = "apply-discount-btn")
    WebElement apply_discount_btn;

    @FindBy(id = "purchase-device-btn")
    WebElement Confirm_Purchase;

    @FindBy(xpath= ("//*[contains(@id, 'view-invoice')]"))
    WebElement Invoice_Order_Details;


// Methods section
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(myLearningTab));
        myLearningTab.isDisplayed();
    }

    public void clickLearn() {
        click_Learn.click();
    }

    public void clickLearningMaterials() {
        click_Learning_Materials.click();
    }

    public void clickWebAutomationBasicForm() {
        click_Web_Automation_Advance.click();
    }

//    filling in the Inventory Form
    public void fillInventoryForm() {
//    Select Device Type: Phone → Brand dropdown enabled.
        device_Type.click();

//    Select Brand: Apple → Device preview shown.
        brand_option.click();

//    Select Storage: 128GB → Unit price R480.00 displayed.
        storage_option.click();

//    Select Color: Blue → Color selection applied.
        color_option.click();

//    Enter Quantity: 2 → Subtotal R960.00.
        quantity_option.sendKeys("2");

//    Enter Address: &quot;123 Test Street&quot; → Address field filled.
        address_details.sendKeys("123 Test Street");

//    Click Next → Order preview displayed.
        Order_preview.click();

//    Select Express Shipping → R25.00 added.
        shipping_express.click();

//    Select 1yr Warranty → R49.00 added.
        warranty_option.click();

//    Apply discount code SAVE10 → 10% off applied.
        discount_code.sendKeys("Save10");

//    Click apply discount button
        apply_discount_btn.click();
    }

//    ========================================================================
     public void ConfirmPurchase(){
//    Click Confirm Purchase → Success toast with order details.
        Confirm_Purchase.click();

    }

    public void viewInvoice() {

//    On Pop Up - Click View Invoice → Invoice history panel shown. (not breaking down yet.need to test)

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("purchase-success-toast")));

        WebElement viewInvoiceButton = successToast.findElement(By.id("view-history-btn"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",viewInvoiceButton);

        new Actions(driver).moveToElement(viewInvoiceButton).click().perform();

//    ========================================================================
    }

    public void viewInvoiceOrderDetails() {
//    Click View on invoice → Invoice opens with all order details.
        Invoice_Order_Details.click();
    }

//    Terminating the entire browser session.
    public void quit() {
        driver.quit();
    }
}


