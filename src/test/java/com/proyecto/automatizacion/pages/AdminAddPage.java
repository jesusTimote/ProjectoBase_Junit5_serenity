package com.proyecto.automatizacion.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.NoSuchElementException;
import com.proyecto.automatizacion.utils.Utilities;
import net.thucydides.core.annotations.findby.By;

public class AdminAddPage extends PageObject {

    @FindBy(xpath = "//span")
    public List<WebElementFacade> menuOptions;

    @FindBy(xpath = "//button[contains(.,'Add')]")
    public WebElementFacade addButton;

    @FindBy(name = "firstName")
    public WebElementFacade firstNameInput;

    @FindBy(name = "middleName")
    public WebElementFacade middleNameInput;

    @FindBy (name = "lastName")
    public WebElementFacade lastNameInput;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    public WebElementFacade userNameInput;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElementFacade passwordInput;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElementFacade confirmPasswordInput;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    public WebElementFacade saveButton;

    @FindBy(xpath = "//input[@type='checkbox']/following-sibling::span[1]")
    public WebElementFacade DetailsCheckbox;

    @FindBy(xpath = "//label[text()='Enabled']")
    public WebElementFacade enabledCheckbox;

    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[1]")
    public WebElementFacade nacionalidadSelect;

    public String opcionNacionalidad="//div[contains(@class,'oxd-select-option')]//span[text()='${nacionalidad}']";

    @FindBy(xpath = "//label[text()='Marital Status']/following::div[contains(@class,'oxd-select-text')]")
    public WebElementFacade selectEstadoCivil;

    public String opcionEstadoCivil="//div[contains(@class,'oxd-select-option')]//span[text()='${estadoCivil}']";

    public String opcionGenero="//label[text()='${genero}']";

    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[2]")
    public WebElementFacade fechaNacimientoInput;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElementFacade submitButton;



}







