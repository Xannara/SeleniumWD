import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CheckSticker extends ApplicationManager {

    @Test
    public void checkStickerTest() {
        driver.get("http://localhost/litecart/");

        List<WebElement> goods = driver.findElements(By.className("product"));
        for (int i = 0; i < goods.size(); i++) {
            goods = driver.findElements(By.className("product"));
            goods.get(i).click();
            assertTrue(isElementPresent(By.cssSelector("#box-product")));
            List<WebElement> stickers;
            stickers = driver.findElements(By.xpath("//div[@id='box-product']//div[contains(@class, 'sticker')]"));
            for (int j = 0; j < stickers.size(); j++) {
                int sticker_count = stickers.size();
                if (sticker_count == 1) {
                    System.out.println("У товара один стикер");
                }
            }
            WebElement link;
            link = driver.findElement(By.linkText("Home"));
            link.click();
        }
    }
}

