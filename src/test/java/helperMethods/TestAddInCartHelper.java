package helperMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TestAddInCartHelper {

    private final WebDriver driver;

    public TestAddInCartHelper(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement waitForVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickLocator(By locator) {
        waitForVisible(locator);
        driver.findElement(locator).click();
    }

    public void fillClearPressLocator(By locator, String value, Keys key) {
        waitForVisible(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
        driver.findElement(locator).sendKeys(key);
    }

    public void validateElementText(By locator, String expectedText, String message) {
        waitForVisible(locator);
        Assert.assertEquals(driver.findElement(locator).getText(), expectedText, message);
    }

    public void validateElementText(By locator, String domProperty, String expectedText, String message) {
        WebElement element = waitForVisible(locator);
        Assert.assertEquals(element.getDomProperty(domProperty), expectedText, message);
    }

    public void validateCurrentURL(String expectedURL, String message) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, message);
    }
}
