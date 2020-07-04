import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class AdminMenu extends ApplicationManager{

    @Test
    public void adminMenuTest() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));

        List<WebElement> links = driver.findElements(By.cssSelector("#app-"));
        for (int i = 0; i < links.size() ; i++){
            links = driver.findElements(By.cssSelector("#app-"));
            links.get(i).click();
            assertTrue(isElementPresent(By.cssSelector("#content h1")));
            if (!driver.findElements(By.cssSelector("#app- ul li a")).isEmpty()) {
                List<WebElement> smalllinks = driver.findElements(By.cssSelector("#app- ul li a"));
                for (int j = 0; j < smalllinks.size() ; j++) {
                    smalllinks = driver.findElements(By.cssSelector("#app- ul li a"));
                    smalllinks.get(j).click();
                    assertTrue(isElementPresent(By.cssSelector("#content h1")));
                }
            }
        }
    }
}
