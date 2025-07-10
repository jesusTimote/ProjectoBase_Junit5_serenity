package com.proyecto.automatizacion.hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Hooks {

    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);

    private WebDriver driver;

    @Before
    public void setUp() {
        LOGGER.info("==== Iniciando escenario ====");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ThucydidesWebDriverSupport.useDriver(driver); // Integrar con Serenity
    }

    @After
    public void tearDown() {
        LOGGER.info("==== Finalizando escenario ====");
        if (driver != null) {
            driver.quit();
        }
    }
}