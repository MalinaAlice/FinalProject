package pages;

import helperMethods.TestAddInCartHelper;
import helperMethods.TestCategoriesHelper;
import helperMethods.TestSearchOpenNewTabHelper;
import modelObject.TestCategoriesModel;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    protected TestSearchOpenNewTabHelper testSearchOpenNewTabHelper;
    protected TestAddInCartHelper testAddInCartHelper;
    protected TestCategoriesHelper testCategoriesHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        testSearchOpenNewTabHelper = new TestSearchOpenNewTabHelper(driver);
        testAddInCartHelper = new TestAddInCartHelper(driver);
        testCategoriesHelper = new TestCategoriesHelper(driver);
    }

}
