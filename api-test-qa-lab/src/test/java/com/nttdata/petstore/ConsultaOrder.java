package com.nttdata.petstore;

import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ConsultaOrder {

    private static String URL_ORDER = "https://petstore.swagger.io/v2/store/order";

    public void validarOrder(int id){
        System.out.println("validarOrder inicio");
        SerenityRest.given()
                .log().all()   //=> Ayuda a revisar el Request
                .contentType("application/json")
                .get(URL_ORDER + "/" + id);

        System.out.println("validarOrder Fin");

    }

    public void validarOrderCreado(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }
}
