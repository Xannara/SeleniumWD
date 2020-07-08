import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class SortZoneInCountry extends ApplicationManager{

    @Test
    public void sortZoneInCountryTest() throws InterruptedException {

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));

        WebElement links;
        links = driver.findElement(By.linkText("Countries"));
        links.click();
        Thread.sleep(3000);

        List<WebElement> zones = driver.findElements(By.xpath("//tr/td[6]"));
        String getNum;
        WebElement edit;
        for (int i = 0; i < zones.size(); i++) {
            zones = driver.findElements(By.xpath("//tr/td[6]"));
            getNum = zones.get(i).getText();
            int num = Integer.parseInt(getNum);
            if (num > 0) {
                edit = driver.findElement(By.xpath("//tr["+ ( i + 2 ) +"]/td[5]/a"));
                edit.click();
                Thread.sleep(3000);

                List<String> displayedZones = new ArrayList<String>();
                List<String> sortedZones = new ArrayList<String>();

                List<WebElement> countryzones = driver.findElements(By.xpath("//table[@id='table-zones']//td[3]"));
                String getData;
                for (int j = 0; j < countryzones.size()-1; j++) {
                    getData = countryzones.get(j).getText();
                    displayedZones.add(getData);
                    sortedZones.add(getData);
                }
                List<String> sorting = displayedZones;
                Collections.sort(sorting);
                Assert.assertEquals(sortedZones, sorting);

                links = driver.findElement(By.linkText("Countries"));
                links.click();
            }

        }
    }
}
