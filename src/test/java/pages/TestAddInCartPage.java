package pages;

import locators.TestAddInCartLocators;
import loggerUtility.LoggerUtility;
import modelObject.TestAddInCartModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestAddInCartPage extends BasePage{
    public TestAddInCartPage(WebDriver driver) {
        super(driver);
    }

    public void addInCart(TestAddInCartModel testData) {

        testAddInCartHelper.clickLocator(TestAddInCartLocators.productButton);

        List<WebElement> listOfCategories = driver.findElements(By.xpath("//md-list-item[@class='md-1-line md-no-proxy ng-scope _md']"));
        WebElement category = listOfCategories.get(4);
        category.click();

        testAddInCartHelper.validateElementText(TestAddInCartLocators.pageCategoryTitle, testData.getExpectedCategory(), "Category was selected incorrectly.");
        LoggerUtility.infoLog("The user went to category " + testData.getPageCategoryTitle());

        testAddInCartHelper.clickLocator(TestAddInCartLocators.subcategory);
        testAddInCartHelper.validateElementText(TestAddInCartLocators.pageSubcategoryTitle, testData.getExpectedSubcategory(), "Subcategory selected incorrectly.");
        LoggerUtility.infoLog("The user went to subcategory " + testData.getPageSubcategoryTitle());

        testAddInCartHelper.clickLocator(TestAddInCartLocators.mangaSelect);
        LoggerUtility.infoLog("The user chose the manga he/she wants.");
        testAddInCartHelper.validateElementText(TestAddInCartLocators.titleManga, testData.getExpectedTitle(), "Wrong manga was selected.");

        testAddInCartHelper.clickLocator(TestAddInCartLocators.addInCart);
        LoggerUtility.infoLog("The user adds in the cart the book.");

        testAddInCartHelper.clickLocator(TestAddInCartLocators.goToCart);
        LoggerUtility.infoLog("The user went to the cart.");

        testAddInCartHelper.clickLocator(TestAddInCartLocators.completeOrder);
        LoggerUtility.infoLog("The user wants to complete the order.");

        testAddInCartHelper.fillClearPressLocator(TestAddInCartLocators.addQuantityBefore, "12", Keys.ENTER);
        LoggerUtility.infoLog("The user tries to buy 12 books of the same kind.");

        testAddInCartHelper.validateElementText(TestAddInCartLocators.addQuantityAfter, "value", "10", "The quantity is not correct.");
        LoggerUtility.infoLog("Verify that the user can't add more than 10 books of the same kind.");

        testAddInCartHelper.validateElementText(TestAddInCartLocators.totalValue, testData.getExpectedValue(), "The total is not the one expected.");
        LoggerUtility.infoLog("Validates that the total value is " + testData.getTotalValue());

        testAddInCartHelper.clickLocator(TestAddInCartLocators.checkoutButton);
        LoggerUtility.infoLog("The user pressed the checkout button.");

        testAddInCartHelper.validateElementText(TestAddInCartLocators.existingAccount, testData.getExpectedText(), "The checkout was not made correctly.");
        testAddInCartHelper.validateCurrentURL(testData.getExpectedURL(), "The checkout was not made correctly.");
        LoggerUtility.infoLog("The new URL is " + driver.getCurrentUrl());

        testAddInCartHelper.clickLocator(TestAddInCartLocators.backToCart);
        LoggerUtility.infoLog("The user went back to the cart.");

        testAddInCartHelper.clickLocator(TestAddInCartLocators.removeButton);
        LoggerUtility.infoLog("The user removed the books from the cart.");

        testAddInCartHelper.validateElementText(TestAddInCartLocators.emptyCartText, testData.getExpectedEmptyCartText(), "The books were not removed from the cart.");
        LoggerUtility.infoLog("Validates that the books were removed from the cart.");
    }
}
