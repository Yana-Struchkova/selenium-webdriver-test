package selenium.uj.project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContactListPage extends DefaultPage {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/form/input")
    private WebElement clientField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/form/button")
    private WebElement createButton;

    public AddContactListPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public AddContactListPage fillAddContactListForm(String clientName) {
        fillElement(clientField, clientName);
        return this;
    }

    public ContactListPage submitAddContactListForm() {
        clickElement(createButton);
        return new ContactListPage(driver,logger);
    }
}
