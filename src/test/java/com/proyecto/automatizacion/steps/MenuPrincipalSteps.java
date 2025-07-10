package com.proyecto.automatizacion.steps;

import com.proyecto.automatizacion.pages.MenuPrincipalPage;


import static org.assertj.core.api.Assertions.assertThat;


public class MenuPrincipalSteps {


    MenuPrincipalPage loginPage;

    public void ingresarCredenciales(String username, String password) {
        loginPage.ingresarCredenciales(username, password);
    }

    public void verificarRedireccionDashboard() {
        loginPage.obtenerTituloDashboard();
    }

    public void verificarMensajeError(String mensajeEsperado) {

        assertThat(loginPage.obtenerMensajeError())
                .as("Verificar mensaje de error")
                .isEqualTo(mensajeEsperado);
    }

}
