package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

    public WebDriver driver;
    public CalculatorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(css = "div[role=\"presentation\"]:nth-of-type(1)")
    private WebElement inputField;

    @FindBy(css = "span[class=\"vUGUtc\"]")
    private WebElement memoryString;

    @FindBy(css = "span[class=\"qv3Wpe\"]")
    private WebElement answer;

    public void InputData(String Data){
        inputField.click();
        inputField.sendKeys(Data);
        inputField.sendKeys(Keys.ENTER);
    }

    public void shouldBeCorrectAnswer(){
        Assert.assertEquals("0", answer.getText());
    }
    public void shouldBeMemoryString(){
        Assert.assertEquals("1 × 2 - 3 + 1 =", memoryString.getText());
    }
}
