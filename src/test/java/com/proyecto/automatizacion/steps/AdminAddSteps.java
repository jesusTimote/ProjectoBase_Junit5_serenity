package com.proyecto.automatizacion.steps;

import com.proyecto.automatizacion.pages.AdminAddPage;

import java.util.NoSuchElementException;

import com.proyecto.automatizacion.utils.Utilities;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class AdminAddSteps {
    @Steps
    Utilities utilities;

    @Steps
    AdminAddPage adminAddPage;


    @Step("Seleccionar opción del menú: {0}")
    public void registrarAdministrador(String opcion) {
        // adminAddPage.buscarOpcionPorTexto(opcion);
        adminAddPage.menuOptions.stream()
                .filter(e -> e.getText().equals(opcion.trim()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No se encontró la opción: " + opcion))
                .click();
    }

    @Step("Agregar empleado")
    public void agregarEmpleado() {
        adminAddPage.addButton.click();
    }

    @Step("Ingresar datos del empleado")
    public void ingresarDatosEmpleado(String firstName, String middleName, String lastName, String userName, String password) throws InterruptedException {
        adminAddPage.firstNameInput.sendKeys(firstName);
        adminAddPage.middleNameInput.sendKeys(middleName);
        adminAddPage.lastNameInput.sendKeys(lastName);
        adminAddPage.DetailsCheckbox.click();
        adminAddPage.userNameInput.sendKeys(userName);
        adminAddPage.passwordInput.sendKeys(password);
        adminAddPage.confirmPasswordInput.sendKeys(password);
        adminAddPage.enabledCheckbox.click();
        Thread.sleep(2000);
        adminAddPage.saveButton.click();
    }

    @Step("Completar datos personales del usuario")
    public void datosPersonalesUsuario(String nacionalidad, String estadoCivil, String genero, String fechaNacimiento) throws InterruptedException {
        Thread.sleep(2000);
        adminAddPage.nacionalidadSelect.click();
        utilities.getOpcionReplace(adminAddPage.opcionNacionalidad, "${nacionalidad}", nacionalidad).waitUntilVisible().click();
        adminAddPage.selectEstadoCivil.click();
        utilities.getOpcionReplace(adminAddPage.opcionEstadoCivil, "${estadoCivil}", estadoCivil).waitUntilVisible().click();
        utilities.getOpcionReplace(adminAddPage.opcionGenero, "${genero}", genero).click();
        adminAddPage.fechaNacimientoInput.sendKeys(fechaNacimiento);
        adminAddPage.submitButton.click();
    }

}
