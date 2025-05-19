package tests.testSearchOpenNewTab;

import modelObject.TestSearchOpenNewTabModel;
import org.testng.annotations.Test;
import pages.TestSearchOpenNewTabPage;
import sharedData.SharedData;


public class TestSearchOpenNewTab extends SharedData {

    @Test
    public void testMethod() {

        TestSearchOpenNewTabModel testData = new TestSearchOpenNewTabModel("src/main/resources/TestSearchOpenNewTabData.json");

        TestSearchOpenNewTabPage testSearchOpenNewTabPage = new TestSearchOpenNewTabPage(getDriver());
        testSearchOpenNewTabPage.testSearchNewTab(testData);
    }
}
