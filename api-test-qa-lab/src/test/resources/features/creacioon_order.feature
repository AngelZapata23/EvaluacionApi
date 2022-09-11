@regresion
Feature: Crear orden de la tienda PetStore

  @test1
  Scenario: Crear order

    When creo el orden con id 4, petId 4, quantity 4
    Then el código respuesta es 200
    And valido petId 4


  @consulta
  Scenario Outline: Consulta de Order
    Given dado el servicio de order
    When consulto el id <ID>
    Then el código de respuesta de consulta Order es 200
    And valido el mensaje la consulta
    Examples:
      |ID|
      |2|
      |3|
      |4|