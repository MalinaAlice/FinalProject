package tests.testAddInCart;

import modelObject.TestAddInCartModel;
import org.testng.annotations.Test;
import pages.TestAddInCartPage;
import sharedData.SharedData;

public class TestAddInCart extends SharedData {

    @Test
    public void testMethod(){

        TestAddInCartModel testData = new TestAddInCartModel("src/main/resources/TestAddInCartData.json");

        TestAddInCartPage testAddInCartPage = new TestAddInCartPage(getDriver());
        testAddInCartPage.addInCart(testData);
    }
}
