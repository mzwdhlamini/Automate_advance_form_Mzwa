package Tests;

import org.testng.annotations.Test;

public class LandingPageTests extends base{

    @Test(dependsOnGroups = "LoginTests")
        public void clickLoginButton() throws InterruptedException {
            takesScreenshots.takesSnapShot(driver,"myLearningTab is Displayed");
            landingPage.clickLoginButton();
        }
    @Test(dependsOnMethods ="clickLoginButton")
        public void clickLearn() {
        landingPage.clickLearn();
        }
    @Test(dependsOnMethods ="clickLearn")
        public void clickLearningMaterials() {
        landingPage.clickLearningMaterials();
        }
    @Test(dependsOnMethods ="clickLearningMaterials")
        public void clickWebAutomationBasicForm() {
        landingPage.clickWebAutomationBasicForm();
        takesScreenshots.takesSnapShot(driver,"Empty Basic Form");
        }
    @Test(dependsOnMethods ="clickWebAutomationBasicForm")
        public void fillInventoryForm() {
        landingPage.fillInventoryForm();
        takesScreenshots.takesSnapShot(driver,"filled Inventory Form");
        }
    @Test(dependsOnMethods ="fillInventoryForm")
        public void ConfirmPurchase(){
        landingPage.ConfirmPurchase();
        }
    @Test(dependsOnMethods ="ConfirmPurchase")
        public void viewInvoice() {
        takesScreenshots.takesSnapShot(driver,"Invoice");
        landingPage.viewInvoice();
        }

    @Test(dependsOnMethods ="viewInvoice")
        public void viewInvoiceOrderDetails() {
        landingPage.viewInvoiceOrderDetails();
        takesScreenshots.takesSnapShot(driver,"Invoice Order Details");
        }
    @Test(dependsOnMethods ="viewInvoiceOrderDetails")
        public void quit() {
        landingPage.quit();
        }
}
