package ca.qaguru.oranghrmbatch29.tests;

import ca.qaguru.oranghrmbatch29.library.TestBase;
import ca.qaguru.oranghrmbatch29.pages.HeaderPage;
import ca.qaguru.oranghrmbatch29.pages.LanguagePage;
import ca.qaguru.oranghrmbatch29.pages.LoginPage;
import ca.qaguru.oranghrmbatch29.pages.MenuOptions;
import org.testng.annotations.Test;


public class LanguageTests extends TestBase {
    @Test (priority = 1)
public void docheckAndUncheck() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("Admin", "admin123", true, null);
    //HeaderPage headerPage = new HeaderPage(driver);
  //  headerPage.selectMenu(MenuOptions.SKILLS);
    LanguagePage languagePage = new LanguagePage(driver);
    languagePage.checkAndUncheck();

}
@Test
    public void addNewLanguage(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("Admin", "admin123", true, null);
    HeaderPage headerPage = new HeaderPage(driver);
   // headerPage.selectMenu(MenuOptions.LANGUAGES);
    LanguagePage languagePage = new LanguagePage(driver);
    languagePage.addNewLanguage("Tamil");

}
@Test (priority = 2)
    public void scrollDownToALanguage(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("Admin", "admin123", true, null);
    HeaderPage headerPage = new HeaderPage(driver);
    // headerPage.selectMenu(MenuOptions.LANGUAGES);
    LanguagePage languagePage = new LanguagePage(driver);
  languagePage.scrollDownALanguage("Tamil");
}
@Test (priority = 3)
    public void editALanguage(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("Admin", "admin123", true, null);
    HeaderPage headerPage = new HeaderPage(driver);
    // headerPage.selectMenu(MenuOptions.LANGUAGES);
    LanguagePage languagePage = new LanguagePage(driver);
    languagePage.editALanguage("Tamil");
}
@Test (priority = 4)
    public void deleteALanguage(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("Admin", "admin123", true, null);
    HeaderPage headerPage = new HeaderPage(driver);
    // headerPage.selectMenu(MenuOptions.LANGUAGES);
    LanguagePage languagePage = new LanguagePage(driver);
    languagePage.deleteALanguage("Tamil");

}
}
