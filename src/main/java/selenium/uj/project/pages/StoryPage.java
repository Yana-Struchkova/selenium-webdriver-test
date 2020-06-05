package selenium.uj.project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoryPage extends DefaultPage{

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/nav/a[1]")
    private WebElement addStoryButton;



    public StoryPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public AddStoryPage openAddStoryPage() {
        clickElement(addStoryButton);
        return new AddStoryPage(driver, logger);
    }


}
