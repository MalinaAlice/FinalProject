package helperMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class TestSearchOpenNewTabHelper {
    private final WebDriver driver;

    public TestSearchOpenNewTabHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void fillPressLocator(By locator, String value, Keys key) {
        waitForVisible(locator);
        driver.findElement(locator).sendKeys(value);
        driver.findElement(locator).sendKeys(key);
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

    public void closeCurrentTab() {
        driver.close();
    }

    public void validateCurrentURL(String expectedURL, String message) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, message);
    }

    public void switchToOriginalTab(String originalHandle) {
        driver.switchTo().window(originalHandle);
        System.out.println("Switched back to original tab: " + driver.getCurrentUrl());
    }


    public void openNewTab(By locator) {
        String originalTab = driver.getWindowHandle();
        WebElement element = driver.findElement(locator);
        String href = element.getDomAttribute("href");

        //Simulate open a new tab using Js
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", href);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> d.getWindowHandles().size() > 1);

        //Switch focus to the new tab
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }
}
