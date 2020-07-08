import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class SortGeoZones extends ApplicationManager{

    @Test
    public void testSortGeoZones() throws InterruptedException {

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));

        WebElement links;
        links = driver.findElement(By.linkText("Geo Zones"));
        links.click();
        Thread.sleep(3000);


        List<WebElement> geozones = driver.findElements(By.xpath("//tr/td[3]"));
        WebElement selectElem;
        for (int i = 0; i < geozones.size(); i++) {
            geozones = driver.findElements(By.xpath("//tr/td[3]/a"));
            Thread.sleep(5000);
            geozones.get(i).click();

            List<String> displayedZones = new ArrayList<String>();
            List<String> sortedZones = new ArrayList<String>();

            List<WebElement> tablezones = driver.findElements(By.xpath("//table[@id='table-zones']//td[3]"));

            for (int j = 0; j < tablezones.size(); j++) {
                selectElem = driver.findElement(By.xpath("//table[@id='table-zones']//tr["+ ( i + 2 ) +"]//td[3]/select"));
                Select select = new Select(selectElem);
                WebElement selectedZone = select.getOptions().get(j+1);
                String getData = selectedZone.getText();
                displayedZones.add(getData);
                sortedZones.add(getData);
            }
            List<String> sorting = displayedZones;
            Collections.sort(sorting);
            Assert.assertEquals(sortedZones, sorting);

            links = driver.findElement(By.linkText("Geo Zones"));
            links.click();
        }
    }
}
