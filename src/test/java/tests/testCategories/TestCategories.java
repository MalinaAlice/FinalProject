package tests.testCategories;

import modelObject.TestCategoriesModel;
import org.testng.annotations.Test;
import pages.TestCategoriesPage;
import sharedData.SharedData;

public class TestCategories extends SharedData {
    @Test
    public void testMethod() throws InterruptedException {

        TestCategoriesModel testData = new TestCategoriesModel("src/main/resources/TestCategoriesData.json");

        TestCategoriesPage testCategoriesPage = new TestCategoriesPage(getDriver());
        testCategoriesPage.categoriesTest(testData);
    }
}
