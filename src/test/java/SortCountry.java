import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class SortCountry extends ApplicationManager{

    @Test
    public void sortCountryTest() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));

        WebElement links;
        links = driver.findElement(By.linkText("Countries"));
        links.click();

        List<String> displayedCountries = new ArrayList<String>();
        List<String> sortedCountries = new ArrayList<String>();

        List<WebElement> names = driver.findElements(By.xpath("//tr/td[5]"));
        String getData;
        for (int i = 0; i < names.size(); i++) {
            getData = names.get(i).getText();
            displayedCountries.add(getData);
            sortedCountries.add(getData);
        }

        List<String> sorting = displayedCountries;
        Collections.sort(sorting);
        Assert.assertEquals(sortedCountries, sorting);
    }
}
