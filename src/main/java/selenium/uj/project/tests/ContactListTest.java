package selenium.uj.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.uj.project.pages.DashboardPage;

import java.util.Date;

public class ContactListTest extends DefaultTest {

    @Test
    public void successAddContactListTest() {
        Assert.assertTrue(
                new DashboardPage(driver, logger)
                        .openContactListPage()
                        .openAddContactListPage()
                        .fillAddContactListForm("contact_" + new Date().getTime())
                        .submitAddContactListForm()

                        .isInfoBoxDisplayed());
    }

}