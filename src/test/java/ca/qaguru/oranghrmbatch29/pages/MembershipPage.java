package ca.qaguru.oranghrmbatch29.pages;

import ca.qaguru.oranghrmbatch29.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MembershipPage extends PageBase{
    WebDriver driver;
    private final String idAddBtn = "//button[text()=' Add ']";
    private final String nameOfMembership = "//label[text()='Name']//following::input[@class='oxd-input oxd-input--active']";
    private final String isRequiredMSg = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']";
    private final String idCancelBtn = "//button[text()=' Cancel ']";
    private final String idSaveBtn = "//button[text()=' Save ']";
    private final String tblMemebership = "//div[@class='oxd-table']";
    private final String memberships = "//div[@class='oxd-table-card']";
    @FindBy(xpath = memberships)
    private List<WebElement> listMembership;


    public MembershipPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void addMembership(String membershipName){
        sleep(500);
        click(By.xpath(idAddBtn));
        sleep(200);
        driver.findElement(By.xpath(nameOfMembership)).sendKeys(membershipName);
        sleep(300);
        if (getText(By.xpath(isRequiredMSg)).contains("Already exists"))
        {
            System.out.println("cancelling");
            click(By.xpath(idCancelBtn));
            sleep(100);

        } else
        {
            click(By.xpath(idSaveBtn));
        }
        isElementVisible(By.xpath(tblMemebership));
        for (WebElement Membership : listMembership){
            String txtMembership = Membership.getText();
            System.out.println(txtMembership);
        }
    }
}
