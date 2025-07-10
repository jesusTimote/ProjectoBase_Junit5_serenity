package com.proyecto.automatizacion.utils;

import net.serenitybdd.core.exceptions.NoSuchElementException;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;


public class Complementos {


    /*
    public static void seleccionarOpcionEnLista(WebElementFacade desplegable, List<WebElementFacade> opciones, String textoDeseado) {
        // 1. Abre el desplegable
        desplegable.waitUntilClickable().click();

        // 2. Espera a que aparezcan las opciones
        opciones.get(0).waitUntilVisible();

        // 3. Filtra las opciones para encontrar la que contiene el texto deseado
        List<WebElementFacade> opcionesFiltradas = opciones.stream()
                .filter(opcion -> opcion.getText().contains(textoDeseado))
                .toList();
        // 4. Si se encuentra la opción, haz clic en ella
        if (!opcionesFiltradas.isEmpty()) {
            opcionesFiltradas.get(0).waitUntilClickable().click();
        } else {
            throw new NoSuchElementException("No se encontró la opción con el texto: " + textoDeseado);
        }

    }*/


}
