package pages;

import locators.TestCategoriesLocators;
import loggerUtility.LoggerUtility;
import modelObject.TestCategoriesModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestCategoriesPage extends BasePage{
    public TestCategoriesPage(WebDriver driver) {
        super(driver);
    }

    public void categoriesTest(TestCategoriesModel testData) {

        testCategoriesHelper.clickLocator(TestCategoriesLocators.productButton);
        LoggerUtility.infoLog("The user pressed the Product Menu.");

        List<WebElement> listOfCategoriesElement =testCategoriesHelper.getListElements(TestCategoriesLocators.listOfCategories);
        testCategoriesHelper.getListElements(TestCategoriesLocators.listOfCategories);

        //Verifies that when clicking one category from Product Menu, the title is the one expected
        //Last category doesn't have a title so it only verifies that the URLs are matching
        for (int i = 0; i < listOfCategoriesElement.size(); i++) {
            listOfCategoriesElement =testCategoriesHelper.getListElements(TestCategoriesLocators.listOfCategories);
            WebElement category = listOfCategoriesElement.get(i);

            category.click();

            testCategoriesHelper.forceWait(2000);
//            Thread.sleep(2000);

            if (i < 18) {

                String actualTitle = driver.findElement(TestCategoriesLocators.pageCategoryTitle).getText().trim();
                testCategoriesHelper.validateCategoryTitle(TestCategoriesLocators.pageCategoryTitle, testData.getTitlesCategories(), i, "Category was selected incorrectly.");
                LoggerUtility.infoLog("Category " + actualTitle + " was validated.");
                LoggerUtility.infoLog("Current URL is " + driver.getCurrentUrl());
                testCategoriesHelper.clickLocator(TestCategoriesLocators.productButton);

            } else if(i == 18) {

                testCategoriesHelper.validateCurrentURL(testData.getExpectedURL(), "Category was selected incorrectly.");
                LoggerUtility.infoLog("Current URL is " + driver.getCurrentUrl());
            }
        }
    }
}
