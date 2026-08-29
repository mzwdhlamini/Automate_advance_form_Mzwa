package Tests;

import org.testng.annotations.Test;

public class LoginTests extends base{


    @Test
    public void clickLoginButton() throws InterruptedException {
        takesScreenshots.takesSnapShot(driver,"landing page");
        homePage.clickLoginButton();
    }

    @Test(priority = 1)
    public void enterUsernameTests(){
        loginPage.enterUsername(readData.username);
    }

    @Test(priority = 2)
    public void enterPassword(){
        loginPage.enterPassword(readData.password);
        takesScreenshots.takesSnapShot(driver,"login page");
    }

    @Test(priority = 3)
    public void clickLoginSubmitButton() throws InterruptedException {
        loginPage.clickLoginSubmitButton();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver,"dashboard page");
    }

}
