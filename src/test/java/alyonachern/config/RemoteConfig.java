package alyonachern.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${launch}.properties"
})
public interface RemoteConfig extends Config{
    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("version")
    @DefaultValue("100.0")
    String getVersion();

    @Key("windowSize")
    @DefaultValue("1920x1080")
    String getWindowSize();

    @Key("remote")
    String remote();
}
