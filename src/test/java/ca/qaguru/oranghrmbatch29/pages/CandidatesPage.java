package ca.qaguru.oranghrmbatch29.pages;


import ca.qaguru.oranghrmbatch29.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Date;
import java.util.List;

public class CandidatesPage extends PageBase {
    WebDriver driver;
    public static final String CANDIDATES = "//*[text()='Recruitment']";
    private final String firstName = "//input[@name='firstName']";
    private final String middleName = "//input[@name='middleName']";
    private final String lastName = "//input[@name='lastName']";
    private final String vacancy = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']";
    private final String email = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//following::input[4]";
    private final String contactNumber = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//following::input[5]";
    private final String Resume = "//*[text()='Browse']";
    private final String resumePath = "";
    private final String keywords = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//following::input[6]";
    private final String dateOfApplication = "//*[@class='oxd-icon bi-calendar oxd-date-input-icon']";
    private final String notes = "//textarea";
    private final String consent = "//div[@class='oxd-checkbox-wrapper']";
    private final String isRequiredMessage = "//*[text()=' * Required']";
    private final String isSaveBtn = "//button[text()=' Save ']";
    private final String isCancelBtn = "//button[text()=' Cancel ']";
    private final String candidatesRecord = "//div[@class='oxd-table-body oxd-card-table-body']";
    @FindBy(xpath = candidatesRecord)
    private final String isAddCandidateBtn = "//*[text()=' Add ']";
    private final String searchName = "//div[@class='oxd-autocomplete-wrapper']";
    private final String recordsFound = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span[@class='oxd-text oxd-text--span']";
    private final String idSearchBtn = "//button[@class= 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']";
    @FindBy(className = "oxd-select-text-input")
    WebElement dropDownVacancy;
    private List<WebElement> candidates;
    private final String addedCandidate = "//div[text()='Koraa  Mathai']";
    @FindBy(xpath = "//div[@class='oxd-form-row']//following::div[@class='oxd-select-text-input']")
    List<WebElement> dropdownStatus;
    private final String tblCandidates = "oxd-table";
    private final String candidatesFound = "//div[@class='oxd-table-body']//div[@class='oxd-table-cell oxd-padding-cell'][3]";
    @FindBy(xpath = candidatesFound)
    List<WebElement>listCandidates;
    public CandidatesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void addNewCandidate(String fName, String lName, String eMail, String phone, String notesToAdd) {
        click(By.xpath(CANDIDATES));
        click(By.xpath(isAddCandidateBtn));
        setText(By.xpath(firstName), fName);
        setText(By.xpath(lastName), lName);
        sleep(1000);
        dropDownVacancy.click();
        for (int i = 0; i < 4; i++) {  // Adjust this based on how many options you want to scroll through
            dropDownVacancy.sendKeys(Keys.ARROW_DOWN);  // Simulates pressing the arrow down key
        }
        sleep(1000);
        setText(By.xpath(email), eMail);
        setText(By.xpath(contactNumber), phone);
        //  setText(By.xpath(dateOfApplication),dateToday);
        setText(By.xpath(notes), notesToAdd);
        click(By.xpath(consent));
        sleep(2000);
        click(By.xpath(isSaveBtn));
        click(By.xpath(CANDIDATES));
        String actualValue = getText(By.xpath(addedCandidate));
        String expectedValue = fName + " " + lName;
        Assert.assertEquals(actualValue, expectedValue);

    }

    public void doSearch(String name) {
        click(By.xpath(CANDIDATES));
        sleep(1000);
         for (int i = 0; i < 3; i++) {
             dropdownStatus.get(1).sendKeys(Keys.ARROW_DOWN);

         }
         dropdownStatus.get(1).sendKeys(Keys.ENTER);
        sleep(2000);
        click(By.xpath(idSearchBtn));
        System.out.println("records found " + getText(By.xpath(recordsFound)));
        sleep(1000);

        for (WebElement Candidates : listCandidates) {
            String txtCandidates = Candidates.getText();
            System.out.println(txtCandidates);

        }
    }
}
