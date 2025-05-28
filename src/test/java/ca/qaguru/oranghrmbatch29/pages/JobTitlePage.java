package ca.qaguru.oranghrmbatch29.pages;

import ca.qaguru.oranghrmbatch29.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class JobTitlePage extends PageBase {
    WebDriver driver;
    private final String idJTitleAddBtn = ".oxd-button--secondary";
    private final String idJobTxtTitle = "div[class='oxd-form-row'] input[class*='oxd-input']";
    private final String idJTitleSaveBtn = "//button[@type='submit']";
    private final String lblAlreadyExistsMsg = "//div[@class='oxd-form-row'] /div";
    private final String getIdJTitleCancelBtn = "//div[@class='oxd-form-actions'] /button[1]";
    private final String tblJobTitle = ".oxd-table-body";
    private final String jobTitle = "//div[@class='oxd-table-body'] /div[@class='oxd-table-card']";
    private String xpathSuccessMessage = "//div[@class=\"oxd-toast oxd-toast--success oxd-toast-container--toast\"]";
    private final String descripJobTitle = "div[class='oxd-form-row'] textarea[class*='oxd-textarea']";
    private final String idJTitleEditBtn = "//i[@class=\"oxd-icon bi-pencil-fill\"]";
    private final String deleteSelectBtn = "//button[text()=' Delete Selected ']";
    private final String checkALL = "//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']";
    private final String unCheckALl = "//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']";
    //private final String idJTitleEditBtn = "//i[@class=\"oxd-icon-button oxd-table-cell-action-space\"]";
    public Boolean editSuccess;
    @FindBy(xpath = jobTitle)
    private List<WebElement> listJobTitle;
    //@FindBy(xpath = "//i[@class=\"oxd-icon bi-trash\"]")
    //List<WebElement> delete;
    private final String trashBtn = "//button[@class='oxd-icon-button oxd-table-cell-action-space']//i[@class='oxd-icon bi-trash']";
    private final String editBtn = "//button[@class='oxd-icon-button oxd-table-cell-action-space']//i[@class='oxd-icon bi-pencil-fill']";
    private final String selectADiv = "//div";
    private final String noCancelBtn = "//button[text()=' No, Cancel ']";
    private final String yesDeleteBtn = "//button[text()=' Yes, Delete ']";
    //@FindBy(xpath = "//i[@class=\"oxd-icon bi-pencil-fill\"]")
   // @FindBy(xpath = "//i[@class=\"oxd-icon-button oxd-table-cell-action-space\"]")
    private List<WebElement> edit;
    @FindBy(xpath = "//div[@class=\"oxd-table-body\"] //div[@class=\"oxd-table-cell oxd-padding-cell\"][2]")
    List<WebElement> listOfRecordNames;


    public JobTitlePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void saveNewJobTitle(String jobtitle) {
        click(By.cssSelector(idJTitleAddBtn));
        setText(By.cssSelector(idJobTxtTitle), jobtitle);
        if (getText(By.xpath(lblAlreadyExistsMsg)).contains("Already exists")) {
            click(By.xpath(getIdJTitleCancelBtn));
        } else {
            click(By.xpath(idJTitleSaveBtn));
        }
        isElementVisible(By.cssSelector(tblJobTitle));

        for (WebElement JobTitle : listJobTitle) {
            String txtJobTitle = JobTitle.getText();
            System.out.println(txtJobTitle);

        }
        Boolean match = listJobTitle.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(jobtitle));
        Assert.assertTrue(match);
        System.out.println("\n");
        System.out.println(jobtitle + " is added successfully");
        System.out.println("\n");
    }

    public void SelectAllJobTitle(){
        click(By.xpath(checkALL));
        mouseHover(By.xpath(deleteSelectBtn));

        Assert.assertTrue(isElementPresent(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']")), "Assertion fail for delete button styling");
        click(By.xpath(unCheckALl));
        System.out.println("Testing Checkbox checking and unchecking with mousehovering over the delete button ");
    }

    public void editJobTitle(String dataToEdit) {
        int counter = 0;
        int locator = 0;

        isElementVisible(By.xpath(jobTitle));
        for (WebElement JobTitle : listJobTitle) {
            counter++;
            String txtJobTitle = JobTitle.getText();
            if (txtJobTitle.equalsIgnoreCase(dataToEdit)) {
                locator = counter;

            }
        }


        String strLocator = String.valueOf(locator);
        String srchCard = selectADiv + "[" + strLocator + "]" + editBtn;


        scrollInToView(By.xpath(srchCard));

        mouseHover(By.xpath(srchCard));

        click(By.xpath(srchCard));


        click(By.xpath(idJTitleSaveBtn));
        isElementVisible(By.xpath(jobTitle));
        for (WebElement Language : listJobTitle) {
            String txtLanguage = Language.getText();
            System.out.println(txtLanguage);
        }
        Boolean match = listJobTitle.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(dataToEdit));
        Assert.assertTrue(match);
        System.out.println("\n");
        System.out.println(dataToEdit + " is edited successfully");
        System.out.println("\n");
    }


    public void deleteJobTitle(String dataToDelete) {
        int counter = 0;
        int locator = 0;

        isElementVisible(By.xpath(jobTitle));
        for (WebElement JTitle : listJobTitle) {
            counter++;
            String txtJTitles = JTitle.getText();
            if (txtJTitles.equalsIgnoreCase(dataToDelete)) {
                locator = counter;
                //  System.out.println(locator);
            }
        }

        String strLocator = String.valueOf(locator);
        String srchCard = selectADiv + "[" + strLocator + "]" + trashBtn;

        scrollInToView(By.xpath(srchCard));

        mouseHover(By.xpath(srchCard));

        click(By.xpath(srchCard));
        click(By.xpath(yesDeleteBtn));

        for (WebElement JobTitle : listJobTitle) {
            String txtJobTitle = JobTitle.getText();
            System.out.println(txtJobTitle);
        }
        Boolean match = listJobTitle.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(dataToDelete));
        Assert.assertFalse(match, "not deleted");
        System.out.println("\n");
        System.out.println(dataToDelete + " is deleted successfully");
        System.out.println("\n");

    }

    public void deleteCancel(String dataToDelete) {
        int counter = 0;
        int locator = 0;

        isElementVisible(By.xpath(jobTitle));
        for (WebElement JTitle : listJobTitle) {
            counter++;
            String txtJTitles = JTitle.getText();
            if (txtJTitles.equalsIgnoreCase(dataToDelete)) {
                locator = counter;
            }
        }

        String strLocator = String.valueOf(locator);
        String srchCard = selectADiv + "[" + strLocator + "]" + trashBtn;

        scrollInToView(By.xpath(srchCard));

        mouseHover(By.xpath(srchCard));
        click(By.xpath(srchCard));
        click(By.xpath(noCancelBtn));

        for (WebElement JobTitle : listJobTitle) {
            String txtJobTitle = JobTitle.getText();
            System.out.println(txtJobTitle);
        }
        Boolean match = listJobTitle.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(dataToDelete));


    }

}
