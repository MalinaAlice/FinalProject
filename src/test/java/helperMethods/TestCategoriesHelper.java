package helperMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TestCategoriesHelper {

    private final WebDriver driver;

    public TestCategoriesHelper(WebDriver driver) {
        this.driver = driver;
    }


    private WebElement waitForVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickLocator(By locator) {
        waitForVisible(locator);
        driver.findElement(locator).click();
    }

    private void waitForPresenceList(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public List<WebElement> getListElements(By locator) {
        waitForPresenceList(locator);
        return driver.findElements(locator);
    }

    public void validateCategoryTitle(By locator, List<String> titlesCategories, int index, String message) {
        WebElement element = waitForVisible(locator);
        String actualTitle = element.getText().trim();
        String expectedTitle = titlesCategories.get(index);
        Assert.assertEquals(expectedTitle, actualTitle, message);
    }

    public void validateCurrentURL(String expectedURL, String message) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, message);
    }
}
