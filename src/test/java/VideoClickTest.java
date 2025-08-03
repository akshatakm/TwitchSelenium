import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
public class VideoClickTest extends BaseTest{

    HomePage homePage;
    @Test
    public void videoClick() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        homePage.searchItem("StarCraft II");
        boolean assertion = homePage.scrollAndClick();
        takeScreenShot();
        Assert.assertTrue(assertion);
    }
}
