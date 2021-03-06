package com.epam.core.webdriver;

import com.epam.core.Configuration;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverFactory extends DriverFactory {

    private static final Logger LOGGER = LogManager.getLogger(AndroidDriverFactory.class);

    @Override
    WebDriver createDriver() {
        WebDriver driver = null;
        DesiredCapabilities capabilities = loadCapabilitiesFromProperties("android");
        String url = Configuration.getAppiumURL();

        try {
            driver = new AndroidDriver<>(new URL(url), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            LOGGER.error("Malformed URL: " + url);
        }
        return driver;
    }
}
