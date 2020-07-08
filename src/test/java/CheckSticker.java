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
        int countGoods = driver.findElements(By.className("sticker")).size();

        for (int i = 0; i < goods.size() ; i++){
            assertEquals(countGoods, goods.size());
        }
    }
}

