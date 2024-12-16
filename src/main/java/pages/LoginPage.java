package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {
    private AndroidDriver driver;

    // Define elements using Page Factory
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='API Demos']")
    private WebElement pageTitle;

    @AndroidFindBy(id = "android:id/list")
    private WebElement listView;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc]")
    private List<WebElement> listItems;

    // Constructor to initialize driver and PageFactory
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    // Method to validate page title
    public boolean validatePageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(pageTitle));
            System.out.println("Page title is displayed: " + pageTitle.getText());
            return pageTitle.isDisplayed();
        } catch (Exception e) {
            System.out.println("Page title not displayed: " + e.getMessage());
            return false;
        }
    }

    // Method to validate the ListView and interact with its items
    public void validateAndInteractWithListItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Validate ListView presence
            wait.until(ExpectedConditions.visibilityOf(listView));
            System.out.println("ListView is displayed.");

            // Loop through and validate each list item
            for (WebElement item : listItems) {
                wait.until(ExpectedConditions.visibilityOf(item));
                System.out.println("List item displayed: " + item.getText());

                // Validate clickability and click the item
                if (item.isEnabled() && item.isDisplayed()) {
                    System.out.println("Clicking on item: " + item.getText());
                    item.click();

                    // Add verification if the item navigates to a new page
                    // For now, navigate back to the list view
                    driver.navigate().back();
                    wait.until(ExpectedConditions.visibilityOf(listView));
                } else {
                    System.out.println("Item is not clickable: " + item.getText());
                }
            }

        } catch (Exception e) {
            System.out.println("An error occurred while interacting with list items: " + e.getMessage());
        }
    }
}
