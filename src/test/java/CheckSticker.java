import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckSticker extends ApplicationManager {

    @Test
    public void checkStickerTest() {
        driver.get("http://localhost/litecart/");

        List<WebElement> goods = driver.findElements(By.className("product"));
        int count_goods = goods.size();

        List<WebElement> stickers = driver.findElements(By.className("sticker"));
        int sticker_count = stickers.size();

        assertEquals(count_goods, sticker_count);

        for (int i = 0; i < goods.size(); i++) {
            goods = driver.findElements(By.className("product"));
            stickers = driver.findElements(By.className("sticker"));
            goods.get(i);
            stickers.get(i);
            goods.get(i).equals(stickers.get(i));
        }
    }
}

