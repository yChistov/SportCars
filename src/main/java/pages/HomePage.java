package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final String PAGE_URL = "https://www.google.com.ua/";

    @FindBy(css = ".gLFyf.gsfi")
    private WebElement searchLine;

    @FindBy(css = ".ab_tnav_wrp #resultStats")
    private WebElement searchStatus;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20, 15);
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void searchText(String text) {
        wait.until(ExpectedConditions.visibilityOf(searchLine)).sendKeys(text, Keys.ENTER);
    }

    public boolean getNumberOfResults() {
        String stringResults = wait.until(ExpectedConditions.visibilityOf(searchStatus)).getText();
        String stringCount = stringResults.replaceAll("[^0-9]", "").replaceAll(" ", "");
        long intSub = Long.parseLong(stringCount);
        System.out.println(intSub);
        return intSub > 1000000;
    }
}
// so i hear you. can you check the sound seetings?
// pini@stampli.com