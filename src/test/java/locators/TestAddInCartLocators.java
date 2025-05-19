package locators;

import org.openqa.selenium.By;

public class TestAddInCartLocators {
    public static final By productButton = By.xpath("//span[@class='coco']");
    public static final By pageCategoryTitle = By.xpath("//h1[@class='md-title']");
    public static final By subcategory = By.xpath("(//a[contains(text(),'Attack on Titan')])[6]");
    public static final By pageSubcategoryTitle = By.xpath("//h1[@class='md-title']");
    public static final By  mangaSelect = By.cssSelector("img[alt='Attack on Titan Vol. 10 ']");
    public static final By titleManga = By.cssSelector("h1[class='titluProdus']");
    public static final By addInCart = By.cssSelector("a[class='ng-scope']");
    public static final By goToCart = By.cssSelector("span[class='checkout__text']");
    public static final By completeOrder = By.cssSelector("a[class='md-raised alt butonFinalizare md-button ng-scope md-ink-ripple']");
    public static final By addQuantityBefore = By.id("product-96604-quantity");
    public static final By addQuantityAfter = By.cssSelector("input[class='form-control re-validate-cart']");
    public static final By totalValue = By.cssSelector("td[data-label='Total']");
    public static final By checkoutButton = By.cssSelector("div[class='pull-right']");
    public static final By existingAccount = By.cssSelector("li[class='active']");
    public static final By backToCart = By.cssSelector("a[class='md-button checkout-back-btn']");
    public static final By removeButton = By.cssSelector("a[class='remove-from-cart remove-product']");
    public static final By emptyCartText = By.xpath("(//h1[contains(text(),'Nu mă lăsa gol')])[1]");
}
