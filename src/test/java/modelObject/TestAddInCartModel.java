package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;


@Getter
@Setter
public class TestAddInCartModel {

    private String productButton;
    private String listOfCategories;
    private String pageCategoryTitle;
    private String expectedCategory;
    private String pageSubcategoryTitle;
    private String expectedSubcategory;
    private String expectedTitle;
    private String mangaSelect;
    private String titleManga;
    private String addInCart;
    private String goToCart;
    private String completeOrder;
    private String addQuantityBefore;
    private String addQuantityAfter;
    private String expectedValue;
    private String totalValue;
    private String checkoutButton;
    private String existingAccount;
    private String expectedText;
    private String expectedURL;
    private String backToCart;
    private String removeButton;
    private String emptyCartText;
    private String expectedEmptyCartText;

    public TestAddInCartModel(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readerForUpdating(this).readValue(new File(jsonFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON file: " + jsonFilePath, e);
        }
    }
}
