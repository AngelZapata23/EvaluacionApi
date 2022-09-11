package com.nttdata.petstore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearOrderStepsDefination {

    @Steps
    CrearOrder crearOrder;

    @Steps
    ConsultaOrder consultaOrder;

    @When("creo el orden con id {int}, petId {int}, quantity {int}")
    public void creoElOrdenConIdPetIdQuantity(int id, int petId, int quantity) {
        crearOrder.crearOrder(id, petId, quantity);
    }

    @Then("el código respuesta es {int}")
    public void elCódigoRespuestaEs(int statusCode) {
        crearOrder.validarOrderCreado(statusCode);
    }

    @Given("dado el servicio de order")
    public void dadoElServicioDeOrder() {
    }

    @When("consulto el id {int}")
    public void consultoElId(int id) {
        System.out.println("consultoElUsuario inicio");
        System.out.println("id: " + id);
        //consultaUsuario = new ConsultaUsuario();
        consultaOrder.validarOrder(id);
        System.out.println("consultoElUsuario fin");
    }

    @Then("el código de respuesta de consulta Order es {int}")
    public void elCódigoDeRespuestaDeConsultaOrderEs(int statusCode) {
        consultaOrder.validarOrderCreado(statusCode);
    }

    @And("valido el mensaje la consulta")
    public void validoElMensajeLaConsulta() {
    }


    @And("valido petId {int}")
    public void validoPetId(int petid) {
        restAssuredThat(response -> response.body("'petId'", equalTo(petid)));
    }
}
