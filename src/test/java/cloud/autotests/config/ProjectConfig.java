package cloud.autotests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/app.properties1",
        "classpath:config/local.properties1"
})
public interface ProjectConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();
    @Key("browserVersion")
    @DefaultValue("99.0")
    String browserVersion();
    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();
    @Key("browserMobileView")
    String browserMobileView();
    @Key("remoteDriverUrl")
    String remoteDriverUrl();
    @Key("videoStorage")
    String videoStorage();
    @Key("login")
    String login();
    @Key("password")
    String password();
    @Key("url")
    String url();
}
