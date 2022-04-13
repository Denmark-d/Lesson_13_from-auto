package cloud.autotests.tests;

import cloud.autotests.config.ProjectConfig;
import cloud.autotests.helpers.Attach;
import cloud.autotests.helpers.DriverSettings;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.closeWebDriver;


@ExtendWith({AllureJunit5.class})
public class TestBase {
    private static ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
        String login = config.login();
        String password = config.password();
        String url = config.url();
        String remoteUrl = "https://" + login + ":" + password + "@" + url;

        }


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
    }
