package pages;

import locators.TestSearchOpenNewTabLocators;
import loggerUtility.LoggerUtility;
import modelObject.TestSearchOpenNewTabModel;
import org.openqa.selenium.*;

public class TestSearchOpenNewTabPage extends BasePage{
    public TestSearchOpenNewTabPage(WebDriver driver) {
        super(driver);
    }

    public void testSearchNewTab(TestSearchOpenNewTabModel testData) {
        String mainTab = driver.getWindowHandle();

        testSearchOpenNewTabHelper.fillPressLocator(TestSearchOpenNewTabLocators.searchInput, testData.getSearchTextValue(), Keys.ENTER);
        LoggerUtility.infoLog("The user was searching for " + testData.getSearchTextValue());

        testSearchOpenNewTabHelper.openNewTab(TestSearchOpenNewTabLocators.sixOfCrowsBook);
        LoggerUtility.infoLog("The user opened a new tab.");

        testSearchOpenNewTabHelper.validateElementText(TestSearchOpenNewTabLocators.titleElement, testData.getExpectedTitle(), "You're on the wrong page.");
        testSearchOpenNewTabHelper.validateCurrentURL(testData.getExpectedURL(), "Something went wrong.");
        LoggerUtility.infoLog("The current URL is: " + driver.getCurrentUrl());

        testSearchOpenNewTabHelper.closeCurrentTab();
        testSearchOpenNewTabHelper.switchToOriginalTab(mainTab);
        LoggerUtility.infoLog("The user closed the new tab. The current URL is: " + driver.getCurrentUrl());

        testSearchOpenNewTabHelper.fillClearPressLocator(TestSearchOpenNewTabLocators.searchInput, testData.getSearchTextValueNew(), Keys.ENTER);
        testSearchOpenNewTabHelper.validateCurrentURL(testData.getNewExpectedURL(), "Something went wrong.");
        LoggerUtility.infoLog("The current URL is: " + driver.getCurrentUrl());
    }
}
