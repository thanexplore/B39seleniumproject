package ca.qaguru.oranghrmbatch29.tests;

import ca.qaguru.oranghrmbatch29.library.TestBase;
import ca.qaguru.oranghrmbatch29.pages.HeaderPage;
import ca.qaguru.oranghrmbatch29.pages.LanguagePage;
import ca.qaguru.oranghrmbatch29.pages.LoginPage;
import ca.qaguru.oranghrmbatch29.pages.MenuOptions;
import org.testng.annotations.Test;


public class LanguageTests extends TestBase {
    @Test
public void docheckAndUncheck() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("Admin", "admin123", true, null);
    //HeaderPage headerPage = new HeaderPage(driver);
  //  headerPage.selectMenu(MenuOptions.SKILLS);
    LanguagePage languagePage = new LanguagePage(driver);
    languagePage.checkAndUncheck();

}

}
