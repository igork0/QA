package uiTests;

import Selenium.insta.page_factory.SendMessage.BO.MessageBO;
import Selenium.insta.page_factory.login.BO.LoginBO;
import Selenium.insta.paralel_run.BrowserFactory;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_helper.BaseTest;

@Test
public class MessageTC extends BaseTest {

    @DataProvider(parallel = true)
    public static Object[][] browserDataProvider() {
        return new Object[][]{
                {"chrome"}
                //,{"firefox"}
                //,{"Opera"}
                //,{"IE"}
                //,{"Safari"}
        };
    }

    @Test(dataProvider = "browserDataProvider")
    @Severity(SeverityLevel.CRITICAL)
    public void MessageTest(String browserName) {
        BrowserFactory.initDriver(browserName);

        LoginBO loginBO = new LoginBO();

        //Step1
        Assert.assertTrue(loginBO.login(),"login Failed!");

        MessageBO messageBO = new MessageBO();

        //Step1
        Assert.assertTrue(messageBO.sendMessage(),"sendMessage Failed!");

    }
}


