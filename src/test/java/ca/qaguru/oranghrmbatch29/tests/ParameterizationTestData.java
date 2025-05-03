package ca.qaguru.oranghrmbatch29.tests;

import org.testng.annotations.DataProvider;

public class ParameterizationTestData {
    @DataProvider(name = "LoginInfo")
    public Object[][] getUserInfo(){
        return new Object[][]{
                {"joe", "joe123"},
                {"Hary", "Password"}
        };
    }
}
