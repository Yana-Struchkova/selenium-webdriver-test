package selenium.uj.project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends DefaultPage {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/nav/button")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/nav/a[2]")
    private WebElement ContactListPageMenuItem;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/nav/a[1]")
    private WebElement storyPageMenuItem;

    public DashboardPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public boolean isDashboardPageDisplayed() {
        return isElementDisplayed(logoutButton);
    }

    public ContactListPage openContactListPage() {
        clickElement(ContactListPageMenuItem);
        return new ContactListPage(driver, logger);
    }

    public StoryPage openStoryPage() {
        clickElement(storyPageMenuItem);
        return new StoryPage(driver, logger);
    }
}
