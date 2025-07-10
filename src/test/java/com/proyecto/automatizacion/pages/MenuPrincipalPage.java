package com.proyecto.automatizacion.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;


import static java.time.Duration.ofSeconds;

public class MenuPrincipalPage extends PageObject {

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='oxd-brand-banner']//img[1]")
    private WebElement logo;


    public void ingresarCredenciales(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

    }

    public void obtenerTituloDashboard() {

        waitFor(logo).withTimeoutOf(ofSeconds(15)).isPresent();

    }

    public String obtenerMensajeError() {
        return errorMessage.getText();
    }


}
