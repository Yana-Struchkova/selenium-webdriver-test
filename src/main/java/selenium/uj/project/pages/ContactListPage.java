package selenium.uj.project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactListPage extends DefaultPage{

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/form/button")
    private WebElement addContactListButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div")
    private WebElement infoBox;

    public ContactListPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public AddContactListPage openAddContactListPage() {
        clickElement(addContactListButton);
        return new AddContactListPage(driver, logger);
    }

    public boolean isInfoBoxDisplayed() {
        return isElementDisplayed(infoBox);
    }
}
