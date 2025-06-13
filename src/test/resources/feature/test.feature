Feature: Akakce Mobil Test


  @Test
  Scenario: Product page go to seller button check
    When Click continues without login
    And Set "Laptop" in search bar
    And User applies filters on product list
    And User list most expensive products
    And User select the "10" product
    Then User check buton Satıcıya Git