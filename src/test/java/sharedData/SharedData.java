package sharedData;

import loggerUtility.LoggerUtility;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {

    @Getter
    private WebDriver driver;
    private String testName;

    @BeforeMethod (alwaysRun = true)
    public void prepareEnvironment() {
        testName = this.getClass().getSimpleName();
        driver = new ChromeDriver();

//        String remoteEnv = System.getProperty("remote");
//        if (Boolean.parseBoolean(remoteEnv)) {
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless=new");
//            driver = new ChromeDriver(options);
//        } else {
//            driver = new ChromeDriver();
//        }

        driver.get("https://carturesti.md/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.startTest(testName);


        WebElement denyCookies = driver.findElement(By.xpath("//a[@class='cc-btn cc-deny']"));
        denyCookies.click();
    }

    @AfterMethod (alwaysRun = true)
    public void clearEnvironment() {
        driver.quit();
        LoggerUtility.finishTest(testName);
    }
}
