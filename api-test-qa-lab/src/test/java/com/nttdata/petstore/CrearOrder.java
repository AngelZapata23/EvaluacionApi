package com.nttdata.petstore;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CrearOrder {

    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";

    @Step("Crear order {4} en PetStore")
    public void crearOrder(int id, int petId, int quantity){
        SerenityRest.given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\":"+id+",\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"shipDate\": \"string\",\n" +
                        "  \"status\": \"string\",\n" +
                        "  \"complete\": \"string\n" +
                        "}")
                .post(CREATE_ORDER);

    }
    public void validarOrderCreado(int statusCode){
        restAssuredThat(response -> response.statusCode(statusCode));
    }

}
