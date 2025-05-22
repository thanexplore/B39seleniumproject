package ca.qaguru.oranghrmbatch29.pages;

import ca.qaguru.oranghrmbatch29.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class VacaniesPage extends PageBase {
    WebDriver driver;

    public final String routeRecruitmentPage = "//*[text()='Recruitment']";
    public final String routeVacancyPage = "//a[text()='Vacancies']";
    private final String idResetBtn ="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']";
    public final String tblVacancy= "//div[@class='oxd-table']";
    public final String vacancies = "//div[@class='oxd-table-body']//div[@class='oxd-table-cell oxd-padding-cell'][3]";
    @FindBy(className = "oxd-select-text-input")
    List<WebElement> dropdownValue;
    @FindBy(xpath = vacancies)
    public List<WebElement> listVacancies;
    @FindBy(tagName = "button")
    public List<WebElement> btnReset;


  public VacaniesPage (WebDriver driver){
      super(driver);
      this.driver = driver;
      PageFactory.initElements(driver,this);
  }
   public void doReset()  {
      click(By.xpath(routeRecruitmentPage));
      sleep(1000);
      click(By.xpath(routeVacancyPage));

       sleep(1000);
       dropdownValue.get(0).sendKeys(Keys.ARROW_DOWN);
       dropdownValue.get(0).sendKeys(Keys.ENTER);
      dropdownValue.get(1).sendKeys(Keys.ARROW_DOWN);
      dropdownValue.get(1).sendKeys(Keys.ENTER);
       dropdownValue.get(2).sendKeys(Keys.ARROW_DOWN);
       dropdownValue.get(2).sendKeys(Keys.ENTER);
       dropdownValue.get(3).sendKeys(Keys.ARROW_DOWN);
       dropdownValue.get(3).sendKeys(Keys.ENTER);
       sleep(3000);

     sleep(3000);
       for (WebElement Vacancies : listVacancies) {
           String txtVacancies = Vacancies.getText();
           System.out.println(txtVacancies);

       }
       click(By.xpath(idResetBtn));
       String actualValue = dropdownValue.get(1).getText();
       String expectedValue = "-- Select --";
       Assert.assertEquals(actualValue,expectedValue);
   }

}
