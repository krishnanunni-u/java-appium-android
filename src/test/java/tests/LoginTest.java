package tests;

import base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void setUp() throws Exception {
        setup(); // Initialize the driver
    }

    @Test
    public void testValidatePageElements() {
        LoginPage loginPage = new LoginPage(driver); // Create LoginPage instance

        // Validate the page title and assert its visibility
        boolean isTitleDisplayed = loginPage.validatePageTitle();
        assertTrue(isTitleDisplayed, "Page title should be displayed.");

        // Validate and interact with list items
        loginPage.validateAndInteractWithListItems();
    }

    @AfterMethod
    public void tearDown() {
        teardown(); // Quit the driver after test
    }
}
