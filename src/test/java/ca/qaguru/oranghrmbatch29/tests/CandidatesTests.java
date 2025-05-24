package ca.qaguru.oranghrmbatch29.tests;

import ca.qaguru.oranghrmbatch29.library.TestBase;
import ca.qaguru.oranghrmbatch29.pages.CandidatesPage;
import ca.qaguru.oranghrmbatch29.pages.LoginPage;
import ca.qaguru.oranghrmbatch29.pages.VacaniesPage;
import org.testng.annotations.Test;

public class CandidatesTests extends TestBase {
    @Test
    public void addACandidate() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        // HeaderPage headerPage = new HeaderPage(driver);
        //headerPage.selectMenu(MenuOptions.CANDIDATES);
        CandidatesPage candidatesPage = new CandidatesPage(driver);

        candidatesPage.addNewCandidate("Koraa","Mathai","k@cmail.com","23344566666","5 years");


    }
    @Test
    public void doSearch(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        CandidatesPage candidatesPage = new CandidatesPage(driver);
       candidatesPage.doSearch("John Doe");

    }


}
//input[@class='oxd-input oxd-input--active oxd-input--error']