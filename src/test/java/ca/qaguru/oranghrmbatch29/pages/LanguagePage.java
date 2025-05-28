package ca.qaguru.oranghrmbatch29.pages;

import ca.qaguru.oranghrmbatch29.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LanguagePage extends PageBase {

    WebDriver driver;
    public final String adminPageRouter = "//span[text()='Admin']";
    public final String qualificationNav = "//span[text()='Qualifications ']";
    public final String languagePageRouter = "//a[text()='Languages']";
    private final String deleteSelectedBtn = "//button[text()=' Delete Selected ']";
    private final String checkALL = "//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']";
    private final String unCheckALl = "//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']";
    private final String addBtn = "//button[text()=' Add ']";
    private final String inputLanguage = "//div [@class='']//input[@class='oxd-input oxd-input--active']";
    private final String isRequiredMSg = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']";
    private final String idCancelBtn = "//button[text()=' Cancel ']";
    private final String lblAlreadyExistsMessage = "//div[@class='oxd-form-row'] /div";
    private final String idSaveBtn = "//button[text()=' Save ']";
    private final String tblLanguage = "//div[@class='oxd-table']";
    private final String languages = "//div[@class='oxd-table-card']";
    @FindBy(xpath = languages)
    private List<WebElement> listLanguage;
    private final String trashBtn = "//button[@class='oxd-icon-button oxd-table-cell-action-space']//i[@class='oxd-icon bi-trash']";
    private final String editBtn = "//button[@class='oxd-icon-button oxd-table-cell-action-space']//i[@class='oxd-icon bi-pencil-fill']";
    private final String selectADiv = "//div";
    private final String noCancelBtn = "//button[text()=' No, Cancel ']";
    private final String yesDeleteBtn = "//button[text()=' Yes, Delete ']";

    public LanguagePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkAndUncheck() {

        click(By.xpath(adminPageRouter));

        click(By.xpath(qualificationNav));

        click(By.xpath(languagePageRouter));

        click(By.xpath(checkALL));
        mouseHover(By.xpath(deleteSelectedBtn));

        Assert.assertTrue(isElementPresent(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']")), "Assertion fail for delete button styling");


        click(By.xpath(unCheckALl));

        System.out.println("Testing Checkbox checking and unchecking with mousehovering over the delete button ");


    }

    public void addNewLanguage(String newLanguage) {

        click(By.xpath(adminPageRouter));
        click(By.xpath(qualificationNav));
        click(By.xpath(languagePageRouter));
        click(By.xpath(addBtn));
        findElement(By.xpath(inputLanguage), newLanguage);

        if (getText(By.xpath(lblAlreadyExistsMessage)).contains("Already exists")) {
            System.out.println("cancelling");
            click(By.xpath(idCancelBtn));
        } else {

            click(By.xpath(idSaveBtn));
        }
        isElementVisible(By.xpath(languages));
        for (WebElement Language : listLanguage) {
            String txtLanguage = Language.getText();
            System.out.println(txtLanguage);
        }
        Boolean match = listLanguage.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(newLanguage));
        Assert.assertTrue(match);
        System.out.println("\n");
        System.out.println(newLanguage + " is added successfully");
        System.out.println("\n");

    }

    public void scrollDownALanguage(String dataToScroll) {
        int counter = 0;
        int locator = 0;
        click(By.xpath(adminPageRouter));
        click(By.xpath(qualificationNav));
        click(By.xpath(languagePageRouter));
        isElementVisible(By.xpath(languages));
        for (WebElement Language : listLanguage) {
            counter++;
            String txtLanguage = Language.getText();
            if (txtLanguage.equalsIgnoreCase(dataToScroll)) {
                locator = counter;
                // System.out.println(locator);
            }
        }

        String strLocator = String.valueOf(locator);
        String srchCard = languages + "[" + strLocator + "]";


        scrollInToView(By.xpath(srchCard));
        String scrolldata = getText(By.xpath(srchCard));
        System.out.println(scrolldata);

        mouseHover(By.xpath(languages + "[" + strLocator + "]"));

        Assert.assertEquals(scrolldata, dataToScroll, "not matching");


    }

    public void editALanguage(String dataToEdit) {
        int counter = 0;
        int locator = 0;
        click(By.xpath(adminPageRouter));
        click(By.xpath(qualificationNav));
        click(By.xpath(languagePageRouter));
        isElementVisible(By.xpath(languages));
        for (WebElement Language : listLanguage) {
            counter++;
            String txtLanguage = Language.getText();
            if (txtLanguage.equalsIgnoreCase(dataToEdit)) {
                locator = counter;
                //System.out.println(locator);
            }
        }


        String strLocator = String.valueOf(locator);
        String srchCard = selectADiv + "[" + strLocator + "]" + editBtn;


        scrollInToView(By.xpath(srchCard));

        mouseHover(By.xpath(srchCard));

        click(By.xpath(srchCard));


        click(By.xpath(idSaveBtn));
        isElementVisible(By.xpath(languages));
        for (WebElement Language : listLanguage) {
            String txtLanguage = Language.getText();
            System.out.println(txtLanguage);
        }
        Boolean match = listLanguage.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(dataToEdit));
        Assert.assertTrue(match);
        System.out.println("\n");
        System.out.println(dataToEdit + " is edited successfully");
        System.out.println("\n");
    }

    public void deleteALanguage(String dataToDelete) {
        int counter = 0;
        int locator = 0;
        click(By.xpath(adminPageRouter));
        click(By.xpath(qualificationNav));
        click(By.xpath(languagePageRouter));
        isElementVisible(By.xpath(languages));
        for (WebElement Language : listLanguage) {
            counter++;
            String txtLanguage = Language.getText();
            if (txtLanguage.equalsIgnoreCase(dataToDelete)) {
                locator = counter;
                //  System.out.println(locator);
            }
        }


        String strLocator = String.valueOf(locator);
        String srchCard = selectADiv + "[" + strLocator + "]" + trashBtn;
        //System.out.println(srchCard);

        scrollInToView(By.xpath(srchCard));

        mouseHover(By.xpath(srchCard));

        click(By.xpath(srchCard));
        click(By.xpath(yesDeleteBtn));
        isElementVisible(By.xpath(languages));
        for (WebElement Language : listLanguage) {
            String txtLanguage = Language.getText();
            System.out.println(txtLanguage);
        }
        Boolean match = listLanguage.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(dataToDelete));
        Assert.assertFalse(match, "not deleted");
        System.out.println("\n");
        System.out.println(dataToDelete + " is deleted successfully");
        System.out.println("\n");

    }


}


