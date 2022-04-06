package com.yandex.smerh8;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CalculatorPage;
import pages.SearchPage;
import java.util.concurrent.TimeUnit;

public class CalcTest {
    public static SearchPage searchPage;
    public static CalculatorPage calculatorPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        calculatorPage = new CalculatorPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/"); }

    @Test
    public void CalculatorTest(){
        searchPage.inputSequence("Калькулятор");
        searchPage.StartSearch();
        calculatorPage.InputData("1*2-3+1");
        calculatorPage.shouldBeCorrectAnswer();
        calculatorPage.shouldBeMemoryString();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit(); }
}
