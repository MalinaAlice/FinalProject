package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;

@Setter
@Getter
public class TestSearchOpenNewTabModel {

    private String searchTextValue;
    private String expectedTitle;
    private String expectedURL;
    private String searchTextValueNew;
    private String newExpectedURL;

    public TestSearchOpenNewTabModel(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readerForUpdating(this).readValue(new File(jsonFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON file: " + jsonFilePath, e);
        }
    }
}
