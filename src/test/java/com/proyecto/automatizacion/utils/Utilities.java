package com.proyecto.automatizacion.utils;


import io.cucumber.java.en.Given;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utilities extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(Utilities.class);
    private static final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    public void openUrl() {
        String urlWeb = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base.url");
        if (urlWeb == null || urlWeb.isEmpty()) {
            LOGGER.error("La propiedad base.url no está definida en serenity.conf");
            throw new RuntimeException("No se encontró la propiedad base.url en serenity.conf");
        }

        getDriver().get(urlWeb);

    }

    @Given("inicio session en la web de la aplicacion")
    public void the_user_is_on_the_login_page() {
        openUrl();
        LOGGER.info("Navegando a la página de inicio de sesión: {}", EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base.url"));

    }

    public WebElementFacade getOpcionReplace(String xpath, String objects, String parametro) {
        String xpathFinal = xpath.replace(objects, parametro);
        return find(By.xpath(xpathFinal));
    }

}
