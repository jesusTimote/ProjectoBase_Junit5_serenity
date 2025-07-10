package com.proyecto.automatizacion.stepsDefinitions;

import com.proyecto.automatizacion.steps.AdminAddSteps;
import com.proyecto.automatizacion.steps.MenuPrincipalSteps;

import com.proyecto.automatizacion.utils.Complementos;
import com.proyecto.automatizacion.utils.ConfigManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginStepsDefinitions {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginStepsDefinitions.class);

    @Steps
    MenuPrincipalSteps menuPrincipalSteps;

    @Steps
    AdminAddSteps adminAddSteps;


    @When("el usuario ingresa un nombre de usuario y una contraseña validos")
    public void the_user_enters_valid_credentials() {
        menuPrincipalSteps.ingresarCredenciales
                (
                        ConfigManager.get("USERNAME"),
                        ConfigManager.get("PASSWORD")
                );
    }

    @Then("el usuario deberia ser redirigido al dashboard")
    public void elUsuarioDeberiaSerRedirigidoAlDashboard() {
        menuPrincipalSteps.verificarRedireccionDashboard();
    }

    @And("verifico el mensaje de error de login")
    public void verificoElMensajeDeErrorDeLogin() {
        String mensajeEsperado = "Invalid credentials";
        menuPrincipalSteps.verificarMensajeError(mensajeEsperado);
        LOGGER.info("Mensaje de error verificado: {}", mensajeEsperado);
    }

    @And("selecciono la opcion {string}")
    public void seleccionoLaOpcion(String opcion) {
        adminAddSteps.registrarAdministrador(opcion);
    }

    @Then("registro un nuevo usuario")
    public void registroUnNuevoUsuario() throws InterruptedException {
        adminAddSteps.agregarEmpleado();
    }

    @And("ingreso un nombre de usuario{string}, segundoNombre{string}, apellido {string}, nombre {string}, contraseña {string}")
    public void ingresoUnNombreDeUsuarioApellidoNombreContraseña(String firstName, String middleName, String lastName, String userName, String password) {
        try {
            adminAddSteps.ingresarDatosEmpleado(firstName, middleName, lastName, userName, password);
        } catch (InterruptedException e) {
            LOGGER.error("Error al ingresar los datos del empleado: {}", e.getMessage());
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }

    @And("completo los datos personales del usuario nacionalidad {string}, estado civil {string}, genero {string}, fecha de nacimiento {string}")
    public void completoLosDatosPersonalesDelUsuarioNacionalidadEstadoCivilGeneroFechaDeNacimiento(String nacionalidad, String estadoCivil, String genero, String fechaNacimiento) {
        try {
            adminAddSteps.datosPersonalesUsuario(nacionalidad, estadoCivil, genero, fechaNacimiento);
        } catch (Exception e) {
            LOGGER.error("Error al completar los datos personales. Nacionalidad: {}, Estado Civil: {}, Género: {}, Fecha de Nacimiento: {}. Detalle: {}",
                    nacionalidad, estadoCivil, genero, fechaNacimiento, e.getMessage());
        }
    }
}
