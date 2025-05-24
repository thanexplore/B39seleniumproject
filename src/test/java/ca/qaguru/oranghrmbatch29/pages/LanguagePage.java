package ca.qaguru.oranghrmbatch29.pages;

import ca.qaguru.oranghrmbatch29.library.PageBase;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LanguagePage extends PageBase {

    WebDriver driver;
    public final String adminPageRouter = "//span[text()='Admin']";
    public final String qualificationNav = "//span[text()='Qualifications ']";
    public final String languagePageRouter = "//a[text()='Languages']";
    private final String deleteSelectedBtn = "//button[text()=' Delete Selected ']";
    private final String checkALL = "//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']";
    private final String unCheckALl = "//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']";

    public LanguagePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkAndUncheck() {
        click(By.xpath(adminPageRouter));
        sleep(300);
        click(By.xpath(qualificationNav));
        sleep(300);
        click(By.xpath(languagePageRouter));
        sleep(500);
        click(By.xpath(checkALL));
        mouseHover(By.xpath(deleteSelectedBtn));

        Assert.assertTrue(isElementPresent(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']")), "Assertion fail for delete button styling");
        sleep(1000);
        click(By.xpath(unCheckALl));
        sleep(3000);
        System.out.println("Testing Checkbox checking and unchecking with mousehovering over the delete button ");
    }


}
