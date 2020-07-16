import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

public class CheckSticker extends ApplicationManager {

    @Test
    public void checkStickerTest() {
        driver.get("http://localhost/litecart/");

        List<WebElement> goods = driver.findElements(className("product"));
        for (WebElement good : goods) {
            List<WebElement> stickers = good.findElements(xpath(".//div[contains(@class, 'sticker')]"));
            int sticker_count = stickers.size();
            Assert.assertEquals(1, sticker_count);
        }
    }
}

