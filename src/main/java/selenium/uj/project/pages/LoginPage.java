package selenium.uj.project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DefaultPage {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/form[1]/div[1]/input")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/form[1]/div[2]/input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/form[1]/label/span")
    private WebElement termsCheckbox;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/form[1]/div[4]/button")
    private WebElement submitButton;

    public LoginPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public LoginPage fillLoginForm(String email, String password, boolean remember) {
        fillElement(emailField, email);
        fillElement(passwordField, password);
        selectCheckbox(termsCheckbox, remember);
        return this;
    }

    public DashboardPage submitLoginForm() {
        clickElement(submitButton);
        return new DashboardPage(driver, logger);
    }
}