import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

public class CheckSticker extends ApplicationManager {

    @Test
    public void checkStickerTest() {
        driver.get("http://localhost/litecart/");

        List<WebElement> goods = driver.findElements(className("product"));
        for (int i = 0; i < goods.size(); i++) {
            goods = driver.findElements(className("product"));
            List<WebElement> stickers;
            stickers = driver.findElements((By) className("product").findElements((SearchContext) xpath(".//div[contains(@class, 'sticker')]")));

            for (int j = 0; j < stickers.size(); j++) {
                int sticker_count = stickers.size();
                if (sticker_count == 1) {
                    System.out.println("У товара один стикер");
                }
            }
        }
    }
}

