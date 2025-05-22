package ca.qaguru.oranghrmbatch29.tests;

import ca.qaguru.oranghrmbatch29.library.TestBase;
import ca.qaguru.oranghrmbatch29.pages.HeaderPage;
import ca.qaguru.oranghrmbatch29.pages.LoginPage;
import ca.qaguru.oranghrmbatch29.pages.MenuOptions;
import ca.qaguru.oranghrmbatch29.pages.VacaniesPage;
import org.testng.annotations.Test;

public class VacanciesTest extends TestBase {
    @Test
    public  void  doResetWithVacancy()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
       // HeaderPage headerPage = new HeaderPage(driver);
        VacaniesPage vacaniesPage = new VacaniesPage(driver);
        vacaniesPage.doReset();
    }


}
