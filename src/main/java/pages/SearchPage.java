package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public WebDriver driver;
    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(css = "input[class]")
    private WebElement searchField;

    @FindBy(css = "input[role=\"button\"]")
    private WebElement searchButton;

    public void inputSequence(String Sequence){
        searchField.click();
        searchField.sendKeys(Sequence);
    }

    public void StartSearch(){
        searchButton.click();
    }
}
