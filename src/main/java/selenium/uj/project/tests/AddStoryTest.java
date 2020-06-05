package selenium.uj.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.uj.project.pages.DashboardPage;

import java.util.Date;

public class AddStoryTest extends DefaultTest {

    @Test
    public void successAddStoryTest() {
        Assert.assertTrue(
                new DashboardPage(driver, logger)
                        .openStoryPage()
                        .openAddStoryPage()
                        .fillAddStoryForm("story_" + new Date().getTime())
                        .submitAddStoryForm()
                        .fillNewStory("#555555", "pageName_" + new Date().getTime())
                        .isInfoBoxDisplayed());
    }

}