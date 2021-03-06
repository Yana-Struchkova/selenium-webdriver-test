package selenium.uj.project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddStoryPage extends DefaultPage {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/form/input")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id=\"meta-page-name\"]")
    private WebElement pageNameField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div[2]/div[1]/div/div[2]/div[1]")
    private WebElement pageNamePreview;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/form/button")
    private WebElement saveButton;
/////////////
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div[1]/div[2]/div[1]/button")
    private WebElement addFontButton;

    @FindBy(xpath = "//*[@id=\"example-text\"]")
    private WebElement addText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div[3]/div[2]/div[2]/button")
    private WebElement addButtonButton;

    @FindBy(className = "btn-nav-next")
    private WebElement addNextButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/button")
    private WebElement addTemplate;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div")
    private WebElement infoBox;

    @FindBy(xpath = "//*[@id='modal-root']/div/div/div[2]/div[2]/div[5]/div")
    private WebElement imageTile;

    @FindBy (xpath = "//*[@id=\"modal-root\"]/div/div/div[2]/div[2]/div[3]/div/button")
    private WebElement choseimage;

    @FindBy (xpath = "//*[@id=\"meta-page-name\"]")
    private WebElement addPageName;

    @FindBy (className = "btn-nav-save")
    private WebElement finalSaveButton;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[1]")
    private WebElement openImagePopup;

    public AddStoryPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public AddStoryPage fillAddStoryForm(String storyName) {
        fillElement(nameField, storyName);
        return this;
    }

    public AddStoryPage submitAddStoryForm() {
        clickElement(saveButton);
        return this; //new StoryPage(driver, logger);
    }
    public AddStoryPage fillNewStory(String text, String pagename) {
        clickElement(addFontButton);
        fillElement(addText, text);
        clickElement(addButtonButton);
        clickElement(addNextButton);
        clickElement(addTemplate);
        clickElement(addNextButton);
        clickElement(addNextButton);

        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Panels Story Builder";
        Assert.assertEquals(ExpectedTitle, ActualTitle);

        clickElement(openImagePopup);

        dbClickElement(imageTile);


        String pageName = "My Super Story";
        fillElement(pageNameField, pageName);
        String actualPageName =  pageNamePreview.getText();
        Assert.assertEquals(actualPageName, pageName);

        clickElement(finalSaveButton);
        return this;
    }

    public boolean isInfoBoxDisplayed() {
        return isElementDisplayed(infoBox);
    }







}
