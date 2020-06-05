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

    @FindBy (xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/button[2]")
    private WebElement removeButton;

    public AddContactListPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public AddContactListPage fillAddContactListForm(String clientName) {
        fillElement(clientField, clientName);
        return this;
    }

    public ContactListPage submitAddContactListForm() {
        clickElement(createButton);
        clickElement(removeButton);
        driver.switchTo().alert().accept();
        return new ContactListPage(driver,logger);
    }
}
