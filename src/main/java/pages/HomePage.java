package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;

    @FindBy(css = "img[class = tw-image]")
    WebElement videoLinks;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void searchItem(String searchText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Click on "Browse"
            WebElement browse = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Browse']")));
            browse.click();

            // Find and click search box
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search']")));
            searchBox.click();
            searchBox.sendKeys(searchText);
            searchBox.sendKeys(Keys.ENTER);
    }

    public boolean scrollAndClick() throws IOException, InterruptedException {
        boolean videoPageLanded = false;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Scroll down twice
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(500); // brief pause after scroll
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(1000);

        // Get all video link elements
        List<WebElement> videoLinks = driver.findElements(By.className("tw-image"));

        for (WebElement video : videoLinks) {
            if (video.isDisplayed()) {
                video.click();
                Thread.sleep(5000); // wait for video page to load

                // Check for indicators of video page
                boolean shareVisible = driver.findElements(By.xpath("//*[contains(text(), 'Share this video')]")).stream().anyMatch(WebElement::isDisplayed);
                boolean followVisible = driver.findElements(By.xpath("//*[contains(text(), 'Follow')]")).stream().anyMatch(WebElement::isDisplayed);

                if (shareVisible || followVisible) {
                    videoPageLanded = true;
                }
                break;
            }
        }

        return videoPageLanded;
    }


}
