package selenium.uj.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.uj.project.pages.LoginPage;
import selenium.uj.project.utils.BaseProperties;

import java.util.Date;

public class LoginTest extends DefaultTest {

    @Test
    public void successLoginTest() {

        LoginPage loginPage = new LoginPage(driver, logger)
                .fillLoginForm(
                        BaseProperties.BASE_ADMIN_EMAIL,
                        BaseProperties.BASE_ADMIN_PASSWORD,
                        true);

        // Przykładowe wykonanie screenshota w teście, nazwa dowolnie modyfikowalna wg potrzeb
        customScreenshot.makeScreenshot(driver,
                new Date().getTime() + "_" +
                        new LoginTest(){}.getClass().getEnclosingMethod().getName()
                        + "_" + "STEP 1 - FILL_LOGIN_FORM");

        Assert.assertTrue(
                loginPage
                        .submitLoginForm()
                        .isDashboardPageDisplayed());
    }
}